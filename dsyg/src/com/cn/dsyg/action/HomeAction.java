package com.cn.dsyg.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.cn.common.action.BaseAction;
import com.cn.common.util.Constants;
import com.cn.common.util.PropertiesConfig;
import com.cn.common.util.StringUtil;
import com.cn.dsyg.dto.CaseDto;
import com.cn.dsyg.dto.Dict01Dto;
import com.cn.dsyg.dto.NewsDto;
import com.cn.dsyg.dto.QaDto;
import com.cn.dsyg.dto.RecruitDto;
import com.cn.dsyg.service.CaseService;
import com.cn.dsyg.service.Dict01Service;
import com.cn.dsyg.service.NewsService;
import com.cn.dsyg.service.QaService;
import com.cn.dsyg.service.RecruitService;
import com.opensymphony.xwork2.ActionContext;

/**
 * @name HomeAction.java
 * @author Frank
 * @time 2013-10-14下午11:06:43
 * @version 1.0
 */
public class HomeAction extends BaseAction {

	private static final long serialVersionUID = 303939388808414480L;
	
	private static final Logger log = LogManager.getLogger(HomeAction.class);
	
	private Dict01Service dict01Service;
	
	private NewsService newsService;
	
	private QaService qaService;
	
	private RecruitService recruitService;
	
	private CaseService caseService;
	
	private String strFieldcode;
	
	/**
	 * 首页大产品分类
	 */
	private List<Dict01Dto> homeGoodsList;
	
	/**
	 * 首页新闻
	 */
	private List<NewsDto> homeNewsList;
	
	/**
	 * 新闻年份
	 */
	private String newsYear;
	
	/**
	 * 新闻年份列表
	 */
	private List<String> yearList;
	
	/**
	 * 新闻明细ID
	 */
	private String newsDetailId;
	
	/**
	 * 新闻明细
	 */
	private NewsDto newsDetail;
	
	/**
	 * PDF文件名
	 */
	private String pdfFileName;

	//QA
	private QaDto addQaDto;
	
	//Case
	private List<CaseDto> homeCaseList;
	private String caseFieldcode;
	private String caseDetailId;
	private CaseDto caseDetail;
	
	//Recruit
	private List<RecruitDto> homeRecruitList;
	private String recruitDetailId;
	private RecruitDto recruitDetail;
	
	/**
	 * 招聘信息列表
	 * @return
	 */
	public String showCompanyRecruitAction() {
		try {
			this.clearMessages();
			recruitDetailId = "";
			recruitDetail = new RecruitDto();
			homeRecruitList = recruitService.queryAllRecruit();
		} catch(Exception e) {
			log.error("showCompanyRecruitAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 招聘信息明细
	 * @return
	 */
	public String showRecruitDetailAction() {
		try {
			this.clearMessages();
			recruitDetail = recruitService.queryRecruitByID(recruitDetailId);
			if(recruitDetail != null) {
				String data = recruitDetail.getData();
				data = data.replace(" ", "&nbsp;");
				data = data.replace("<", "&lt;");
				data = data.replace(">", "&gt;");
				data = data.replace("\r\n", "<br>");
				recruitDetail.setData(data);
			}
		} catch(Exception e) {
			log.error("showCompanyRecruitAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 案例介绍明细
	 * @return
	 */
	public String showHomeCaseDetailAction() {
		try {
			this.clearMessages();
			caseDetail = caseService.queryCaseByID(caseDetailId);
			if(caseDetail != null) {
				String data = caseDetail.getData();
				data = data.replace(" ", "&nbsp;");
				data = data.replace("<", "&lt;");
				data = data.replace(">", "&gt;");
				data = data.replace("\r\n", "<br>");
				caseDetail.setData(data);
			}
		} catch(Exception e) {
			log.error("showHomeCaseDetail error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 案例介绍
	 * @return
	 */
	public String showHomeCaseAction() {
		try {
			this.clearMessages();
			caseDetailId = "";

			String language = (String) ActionContext.getContext().getSession().get(Constants.SYSTEM_LANGUAGE);
//			System.out.println(language);
			//大分类列表
			if("en".equals(language)) {
				//英文系统
				homeGoodsList = dict01Service.queryGoodsNoOther(Constants.SYSTEM_LANGUAGE_E);
			} else {
				//默认读取配置文件
				homeGoodsList = dict01Service.queryGoodsNoOther(PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			}
//			homeGoodsList = dict01Service.queryGoodsNoOther(PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			
			if(StringUtil.isBlank(caseFieldcode)) {
				//默认选择第一个电线
				caseFieldcode = Constants.DICT_GOODS_TYPE_CODE_01;
			}
			homeCaseList = caseService.queryCaseByType(caseFieldcode);
		} catch(Exception e) {
			log.error("showHomeCaseAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * QA页面
	 * @return
	 */
	public String showQaAction() {
		try {
			this.clearMessages();
			addQaDto = new QaDto();
		} catch(Exception e) {
			log.error("showQaAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 新增QA记录
	 * @return
	 */
	public String addQaAction() {
		try {
			this.clearMessages();
			//数据验证
			if(!checkData(addQaDto)) {
				return "checkerror";
			}
			addQaDto.setStatus("" + Constants.STATUS_NORMAL);
			addQaDto.setIp(getIP());
			qaService.insertQa(addQaDto);
			
			this.addActionMessage(this.getText("addsuccess"));
			addQaDto = new QaDto();
		} catch(Exception e) {
			log.error("addQaAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 回到首页Action
	 * @return
	 */
	public String goHomeAction() {
		try {
			this.clearMessages();
			newsDetailId = "";
			newsDetail = new NewsDto();
			
			String language = (String) ActionContext.getContext().getSession().get(Constants.SYSTEM_LANGUAGE);
			//大分类列表
			if("en".equals(language)) {
				//英文系统
				homeGoodsList = dict01Service.queryGoodsNoOther(Constants.SYSTEM_LANGUAGE_E);
			} else {
				//默认读取配置文件
				homeGoodsList = dict01Service.queryGoodsNoOther(PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			}
//			homeGoodsList = dict01Service.queryGoodsNoOther(PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
			
			//查询新闻
			homeNewsList = newsService.queryHomeNews();
		} catch(Exception e) {
			log.error("goHomeAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * PDF明细
	 * @return
	 */
	public String showPdfAction() {
		try {
			this.clearMessages();
			//判断PDF文件是否存在
			String pdf_path = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_PDF_PATH);
			String pdf_url = PropertiesConfig.getPropertiesValueByKey(Constants.PROPERTIES_PDF_URL);
			File file = new File(pdf_path + pdfFileName);
			if(!file.exists()) {
				return "notfound";
			}
			pdfFileName = pdf_url + pdfFileName;
		} catch(Exception e) {
			log.error("showPdfAction error:" + e);
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 相关技术情报
	 * @return
	 */
	public String showInformationAction() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showInformationAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 相关技术情报1
	 * @return
	 */
	public String showInformationDetail1Action() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showInformationDetail1Action error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 相关技术情报2
	 * @return
	 */
	public String showInformationDetail2Action() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showInformationDetail2Action error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 相关技术情报3
	 * @return
	 */
	public String showInformationDetail3Action() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showInformationDetail3Action error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 相关技术情报4
	 * @return
	 */
	public String showInformationDetail4Action() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showInformationDetail4Action error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 相关技术情报5
	 * @return
	 */
	public String showInformationDetail5Action() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showInformationDetail5Action error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 相关技术情报6
	 * @return
	 */
	public String showInformationDetail6Action() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showInformationDetail6Action error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 相关技术情报7 (标识和标签)
	 * @return
	 */
	public String showInformationDetail7Action() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showInformationDetail7Action error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 相关技术情报8 (交联含氟树脂)
	 * @return
	 */
	public String showInformationDetail8Action() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showInformationDetail8Action error:" + e);
		}
		return SUCCESS;
	}

	/**
	 * 在线购买
	 * @return
	 */
	public String showOnlineAction() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showOnlineAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 公司信息
	 * @return
	 */
	public String showCompanyInfoAction() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showCompanyInfoAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 公司分布
	 * @return
	 */
	public String showCompanyDistributionAction() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showCompanyDistributionAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 公司历史
	 * @return
	 */
	public String showCompanyHistoryAction() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showCompanyHistoryAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 总经理致辞
	 * @return
	 */
	public String showCompanySpeechAction() {
		try {
			this.clearMessages();
		} catch(Exception e) {
			log.error("showCompanySpeechAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 公司新闻
	 * @return
	 */
	public String showCompanyNewAction() {
		try {
			this.clearMessages();
			homeNewsList = new ArrayList<NewsDto>();
			yearList = new ArrayList<String>();
			String curryear = "";
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			curryear = sdf.format(new Date());
			
			if(StringUtil.isBlank(newsYear)) {
				//如果日期为空，则默认年份为当前时间年份
				newsYear = curryear;
			}
			
			//默认显示N年之内的新闻
			int year = Integer.valueOf(curryear);
			int i = Constants.SHOW_NEWS_YEAR;
			if(year - Constants.SHOW_NEWS_YEAR > Constants.SHOW_NEWS_YEAR_COUNT) {
				i = year - Constants.SHOW_NEWS_YEAR_COUNT;
			}
			for(; i <= year; i++) {
				yearList.add("" + i);
			}
			
			//根据年份查询新闻列表
			homeNewsList = newsService.queryNewsByYear(newsYear);
		} catch(Exception e) {
			log.error("showCompanyNewAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 新闻明细页面
	 * @return
	 */
	public String showNewsDetailAction() {
		try {
			this.clearMessages();
			newsDetail = newsService.queryNewsByID(newsDetailId);
			if(newsDetail != null) {
				String data = newsDetail.getData();
				data = data.replace(" ", "&nbsp;");
				data = data.replace("<", "&lt;");
				data = data.replace(">", "&gt;");
				data = data.replace("\r\n", "<br>");
				newsDetail.setData(data);
			}
		} catch(Exception e) {
			log.error("showNewsDetailAction error:" + e);
		}
		return SUCCESS;
	}
	
	/**
	 * 数据check
	 * @param news
	 * @return
	 */
	private boolean checkData(QaDto qa) {
		if(qa == null) {
			this.addActionMessage(this.getText("qatitlecheck"));
			return false;
		}
		if(StringUtil.isBlank(qa.getTitle())) {
			this.addActionMessage(this.getText("qatitlecheck"));
			return false;
		}
		if(StringUtil.isBlank(qa.getData())) {
			this.addActionMessage(this.getText("qacontentcheck"));
			return false;
		}
		if(qa.getData().length() > 2500) {
			this.addActionMessage(this.getText("qacontentlengthcheck"));
			return false;
		}
		if(StringUtil.isBlank(qa.getFullname())) {
			this.addActionMessage(this.getText("qausernamecheck"));
			return false;
		}
		if(StringUtil.isBlank(qa.getCompany())) {
			this.addActionMessage(this.getText("qacompanynamecheck"));
			return false;
		}
		if(StringUtil.isBlank(qa.getAddress())) {
			this.addActionMessage(this.getText("qaaddresscheck"));
			return false;
		}
		if(StringUtil.isBlank(qa.getTell())) {
			this.addActionMessage(this.getText("qatelcheck"));
			return false;
		}
		if(StringUtil.isBlank(qa.getFax())) {
			this.addActionMessage(this.getText("qafaxcheck"));
			return false;
		}
		if(StringUtil.isBlank(qa.getEmail())) {
			this.addActionMessage(this.getText("qamailcheck"));
			return false;
		}
		return true;
	}
	
	public String getStrFieldcode() {
		return strFieldcode;
	}

	public void setStrFieldcode(String strFieldcode) {
		this.strFieldcode = strFieldcode;
	}

	public Dict01Service getDict01Service() {
		return dict01Service;
	}

	public void setDict01Service(Dict01Service dict01Service) {
		this.dict01Service = dict01Service;
	}

	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public List<NewsDto> getHomeNewsList() {
		return homeNewsList;
	}

	public void setHomeNewsList(List<NewsDto> homeNewsList) {
		this.homeNewsList = homeNewsList;
	}

	public List<Dict01Dto> getHomeGoodsList() {
		return homeGoodsList;
	}

	public void setHomeGoodsList(List<Dict01Dto> homeGoodsList) {
		this.homeGoodsList = homeGoodsList;
	}

	public String getNewsYear() {
		return newsYear;
	}

	public void setNewsYear(String newsYear) {
		this.newsYear = newsYear;
	}

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public String getNewsDetailId() {
		return newsDetailId;
	}

	public void setNewsDetailId(String newsDetailId) {
		this.newsDetailId = newsDetailId;
	}

	public NewsDto getNewsDetail() {
		return newsDetail;
	}

	public void setNewsDetail(NewsDto newsDetail) {
		this.newsDetail = newsDetail;
	}

	public String getPdfFileName() {
		return pdfFileName;
	}

	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}

	public QaService getQaService() {
		return qaService;
	}

	public void setQaService(QaService qaService) {
		this.qaService = qaService;
	}

	public QaDto getAddQaDto() {
		return addQaDto;
	}

	public void setAddQaDto(QaDto addQaDto) {
		this.addQaDto = addQaDto;
	}

	public RecruitService getRecruitService() {
		return recruitService;
	}

	public void setRecruitService(RecruitService recruitService) {
		this.recruitService = recruitService;
	}

	public CaseService getCaseService() {
		return caseService;
	}

	public void setCaseService(CaseService caseService) {
		this.caseService = caseService;
	}

	public List<CaseDto> getHomeCaseList() {
		return homeCaseList;
	}

	public void setHomeCaseList(List<CaseDto> homeCaseList) {
		this.homeCaseList = homeCaseList;
	}

	public String getCaseFieldcode() {
		return caseFieldcode;
	}

	public void setCaseFieldcode(String caseFieldcode) {
		this.caseFieldcode = caseFieldcode;
	}

	public String getCaseDetailId() {
		return caseDetailId;
	}

	public void setCaseDetailId(String caseDetailId) {
		this.caseDetailId = caseDetailId;
	}

	public CaseDto getCaseDetail() {
		return caseDetail;
	}

	public void setCaseDetail(CaseDto caseDetail) {
		this.caseDetail = caseDetail;
	}

	public List<RecruitDto> getHomeRecruitList() {
		return homeRecruitList;
	}

	public void setHomeRecruitList(List<RecruitDto> homeRecruitList) {
		this.homeRecruitList = homeRecruitList;
	}

	public String getRecruitDetailId() {
		return recruitDetailId;
	}

	public void setRecruitDetailId(String recruitDetailId) {
		this.recruitDetailId = recruitDetailId;
	}

	public RecruitDto getRecruitDetail() {
		return recruitDetail;
	}

	public void setRecruitDetail(RecruitDto recruitDetail) {
		this.recruitDetail = recruitDetail;
	}
}
