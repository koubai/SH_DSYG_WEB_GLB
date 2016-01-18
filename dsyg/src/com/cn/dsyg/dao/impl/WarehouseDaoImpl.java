package com.cn.dsyg.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.common.dao.BaseDao;
import com.cn.dsyg.dao.WarehouseDao;
import com.cn.dsyg.dto.WarehouseDto;

/**
 * @name WarehouseDaoImpl.java
 * @author Frank
 * @time 2015-1-3下午9:53:47
 * @version 1.0
 */
public class WarehouseDaoImpl extends BaseDao implements WarehouseDao {

	@Override
	public List<WarehouseDto> queryWarehouseByPage(String productid, String productname, String producttype,
			String status, String rank, int start, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productname", productname);
		paramMap.put("producttype", producttype);
		paramMap.put("productid", productid);
		paramMap.put("status", status);
		paramMap.put("rank", rank);
		paramMap.put("start", start);
		paramMap.put("end", end);
		@SuppressWarnings("unchecked")
		List<WarehouseDto> list = getSqlMapClientTemplate().queryForList("queryWarehouseByPage", paramMap);
		return list;
	}

	@Override
	public int queryWarehouseCountByPage(String productid, String productname, String producttype, String status,
			String rank) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productname", productname);
		paramMap.put("producttype", producttype);
		paramMap.put("productid", productid);
		paramMap.put("status", status);
		paramMap.put("rank", rank);
		return (Integer) getSqlMapClientTemplate().queryForObject("queryWarehouseCountByPage", paramMap);
	}

	@Override
	public WarehouseDto queryWarehouseByID(String id, String rank) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("rank", rank);
		@SuppressWarnings("unchecked")
		List<WarehouseDto> list = getSqlMapClientTemplate().queryForList("queryWarehouseByID", paramMap);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deleteWarehouse(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		getSqlMapClientTemplate().delete("deleteWarehouse", paramMap);
	}

	@Override
	public void insertWarehouse(WarehouseDto warehouse) {
		getSqlMapClientTemplate().insert("insertWarehouse", warehouse);
	}

	@Override
	public void updateWarehouse(WarehouseDto warehouse) {
		getSqlMapClientTemplate().update("updateWarehouse", warehouse);
	}
	
	@Override
	public void deleteWarehouseByProductid(String productid, String status, String userid) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productid", productid);
		paramMap.put("updateuid", userid);
		paramMap.put("status", status);
		getSqlMapClientTemplate().update("deleteWarehouseByProductid", paramMap);
	}
}
