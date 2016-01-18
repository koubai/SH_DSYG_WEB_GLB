package com.cn.dsyg.service;

import com.cn.common.util.Page;
import com.cn.dsyg.dto.WarehouseDto;

/**
 * @name WarehouseService.java
 * @author Frank
 * @time 2015-1-3下午10:22:26
 * @version 1.0
 */
public interface WarehouseService {

	/**
	 * 翻页查询数据
	 * @param productid
	 * @param productname
	 * @param producttype
	 * @param rank 数据权限
	 * @param page
	 * @return
	 */
	public Page queryWarehouseByPage(String productid, String productname, String producttype, String rank, Page page);
	
	/**
	 * 检索库存数据
	 * @param productname
	 * @param producttype
	 * @param rank 数据权限
	 * @param page
	 * @param startIndex
	 * @return
	 */
	public Page searchWarehouseByPage(String productname, String producttype, String rank, Page page, int startIndex);
	
	/**
	 * 根据ID查询数据
	 * @param id
	 * @param rank
	 * @return
	 */
	public WarehouseDto queryWarehouseByID(String id, String rank);
	
	/**
	 * 删除数据
	 * @param id
	 * @param rank
	 * @param userid
	 */
	public void deleteWarehouse(String id, String rank, String userid);
	
	/**
	 * 新增数据
	 * @param warehouse
	 */
	public void insertWarehouse(WarehouseDto warehouse);
	
	/**
	 * 修改数据
	 * @param warehouse
	 */
	public void updateWarehouse(WarehouseDto warehouse);
}
