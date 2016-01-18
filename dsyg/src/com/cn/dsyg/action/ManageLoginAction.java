package com.cn.dsyg.action;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cn.common.action.BaseAction;
import com.cn.common.util.Constants;
import com.cn.common.util.DateUtil;
import com.cn.common.util.MD5Util;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dto.RoleDto;
import com.cn.dsyg.dto.UserDto;
import com.cn.dsyg.service.RoleService;
import com.cn.dsyg.service.UserService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 管理员登录Action
 * @author Frank
 * @time 2013-9-24下午8:36:53
 * @version 1.0
 */
public class ManageLoginAction extends BaseAction {

	private static final Logger log = LogManager.getLogger(ManageLoginAction.class);
	
	private static final long serialVersionUID = -3307892137806702480L;
	
	private RoleService roleService;
	
	private UserService userService;
	
	private UserDto userDto;
	
	/**
	 * 显示用户登录页
	 * @return
	 */
	public String showManageLoginAction() {
		try {
			this.clearMessages();
			String ip = this.getIP();
			log.info("ip=" + ip);
			userDto = new UserDto();
		} catch(Exception e) {
			log.error("showManageLoginAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String manageLoginAction() {
		try {
			this.clearMessages();
			if(userDto == null) {
				return ERROR;
			}
			if(StringUtil.isBlank(userDto.getUserid())) {
				this.addActionMessage("用户名不能为空！");
				return ERROR;
			}
			if(StringUtil.isBlank(userDto.getPassword())) {
				this.addActionMessage("登录密码不能为空！");
				return ERROR;
			}
			if(StringUtil.isBlank(userDto.getVerificationcode())) {
				this.addActionMessage("验证码不能为空！");
				return ERROR;
			}
			String rand = (String) ActionContext.getContext().getSession().get(Constants.RANDOM);
			if(!userDto.getVerificationcode().equals(rand)) {
				this.addActionMessage("验证码不正确！");
				return ERROR;
			}
			//验证登录密码
			UserDto user = userService.queryUserByID(userDto.getUserid());
			if(!MD5Util.md5(userDto.getPassword()).equals(user.getPassword())) {
				this.addActionMessage("登录密码不正确！");
				return ERROR;
			}
			//判断用户状态是否是有效
			if(user.getStatus() != Constants.STATUS_NORMAL) {
				this.addActionMessage("非有效用户！");
				return ERROR;
			}
			//用户权限
			RoleDto role = roleService.queryRoleByCode(user.getRolecode());
			ActionContext.getContext().getSession().put(Constants.ROLE_RANK, role.getRank());
			ActionContext.getContext().getSession().put(Constants.USER_ID, userDto.getUserid());
			ActionContext.getContext().getSession().put(Constants.USER_NAME, user.getUsername());
			ActionContext.getContext().getSession().put(Constants.LOGIN_TIME, DateUtil.dateToLogintime(new Date()));
			ActionContext.getContext().getSession().put(Constants.SESSION_ISLOGIN, Constants.FLAG_IS_LOGIN);
			log.info(userDto.getUserid() + " login success.");
		} catch(Exception e) {
			log.error("manageLoginAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	public String manageLogoutAction() {
		try {
			this.clearMessages();
			ActionContext.getContext().getSession().clear();
			userDto = new UserDto();
		} catch(Exception e) {
			log.error("manageLogoutAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
