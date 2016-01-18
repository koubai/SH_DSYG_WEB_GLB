package com.cn.dsyg.dao;

import java.util.List;

import com.cn.dsyg.dto.RecruitDto;

/**
 * 招聘信息DAO
 * @name RecruitDao.java
 * @author Frank
 * @time 2015-2-5上午12:34:53
 * @version 1.0
 */
public interface RecruitDao {
	
	/**
	 * 查询所有的招聘信息
	 * @return
	 */
	public List<RecruitDto> queryAllRecruit();

	/**
	 * 翻页查询数据
	 * @param title
	 * @param recruittype
	 * @param status
	 * @param start
	 * @param end
	 * @return
	 */
	public List<RecruitDto> queryRecruitByPage(String title, String recruittype, String status, int start, int end);
	
	/**
	 * 查询总记录数
	 * @param title
	 * @param recruittype
	 * @param status
	 * @return
	 */
	public int queryRecruitCountByPage(String title, String recruittype, String status);

	/**
	 * 根据登录ID查询数据
	 * @param id
	 * @return
	 */
	public RecruitDto queryRecruitByID(String id);
	
	/**
	 * 删除数据
	 * @param id
	 */
	public void deleteRecruit(String id);
	
	/**
	 * 新增数据
	 * @param recruit
	 */
	public void insertRecruit(RecruitDto recruit);
	
	/**
	 * 修改数据
	 * @param recruit
	 */
	public void updateRecruit(RecruitDto recruit);
}
