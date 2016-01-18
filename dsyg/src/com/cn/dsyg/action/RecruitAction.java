package com.cn.dsyg.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cn.common.action.BaseAction;
import com.cn.common.util.Constants;
import com.cn.common.util.Page;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dto.RecruitDto;
import com.cn.dsyg.service.RecruitService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @name RecruitAction.java
 * @author Frank
 * @time 2015-2-7下午2:35:09
 * @version 1.0
 */
public class RecruitAction extends BaseAction {
	
	private static final long serialVersionUID = 5400580595978410833L;

	private static final Logger log = LogManager.getLogger(RecruitAction.class);

	private RecruitService recruitService;
	
	/**
	 * 页码
	 */
	private int startIndex;
	
	/**
	 * 翻页
	 */
	private Page page;
	
	private List<RecruitDto> recruitList;
	
	private RecruitDto queryRecruitDto;
	
	//删除
	private String delRecruitId;
	
	//新增
	private RecruitDto addRecruitDto;
	
	//修改
	private String updRecruitId;
	private RecruitDto updRecruitDto;
	
	/**
	 * 显示新增招聘页面
	 * @return
	 */
	public String showAddRecruitAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			addRecruitDto = new RecruitDto();
		} catch(Exception e) {
			log.error("showAddRecruitAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 新增招聘
	 * @return
	 */
	public String addRecruitAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			//数据验证
			if(!checkData(addRecruitDto)) {
				return "checkerror";
			}
			
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			addRecruitDto.setUpdateuid(username);
			addRecruitDto.setCreateuid(username);
			//默认状态=有效
			addRecruitDto.setStatus("" + Constants.STATUS_NORMAL);
			recruitService.insertRecruit(addRecruitDto);
			
			this.addActionMessage("添加成功！");
			addRecruitDto = new RecruitDto();
		} catch(Exception e) {
			log.error("addRecruitAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 显示修改招聘页面
	 * @return
	 */
	public String showUpdRecruitAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			updRecruitDto = recruitService.queryRecruitByID(updRecruitId);
		} catch(Exception e) {
			log.error("showUpdRecruitAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 修改招聘
	 * @return
	 */
	public String updRecruitAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			
			//数据验证
			if(!checkData(updRecruitDto)) {
				return "checkerror";
			}
			
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			updRecruitDto.setUpdateuid(username);
			recruitService.updateRecruit(updRecruitDto);
			
			this.addActionMessage("更新成功！");
			log.info("更新成功！");
		} catch(Exception e) {
			log.error("updRecruitAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 删除新闻
	 * @return
	 */
	public String delRecruitAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限删除
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			recruitService.deleteRecruit(delRecruitId);
			//重新刷新页面数据
			startIndex = 0;
			page = new Page();
			queryData();
			this.addActionMessage("删除成功！");
		} catch(Exception e) {
			log.error("delRecruitAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 招聘介绍管理页面
	 * @return
	 */
	public String showRecruitAction() {
		try {
			this.clearMessages();
			startIndex = 0;
			page = new Page();
			queryRecruitDto = new RecruitDto();
			recruitList = new ArrayList<RecruitDto>();
		} catch(Exception e) {
			log.error("showRecruitAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询消息
	 * @return
	 */
	public String queryRecruitAction() {
		try {
			this.clearMessages();
			startIndex = 0;
			page = new Page();
			queryData();
		} catch(Exception e) {
			log.error("queryRecruitAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 翻页
	 * @return
	 */
	public String turnRecruitAction() {
		try {
			this.clearMessages();
			queryData();
		} catch(Exception e) {
			log.error("turnRecruitAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 数据check
	 * @param RecruitDto
	 * @return
	 */
	private boolean checkData(RecruitDto recruitDto) {
		if(recruitDto == null) {
			this.addActionMessage("标题不能为空！");
			return false;
		}
		if(StringUtil.isBlank(recruitDto.getTitle())) {
			this.addActionMessage("标题不能为空！");
			return false;
		}
		if(StringUtil.isBlank(recruitDto.getPersons())) {
			this.addActionMessage("招聘人数不能为空！");
			return false;
		}
		if(StringUtil.isBlank(recruitDto.getData())) {
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
		recruitList = new ArrayList<RecruitDto>();
		if(page == null) {
			page = new Page();
		}
		//翻页查询所有委托公司
		this.page.setStartIndex(startIndex);
		page = recruitService.queryRecruitByPage(queryRecruitDto.getTitle(), queryRecruitDto.getRecruittype(), "", page);
		recruitList = (List<RecruitDto>) page.getItems();
		this.setStartIndex(page.getStartIndex());
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

	public List<RecruitDto> getRecruitList() {
		return recruitList;
	}

	public void setRecruitList(List<RecruitDto> recruitList) {
		this.recruitList = recruitList;
	}

	public RecruitDto getQueryRecruitDto() {
		return queryRecruitDto;
	}

	public void setQueryRecruitDto(RecruitDto queryRecruitDto) {
		this.queryRecruitDto = queryRecruitDto;
	}

	public String getDelRecruitId() {
		return delRecruitId;
	}

	public void setDelRecruitId(String delRecruitId) {
		this.delRecruitId = delRecruitId;
	}

	public RecruitDto getAddRecruitDto() {
		return addRecruitDto;
	}

	public void setAddRecruitDto(RecruitDto addRecruitDto) {
		this.addRecruitDto = addRecruitDto;
	}

	public String getUpdRecruitId() {
		return updRecruitId;
	}

	public void setUpdRecruitId(String updRecruitId) {
		this.updRecruitId = updRecruitId;
	}

	public RecruitDto getUpdRecruitDto() {
		return updRecruitDto;
	}

	public void setUpdRecruitDto(RecruitDto updRecruitDto) {
		this.updRecruitDto = updRecruitDto;
	}

	public RecruitService getRecruitService() {
		return recruitService;
	}

	public void setRecruitService(RecruitService recruitService) {
		this.recruitService = recruitService;
	}
}
