package com.cn.dsyg.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cn.common.action.BaseAction;
import com.cn.common.util.Constants;
import com.cn.common.util.DateUtil;
import com.cn.common.util.FileUtil;
import com.cn.common.util.Page;
import com.cn.common.util.PropertiesConfig;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dto.NewsDto;
import com.cn.dsyg.service.NewsService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @name NewsAction.java
 * @author Frank
 * @time 2014-12-25下午11:03:55
 * @version 1.0
 */
public class NewsAction extends BaseAction {

	private static final Logger log = LogManager.getLogger(NewsAction.class);
	
	private static final long serialVersionUID = -4721276630639546027L;
	
	private NewsService newsService;
	//查询条件
	private String queryTitle;
	private String queryAuthor;
	
	/**
	 * 页码
	 */
	private int startIndex;
	
	/**
	 * 翻页
	 */
	private Page page;
	
	private List<NewsDto> newsList;
	
	private File addPicFile01;
	private File addPicFile02;
	private File addPicFile03;
	//对应的文件名
	private String file01Name;
	private String file02Name;
	private String file03Name;
	
	//添加新闻
	private NewsDto addNewsDto;
	//修改新闻
	private String updNewsId;
	private NewsDto updNewsDto;
	private File updPicFile01;
	private File updPicFile02;
	private File updPicFile03;
	//删除
	private String delNewsId;
	
	/**
	 * 删除新闻
	 * @return
	 */
	public String delNewsAction() {
		try {
			this.clearMessages();
			//只有管理员才有权限删除
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_ADMIN) {
				return "noauthority";
			}
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			newsService.deleteNews(delNewsId, username);
			//重新刷新页面数据
			startIndex = 0;
			page = new Page();
			queryData();
			this.addActionMessage("删除成功！");
		} catch(Exception e) {
			log.error("showAddNewsAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 显示添加新闻页面
	 * @return
	 */
	public String showAddNewsAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			addNewsDto = new NewsDto();
			//默认新闻日期为今天
			addNewsDto.setNewsdate(DateUtil.dateToShortStr(new Date()));
		} catch(Exception e) {
			log.error("showAddNewsAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 添加新闻
	 * @return
	 */
	public String addNewsAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			//数据验证
			if(!checkData(addNewsDto)) {
				return "checkerror";
			}
			
			//图片验证
//			if(addPicFile01 == null) {
//				this.addActionMessage("图片不能为空！");
//				return "checkerror";
//			}
//			if(addPicFile02 == null) {
//				this.addActionMessage("图片2不能为空！");
//				return "checkerror";
//			}
//			if(addPicFile03 == null) {
//				this.addActionMessage("图片3不能为空！");
//				return "checkerror";
//			}
			
			//文件目录
			String image_path = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_NEW_PIC_PATH);
			
			//保存文件到指定目录
			if(addPicFile01 != null) {
				String newfile01 = FileUtil.uploadFile(addPicFile01, image_path, file01Name);
				addNewsDto.setPic01(newfile01);
			}
			
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			addNewsDto.setUpdateuid(username);
			addNewsDto.setCreateuid(username);
			//默认状态=有效
			addNewsDto.setStatus("" + Constants.STATUS_NORMAL);
			newsService.insertNews(addNewsDto);
			
			this.addActionMessage("添加成功！");
			addNewsDto = new NewsDto();
		} catch(Exception e) {
			log.error("addNewsAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	//修改
	/**
	 * 显示修改新闻页面
	 * @return
	 */
	public String showUpdNewsAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			updPicFile01 = null;
			updNewsDto = newsService.queryNewsByID(updNewsId);
		} catch(Exception e) {
			log.error("showUpdNewsAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 修改新闻
	 * @return
	 */
	public String updNewsAction() {
		try {
			this.clearMessages();
			//只有一般用户及以上才有权限
			Integer rank = (Integer) ActionContext.getContext().getSession().get(Constants.ROLE_RANK);
			if(rank == null || rank < Constants.ROLE_RANK_NORMAL) {
				return "noauthority";
			}
			//数据验证
			if(!checkData(updNewsDto)) {
				return "checkerror";
			}
			
			//记录原来的图片文件
			NewsDto oldNews = newsService.queryNewsByID(updNewsId);
			String oldpic1 = "";
			
			//文件目录
			String image_path = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_NEW_PIC_PATH);
			if(updPicFile01 != null) {
				String newfile01 = FileUtil.uploadFile(updPicFile01, image_path, file01Name);
				updNewsDto.setPic01(newfile01);
				oldpic1 = oldNews.getPic01();
			}
			
			//当前操作用户ID
			String username = (String) ActionContext.getContext().getSession().get(Constants.USER_ID);
			updNewsDto.setUpdateuid(username);
			newsService.updateNews(updNewsDto);
			
			this.addActionMessage("更新成功！");
			log.info("更新成功！");
			
			//如果更新前有图片，更新后没有图片，则删除原图片
			if(StringUtil.isNotBlank(oldNews.getPic01()) && StringUtil.isBlank(updNewsDto.getPic01())) {
				oldpic1 = oldNews.getPic01();
			}
			//删除原来图片
			if(StringUtil.isNotBlank(oldpic1)) {
				FileUtil.deleteFile(oldpic1, image_path);
			}
			updPicFile01 = null;
		} catch(Exception e) {
			log.error("updNewsAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 新闻页面
	 * @return
	 */
	public String showNewsManageAction() {
		try {
			this.clearMessages();
			queryTitle = "";
			queryAuthor = "";
			startIndex = 0;
			page = new Page();
			newsList = new ArrayList<NewsDto>();
		} catch(Exception e) {
			log.error("showNewsManageAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询消息
	 * @return
	 */
	public String queryNewsAction() {
		try {
			this.clearMessages();
			startIndex = 0;
			page = new Page();
			queryData();
		} catch(Exception e) {
			log.error("queryNewsAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 翻页
	 * @return
	 */
	public String turnNewsAction() {
		try {
			this.clearMessages();
			queryData();
		} catch(Exception e) {
			log.error("turnNewsAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 数据check
	 * @param news
	 * @return
	 */
	private boolean checkData(NewsDto news) {
		if(news == null) {
			this.addActionMessage("新闻标题不能为空！");
			return false;
		}
		if(StringUtil.isBlank(news.getTitle())) {
			this.addActionMessage("新闻标题不能为空！");
			return false;
		}
		if(StringUtil.isBlank(news.getAuthor())) {
			this.addActionMessage("作者不能为空！");
			return false;
		}
		if(StringUtil.isBlank(news.getNewsdate())) {
			this.addActionMessage("新闻日期不能为空！");
			return false;
		}
		if(StringUtil.isBlank(news.getData())) {
			this.addActionMessage("新闻内容不能为空！");
			return false;
		}
		if(news.getData().length() > 2500) {
			this.addActionMessage("新闻内容不能超过2500个字！");
			return false;
		}
		if(StringUtil.isBlank(news.getAuthor())) {
			this.addActionMessage("新闻作者不能为空！");
			return false;
		}
		return true;
	}
	
	/**
	 * 数据查询
	 */
	@SuppressWarnings("unchecked")
	private void queryData() {
		newsList = new ArrayList<NewsDto>();
		if(page == null) {
			page = new Page();
		}
		//翻页查询所有委托公司
		this.page.setStartIndex(startIndex);
		page = newsService.queryNewsByPage(queryTitle, queryAuthor, page);
		newsList = (List<NewsDto>) page.getItems();
		this.setStartIndex(page.getStartIndex());
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public String getQueryTitle() {
		return queryTitle;
	}

	public void setQueryTitle(String queryTitle) {
		this.queryTitle = queryTitle;
	}

	public String getQueryAuthor() {
		return queryAuthor;
	}

	public void setQueryAuthor(String queryAuthor) {
		this.queryAuthor = queryAuthor;
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

	public List<NewsDto> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsDto> newsList) {
		this.newsList = newsList;
	}

	public NewsDto getAddNewsDto() {
		return addNewsDto;
	}

	public void setAddNewsDto(NewsDto addNewsDto) {
		this.addNewsDto = addNewsDto;
	}

	public String getUpdNewsId() {
		return updNewsId;
	}

	public void setUpdNewsId(String updNewsId) {
		this.updNewsId = updNewsId;
	}

	public NewsDto getUpdNewsDto() {
		return updNewsDto;
	}

	public void setUpdNewsDto(NewsDto updNewsDto) {
		this.updNewsDto = updNewsDto;
	}

	public String getDelNewsId() {
		return delNewsId;
	}

	public void setDelNewsId(String delNewsId) {
		this.delNewsId = delNewsId;
	}

	public File getAddPicFile01() {
		return addPicFile01;
	}

	public void setAddPicFile01(File addPicFile01) {
		this.addPicFile01 = addPicFile01;
	}

	public File getAddPicFile02() {
		return addPicFile02;
	}

	public void setAddPicFile02(File addPicFile02) {
		this.addPicFile02 = addPicFile02;
	}

	public File getAddPicFile03() {
		return addPicFile03;
	}

	public void setAddPicFile03(File addPicFile03) {
		this.addPicFile03 = addPicFile03;
	}

	public String getFile01Name() {
		return file01Name;
	}

	public void setFile01Name(String file01Name) {
		this.file01Name = file01Name;
	}

	public String getFile02Name() {
		return file02Name;
	}

	public void setFile02Name(String file02Name) {
		this.file02Name = file02Name;
	}

	public String getFile03Name() {
		return file03Name;
	}

	public void setFile03Name(String file03Name) {
		this.file03Name = file03Name;
	}

	public File getUpdPicFile01() {
		return updPicFile01;
	}

	public void setUpdPicFile01(File updPicFile01) {
		this.updPicFile01 = updPicFile01;
	}

	public File getUpdPicFile02() {
		return updPicFile02;
	}

	public void setUpdPicFile02(File updPicFile02) {
		this.updPicFile02 = updPicFile02;
	}

	public File getUpdPicFile03() {
		return updPicFile03;
	}

	public void setUpdPicFile03(File updPicFile03) {
		this.updPicFile03 = updPicFile03;
	}
}
