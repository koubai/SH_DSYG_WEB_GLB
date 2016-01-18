package com.cn.dsyg.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.common.dao.BaseDao;
import com.cn.dsyg.dao.CaseDao;
import com.cn.dsyg.dto.CaseDto;

/**
 * @name CaseDaoImpl.java
 * @author Frank
 * @time 2015-2-4上午1:53:40
 * @version 1.0
 */
public class CaseDaoImpl extends BaseDao implements CaseDao {

	@Override
	public List<CaseDto> queryCaseByPage(String title, String fieldcode,
			int start, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", title);
		paramMap.put("fieldcode", fieldcode);
		paramMap.put("start", start);
		paramMap.put("end", end);
		@SuppressWarnings("unchecked")
		List<CaseDto> list = getSqlMapClientTemplate().queryForList("queryCaseByPage", paramMap);
		return list;
	}

	@Override
	public int queryCaseCountByPage(String title, String fieldcode) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", title);
		paramMap.put("fieldcode", fieldcode);
		return (Integer) getSqlMapClientTemplate().queryForObject("queryCaseCountByPage", paramMap);
	}

	@Override
	public CaseDto queryCaseByID(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		@SuppressWarnings("unchecked")
		List<CaseDto> list = getSqlMapClientTemplate().queryForList("queryCaseByID", paramMap);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<CaseDto> queryCaseByType(String fieldcode) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fieldcode", fieldcode);
		@SuppressWarnings("unchecked")
		List<CaseDto> list = getSqlMapClientTemplate().queryForList("queryCaseByType", paramMap);
		return list;
	}

	@Override
	public List<CaseDto> queryAllCase() {
		@SuppressWarnings("unchecked")
		List<CaseDto> list = getSqlMapClientTemplate().queryForList("queryAllCase");
		return list;
	}

	@Override
	public List<CaseDto> queryHomeCase(int start, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("end", end);
		@SuppressWarnings("unchecked")
		List<CaseDto> list = getSqlMapClientTemplate().queryForList("queryHomeCase", paramMap);
		return list;
	}

	@Override
	public void deleteCase(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		getSqlMapClientTemplate().delete("deleteCase", paramMap);
	}

	@Override
	public void insertCase(CaseDto casedto) {
		getSqlMapClientTemplate().insert("insertCase", casedto);
	}

	@Override
	public void updateCase(CaseDto casedto) {
		getSqlMapClientTemplate().update("updateCase", casedto);
	}
}
