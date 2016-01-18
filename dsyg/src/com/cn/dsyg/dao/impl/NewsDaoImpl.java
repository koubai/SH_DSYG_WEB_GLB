package com.cn.dsyg.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.common.dao.BaseDao;
import com.cn.dsyg.dao.NewsDao;
import com.cn.dsyg.dto.NewsDto;

/**
 * @name NewsDaoImpl.java
 * @author Frank
 * @time 2014-12-9上午12:42:14
 * @version 1.0
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {

	@Override
	public List<NewsDto> queryNewsByPage(String title, String author, int start, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", title);
		paramMap.put("author", author);
		paramMap.put("start", start);
		paramMap.put("end", end);
		@SuppressWarnings("unchecked")
		List<NewsDto> list = getSqlMapClientTemplate().queryForList("queryNewsByPage", paramMap);
		return list;
	}

	@Override
	public int queryNewsCountByPage(String title, String author) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", title);
		paramMap.put("author", author);
		return (Integer) getSqlMapClientTemplate().queryForObject("queryNewsCountByPage", paramMap);
	}

	@Override
	public NewsDto queryNewsByID(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		@SuppressWarnings("unchecked")
		List<NewsDto> list = getSqlMapClientTemplate().queryForList("queryNewsByID", paramMap);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	@Override
	public List<NewsDto> queryNewsByYear(String year) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("year", year);
		@SuppressWarnings("unchecked")
		List<NewsDto> list = getSqlMapClientTemplate().queryForList("queryNewsByYear", paramMap);
		return list;
	}
	
	@Override
	public List<NewsDto> queryHomeNews(int start, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("start", start);
		paramMap.put("end", end);
		@SuppressWarnings("unchecked")
		List<NewsDto> list = getSqlMapClientTemplate().queryForList("queryHomeNews", paramMap);
		return list;
	}

	@Override
	public List<NewsDto> queryAllNews() {
		@SuppressWarnings("unchecked")
		List<NewsDto> list = getSqlMapClientTemplate().queryForList("queryAllNews");
		return list;
	}

	@Override
	public void deleteNews(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		getSqlMapClientTemplate().delete("deleteNews", paramMap);
	}

	@Override
	public void insertNews(NewsDto news) {
		getSqlMapClientTemplate().insert("insertNews", news);
	}

	@Override
	public void updateNews(NewsDto news) {
		getSqlMapClientTemplate().update("updateNews", news);
	}
}
