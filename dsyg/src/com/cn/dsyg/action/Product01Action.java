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
import com.cn.dsyg.dto.Dict01Dto;
import com.cn.dsyg.dto.FeatureDto;
import com.cn.dsyg.dto.Product01Dto;
import com.cn.dsyg.service.Dict01Service;
import com.cn.dsyg.service.Product01Service;
import com.opensymphony.xwork2.ActionContext;

/**
 * 库存检索输入
 * @author Frank
 * @time 2014-12-16下午10:49:26
 * @version 1.0
 */
public class Product01Action extends BaseAction {

	private static final long serialVersionUID = -7519440567808036928L;
	private static final Logger log = LogManager.getLogger(Product01Action.class);

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
	
	/**
	 * 数据列表
	 */
	private List<Product01Dto> manageProduct01List;
	
	//查询条件
	private Product01Dto queryProduct01Dto;
	
	/**
	 * 大产品分类
	 */
	private List<Dict01Dto> goodsList;
	
	//电线特征列表
	private List<FeatureDto> featureList01;
	//套管特征列表
	private List<FeatureDto> featureList02;
	//颜色
	private List<Dict01Dto> colorList;
	
	//新增
	private Product01Dto addProduct01Dto;
	private File addPicFile01;
	private File addPicFile02;
	private File addPicFile03;
	private File addPdfFile;
	//对应的文件名
	private String file01Name;
	private String file02Name;
	private String file03Name;
	private String file04Name;
	
	//删除
	private String delProduct01Id;
	
	//修改
	private String updProduct01Id;
	private Product01Dto updProduct01Dto;
	private File updPicFile01;
	private File updPicFile02;
	private File updPicFile03;
	private File updPdfFile;
	
	/**
	 * 删除产品
	 * @return
	 */
	public String delProductAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限删除
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			product01Service.deleteProduct01(delProduct01Id, username);
			//重新刷新页面数据
			startIndex = 0;
			page = new Page();
			//大分类列表
			goodsList = dict01Service.queryDict01ByFieldcode(Constants.DICT_GOODS_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			queryData();
			this.addActionMessage("删除成功！");
		} catch(Exception e) {
			log.error("delProduct error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 修改产品页面
	 * @return
	 */
	public String showUpdProductAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			initData();
			updPicFile01 = null;
			updPicFile02 = null;
			updPicFile03 = null;
			updProduct01Dto = product01Service.queryProduct01ByID(updProduct01Id, "");
		} catch(Exception e) {
			log.error("showAddProduct error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 修改产品
	 * @return
	 */
	public String updProductAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			initData();
			//数据验证
			if(!checkData(updProduct01Dto)) {
				return "checkerror";
			}
			
			//判断逻辑主键是否唯一
			Product01Dto pro = product01Service.queryProduct01ByLogicId(updProduct01Dto.getNameno(),
					updProduct01Dto.getTypeno(), updProduct01Dto.getColor1());
			if(pro != null && !pro.getId().equals(updProduct01Dto.getId())) {
				this.addActionMessage("已存在相同产品名称、产品规格和颜色的产品！");
				return "checkerror";
			}
			
			//文件目录
			String image_path = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_IMAGES_PATH);
			String pdf_path = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_PDF_PATH);
			
			//保存文件到指定目录
			String oldpic1 = "";
			String oldpic2 = "";
			String oldpic3 = "";
			String oldpdf = "";
			Product01Dto oldProduct01 = product01Service.queryProduct01ByID(updProduct01Id, "");
			
			if(updPicFile01 != null) {
				String newfile01 = FileUtil.uploadFile(updPicFile01, image_path, file01Name);
				updProduct01Dto.setPic01(newfile01);
				oldpic1 = oldProduct01.getPic01();
			}
			if(updPicFile02 != null) {
				String newfile02 = FileUtil.uploadFile(updPicFile02, image_path, file02Name);
				updProduct01Dto.setPic02(newfile02);
				oldpic2 = oldProduct01.getPic02();
			}
			if(updPicFile03 != null) {
				String newfile03 = FileUtil.uploadFile(updPicFile03, image_path, file03Name);
				updProduct01Dto.setPic03(newfile03);
				oldpic3 = oldProduct01.getPic03();
			}
			if(updPdfFile != null) {
				String newfile04 = FileUtil.uploadFile(updPdfFile, pdf_path, file04Name);
				updProduct01Dto.setPdfpath(newfile04);
				oldpdf = oldProduct01.getPdfpath();
			}
			
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			updProduct01Dto.setUpdateuid(username);
			product01Service.updateProduct01(updProduct01Dto);
			log.info("更新成功");
			this.addActionMessage("更新成功！");
			//清空数据
			updPicFile01 = null;
			updPicFile02 = null;
			updPicFile03 = null;
			updPdfFile = null;
			
			//如果更新前有图片，更新后没有图片，则删除原图片
			if(StringUtil.isNotBlank(oldProduct01.getPic01()) && StringUtil.isBlank(updProduct01Dto.getPic01())) {
				oldpic1 = oldProduct01.getPic01();
			}
			if(StringUtil.isNotBlank(oldProduct01.getPic02()) && StringUtil.isBlank(updProduct01Dto.getPic02())) {
				oldpic2 = oldProduct01.getPic02();
			}
			if(StringUtil.isNotBlank(oldProduct01.getPic03()) && StringUtil.isBlank(updProduct01Dto.getPic03())) {
				oldpic3 = oldProduct01.getPic03();
			}
			
			//判断是否需要删除原来文件
			if(StringUtil.isNotBlank(oldpic1)) {
				FileUtil.deleteFile(oldpic1, image_path);
			}
			if(StringUtil.isNotBlank(oldpic2)) {
				FileUtil.deleteFile(oldpic2, image_path);
			}
			if(StringUtil.isNotBlank(oldpic3)) {
				FileUtil.deleteFile(oldpic3, image_path);
			}
			if(StringUtil.isNotBlank(oldpdf)) {
				FileUtil.deleteFile(oldpdf, pdf_path);
			}
		} catch(Exception e) {
			log.error("showAddProduct error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 新增产品页面
	 * @return
	 */
	public String showAddProductAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			initData();
			addProduct01Dto = new Product01Dto();
			//默认显示
			addProduct01Dto.setRank("" + Constants.ROLE_RANK_OPERATOR);
		} catch(Exception e) {
			log.error("showAddProduct error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 新增
	 * @return
	 */
	public String addProductAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			initData();
			//数据验证
			if(!checkData(addProduct01Dto)) {
				return "checkerror";
			}
			
			//判断逻辑主键是否唯一（产品名称、产品规格和颜色）
			Product01Dto pro = product01Service.queryProduct01ByLogicId(addProduct01Dto.getNameno(),
					addProduct01Dto.getTypeno(), addProduct01Dto.getColor1());
			if(pro != null) {
				this.addActionMessage("已存在相同产品名称、产品规格和颜色的产品！");
				return "checkerror";
			}
			
//			//图片验证
//			if(addPicFile01 == null) {
//				this.addActionMessage("图片不能为空！");
//				return "checkerror";
//			}
			if(addPdfFile == null) {
				this.addActionMessage("请选择对应PDF文件！");
				return "checkerror";
			}
			
			//文件目录
			String image_path = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_IMAGES_PATH);
			String pdf_path = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_PDF_PATH);
			
			//保存文件到指定目录
			if(addPicFile01 != null) {
				String newfile01 = FileUtil.uploadFile(addPicFile01, image_path, file01Name);
				addProduct01Dto.setPic01(newfile01);
			}
			if(addPicFile02 != null) {
				String newfile02 = FileUtil.uploadFile(addPicFile02, image_path, file02Name);
				addProduct01Dto.setPic02(newfile02);
			}
			if(addPicFile03 != null) {
				String newfile03 = FileUtil.uploadFile(addPicFile03, image_path, file03Name);
				addProduct01Dto.setPic03(newfile03);
			}
			
			String newfile04 = FileUtil.uploadFile(addPdfFile, pdf_path, file04Name);
			addProduct01Dto.setPdfpath(newfile04);
			
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			addProduct01Dto.setUpdateuid(username);
			addProduct01Dto.setCreateuid(username);
			//默认状态=有效
			addProduct01Dto.setStatus("" + Constants.STATUS_NORMAL);
			
			product01Service.insertProduct01(addProduct01Dto);
			this.addActionMessage("添加成功！");
			log.info("添加成功");
			addProduct01Dto = new Product01Dto();
		} catch(Exception e) {
			log.error("addProduct error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 显示库存检索页面
	 * @return
	 */
	public String showManageProductListAction() {
		try {
			this.clearMessages();
			startIndex = 0;
			page = new Page();
			manageProduct01List = new ArrayList<Product01Dto>();
			//大分类列表
			goodsList = dict01Service.queryDict01ByFieldcode(Constants.DICT_GOODS_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			//页面查询条件清空
			queryProduct01Dto = new Product01Dto();
		} catch(Exception e) {
			log.error("showManageProductList error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询库存
	 * @return
	 */
	public String queryManageProductAction() {
		try {
			this.clearMessages();
			startIndex = 0;
			page = new Page();
			queryData();
		} catch(Exception e) {
			log.error("queryManageProduct error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 库存数据翻页
	 * @return
	 */
	public String turnManageProductAction() {
		try {
			this.clearMessages();
			queryData();
		} catch(Exception e) {
			log.error("turnManageProduct error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 数据验证
	 * @param product01
	 * @return
	 */
	private boolean checkData(Product01Dto product01) {
		if(product01 == null) {
			this.addActionMessage("请选择产品类型！");
			return false;
		}
		if(StringUtil.isBlank(product01.getFieldcode())) {
			this.addActionMessage("请选择产品类型！");
			return false;
		}
		if(StringUtil.isBlank(product01.getRank())) {
			this.addActionMessage("数据级别不能为空！");
			return false;
		}
		if(StringUtil.isBlank(product01.getNameno())) {
			this.addActionMessage("产品名称不能为空！");
			return false;
		}
		if(StringUtil.isBlank(product01.getTypeno())) {
			this.addActionMessage("产品规格不能为空！");
			return false;
		}
		if(StringUtil.isBlank(product01.getColor1())) {
			this.addActionMessage("颜色不能为空！");
			return false;
		}
		//品牌
		if(StringUtil.isBlank(product01.getItem08())) {
			this.addActionMessage("品牌不能为空！");
			return false;
		}
		//UL型号/编号
//		if(StringUtil.isBlank(product01.getItem09())) {
//			this.addActionMessage("UL型号/编号不能为空！");
//			return false;
//		}
		if(Constants.DICT_GOODS_TYPE_CODE_01.equals(product01.getFieldcode())) {
			//电线，需要验证单选框数据
			if(StringUtil.isBlank(product01.getItem01())) {
				this.addActionMessage("请选择耐温！");
				return false;
			}
			if(StringUtil.isBlank(product01.getItem02())) {
				this.addActionMessage("请选择耐压！");
				return false;
			}
			if(StringUtil.isBlank(product01.getItem03())) {
				this.addActionMessage("请选择材质！");
				return false;
			}
//			if(StringUtil.isBlank(product01.getItem04())) {
//				this.addActionMessage("请选择环保！");
//				return false;
//			}
		} else if(Constants.DICT_GOODS_TYPE_CODE_02.equals(product01.getFieldcode())) {
			//套管，需要验证单选框数据
			if(StringUtil.isBlank(product01.getItem01())) {
				this.addActionMessage("请选择耐温！");
				return false;
			}
			if(StringUtil.isBlank(product01.getItem02())) {
				this.addActionMessage("请选择耐压！");
				return false;
			}
			if(StringUtil.isBlank(product01.getItem03())) {
				this.addActionMessage("请选择绝缘！");
				return false;
			}
			if(StringUtil.isBlank(product01.getItem04())) {
				this.addActionMessage("请选择收缩比！");
				return false;
			}
			if(StringUtil.isBlank(product01.getItem05())) {
				this.addActionMessage("请选择材质！");
				return false;
			}
//			if(StringUtil.isBlank(product01.getItem06())) {
//				this.addActionMessage("请选择环保！");
//				return false;
//			}
		}
		
		/*/尺寸数据验证
		if(StringUtil.isBlank(product01.getItem10())) {
			this.addActionMessage("称呼尺寸不能为空！");
			return false;
		}
		if(StringUtil.isBlank(product01.getItem11())) {
			this.addActionMessage("内径不能为空！");
			return false;
		}
		if(StringUtil.isBlank(product01.getItem12())) {
			this.addActionMessage("壁厚不能为空！");
			return false;
		}
		if(StringUtil.isBlank(product01.getItem13())) {
			this.addActionMessage("外径不能为空！");
			return false;
		}
		if(StringUtil.isBlank(product01.getItem14())) {
			this.addActionMessage("长度不能为空！");
			return false;
		}
		if(StringUtil.isBlank(product01.getItem15())) {
			this.addActionMessage("请选择尺寸编辑单位！");
			return false;
		}//*/
		
		//库存编辑
//		if(StringUtil.isBlank(product01.getItem20())) {
//			this.addActionMessage("在库数（整箱）不能为空！");
//			return false;
//		}
//		if(StringUtil.isBlank(product01.getItem21())) {
//			this.addActionMessage("在库数（乱尺）不能为空！");
//			return false;
//		}
//		if(StringUtil.isBlank(product01.getItem22())) {
//			this.addActionMessage("请选择库存编辑单位！");
//			return false;
//		}
//		if(StringUtil.isBlank(product01.getItem23())) {
//			this.addActionMessage("发送天数不能为空！");
//			return false;
//		}
//		if(StringUtil.isBlank(product01.getMakearea())) {
//			this.addActionMessage("请选择产地！");
//			return false;
//		}
		return true;
	}
	
	/**
	 * 初始化参数
	 */
	private void initData() {
		//大分类列表
		goodsList = dict01Service.queryDict01ByFieldcode(Constants.DICT_GOODS_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		//电线特征列表
		featureList01 = dict01Service.queryFeatureByFieldcode(Constants.DICT_GOODS_TYPE_CODE_01, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		//套管特征列表
		featureList02 = dict01Service.queryFeatureByFieldcode(Constants.DICT_GOODS_TYPE_CODE_02, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		//颜色
		colorList = dict01Service.queryDict01ByFieldcode(Constants.DICT_COLOR_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
	}
	
	/**
	 * 数据查询
	 */
	@SuppressWarnings("unchecked")
	private void queryData() {
		//大分类列表
		delProduct01Id = "";
		updProduct01Id = "";
		goodsList = dict01Service.queryDict01ByFieldcode(Constants.DICT_GOODS_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		//颜色
		colorList = dict01Service.queryDict01ByFieldcode(Constants.DICT_COLOR_TYPE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		manageProduct01List = new ArrayList<Product01Dto>();
		if(page == null) {
			page = new Page();
		}
		//翻页查询所有委托公司
		this.page.setStartIndex(startIndex);
		//page = product01Service.queryProduct01ByPage(queryProduct01Dto.getFieldcode(), queryProduct01Dto.getKeyword(), "" + Constants.ROLE_RANK_NORMAL, page);
		page = product01Service.queryProduct01ByPage(queryProduct01Dto.getFieldcode(), queryProduct01Dto.getKeyword(), "", page);
		manageProduct01List = (List<Product01Dto>) page.getItems();
		this.setStartIndex(page.getStartIndex());
	}

	public Dict01Service getDict01Service() {
		return dict01Service;
	}

	public void setDict01Service(Dict01Service dict01Service) {
		this.dict01Service = dict01Service;
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

	public List<Dict01Dto> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Dict01Dto> goodsList) {
		this.goodsList = goodsList;
	}

	public Product01Service getProduct01Service() {
		return product01Service;
	}

	public void setProduct01Service(Product01Service product01Service) {
		this.product01Service = product01Service;
	}

	public List<Product01Dto> getManageProduct01List() {
		return manageProduct01List;
	}

	public void setManageProduct01List(List<Product01Dto> manageProduct01List) {
		this.manageProduct01List = manageProduct01List;
	}

	public Product01Dto getQueryProduct01Dto() {
		return queryProduct01Dto;
	}

	public void setQueryProduct01Dto(Product01Dto queryProduct01Dto) {
		this.queryProduct01Dto = queryProduct01Dto;
	}

	public Product01Dto getAddProduct01Dto() {
		return addProduct01Dto;
	}

	public void setAddProduct01Dto(Product01Dto addProduct01Dto) {
		this.addProduct01Dto = addProduct01Dto;
	}

	public List<FeatureDto> getFeatureList01() {
		return featureList01;
	}

	public void setFeatureList01(List<FeatureDto> featureList01) {
		this.featureList01 = featureList01;
	}

	public List<FeatureDto> getFeatureList02() {
		return featureList02;
	}

	public void setFeatureList02(List<FeatureDto> featureList02) {
		this.featureList02 = featureList02;
	}

	public File getAddPicFile01() {
		return addPicFile01;
	}

	public void setAddPicFile01(File addPicFile01) {
		this.addPicFile01 = addPicFile01;
	}

	public File getAddPicFile02() {
		return addPicFile02;
	}

	public void setAddPicFile02(File addPicFile02) {
		this.addPicFile02 = addPicFile02;
	}

	public File getAddPicFile03() {
		return addPicFile03;
	}

	public void setAddPicFile03(File addPicFile03) {
		this.addPicFile03 = addPicFile03;
	}

	public Product01Dto getUpdProduct01Dto() {
		return updProduct01Dto;
	}

	public void setUpdProduct01Dto(Product01Dto updProduct01Dto) {
		this.updProduct01Dto = updProduct01Dto;
	}

	public File getUpdPicFile01() {
		return updPicFile01;
	}

	public void setUpdPicFile01(File updPicFile01) {
		this.updPicFile01 = updPicFile01;
	}

	public File getUpdPicFile02() {
		return updPicFile02;
	}

	public void setUpdPicFile02(File updPicFile02) {
		this.updPicFile02 = updPicFile02;
	}

	public File getUpdPicFile03() {
		return updPicFile03;
	}

	public void setUpdPicFile03(File updPicFile03) {
		this.updPicFile03 = updPicFile03;
	}

	public File getAddPdfFile() {
		return addPdfFile;
	}

	public void setAddPdfFile(File addPdfFile) {
		this.addPdfFile = addPdfFile;
	}

	public File getUpdPdfFile() {
		return updPdfFile;
	}

	public void setUpdPdfFile(File updPdfFile) {
		this.updPdfFile = updPdfFile;
	}

	public String getFile01Name() {
		return file01Name;
	}

	public void setFile01Name(String file01Name) {
		this.file01Name = file01Name;
	}

	public String getFile02Name() {
		return file02Name;
	}

	public void setFile02Name(String file02Name) {
		this.file02Name = file02Name;
	}

	public String getFile03Name() {
		return file03Name;
	}

	public void setFile03Name(String file03Name) {
		this.file03Name = file03Name;
	}

	public String getFile04Name() {
		return file04Name;
	}

	public void setFile04Name(String file04Name) {
		this.file04Name = file04Name;
	}

	public String getDelProduct01Id() {
		return delProduct01Id;
	}

	public void setDelProduct01Id(String delProduct01Id) {
		this.delProduct01Id = delProduct01Id;
	}

	public String getUpdProduct01Id() {
		return updProduct01Id;
	}

	public void setUpdProduct01Id(String updProduct01Id) {
		this.updProduct01Id = updProduct01Id;
	}

	public List<Dict01Dto> getColorList() {
		return colorList;
	}

	public void setColorList(List<Dict01Dto> colorList) {
		this.colorList = colorList;
	}
}
