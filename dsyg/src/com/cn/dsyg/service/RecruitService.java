package com.cn.dsyg.service;

import java.util.List;

import com.cn.common.util.Page;
import com.cn.dsyg.dto.RecruitDto;

public interface RecruitService {
	
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
	 * @param page
	 * @return
	 */
	public Page queryRecruitByPage(String title, String recruittype, String status, Page page);
	
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
