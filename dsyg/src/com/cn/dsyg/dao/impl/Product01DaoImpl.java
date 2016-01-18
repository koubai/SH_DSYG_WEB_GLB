package com.cn.dsyg.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.common.dao.BaseDao;
import com.cn.dsyg.dao.Product01Dao;
import com.cn.dsyg.dto.Product01Dto;
import com.cn.dsyg.dto.Product01SummaryDto;
import com.cn.dsyg.dto.Product01TmpDto;

/**
 * @name Product01DaoImpl.java
 * @author Frank
 * @time 2014-12-17上午1:15:58
 * @version 1.0
 */
public class Product01DaoImpl extends BaseDao implements Product01Dao {
	
	@Override
	public List<Product01Dto> searchProduct01ByGoodsid(String fieldcode,
			String status, String rank) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fieldcode", fieldcode);
		paramMap.put("status", status);
		paramMap.put("rank", rank);
		@SuppressWarnings("unchecked")
		List<Product01Dto> list = getSqlMapClientTemplate().queryForList("searchProduct01ByGoodsid", paramMap);
		return list;
	}
	
	@Override
	public List<Product01SummaryDto> searchProduct01Summary(String fieldcode, String item01,
			String item02, String item03, String item04, String item05, String item06, String ulCode,
			String status, String keyword, String rank) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fieldcode", fieldcode);
		paramMap.put("item01", item01);
		paramMap.put("item02", item02);
		paramMap.put("item03", item03);
		paramMap.put("item04", item04);
		paramMap.put("item05", item05);
		paramMap.put("item06", item06);
		//ulCode
		paramMap.put("item09", ulCode);
		paramMap.put("status", status);
		paramMap.put("keyword", keyword);
		paramMap.put("rank", rank);
		@SuppressWarnings("unchecked")
		List<Product01SummaryDto> list = getSqlMapClientTemplate().queryForList("searchProduct01Summary", paramMap);
		return list;
	}

	@Override
	public List<Product01TmpDto> searchProduct01ListByPage(String fieldcode, String item01,
			String item02, String item03, String item04, String item05, String item06,
			String ulCode, String status, String keyword, String rank, int start, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fieldcode", fieldcode);
		paramMap.put("item01", item01);
		paramMap.put("item02", item02);
		paramMap.put("item03", item03);
		paramMap.put("item04", item04);
		paramMap.put("item05", item05);
		paramMap.put("item06", item06);
		//ulCode
		paramMap.put("item09", ulCode);
		paramMap.put("status", status);
		paramMap.put("keyword", keyword);
		paramMap.put("rank", rank);
		paramMap.put("start", start);
		paramMap.put("end", end);
		@SuppressWarnings("unchecked")
		List<Product01TmpDto> list = getSqlMapClientTemplate().queryForList("searchProduct01ListByPage", paramMap);
		return list;
	}

	@Override
	public int searchProduct01ListCountByPage(String fieldcode, String item01, String item02,
			String item03, String item04, String item05, String item06, String ulCode, String status,
			String keyword, String rank) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fieldcode", fieldcode);
		paramMap.put("item01", item01);
		paramMap.put("item02", item02);
		paramMap.put("item03", item03);
		paramMap.put("item04", item04);
		paramMap.put("item05", item05);
		paramMap.put("item06", item06);
		//ulCode
		paramMap.put("item09", ulCode);
		paramMap.put("status", status);
		paramMap.put("keyword", keyword);
		paramMap.put("rank", rank);
		return (Integer) getSqlMapClientTemplate().queryForObject("searchProduct01ListCountByPage", paramMap);
	}
	
	@Override
	public List<Product01Dto> queryProduct01ByPage(String fieldcode,
			String keyword, String status, String rank, int start, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fieldcode", fieldcode);
		paramMap.put("keyword", keyword);
		paramMap.put("status", status);
		paramMap.put("rank", rank);
		paramMap.put("start", start);
		paramMap.put("end", end);
		@SuppressWarnings("unchecked")
		List<Product01Dto> list = getSqlMapClientTemplate().queryForList("queryProduct01ByPage", paramMap);
		return list;
	}

	@Override
	public int queryProduct01CountByPage(String fieldcode, String keyword, String status, String rank) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fieldcode", fieldcode);
		paramMap.put("keyword", keyword);
		paramMap.put("status", status);
		paramMap.put("rank", rank);
		return (Integer) getSqlMapClientTemplate().queryForObject("queryProduct01CountByPage", paramMap);
	}

	@Override
	public Product01Dto queryProduct01ByID(String id, String rank) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("rank", rank);
		@SuppressWarnings("unchecked")
		List<Product01Dto> list = getSqlMapClientTemplate().queryForList("queryProduct01ByID", paramMap);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public Product01Dto queryProduct01ByLogicId(String nameno, String typeno,
			String color1) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("nameno", nameno);
		paramMap.put("typeno", typeno);
		paramMap.put("color1", color1);
		@SuppressWarnings("unchecked")
		List<Product01Dto> list = getSqlMapClientTemplate().queryForList("queryProduct01ByLogicId", paramMap);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deleteProduct01(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		getSqlMapClientTemplate().delete("deleteProduct01", paramMap);
	}

	@Override
	public void insertProduct01(Product01Dto product) {
		getSqlMapClientTemplate().insert("insertProduct01", product);
	}

	@Override
	public void updateProduct01(Product01Dto product) {
		getSqlMapClientTemplate().update("updateProduct01", product);
	}
}
