package com.cn.dsyg.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cn.common.action.BaseAction;
import com.cn.common.util.Constants;
import com.cn.common.util.Page;
import com.cn.dsyg.dto.QaDto;
import com.cn.dsyg.service.QaService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @name QaAction.java
 * @author Frank
 * @time 2015-2-6上午2:04:15
 * @version 1.0
 */
public class QaAction extends BaseAction {

	private static final Logger log = LogManager.getLogger(QaAction.class);
	private static final long serialVersionUID = 4504216653134620318L;
	
	private QaService qaService;

	/**
	 * 页码
	 */
	private int startIndex;
	
	/**
	 * 翻页
	 */
	private Page page;
	
	private QaDto queryQaDto;
	
	private List<QaDto> qaList;
	
	//删除
	private String delQaId;
	
	/**
	 * QA页面
	 * @return
	 */
	public String showQaAction() {
		try {
			this.clearMessages();
			queryQaDto = new QaDto();
			delQaId = "";
			page = new Page();
			startIndex = 0;
		} catch(Exception e) {
			log.error("showQaAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 查询QA
	 * @return
	 */
	public String queryQaAction() {
		try {
			this.clearMessages();
			page = new Page();
			startIndex = 0;
			queryData();
		} catch(Exception e) {
			log.error("queryQaAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 翻页
	 * @return
	 */
	public String turnQaAction() {
		try {
			this.clearMessages();
			queryData();
		} catch(Exception e) {
			log.error("turnQaAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 删除QA
	 * @return
	 */
	public String delQaAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限删除
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			//当前操作用户ID
			String userid = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			qaService.deleteQa(delQaId, userid);
			//刷新数据
			page = new Page();
			startIndex = 0;
			queryData();
		} catch(Exception e) {
			log.error("queryQaAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 数据查询
	 */
	@SuppressWarnings("unchecked")
	private void queryData() {
		qaList = new ArrayList<QaDto>();
		if(page == null) {
			page = new Page();
		}
		this.page.setStartIndex(startIndex);
		page = qaService.queryQaByPage(queryQaDto.getTitle(), queryQaDto.getCompany(), queryQaDto.getTell(), page);
		qaList = (List<QaDto>) page.getItems();
		this.setStartIndex(page.getStartIndex());
		delQaId = "";
	}

	public QaDto getQueryQaDto() {
		return queryQaDto;
	}

	public void setQueryQaDto(QaDto queryQaDto) {
		this.queryQaDto = queryQaDto;
	}

	public QaService getQaService() {
		return qaService;
	}

	public void setQaService(QaService qaService) {
		this.qaService = qaService;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<QaDto> getQaList() {
		return qaList;
	}

	public void setQaList(List<QaDto> qaList) {
		this.qaList = qaList;
	}

	public String getDelQaId() {
		return delQaId;
	}

	public void setDelQaId(String delQaId) {
		this.delQaId = delQaId;
	}
}
