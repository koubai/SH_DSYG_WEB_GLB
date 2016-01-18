package com.cn.dsyg.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cn.common.action.BaseAction;
import com.cn.common.util.Constants;
import com.cn.common.util.FileUtil;
import com.cn.common.util.Page;
import com.cn.common.util.PropertiesConfig;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dto.CaseDto;
import com.cn.dsyg.dto.Dict01Dto;
import com.cn.dsyg.service.CaseService;
import com.cn.dsyg.service.Dict01Service;
import com.opensymphony.xwork2.ActionContext;

/**
 * 案例介绍
 * @name CaseAction.java
 * @author Frank
 * @time 2015-2-7上午1:04:01
 * @version 1.0
 */
public class CaseAction extends BaseAction {

	private static final Logger log = LogManager.getLogger(CaseAction.class);
	private static final long serialVersionUID = 7743187565769212327L;

	private CaseService caseService;
	
	private Dict01Service dict01Service;
	
	/**
	 * 页码
	 */
	private int startIndex;
	
	/**
	 * 翻页
	 */
	private Page page;
	
	private List<CaseDto> caseList;
	
	private CaseDto queryCaseDto;
	
	/**
	 * 大产品分类
	 */
	private List<Dict01Dto> goodsList;
	
	//删除
	private String delCaseId;
	
	//新增
	private CaseDto addCaseDto;
	private File addPicFile01;
	//对应的文件名
	private String file01Name;
	
	//修改
	private String updCaseId;
	private CaseDto updCaseDto;
	private File updPicFile01;
	
	/**
	 * 显示新增案例页面
	 * @return
	 */
	public String showAddCaseAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			//大分类列表
			goodsList = dict01Service.queryDict01ByFieldcode(Constants.DICT_GOODS_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			addCaseDto = new CaseDto();
		} catch(Exception e) {
			log.error("showAddCaseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 新增案例
	 * @return
	 */
	public String addCaseAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			//数据验证
			if(!checkData(addCaseDto)) {
				return "checkerror";
			}
			
			//文件目录
			String image_path = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_NEW_PIC_PATH);
			
			//保存文件到指定目录
			if(addPicFile01 != null) {
				String newfile01 = FileUtil.uploadFile(addPicFile01, image_path, file01Name);
				addCaseDto.setPic01(newfile01);
			}
			
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			addCaseDto.setUpdateuid(username);
			addCaseDto.setCreateuid(username);
			//默认状态=有效
			addCaseDto.setStatus("" + Constants.STATUS_NORMAL);
			caseService.insertCase(addCaseDto);
			
			this.addActionMessage("添加成功！");
			addCaseDto = new CaseDto();
		} catch(Exception e) {
			log.error("addCaseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 显示修改案例页面
	 * @return
	 */
	public String showUpdCaseAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			updPicFile01 = null;
			updCaseDto = caseService.queryCaseByID(updCaseId);
			//大分类列表
			goodsList = dict01Service.queryDict01ByFieldcode(Constants.DICT_GOODS_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		} catch(Exception e) {
			log.error("showUpdCaseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 修改案例
	 * @return
	 */
	public String updCaseAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			
			//数据验证
			if(!checkData(updCaseDto)) {
				return "checkerror";
			}
			
			//记录原来的图片文件
			CaseDto oldCase = caseService.queryCaseByID(updCaseId);
			String oldpic1 = "";
			
			//文件目录
			String image_path = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_NEW_PIC_PATH);
			if(updPicFile01 != null) {
				String newfile01 = FileUtil.uploadFile(updPicFile01, image_path, file01Name);
				updCaseDto.setPic01(newfile01);
				oldpic1 = oldCase.getPic01();
			}
			
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			updCaseDto.setUpdateuid(username);
			caseService.updateCase(updCaseDto);
			
			this.addActionMessage("更新成功！");
			log.info("更新成功！");
			
			//如果更新前有图片，更新后没有图片，则删除原图片
			if(StringUtil.isNotBlank(oldCase.getPic01()) && StringUtil.isBlank(updCaseDto.getPic01())) {
				oldpic1 = oldCase.getPic01();
			}
			//删除原来图片
			if(StringUtil.isNotBlank(oldpic1)) {
				FileUtil.deleteFile(oldpic1, image_path);
			}
			updPicFile01 = null;
		} catch(Exception e) {
			log.error("updCaseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 删除新闻
	 * @return
	 */
	public String delCaseAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限删除
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			caseService.deleteCase(delCaseId);
			//重新刷新页面数据
			startIndex = 0;
			page = new Page();
			queryData();
			this.addActionMessage("删除成功！");
		} catch(Exception e) {
			log.error("delCaseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 案例介绍管理页面
	 * @return
	 */
	public String showCaseAction() {
		try {
			this.clearMessages();
			startIndex = 0;
			page = new Page();
			queryCaseDto = new CaseDto();
			caseList = new ArrayList<CaseDto>();
			//大分类列表
			goodsList = dict01Service.queryDict01ByFieldcode(Constants.DICT_GOODS_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		} catch(Exception e) {
			log.error("showCaseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询消息
	 * @return
	 */
	public String queryCaseAction() {
		try {
			this.clearMessages();
			startIndex = 0;
			page = new Page();
			queryData();
		} catch(Exception e) {
			log.error("queryCaseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 翻页
	 * @return
	 */
	public String turnCaseAction() {
		try {
			this.clearMessages();
			queryData();
		} catch(Exception e) {
			log.error("turnCaseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 数据check
	 * @param caseDto
	 * @return
	 */
	private boolean checkData(CaseDto caseDto) {
		if(caseDto == null) {
			this.addActionMessage("标题不能为空！");
			return false;
		}
		if(StringUtil.isBlank(caseDto.getTitle())) {
			this.addActionMessage("标题不能为空！");
			return false;
		}
		if(StringUtil.isBlank(caseDto.getFieldcode())) {
			this.addActionMessage("产品类型不能为空！");
			return false;
		}
		if(StringUtil.isBlank(caseDto.getData())) {
			this.addActionMessage("内容不能为空！");
			return false;
		}
		return true;
	}
	
	/**
	 * 数据查询
	 */
	@SuppressWarnings("unchecked")
	private void queryData() {
		caseList = new ArrayList<CaseDto>();
		if(page == null) {
			page = new Page();
		}
		//大分类列表
		goodsList = dict01Service.queryDict01ByFieldcode(Constants.DICT_GOODS_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		//翻页查询所有委托公司
		this.page.setStartIndex(startIndex);
		page = caseService.queryCaseByPage(queryCaseDto.getTitle(), queryCaseDto.getFieldcode(), page);
		caseList = (List<CaseDto>) page.getItems();
		this.setStartIndex(page.getStartIndex());
	}

	public CaseService getCaseService() {
		return caseService;
	}

	public void setCaseService(CaseService caseService) {
		this.caseService = caseService;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<CaseDto> getCaseList() {
		return caseList;
	}

	public void setCaseList(List<CaseDto> caseList) {
		this.caseList = caseList;
	}

	public CaseDto getQueryCaseDto() {
		return queryCaseDto;
	}

	public void setQueryCaseDto(CaseDto queryCaseDto) {
		this.queryCaseDto = queryCaseDto;
	}

	public List<Dict01Dto> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Dict01Dto> goodsList) {
		this.goodsList = goodsList;
	}

	public Dict01Service getDict01Service() {
		return dict01Service;
	}

	public void setDict01Service(Dict01Service dict01Service) {
		this.dict01Service = dict01Service;
	}

	public String getDelCaseId() {
		return delCaseId;
	}

	public void setDelCaseId(String delCaseId) {
		this.delCaseId = delCaseId;
	}

	public CaseDto getAddCaseDto() {
		return addCaseDto;
	}

	public void setAddCaseDto(CaseDto addCaseDto) {
		this.addCaseDto = addCaseDto;
	}

	public CaseDto getUpdCaseDto() {
		return updCaseDto;
	}

	public void setUpdCaseDto(CaseDto updCaseDto) {
		this.updCaseDto = updCaseDto;
	}

	public String getUpdCaseId() {
		return updCaseId;
	}

	public void setUpdCaseId(String updCaseId) {
		this.updCaseId = updCaseId;
	}

	public File getAddPicFile01() {
		return addPicFile01;
	}

	public void setAddPicFile01(File addPicFile01) {
		this.addPicFile01 = addPicFile01;
	}

	public String getFile01Name() {
		return file01Name;
	}

	public void setFile01Name(String file01Name) {
		this.file01Name = file01Name;
	}

	public File getUpdPicFile01() {
		return updPicFile01;
	}

	public void setUpdPicFile01(File updPicFile01) {
		this.updPicFile01 = updPicFile01;
	}
}
