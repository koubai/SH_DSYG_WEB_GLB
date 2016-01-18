package com.cn.dsyg.service.impl;

import java.util.List;

import com.cn.common.util.Constants;
import com.cn.common.util.Page;
import com.cn.common.util.PropertiesConfig;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dao.NewsDao;
import com.cn.dsyg.dto.NewsDto;
import com.cn.dsyg.service.NewsService;

/**
 * @name NewsServiceImpl.java
 * @author Frank
 * @time 2014-12-25下午10:15:16
 * @version 1.0
 */
public class NewsServiceImpl implements NewsService {

	private NewsDao newsDao;
	
	@Override
	public Page queryNewsByPage(String title, String author, Page page) {
		title = StringUtil.replaceDatabaseKeyword_mysql(title);
		
		//查询总记录数（查询有效数据）
		int totalCount = newsDao.queryNewsCountByPage(title, author);
		page.setTotalCount(totalCount);
		if(totalCount % page.getPageSize() > 0) {
			page.setTotalPage(totalCount / page.getPageSize() + 1);
		} else {
			page.setTotalPage(totalCount / page.getPageSize());
		}
		//翻页查询记录（查询有效数据）
		List<NewsDto> list = newsDao.queryNewsByPage(title, author,
				page.getStartIndex() * page.getPageSize(), page.getPageSize());
		page.setItems(list);
		return page;
	}

	@Override
	public NewsDto queryNewsByID(String id) {
		NewsDto news = newsDao.queryNewsByID(id);
		if(news != null) {
			//图片显示路径
			news.setNewsPicUrl(PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_NEW_PIC_URL));
			return news;
		}
		return null;
	}
	
	@Override
	public List<NewsDto> queryNewsByYear(String year) {
		return newsDao.queryNewsByYear(year);
	}
	
	@Override
	public List<NewsDto> queryHomeNews() {
		return newsDao.queryHomeNews(0, Constants.SHOW_NEWS_COUNT);
	}

	@Override
	public List<NewsDto> queryAllNews() {
		return newsDao.queryAllNews();
	}

	@Override
	public void deleteNews(String id, String userid) {
		//逻辑删除
		NewsDto news = newsDao.queryNewsByID(id);
		if(news != null) {
			//状态=无效
			news.setStatus("" + Constants.STATUS_DEL);
			news.setUpdateuid(userid);
			newsDao.updateNews(news);
		}
		//newsDao.deleteNews(id);
	}

	@Override
	public void insertNews(NewsDto news) {
		newsDao.insertNews(news);
	}

	@Override
	public void updateNews(NewsDto news) {
		newsDao.updateNews(news);
	}

	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
}
