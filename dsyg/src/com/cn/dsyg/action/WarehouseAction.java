package com.cn.dsyg.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cn.common.action.BaseAction;
import com.cn.common.util.Constants;
import com.cn.common.util.Page;
import com.cn.common.util.PropertiesConfig;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dto.Dict01Dto;
import com.cn.dsyg.dto.Product01Dto;
import com.cn.dsyg.dto.WarehouseDto;
import com.cn.dsyg.service.Dict01Service;
import com.cn.dsyg.service.Product01Service;
import com.cn.dsyg.service.WarehouseService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @name WarehouseAction.java
 * @author Frank
 * @time 2015-1-4上午2:31:12
 * @version 1.0
 */
public class WarehouseAction extends BaseAction {

	private static final long serialVersionUID = -7502773227490023518L;
	
	private static final Logger log = LogManager.getLogger(WarehouseAction.class);
	
	private WarehouseService warehouseService;
	
	private Dict01Service dict01Service;
	
	private Product01Service product01Service;
	
	/**
	 * 页码
	 */
	private int startIndex;
	
	/**
	 * 翻页
	 */
	private Page page;
	
	private List<WarehouseDto> warehouseManageList;
	
	//检索条件
	//产品ID
	private String queryProductId;
	
	/**
	 * 大产品分类
	 */
	private List<Dict01Dto> goodsList;
	
	//单位
	private List<Dict01Dto> unitList;
	//产地
	private List<Dict01Dto> makeareaList;
	
	//产品信息
	private Product01Dto showProduct01;
	
	//新增
	private WarehouseDto addWarehouseDto;
	
	//修改
	private String updWarehouseId;
	private WarehouseDto updWarehouseDto;
	
	//删除
	private String delWarehouseId;
	
	/**
	 * 显示新增库存页面
	 * @return
	 */
	public String showAddWarehouseAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			initData();
			addWarehouseDto = new WarehouseDto();
			//默认单位为箱
			addWarehouseDto.setRes01("004");
			//产品ID
			addWarehouseDto.setProductid(queryProductId);
		} catch(Exception e) {
			log.error("showAddWarehouseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 新增库存
	 * @return
	 */
	public String addWarehouseAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			initData();
			//数据验证
			if(!checkData(addWarehouseDto)) {
				return "checkerror";
			}
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			addWarehouseDto.setUpdateuid(username);
			addWarehouseDto.setCreateuid(username);
			//默认状态=有效
			addWarehouseDto.setStatus("" + Constants.STATUS_NORMAL);
			//数据权限
			addWarehouseDto.setRank("" + Constants.ROLE_RANK_OPERATOR);
			//库存为空时，默认库存为0
			if(StringUtil.isBlank(addWarehouseDto.getItem01())) {
				addWarehouseDto.setItem01("0.00");
			}
			
			//新增
			warehouseService.insertWarehouse(addWarehouseDto);
			
			this.addActionMessage("添加成功！");
			addWarehouseDto = new WarehouseDto();
		} catch(Exception e) {
			log.error("addWarehouseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 显示修改库存页面
	 * @return
	 */
	public String showUpdWarehouseAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			initData();
			updWarehouseDto = warehouseService.queryWarehouseByID(updWarehouseId, "");
		} catch(Exception e) {
			log.error("showAddWarehouseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 修改库存
	 * @return
	 */
	public String updWarehouseAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			initData();
			
			//数据验证
			if(!checkData(updWarehouseDto)) {
				return "checkerror";
			}
			//库存为空时，默认库存为0
			if(StringUtil.isBlank(updWarehouseDto.getItem01())) {
				updWarehouseDto.setItem01("0.00");
			}
			
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			updWarehouseDto.setUpdateuid(username);
			warehouseService.updateWarehouse(updWarehouseDto);
			this.addActionMessage("更新成功！");
		} catch(Exception e) {
			log.error("updWarehouseAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 删除库存
	 * @return
	 */
	public String delWarehouseAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限删除
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			warehouseService.deleteWarehouse(delWarehouseId, "" + rank, username);
			queryData();
			this.addActionMessage("删除成功！");
		} catch(Exception e) {
			log.error("delProduct error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 库存管理页面
	 * @return
	 */
	public String showWarehouseManageAction() {
		try {
			this.clearMessages();
			//重新刷新页面数据
			startIndex = 0;
			page = new Page();
			queryProductId = "";
			showProduct01 = new Product01Dto();
			if(StringUtil.isNotBlank(queryProductId)) {
				showProduct01 = product01Service.queryProduct01ByID(queryProductId, "");
			}
			warehouseManageList = new ArrayList<WarehouseDto>();
			initData();
			//大分类列表
			goodsList = dict01Service.queryDict01ByFieldcode(Constants.DICT_GOODS_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		} catch(Exception e) {
			log.error("shouWarehouseManageAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询库存
	 * @return
	 */
	public String queryWarehouseListAction() {
		try {
			this.clearMessages();
			//重新刷新页面数据
			startIndex = 0;
			page = new Page();
			queryData();
		} catch(Exception e) {
			log.error("queryWarehouseListAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 翻页库存
	 * @return
	 */
	public String turnWarehouseListAction() {
		try {
			this.clearMessages();
			queryData();
		} catch(Exception e) {
			log.error("turnWarehouseListAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 数据check
	 * @param warehouse
	 * @return
	 */
	private boolean checkData(WarehouseDto warehouse) {
		if(warehouse == null) {
			this.addActionMessage("库存不能为空！");
			return false;
		}
//		if(StringUtil.isBlank(warehouse.getItem01())) {
//			this.addActionMessage("数量不能为空！");
//			return false;
//		}
		if(StringUtil.isBlank(warehouse.getRes01())) {
			this.addActionMessage("请选择单位！");
			return false;
		}
		if(StringUtil.isBlank(warehouse.getItem03())) {
			this.addActionMessage("发送天数不能为空！");
			return false;
		}
		if(StringUtil.isBlank(warehouse.getRes02())) {
			this.addActionMessage("请选择产地！");
			return false;
		}
		return true;
	}
	
	/**
	 * 初期化数据
	 */
	private void initData() {
		//单位
		unitList = dict01Service.queryDict01ByFieldcode(Constants.DICT_UNIT_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		//产地
		makeareaList = dict01Service.queryDict01ByFieldcode(Constants.DICT_MAKEAREA, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
	}
	
	/**
	 * 数据查询
	 */
	@SuppressWarnings("unchecked")
	private void queryData() {
		showProduct01 = new Product01Dto();
		if(StringUtil.isNotBlank(queryProductId)) {
			showProduct01 = product01Service.queryProduct01ByID(queryProductId, "");
		}
		warehouseManageList = new ArrayList<WarehouseDto>();
		initData();
		//大分类列表
		goodsList = dict01Service.queryDict01ByFieldcode(Constants.DICT_GOODS_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		if(page == null) {
			page = new Page();
		}
		//翻页查询所有委托公司
		this.page.setStartIndex(startIndex);
		page = warehouseService.queryWarehouseByPage(queryProductId, "", "", "", page);
		warehouseManageList = (List<WarehouseDto>) page.getItems();
		this.setStartIndex(page.getStartIndex());
	}

	public WarehouseService getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseService warehouseService) {
		this.warehouseService = warehouseService;
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

	public List<WarehouseDto> getWarehouseManageList() {
		return warehouseManageList;
	}

	public void setWarehouseManageList(List<WarehouseDto> warehouseManageList) {
		this.warehouseManageList = warehouseManageList;
	}

	public Dict01Service getDict01Service() {
		return dict01Service;
	}

	public void setDict01Service(Dict01Service dict01Service) {
		this.dict01Service = dict01Service;
	}

	public List<Dict01Dto> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Dict01Dto> goodsList) {
		this.goodsList = goodsList;
	}

	public String getQueryProductId() {
		return queryProductId;
	}

	public void setQueryProductId(String queryProductId) {
		this.queryProductId = queryProductId;
	}

	public Product01Service getProduct01Service() {
		return product01Service;
	}

	public void setProduct01Service(Product01Service product01Service) {
		this.product01Service = product01Service;
	}

	public Product01Dto getShowProduct01() {
		return showProduct01;
	}

	public void setShowProduct01(Product01Dto showProduct01) {
		this.showProduct01 = showProduct01;
	}

	public WarehouseDto getAddWarehouseDto() {
		return addWarehouseDto;
	}

	public void setAddWarehouseDto(WarehouseDto addWarehouseDto) {
		this.addWarehouseDto = addWarehouseDto;
	}

	public String getUpdWarehouseId() {
		return updWarehouseId;
	}

	public void setUpdWarehouseId(String updWarehouseId) {
		this.updWarehouseId = updWarehouseId;
	}

	public WarehouseDto getUpdWarehouseDto() {
		return updWarehouseDto;
	}

	public void setUpdWarehouseDto(WarehouseDto updWarehouseDto) {
		this.updWarehouseDto = updWarehouseDto;
	}

	public List<Dict01Dto> getUnitList() {
		return unitList;
	}

	public void setUnitList(List<Dict01Dto> unitList) {
		this.unitList = unitList;
	}

	public List<Dict01Dto> getMakeareaList() {
		return makeareaList;
	}

	public void setMakeareaList(List<Dict01Dto> makeareaList) {
		this.makeareaList = makeareaList;
	}

	public String getDelWarehouseId() {
		return delWarehouseId;
	}

	public void setDelWarehouseId(String delWarehouseId) {
		this.delWarehouseId = delWarehouseId;
	}
}
