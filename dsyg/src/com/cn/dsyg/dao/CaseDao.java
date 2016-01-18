package com.cn.dsyg.dao;

import java.util.List;

import com.cn.dsyg.dto.CaseDto;

/**
 * @name CaseDao.java
 * @author Frank
 * @time 2015-2-4上午1:50:13
 * @version 1.0
 */
public interface CaseDao {
	
	/**
	 * 翻页查询数据
	 * @param title
	 * @param fieldcode
	 * @param start
	 * @param end
	 * @return
	 */
	public List<CaseDto> queryCaseByPage(String title, String fieldcode, int start, int end);
	
	/**
	 * 查询总记录数
	 * @param title
	 * @param fieldcode
	 * @return
	 */
	public int queryCaseCountByPage(String title, String fieldcode);

	/**
	 * 根据登录ID查询数据
	 * @param id
	 * @return
	 */
	public CaseDto queryCaseByID(String id);
	
	
	/**
	 * 根据产品类型查询案例
	 * @param fieldcode
	 * @return
	 */
	public List<CaseDto> queryCaseByType(String fieldcode);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<CaseDto> queryAllCase();
	
	/**
	 * 查询案例介绍记录
	 * @param start
	 * @param end
	 * @return
	 */
	public List<CaseDto> queryHomeCase(int start, int end);
	
	/**
	 * 删除数据
	 * @param id
	 */
	public void deleteCase(String id);
	
	/**
	 * 新增数据
	 * @param casedto
	 */
	public void insertCase(CaseDto casedto);
	
	/**
	 * 修改数据
	 * @param casedto
	 */
	public void updateCase(CaseDto casedto);
}
