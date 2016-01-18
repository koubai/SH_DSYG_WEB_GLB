package com.cn.dsyg.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.cn.common.util.Constants;
import com.cn.common.util.Page;
import com.cn.common.util.PropertiesConfig;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dao.Dict01Dao;
import com.cn.dsyg.dao.Product01Dao;
import com.cn.dsyg.dao.WarehouseDao;
import com.cn.dsyg.dto.Dict01Dto;
import com.cn.dsyg.dto.Product01Dto;
import com.cn.dsyg.dto.Product01SummaryDto;
import com.cn.dsyg.dto.Product01TmpDto;
import com.cn.dsyg.service.Product01Service;

/**
 * @name Product01ServiceImpl.java
 * @author Frank
 * @time 2014-12-17上午1:19:48
 * @version 1.0
 */
public class Product01ServiceImpl implements Product01Service {
	
	private WarehouseDao warehouseDao;
	private Product01Dao product01Dao;
	private Dict01Dao dict01Dao;
	
	@Override
	public List<Product01Dto> searchProduct01ByGoodsid(String fieldcode,
			String status, String rank) {
		List<Product01Dto> list = product01Dao.searchProduct01ByGoodsid(fieldcode, status, rank);

		List<Product01Dto> list2 = new ArrayList<Product01Dto>();
		if(list != null && list.size() > 0) {
			//PDF文件URL
			String pdfurl = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_PDF_URL);
			for(Product01Dto tmp : list) {
				//逐个查询数据
				Product01Dto p = product01Dao.queryProduct01ByID(tmp.getId(), "");
				//添加PDF文件URL
				p.setPdfurl(pdfurl);
				list2.add(p);
			}
		}	
		return list2;
	}
	
	@Override
	public Page searchProduct01List(String fieldcode, String item01, String item02,
			String item03, String item04, String item05, String item06, String ulCode,
			String status, String keyword, String rank, Page page, int startIndex) {
		keyword = StringUtil.searchKeyword(keyword);
		ulCode = StringUtil.searchKeyword(ulCode);
		
		//查询总记录数（查询有效数据）
		int totalCount = product01Dao.searchProduct01ListCountByPage(fieldcode, item01, item02,
				item03, item04, item05, item06, ulCode, status, keyword, rank);
		page.setTotalCount(totalCount);
		if(totalCount % page.getPageSize() > 0) {
			page.setTotalPage(totalCount / page.getPageSize() + 1);
		} else {
			page.setTotalPage(totalCount / page.getPageSize());
		}
		//翻页查询记录（查询有效数据）
		List<Product01TmpDto> tmpList = product01Dao.searchProduct01ListByPage(fieldcode, item01,
				item02, item03, item04, item05, item06, ulCode, status, keyword, rank,
				startIndex * page.getPageSize(), page.getPageSize());
		
		//循环查询数据
		List<Product01Dto> list = new ArrayList<Product01Dto>();
		if(tmpList != null && tmpList.size() > 0) {
			//PDF文件URL
			String pdfurl = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_PDF_URL);
			for(Product01TmpDto tmp : tmpList) {
				//逐个查询数据
				Product01Dto p = product01Dao.queryProduct01ByID(tmp.getId(), "");
				//添加PDF文件URL
				p.setPdfurl(pdfurl);
				list.add(p);
			}
		}
		page.setItems(list);
		return page;
	}
	
	@Override
	public List<Product01SummaryDto> searchProduct01Summary(String fieldcode, String item01,
			String item02, String item03, String item04, String item05, String item06, String ulCode,
			String status, String keyword, String rank) {
		keyword = StringUtil.searchKeyword(keyword);
		ulCode = StringUtil.searchKeyword(ulCode);
		return product01Dao.searchProduct01Summary(fieldcode, item01, item02,
				item03, item04, item05, item06, ulCode, status, keyword, rank);
	}

	@Override
	public Page searchProduct01ListByPage(String fieldcode, String item01, String item02,
			String item03, String item04, String item05, String item06, String ulCode,
			String status, String keyword, String rank, Page page) {
		keyword = StringUtil.searchKeyword(keyword);
		ulCode = StringUtil.searchKeyword(ulCode);
		
		//查询总记录数（查询有效数据）
		int totalCount = product01Dao.searchProduct01ListCountByPage(fieldcode, item01,
				item02, item03, item04, item05, item06, ulCode, status, keyword, rank);
		page.setTotalCount(totalCount);
		if(totalCount % page.getPageSize() > 0) {
			page.setTotalPage(totalCount / page.getPageSize() + 1);
		} else {
			page.setTotalPage(totalCount / page.getPageSize());
		}
		
		//翻页查询记录（查询有效数据）
		List<Product01TmpDto> tmpList = product01Dao.searchProduct01ListByPage(fieldcode,
				item01, item02, item03, item04, item05, item06, ulCode, status, keyword, rank,
				page.getStartIndex() * page.getPageSize(), page.getPageSize());
		
		//循环查询数据
		List<Product01Dto> list = new ArrayList<Product01Dto>();
		if(tmpList != null && tmpList.size() > 0) {
			//PDF文件URL
			String pdfurl = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_PDF_URL);
			for(Product01TmpDto tmp : tmpList) {
				//逐个查询数据
				Product01Dto p = product01Dao.queryProduct01ByID(tmp.getId(), "");
				//添加PDF文件URL
				p.setPdfurl(pdfurl);
				list.add(p);
			}
		}
		page.setItems(list);
		return page;
	}

	@Override
	public Page queryProduct01ByPage(String fieldcode, String keyword, String rank, Page page) {
		keyword = StringUtil.searchKeyword(keyword);
		
		//查询总记录数（查询有效数据）
		int totalCount = product01Dao.queryProduct01CountByPage(fieldcode, keyword, "" + Constants.STATUS_NORMAL, rank);
		page.setTotalCount(totalCount);
		if(totalCount % page.getPageSize() > 0) {
			page.setTotalPage(totalCount / page.getPageSize() + 1);
		} else {
			page.setTotalPage(totalCount / page.getPageSize());
		}
		//翻页查询记录（查询有效数据）
		List<Product01Dto> list = product01Dao.queryProduct01ByPage(fieldcode, keyword, "" + Constants.STATUS_NORMAL, rank,
				page.getStartIndex() * page.getPageSize(), page.getPageSize());
		page.setItems(list);
		return page;
	}

	@Override
	public Product01Dto queryProduct01ByID(String id, String rank) {
		Product01Dto product01 = product01Dao.queryProduct01ByID(id, rank);
		if(product01 != null) {
			//图片和PDF文件显示地址
			String imageurl = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_IMAGES_URL);
			String pdfurl = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_PDF_URL);
			product01.setImageurl(imageurl);
			product01.setPdfurl(pdfurl);
			return product01;
		}
		return null;
	}
	
	@Override
	public Product01Dto queryProduct01ByLogicId(String nameno, String typeno,
			String color1) {
		Product01Dto product01 = product01Dao.queryProduct01ByLogicId(nameno, typeno, color1);
		if(product01 != null) {
			//图片和PDF文件显示地址
			String imageurl = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_IMAGES_URL);
			String pdfurl = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_PDF_URL);
			product01.setImageurl(imageurl);
			product01.setPdfurl(pdfurl);
			return product01;
		}
		return null;
	}

	@Override
	public void deleteProduct01(String id, String userid) {
		//逻辑删除
		Product01Dto product = product01Dao.queryProduct01ByID(id, "");
		if(product != null) {
			//状态=无效
			product.setStatus("" + Constants.STATUS_DEL);
			product.setUpdateuid(userid);
			product01Dao.updateProduct01(product);
			//逻辑删除库存
			warehouseDao.deleteWarehouseByProductid(id, "" + Constants.STATUS_DEL, userid);
		}
	}

	@Override
	public void insertProduct01(Product01Dto product) {
		//关键字
		product.setKeyword(getKeyword(product));
		product01Dao.insertProduct01(product);
	}

	@Override
	public void updateProduct01(Product01Dto product) {
		//关键字
		product.setKeyword(getKeyword(product));
		product01Dao.updateProduct01(product);
	}
	
	/**
	 * 关键字
	 * @param product
	 * @return
	 */
	private String getKeyword(Product01Dto product) {
		String keyword = "";
		if(product == null) {
			return keyword;
		}
		//大分类
		Dict01Dto dict = dict01Dao.queryDict01ByLogicId(Constants.DICT_GOODS_TYPE, product.getFieldcode(), PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
		if(dict != null) {
			keyword += dict.getFieldname() + "," + dict.getNote() + ",";
		}
		//名称
		keyword += product.getNameno() + ",";
		//品牌
		keyword += product.getItem08() + ",";
		//UL编号
		keyword += product.getItem09() + ",";
		//item01
		if(StringUtil.isNotBlank(product.getItem01())) {
			dict = dict01Dao.queryDict01ByLogicId(product.getFieldcode() + "_" + Constants.DICT_SUB_TYPE_ITEM01,
					product.getItem01(), PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			if(dict != null) {
				keyword += dict.getFieldname() + ",";
			}
		}
		//item02
		if(StringUtil.isNotBlank(product.getItem02())) {
			dict = dict01Dao.queryDict01ByLogicId(product.getFieldcode() + "_" + Constants.DICT_SUB_TYPE_ITEM02,
					product.getItem02(), PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			if(dict != null) {
				keyword += dict.getFieldname() + ",";
			}
		}
		//item03
		if(StringUtil.isNotBlank(product.getItem03())) {
			dict = dict01Dao.queryDict01ByLogicId(product.getFieldcode() + "_" + Constants.DICT_SUB_TYPE_ITEM03,
					product.getItem03(), PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			if(dict != null) {
				keyword += dict.getFieldname() + ",";
			}
		}
		//item04
		if(StringUtil.isNotBlank(product.getItem04())) {
			dict = dict01Dao.queryDict01ByLogicId(product.getFieldcode() + "_" + Constants.DICT_SUB_TYPE_ITEM04,
					product.getItem04(), PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			if(dict != null) {
				keyword += dict.getFieldname() + ",";
			}
		}
		//item05
		if(StringUtil.isNotBlank(product.getItem05())) {
			dict = dict01Dao.queryDict01ByLogicId(product.getFieldcode() + "_" + Constants.DICT_SUB_TYPE_ITEM05,
					product.getItem05(), PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			if(dict != null) {
				keyword += dict.getFieldname() + ",";
			}
		}
		//item06
		if(StringUtil.isNotBlank(product.getItem06())) {
			dict = dict01Dao.queryDict01ByLogicId(product.getFieldcode() + "_" + Constants.DICT_SUB_TYPE_ITEM06,
					product.getItem06(), PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			if(dict != null) {
				keyword += dict.getFieldname() + ",";
			}
		}
		//型号
		if(StringUtil.isNotBlank(product.getTypeno())) {
			keyword += product.getTypeno() + ",";
		}
		//型号辅助
		if(StringUtil.isNotBlank(product.getTypenosub())) {
			keyword += product.getTypenosub() + ",";
		}
		//颜色
		if(StringUtil.isNotBlank(product.getColor1())) {
			dict = dict01Dao.queryDict01ByLogicId(Constants.DICT_COLOR_TYPE,
					product.getColor1(), PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			if(dict != null) {
				keyword += dict.getFieldname() + ",";
			}
		}
		
//		//尺寸
//		//称呼尺寸
//		if(StringUtil.isNotBlank(product.getItem10())) {
//			keyword += product.getItem10() + ",";
//		}
//		//内径
//		if(StringUtil.isNotBlank(product.getItem11())) {
//			keyword += product.getItem11() + ",";
//		}
//		//壁厚
//		if(StringUtil.isNotBlank(product.getItem12())) {
//			keyword += product.getItem12() + ",";
//		}
//		//外径
//		if(StringUtil.isNotBlank(product.getItem13())) {
//			keyword += product.getItem13() + ",";
//		}
//		//长度
//		if(StringUtil.isNotBlank(product.getItem13())) {
//			keyword += product.getItem13() + ",";
//		}
		
		//产地
		if(StringUtil.isNotBlank(product.getMakearea())) {
			dict = dict01Dao.queryDict01ByLogicId(Constants.DICT_MAKEAREA,
					product.getMakearea(), PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			if(dict != null) {
				keyword += dict.getFieldname() + ",";
			}
		}
		return keyword;
	}

	public Product01Dao getProduct01Dao() {
		return product01Dao;
	}

	public void setProduct01Dao(Product01Dao product01Dao) {
		this.product01Dao = product01Dao;
	}

	public Dict01Dao getDict01Dao() {
		return dict01Dao;
	}

	public void setDict01Dao(Dict01Dao dict01Dao) {
		this.dict01Dao = dict01Dao;
	}

	public WarehouseDao getWarehouseDao() {
		return warehouseDao;
	}

	public void setWarehouseDao(WarehouseDao warehouseDao) {
		this.warehouseDao = warehouseDao;
	}
}
