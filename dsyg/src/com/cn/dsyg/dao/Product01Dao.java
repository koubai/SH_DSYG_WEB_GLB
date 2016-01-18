package com.cn.dsyg.dao;

import java.util.List;

import com.cn.dsyg.dto.Product01Dto;
import com.cn.dsyg.dto.Product01SummaryDto;
import com.cn.dsyg.dto.Product01TmpDto;

/**
 * @name Product01Dao.java
 * @author Frank
 * @time 2014-12-9上午12:38:28
 * @version 1.0
 */
public interface Product01Dao {
	
	/**
	 * 根据产品类型查询所有产品
	 * @param fieldcode
	 * @param status
	 * @param rank
	 * @return
	 */
	public List<Product01Dto> searchProduct01ByGoodsid(String fieldcode, String status, String rank);
	
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
	public List<Product01SummaryDto> searchProduct01Summary(String fieldcode, String item01,
			String item02, String item03, String item04, String item05, String item06, String ulCode,
			String status, String keyword, String rank);
	
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
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Product01TmpDto> searchProduct01ListByPage(String fieldcode, String item01,
			String item02, String item03, String item04, String item05, String item06,
			String ulCode, String status, String keyword, String rank, int start, int end);
	
	/**
	 * 产品检索明细数据量
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
	public int searchProduct01ListCountByPage(String fieldcode, String item01,
			String item02, String item03, String item04, String item05, String item06,
			String ulCode, String status, String keyword, String rank);
	
	/**
	 * 翻页查询数据
	 * @param fieldcode
	 * @param keyword 关键字
	 * @param status
	 * @param rank 数据权限
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Product01Dto> queryProduct01ByPage(String fieldcode,
			String keyword, String status, String rank, int start, int end);
	
	/**
	 * 查询总记录数
	 * @param fieldcode
	 * @param keyword
	 * @param status
	 * @param rank 数据权限
	 * @return
	 */
	public int queryProduct01CountByPage(String fieldcode, String keyword, String status, String rank);

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
	 */
	public void deleteProduct01(String id);
	
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
