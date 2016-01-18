package com.cn.dsyg.dto;

import com.cn.common.dto.BaseDto;

/**
 * @name 产品（汇总DTO）
 * @author Frank
 * @time 2014-12-16下午11:51:36
 * @version 1.0
 */
public class Product01TmpDto extends BaseDto {
	
	private static final long serialVersionUID = -9140153350252423487L;

	/**
	 * ID
	 */
	private String id;

	/**
	 * 品种01：电线，02：套管，03：扁平线，04：线束，05：连接器，06：FPC
	 */
	private String fieldcode;

	/**
	 * 名称代码
	 */
	private String nameno;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFieldcode() {
		return fieldcode;
	}

	public void setFieldcode(String fieldcode) {
		this.fieldcode = fieldcode;
	}

	public String getNameno() {
		return nameno;
	}

	public void setNameno(String nameno) {
		this.nameno = nameno;
	}
}
