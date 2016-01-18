package com.cn.dsyg.dto;

import com.cn.common.dto.BaseDto;

/**
 * @name 产品
 * @author Frank
 * @time 2014-12-16下午11:51:36
 * @version 1.0
 */
public class Product01Dto extends BaseDto {
	
	private static final long serialVersionUID = -3431277507006642510L;

	/**
	 * ID
	 */
	private String id;

	/**
	 * 品种01：电线，02：套管，03：扁平线，04：线束，05：连接器，06：FPC
	 */
	private String fieldcode;

	/**
	 * 大分类
	 */
	private String cata1;

	/**
	 * 中分类
	 */
	private String cata2;

	/**
	 * 小分类
	 */
	private String cata3;

	/**
	 * 名称代码
	 */
	private String nameno;

	/**
	 * 产品规格
	 */
	private String typeno;

	/**
	 * 型号辅助
	 */
	private String typenosub;

	/**
	 * 颜色1
	 */
	private String color1;

	/**
	 * 颜色2（备用）
	 */
	private String color2;

	/**
	 * 规格1
	 */
	private String size01;

	/**
	 * 规格2
	 */
	private String size02;

	/**
	 * 产地
	 */
	private String makearea;

	/**
	 * 项目1
	 */
	private String item01;

	/**
	 * 项目2
	 */
	private String item02;

	/**
	 * 项目3
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
	 * 项目8（品牌）
	 */
	private String item08;

	/**
	 * 项目9（U/L编号）
	 */
	private String item09;

	/**
	 * 项目10
	 */
	private String item10;

	/**
	 * 项目11
	 */
	private String item11;

	/**
	 * 项目12
	 */
	private String item12;

	/**
	 * 项目13
	 */
	private String item13;

	/**
	 * 项目14
	 */
	private String item14;

	/**
	 * 项目15
	 */
	private String item15;

	/**
	 * 项目16
	 */
	private String item16;

	/**
	 * 项目17
	 */
	private String item17;

	/**
	 * 项目18
	 */
	private String item18;

	/**
	 * 项目19
	 */
	private String item19;

	/**
	 * 项目20
	 */
	private String item20;

	/**
	 * 项目21
	 */
	private String item21;

	/**
	 * 项目22
	 */
	private String item22;

	/**
	 * 项目23
	 */
	private String item23;

	/**
	 * 项目24
	 */
	private String item24;

	/**
	 * 项目25
	 */
	private String item25;

	/**
	 * 项目26
	 */
	private String item26;

	/**
	 * 项目27
	 */
	private String item27;

	/**
	 * 项目28
	 */
	private String item28;

	/**
	 * 项目29
	 */
	private String item29;

	/**
	 * 项目30
	 */
	private String item30;
	
	//
	/**
	 * 图片网络访问地址
	 */
	private String imageurl;
	
	/**
	 * PDF文件访问地址
	 */
	private String pdfurl;
	//

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
	 * PDF文件名
	 */
	private String pdfpath;

	/**
	 * 级别（0-99）
	 */
	private String rank;

	/**
	 * 状态：1为有效，其他为无效
	 */
	private String status;

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
	 * 关键字，模糊查询用
	 */
	private String keyword;

	/**
	 * 数据创建者
	 */
	private String createuid;

	/**
	 * 数据创建时间
	 */
	private String createdate;

	/**
	 * 数据更新者
	 */
	private String updateuid;

	/**
	 * 数据更新时间
	 */
	private String updatedate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCata1() {
		return cata1;
	}

	public void setCata1(String cata1) {
		this.cata1 = cata1;
	}

	public String getCata2() {
		return cata2;
	}

	public void setCata2(String cata2) {
		this.cata2 = cata2;
	}

	public String getCata3() {
		return cata3;
	}

	public void setCata3(String cata3) {
		this.cata3 = cata3;
	}

	public String getNameno() {
		return nameno;
	}

	public void setNameno(String nameno) {
		this.nameno = nameno;
	}

	public String getTypeno() {
		return typeno;
	}

	public void setTypeno(String typeno) {
		this.typeno = typeno;
	}

	public String getTypenosub() {
		return typenosub;
	}

	public void setTypenosub(String typenosub) {
		this.typenosub = typenosub;
	}

	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		this.color1 = color1;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}

	public String getSize01() {
		return size01;
	}

	public void setSize01(String size01) {
		this.size01 = size01;
	}

	public String getSize02() {
		return size02;
	}

	public void setSize02(String size02) {
		this.size02 = size02;
	}

	public String getMakearea() {
		return makearea;
	}

	public void setMakearea(String makearea) {
		this.makearea = makearea;
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

	public String getItem11() {
		return item11;
	}

	public void setItem11(String item11) {
		this.item11 = item11;
	}

	public String getItem12() {
		return item12;
	}

	public void setItem12(String item12) {
		this.item12 = item12;
	}

	public String getItem13() {
		return item13;
	}

	public void setItem13(String item13) {
		this.item13 = item13;
	}

	public String getItem14() {
		return item14;
	}

	public void setItem14(String item14) {
		this.item14 = item14;
	}

	public String getItem15() {
		return item15;
	}

	public void setItem15(String item15) {
		this.item15 = item15;
	}

	public String getItem16() {
		return item16;
	}

	public void setItem16(String item16) {
		this.item16 = item16;
	}

	public String getItem17() {
		return item17;
	}

	public void setItem17(String item17) {
		this.item17 = item17;
	}

	public String getItem18() {
		return item18;
	}

	public void setItem18(String item18) {
		this.item18 = item18;
	}

	public String getItem19() {
		return item19;
	}

	public void setItem19(String item19) {
		this.item19 = item19;
	}

	public String getItem20() {
		return item20;
	}

	public void setItem20(String item20) {
		this.item20 = item20;
	}

	public String getItem21() {
		return item21;
	}

	public void setItem21(String item21) {
		this.item21 = item21;
	}

	public String getItem22() {
		return item22;
	}

	public void setItem22(String item22) {
		this.item22 = item22;
	}

	public String getItem23() {
		return item23;
	}

	public void setItem23(String item23) {
		this.item23 = item23;
	}

	public String getItem24() {
		return item24;
	}

	public void setItem24(String item24) {
		this.item24 = item24;
	}

	public String getItem25() {
		return item25;
	}

	public void setItem25(String item25) {
		this.item25 = item25;
	}

	public String getItem26() {
		return item26;
	}

	public void setItem26(String item26) {
		this.item26 = item26;
	}

	public String getItem27() {
		return item27;
	}

	public void setItem27(String item27) {
		this.item27 = item27;
	}

	public String getItem28() {
		return item28;
	}

	public void setItem28(String item28) {
		this.item28 = item28;
	}

	public String getItem29() {
		return item29;
	}

	public void setItem29(String item29) {
		this.item29 = item29;
	}

	public String getItem30() {
		return item30;
	}

	public void setItem30(String item30) {
		this.item30 = item30;
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

	public String getPdfpath() {
		return pdfpath;
	}

	public void setPdfpath(String pdfpath) {
		this.pdfpath = pdfpath;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getFieldcode() {
		return fieldcode;
	}

	public void setFieldcode(String fieldcode) {
		this.fieldcode = fieldcode;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getPdfurl() {
		return pdfurl;
	}

	public void setPdfurl(String pdfurl) {
		this.pdfurl = pdfurl;
	}
}
