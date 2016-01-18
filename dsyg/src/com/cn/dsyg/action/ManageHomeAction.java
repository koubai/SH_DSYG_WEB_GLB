package com.cn.dsyg.action;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cn.common.action.BaseAction;

/**
 * @name ManageHomeAction.java
 * @author Frank
 * @time 2015-1-4上午2:07:23
 * @version 1.0
 */
public class ManageHomeAction extends BaseAction {

	private static final long serialVersionUID = -4429037297842259979L;
	private static final Logger log = LogManager.getLogger(ManageHomeAction.class);

	/**
	 * 显示用户菜单页面
	 * @return
	 */
	public String showManageHomeAction() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showManageHomeAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
}
