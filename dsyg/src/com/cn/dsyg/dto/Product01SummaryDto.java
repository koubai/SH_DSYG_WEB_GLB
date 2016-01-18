package com.cn.dsyg.dto;

import com.cn.common.dto.BaseDto;

/**
 * @name Product01SummaryDto.java
 * @author Frank
 * @time 2014-12-30上午12:18:36
 * @version 1.0
 */
public class Product01SummaryDto extends BaseDto {

	private static final long serialVersionUID = -4413274751705777502L;

	private String fieldcode;
	
	private int num;

	public String getFieldcode() {
		return fieldcode;
	}

	public void setFieldcode(String fieldcode) {
		this.fieldcode = fieldcode;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
