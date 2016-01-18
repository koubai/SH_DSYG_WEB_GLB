package com.cn.dsyg.service.impl;

import java.util.List;

import com.cn.common.util.Page;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dao.RecruitDao;
import com.cn.dsyg.dto.RecruitDto;
import com.cn.dsyg.service.RecruitService;

/**
 * @name RecruitServiceImpl.java
 * @author Frank
 * @time 2015-2-5上午12:36:33
 * @version 1.0
 */
public class RecruitServiceImpl implements RecruitService {
	
	private RecruitDao recruitDao;
	
	@Override
	public List<RecruitDto> queryAllRecruit() {
		return recruitDao.queryAllRecruit();
	}

	@Override
	public Page queryRecruitByPage(String title, String recruittype,
			String status, Page page) {
		title = StringUtil.replaceDatabaseKeyword_mysql(title);
		//查询总记录数
		int totalCount = recruitDao.queryRecruitCountByPage(title, recruittype, status);
		page.setTotalCount(totalCount);
		if(totalCount % page.getPageSize() > 0) {
			page.setTotalPage(totalCount / page.getPageSize() + 1);
		} else {
			page.setTotalPage(totalCount / page.getPageSize());
		}
		//翻页查询记录
		List<RecruitDto> list = recruitDao.queryRecruitByPage(title, recruittype, status,
				page.getStartIndex() * page.getPageSize(), page.getPageSize());
		page.setItems(list);
		return page;
	}

	@Override
	public RecruitDto queryRecruitByID(String id) {
		return recruitDao.queryRecruitByID(id);
	}

	@Override
	public void deleteRecruit(String id) {
		recruitDao.deleteRecruit(id);
	}

	@Override
	public void insertRecruit(RecruitDto recruit) {
		recruitDao.insertRecruit(recruit);
	}

	@Override
	public void updateRecruit(RecruitDto recruit) {
		recruitDao.updateRecruit(recruit);
	}

	public RecruitDao getRecruitDao() {
		return recruitDao;
	}

	public void setRecruitDao(RecruitDao recruitDao) {
		this.recruitDao = recruitDao;
	}
}
