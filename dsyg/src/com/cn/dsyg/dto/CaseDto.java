package com.cn.dsyg.dto;

import com.cn.common.dto.BaseDto;

/**
 * 案例介绍
 * @name CaseDto.java
 * @author Frank
 * @time 2015-2-4上午1:32:36
 * @version 1.0
 */
public class CaseDto extends BaseDto {

	private static final long serialVersionUID = 4419871672266616982L;

	/**
	 * 编号
	 */
	private String id;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 产品类型
	 */
	private String fieldcode;

	/**
	 * 内容
	 */
	private String data;
	
	/**
	 * 图片URL
	 */
	private String casePicUrl;

	/**
	 * 图片1路径
	 */
	private String pic01;

	/**
	 * 图片2路径
	 */
	private String pic02;

	/**
	 * 图片3路径
	 */
	private String pic03;

	/**
	 * 图片4路径
	 */
	private String pic04;

	/**
	 * 图片5路径
	 */
	private String pic05;

	/**
	 * 预备项目1
	 */
	private String res01;

	/**
	 * 预备项目2
	 */
	private String res02;
	
	/**
	 * 预备项目3
	 */
	private String res03;

	/**
	 * 预备项目4
	 */
	private String res04;

	/**
	 * 预备项目5
	 */
	private String res05;

	/**
	 * 状态，1为有效，其他为无效
	 */
	private String status;

	/**
	 * 数据创建者
	 */
	private String createuid;

	/**
	 * 创建时间
	 */
	private String createdate;

	/**
	 * 数据更新者
	 */
	private String updateuid;

	/**
	 * 更新时间
	 */
	private String updatedate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFieldcode() {
		return fieldcode;
	}

	public void setFieldcode(String fieldcode) {
		this.fieldcode = fieldcode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPic01() {
		return pic01;
	}

	public void setPic01(String pic01) {
		this.pic01 = pic01;
	}

	public String getPic02() {
		return pic02;
	}

	public void setPic02(String pic02) {
		this.pic02 = pic02;
	}

	public String getPic03() {
		return pic03;
	}

	public void setPic03(String pic03) {
		this.pic03 = pic03;
	}

	public String getPic04() {
		return pic04;
	}

	public void setPic04(String pic04) {
		this.pic04 = pic04;
	}

	public String getPic05() {
		return pic05;
	}

	public void setPic05(String pic05) {
		this.pic05 = pic05;
	}

	public String getRes01() {
		return res01;
	}

	public void setRes01(String res01) {
		this.res01 = res01;
	}

	public String getRes02() {
		return res02;
	}

	public void setRes02(String res02) {
		this.res02 = res02;
	}

	public String getRes03() {
		return res03;
	}

	public void setRes03(String res03) {
		this.res03 = res03;
	}

	public String getRes04() {
		return res04;
	}

	public void setRes04(String res04) {
		this.res04 = res04;
	}

	public String getRes05() {
		return res05;
	}

	public void setRes05(String res05) {
		this.res05 = res05;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateuid() {
		return createuid;
	}

	public void setCreateuid(String createuid) {
		this.createuid = createuid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdateuid() {
		return updateuid;
	}

	public void setUpdateuid(String updateuid) {
		this.updateuid = updateuid;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getCasePicUrl() {
		return casePicUrl;
	}

	public void setCasePicUrl(String casePicUrl) {
		this.casePicUrl = casePicUrl;
	}
}
