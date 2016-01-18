package com.cn.dsyg.dao;

import java.util.List;

import com.cn.dsyg.dto.NewsDto;

/**
 * @name NewsDao.java
 * @author Frank
 * @time 2014-12-9上午12:38:28
 * @version 1.0
 */
public interface NewsDao {
	
	/**
	 * 翻页查询数据
	 * @param title
	 * @param author
	 * @param start
	 * @param end
	 * @return
	 */
	public List<NewsDto> queryNewsByPage(String title, String author, int start, int end);
	
	/**
	 * 查询总记录数
	 * @param title
	 * @param author
	 * @return
	 */
	public int queryNewsCountByPage(String title, String author);

	/**
	 * 根据登录ID查询数据
	 * @param id
	 * @return
	 */
	public NewsDto queryNewsByID(String id);
	
	
	/**
	 * 根据年份查询新闻列表
	 * @param year
	 * @return
	 */
	public List<NewsDto> queryNewsByYear(String year);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<NewsDto> queryAllNews();
	
	/**
	 * 查询首页显示新闻记录
	 * @param start
	 * @param end
	 * @return
	 */
	public List<NewsDto> queryHomeNews(int start, int end);
	
	/**
	 * 删除数据
	 * @param id
	 */
	public void deleteNews(String id);
	
	/**
	 * 新增数据
	 * @param news
	 */
	public void insertNews(NewsDto news);
	
	/**
	 * 修改数据
	 * @param news
	 */
	public void updateNews(NewsDto news);
}
