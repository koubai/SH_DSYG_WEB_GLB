package com.cn.dsyg.dao;

import java.util.List;

import com.cn.dsyg.dto.WarehouseDto;

/**
 * @name WarehouseDao.java
 * @author Frank
 * @time 2015-1-3下午9:45:28
 * @version 1.0
 */
public interface WarehouseDao {

	/**
	 * 翻页查询数据
	 * @param productid
	 * @param productname
	 * @param producttype
	 * @param status
	 * @param rank 数据权限
	 * @param start
	 * @param end
	 * @return
	 */
	public List<WarehouseDto> queryWarehouseByPage(String productid, String productname,
			String producttype, String status, String rank, int start, int end);
	
	/**
	 * 查询总记录数
	 * @param productid
	 * @param productname
	 * @param producttype
	 * @param status
	 * @param rank 数据权限
	 * @return
	 */
	public int queryWarehouseCountByPage(String productid, String productname, String producttype, String status, String rank);

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
	 */
	public void deleteWarehouse(String id);
	
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
	
	/**
	 * 根据产品ID逻辑删除库存信息数据
	 * @param productid
	 * @param status
	 * @param userid
	 */
	public void deleteWarehouseByProductid(String productid, String status, String userid);
}
