package com.cn.dsyg.service.impl;

import java.util.List;

import com.cn.common.util.Constants;
import com.cn.common.util.Page;
import com.cn.common.util.PropertiesConfig;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dao.CaseDao;
import com.cn.dsyg.dto.CaseDto;
import com.cn.dsyg.service.CaseService;

/**
 * @name CaseServiceImpl.java
 * @author Frank
 * @time 2015-2-5上午12:37:32
 * @version 1.0
 */
public class CaseServiceImpl implements CaseService {
	
	private CaseDao caseDao;

	@Override
	public Page queryCaseByPage(String title, String fieldcode, Page page) {
		title = StringUtil.replaceDatabaseKeyword_mysql(title);
		//查询总记录数
		int totalCount = caseDao.queryCaseCountByPage(title, fieldcode);
		page.setTotalCount(totalCount);
		if(totalCount % page.getPageSize() > 0) {
			page.setTotalPage(totalCount / page.getPageSize() + 1);
		} else {
			page.setTotalPage(totalCount / page.getPageSize());
		}
		//翻页查询记录
		List<CaseDto> list = caseDao.queryCaseByPage(title, fieldcode,
				page.getStartIndex() * page.getPageSize(), page.getPageSize());
		page.setItems(list);
		return page;
	}

	@Override
	public CaseDto queryCaseByID(String id) {
		CaseDto casedto = caseDao.queryCaseByID(id);
		if(casedto != null) {
			//图片显示路径
			casedto.setCasePicUrl(PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_NEW_PIC_URL));
			return casedto;
		}
		return null;
	}

	@Override
	public List<CaseDto> queryCaseByType(String fieldcode) {
		return caseDao.queryCaseByType(fieldcode);
	}

	@Override
	public List<CaseDto> queryAllCase() {
		return caseDao.queryAllCase();
	}

	@Override
	public List<CaseDto> queryHomeCase(int start, int end) {
		return caseDao.queryHomeCase(start, end);
	}

	@Override
	public void deleteCase(String id) {
		caseDao.deleteCase(id);
	}

	@Override
	public void insertCase(CaseDto casedto) {
		caseDao.insertCase(casedto);
	}

	@Override
	public void updateCase(CaseDto casedto) {
		caseDao.updateCase(casedto);
	}

	public CaseDao getCaseDao() {
		return caseDao;
	}

	public void setCaseDao(CaseDao caseDao) {
		this.caseDao = caseDao;
	}
}
