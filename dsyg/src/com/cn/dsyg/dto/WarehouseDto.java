package com.cn.dsyg.dto;

import com.cn.common.dto.BaseDto;

/**
 * @name WarehouseDto.java
 * @author Frank
 * @time 2015-1-3下午6:09:13
 * @version 1.0
 */
public class WarehouseDto extends BaseDto {

	private static final long serialVersionUID = 4203100379298800074L;

	/**
	 * ID
	 */
	private String id;

	/**
	 * 产品表ID
	 */
	private String productid;
	
	/**
	 * 产品名称
	 */
	private String productname;
	
	/**
	 * 产品大类型
	 */
	private String producttype;
	
	/**
	 * UL编号
	 */
	private String ulcode;
	
	/**
	 * 品牌
	 */
	private String brand;
	
	/**
	 * 产品型号（规格）
	 */
	private String typeno;
	
	/**
	 * 产品数据权限
	 */
	private String productrank;
	
	/**
	 * 颜色
	 */
	private String color;

	/**
	 * 库存
	 */
	private String item01;

	/**
	 * 出库（作废）
	 */
	private String item02;

	/**
	 * 发送天数
	 */
	private String item03;

	/**
	 * 项目4
	 */
	private String item04;

	/**
	 * 项目5
	 */
	private String item05;

	/**
	 * 项目6
	 */
	private String item06;

	/**
	 * 项目7
	 */
	private String item07;

	/**
	 * 项目8
	 */
	private String item08;

	/**
	 * 项目9
	 */
	private String item09;

	/**
	 * 项目10
	 */
	private String item10;

	/**
	 * 级别（0-99）
	 */
	private String rank;

	/**
	 * 单位
	 */
	private String res01;

	/**
	 * 产地
	 */
	private String res02;

	/**
	 * 整箱OR乱尺（0整箱1乱尺）
	 */
	private String res03;

	/**
	 * 期货OR现货（1期货0现货）
	 */
	private String res04;

	/**
	 * 预备项目5
	 */
	private String res05;

	/**
	 * 预备项目6
	 */
	private String res06;

	/**
	 * 预备项目7
	 */
	private String res07;

	/**
	 * 预备项目8
	 */
	private String res08;

	/**
	 * 预备项目9
	 */
	private String res09;

	/**
	 * 预备项目10
	 */
	private String res10;

	/**
	 * 状态，1为有效，其他无效
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

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getItem01() {
		return item01;
	}

	public void setItem01(String item01) {
		this.item01 = item01;
	}

	public String getItem02() {
		return item02;
	}

	public void setItem02(String item02) {
		this.item02 = item02;
	}

	public String getItem03() {
		return item03;
	}

	public void setItem03(String item03) {
		this.item03 = item03;
	}

	public String getItem04() {
		return item04;
	}

	public void setItem04(String item04) {
		this.item04 = item04;
	}

	public String getItem05() {
		return item05;
	}

	public void setItem05(String item05) {
		this.item05 = item05;
	}

	public String getItem06() {
		return item06;
	}

	public void setItem06(String item06) {
		this.item06 = item06;
	}

	public String getItem07() {
		return item07;
	}

	public void setItem07(String item07) {
		this.item07 = item07;
	}

	public String getItem08() {
		return item08;
	}

	public void setItem08(String item08) {
		this.item08 = item08;
	}

	public String getItem09() {
		return item09;
	}

	public void setItem09(String item09) {
		this.item09 = item09;
	}

	public String getItem10() {
		return item10;
	}

	public void setItem10(String item10) {
		this.item10 = item10;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
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

	public String getRes06() {
		return res06;
	}

	public void setRes06(String res06) {
		this.res06 = res06;
	}

	public String getRes07() {
		return res07;
	}

	public void setRes07(String res07) {
		this.res07 = res07;
	}

	public String getRes08() {
		return res08;
	}

	public void setRes08(String res08) {
		this.res08 = res08;
	}

	public String getRes09() {
		return res09;
	}

	public void setRes09(String res09) {
		this.res09 = res09;
	}

	public String getRes10() {
		return res10;
	}

	public void setRes10(String res10) {
		this.res10 = res10;
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

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	public String getUlcode() {
		return ulcode;
	}

	public void setUlcode(String ulcode) {
		this.ulcode = ulcode;
	}

	public String getProductrank() {
		return productrank;
	}

	public void setProductrank(String productrank) {
		this.productrank = productrank;
	}

	public String getTypeno() {
		return typeno;
	}

	public void setTypeno(String typeno) {
		this.typeno = typeno;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
