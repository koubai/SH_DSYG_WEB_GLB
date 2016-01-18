package com.cn.dsyg.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cn.common.action.BaseAction;
import com.cn.common.util.Constants;
import com.cn.common.util.MD5Util;
import com.cn.common.util.Page;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dto.RoleDto;
import com.cn.dsyg.dto.UserDto;
import com.cn.dsyg.service.RoleService;
import com.cn.dsyg.service.UserService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @name UserAction.java
 * @author Frank
 * @time 2014-12-13下午2:07:24
 * @version 1.0
 */
public class UserAction extends BaseAction {

	private static final long serialVersionUID = -36067602288448902L;
	
	private static final Logger log = LogManager.getLogger(UserAction.class);
	
	private UserService userService;
	
	private RoleService roleService;
	
	/**
	 * 页码
	 */
	private int startIndex;
	
	/**
	 * 翻页
	 */
	private Page page;
	
	private String queryUsername;
	
	private List<UserDto> userList;
	//角色列表
	private List<RoleDto> showRoleDtoList;
	//添加用户
	private UserDto addUserDto;
	//修改用户
	private String updUserid;
	private UserDto updUserDto;
	//删除用户
	private String delUserid;
	//修改密码
	private UserDto psdUserDto;
	
	/**
	 * 显示密码修改页面
	 * @return
	 */
	public String showUpdPasswordAction() {
		try {
			this.clearMessages();
			psdUserDto = new UserDto();
		} catch(Exception e) {
			log.error("showUpdPassword error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 密码修改
	 * @return
	 */
	public String updPasswordAction() {
		try {
			this.clearMessages();
			if(psdUserDto == null) {
				this.addActionMessage("请输入旧密码！");
				return "checkerror";
			}
			if(StringUtil.isBlank(psdUserDto.getOldpassword())) {
				this.addActionMessage("请输入旧密码！");
				return "checkerror";
			}
			//当前操作用户ID
			String userid = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			//验证旧密码是否正确
			UserDto user = userService.queryUserByID(userid);
			if(!MD5Util.md5(psdUserDto.getOldpassword()).equals(user.getPassword())) {
				this.addActionMessage("旧密码不正确！");
				return "checkerror";
			}
			if(StringUtil.isBlank(psdUserDto.getPassword())) {
				this.addActionMessage("请输入新密码！");
				return "checkerror";
			}
			if(psdUserDto.getPassword().length() < 4) {
				this.addActionMessage("登录密码不能少于4位！");
				return "checkerror";
			}
			if(StringUtil.isBlank(psdUserDto.getRepassword())) {
				this.addActionMessage("确认密码不能为空！");
				return "checkerror";
			}
			if(!psdUserDto.getPassword().equals(psdUserDto.getRepassword())) {
				this.addActionMessage("两次密码不一致！");
				return "checkerror";
			}
			//修改密码
			psdUserDto.setUserid(userid);
			userService.updPassword(psdUserDto);
			this.addActionMessage("密码修改成功！");
			psdUserDto = new UserDto();
		} catch(Exception e) {
			log.error("showUpdPassword error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 显示用户管理页面
	 * @return
	 */
	public String showUserManagePageAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			startIndex = 0;
			page = new Page();
			userList = new ArrayList<UserDto>();
			addUserDto = new UserDto();
		} catch(Exception e) {
			log.error("showUserManagePageAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询用户
	 * @return
	 */
	public String queryUserAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			startIndex = 0;
			page = new Page();
			queryData();
		} catch(Exception e) {
			log.error("queryUserAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 翻页
	 * @return
	 */
	public String turnUserAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			queryData();
		} catch(Exception e) {
			log.error("turnUserAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	//其他操作
	/**
	 * 显示添加用户页面
	 * @return
	 */
	public String showAddUserAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			addUserDto = new UserDto();
			addUserDto.setRolecode(Constants.ROLE_CODE_EMPLOYEE);
			addUserDto.setStatus(Constants.STATUS_NORMAL);
			showRoleDtoList = roleService.queryAllRole();
		} catch(Exception e) {
			log.error("showAddUserAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 添加用户
	 * @return
	 */
	public String addUserAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			showRoleDtoList = roleService.queryAllRole();
			//数据check
			if(!checkData(addUserDto, false)) {
				return "checkerror";
			}
			
			//验证ID是否存在
			UserDto user = userService.queryUserByID(addUserDto.getUserid());
			if(user != null) {
				this.addActionMessage("该登录ID已存在！");
				return "checkerror";
			}
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_NAME);
			addUserDto.setUpdateuid(username);
			addUserDto.setCreateuid(username);
			
			userService.insertUser(addUserDto);
			this.addActionMessage("添加用户成功！");
			addUserDto = new UserDto();
		} catch(Exception e) {
			log.error("addUserAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 显示修改用户页面
	 * @return
	 */
	public String showUpdUserAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			showRoleDtoList = roleService.queryAllRole();
			//查询用户信息
			updUserDto = userService.queryUserByID(updUserid);
		} catch(Exception e) {
			log.error("showUpdUserAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 修改用户
	 * @return
	 */
	public String updUserAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			showRoleDtoList = roleService.queryAllRole();
			//数据校验
			if(!checkData(updUserDto, true)) {
				return "checkerror";
			}
			//修改
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_NAME);
			updUserDto.setUpdateuid(username);
			userService.updateUser(updUserDto);
			this.addActionMessage("修改用户成功！");
		} catch(Exception e) {
			log.error("updUserAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	public String delUserAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			if(StringUtil.isBlank(delUserid)) {
				this.addActionMessage("用户登录ID不能为空！");
				return "checkerror";
			}
			if(Constants.ROLE_CODE_ADMIN.equals(delUserid)) {
				this.addActionMessage("该用户为系统管理员，不能删除！");
				return "checkerror";
			}
			//删除用户
			userService.deleteUser(delUserid);
			this.addActionMessage("删除成功！");
			//刷新页面
			startIndex = 0;
			queryData();
			delUserid = "";
		} catch(Exception e) {
			log.error("updUserAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 数据check
	 * @return
	 */
	private boolean checkData(UserDto user, boolean isupd) {
		if(user == null) {
			this.addActionMessage("登录ID不能为空！");
			return false;
		}
		if(StringUtil.isBlank(user.getUserid())) {
			this.addActionMessage("登录ID不能为空！");
			return false;
		}
		//非法字符验证
		if(StringUtil.checkString(user.getUserid())) {
			this.addActionMessage("登录ID只能为英数字！");
			return false;
		}
		if(StringUtil.isBlank(user.getUsername())) {
			this.addActionMessage("用户姓名不能为空！");
			return false;
		}
		if(!isupd) {
			if(StringUtil.isBlank(user.getPassword())) {
				this.addActionMessage("登录密码不能为空！");
				return false;
			}
			if(user.getPassword().length() < 4) {
				this.addActionMessage("登录密码不能少于4位！");
				return false;
			}
			if(StringUtil.isBlank(user.getRepassword())) {
				this.addActionMessage("确认密码不能为空！");
				return false;
			}
			if(!user.getPassword().equals(user.getRepassword())) {
				this.addActionMessage("两次密码不一致！");
				return false;
			}
		}
		if(StringUtil.isBlank(user.getRolecode())) {
			this.addActionMessage("角色不能为空！");
			return false;
		}
		if(user.getNote() != null && user.getNote().length() > 80) {
			this.addActionMessage("备注不能超过80个字！");
			return false;
		}
		return true;
	}
	
	/**
	 * 查询数据
	 */
	@SuppressWarnings("unchecked")
	private void queryData() {
		showRoleDtoList = roleService.queryAllRole();
		userList = new ArrayList<UserDto>();
		if(page == null) {
			page = new Page();
		}
		//翻页查询所有委托公司
		this.page.setStartIndex(startIndex);
		page = userService.queryUserByPage(queryUsername, page);
		userList = (List<UserDto>) page.getItems();
		this.setStartIndex(page.getStartIndex());
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

	public List<UserDto> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDto> userList) {
		this.userList = userList;
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

	public String getQueryUsername() {
		return queryUsername;
	}

	public void setQueryUsername(String queryUsername) {
		this.queryUsername = queryUsername;
	}

	public UserDto getAddUserDto() {
		return addUserDto;
	}

	public void setAddUserDto(UserDto addUserDto) {
		this.addUserDto = addUserDto;
	}

	public List<RoleDto> getShowRoleDtoList() {
		return showRoleDtoList;
	}

	public void setShowRoleDtoList(List<RoleDto> showRoleDtoList) {
		this.showRoleDtoList = showRoleDtoList;
	}

	public String getDelUserid() {
		return delUserid;
	}

	public void setDelUserid(String delUserid) {
		this.delUserid = delUserid;
	}

	public UserDto getUpdUserDto() {
		return updUserDto;
	}

	public void setUpdUserDto(UserDto updUserDto) {
		this.updUserDto = updUserDto;
	}

	public String getUpdUserid() {
		return updUserid;
	}

	public void setUpdUserid(String updUserid) {
		this.updUserid = updUserid;
	}

	public UserDto getPsdUserDto() {
		return psdUserDto;
	}

	public void setPsdUserDto(UserDto psdUserDto) {
		this.psdUserDto = psdUserDto;
	}
}
