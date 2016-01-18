package com.cn.dsyg.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.common.dao.BaseDao;
import com.cn.dsyg.dao.RecruitDao;
import com.cn.dsyg.dto.RecruitDto;

public class RecruitDaoImpl extends BaseDao implements RecruitDao {
	
	@Override
	public List<RecruitDto> queryAllRecruit() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		List<RecruitDto> list = getSqlMapClientTemplate().queryForList("queryAllRecruit", paramMap);
		return list;
	}

	@Override
	public List<RecruitDto> queryRecruitByPage(String title,
			String recruittype, String status, int start, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", title);
		paramMap.put("recruittype", recruittype);
		paramMap.put("status", status);
		paramMap.put("start", start);
		paramMap.put("end", end);
		@SuppressWarnings("unchecked")
		List<RecruitDto> list = getSqlMapClientTemplate().queryForList("queryRecruitByPage", paramMap);
		return list;
	}

	@Override
	public int queryRecruitCountByPage(String title, String recruittype,
			String status) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", title);
		paramMap.put("recruittype", recruittype);
		paramMap.put("status", status);
		return (Integer) getSqlMapClientTemplate().queryForObject("queryRecruitCountByPage", paramMap);
	}

	@Override
	public RecruitDto queryRecruitByID(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		@SuppressWarnings("unchecked")
		List<RecruitDto> list = getSqlMapClientTemplate().queryForList("queryRecruitByID", paramMap);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deleteRecruit(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		getSqlMapClientTemplate().delete("deleteRecruit", paramMap);
	}

	@Override
	public void insertRecruit(RecruitDto recruit) {
		getSqlMapClientTemplate().insert("insertRecruit", recruit);
	}

	@Override
	public void updateRecruit(RecruitDto recruit) {
		getSqlMapClientTemplate().update("updateRecruit", recruit);
	}
}
