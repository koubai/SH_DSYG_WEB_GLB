package com.cn.dsyg.service;

import java.util.List;

import com.cn.common.util.Page;
import com.cn.dsyg.dto.Product01Dto;
import com.cn.dsyg.dto.Product01SummaryDto;

/**
 * @name Product01Service.java
 * @author Frank
 * @time 2014-12-17上午1:18:33
 * @version 1.0
 */
public interface Product01Service {
	
	/**
	 * 检索产品汇总
	 * @param fieldcode
	 * @param item01
	 * @param item02
	 * @param item03
	 * @param item04
	 * @param item05
	 * @param item06
	 * @param ulCode
	 * @param status
	 * @param keyword
	 * @param rank 数据权限
	 * @return
	 */
	public List<Product01SummaryDto> searchProduct01Summary(String fieldcode,
			String item01, String item02, String item03, String item04, String item05,
			String item06, String ulCode, String status, String keyword, String rank);
	
	/**
	 * 产品检索明细列表
	 * @param fieldcode
	 * @param item01
	 * @param item02
	 * @param item03
	 * @param item04
	 * @param item05
	 * @param item06
	 * @param ulCode
	 * @param status
	 * @param keyword
	 * @param rank 数据权限
	 * @param page
	 * @return
	 */
	public Page searchProduct01ListByPage(String fieldcode, String item01, String item02,
			String item03, String item04, String item05, String item06, String ulCode,
			String status, String keyword, String rank, Page page);
	
	/**
	 * 产品检索明细列表（for search page）
	 * 对于对外的WEB页面翻页，不能用SESSION模式，只能用REQUEST，故不能用page参数记录下当前页码，page里面有验证计算startIndex
	 * 所以在改动最小的情况下，这里就把直接页码传过来。
	 * @param fieldcode
	 * @param item01
	 * @param item02
	 * @param item03
	 * @param item04
	 * @param item05
	 * @param item06
	 * @param ulCode
	 * @param status
	 * @param keyword
	 * @param rank 数据权限
	 * @param page
	 * @param startIndex 当前页码
	 * @return
	 */
	public Page searchProduct01List(String fieldcode, String item01, String item02,
			String item03, String item04, String item05, String item06, String ulCode, String status,
			String keyword, String rank, Page page, int startIndex);
	
	/**
	 * 根据产品类型查询所有产品
	 * @param fieldcode
	 * @param status
	 * @param rank
	 * @return
	 */
	public List<Product01Dto> searchProduct01ByGoodsid(String fieldcode, String status, String rank);
	
	/**
	 * 翻页查询数据
	 * @param fieldcode
	 * @param keyword 关键字
	 * @param rank 数据权限
	 * @param page
	 * @return
	 */
	public Page queryProduct01ByPage(String fieldcode,
			String keyword, String rank, Page page);
	
	/**
	 * 根据ID查询数据
	 * @param id
	 * @param rank
	 * @return
	 */
	public Product01Dto queryProduct01ByID(String id, String rank);
	
	/**
	 * 根据产品名称，型号，颜色（逻辑主键）查询产品
	 * @param nameno
	 * @param typeno
	 * @param color1
	 * @return
	 */
	public Product01Dto queryProduct01ByLogicId(String nameno, String typeno, String color1);
	
	/**
	 * 删除数据
	 * @param id
	 * @param userid
	 */
	public void deleteProduct01(String id, String userid);
	
	/**
	 * 新增数据
	 * @param product
	 */
	public void insertProduct01(Product01Dto product);
	
	/**
	 * 修改数据
	 * @param product
	 */
	public void updateProduct01(Product01Dto product);
}
