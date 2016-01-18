package com.cn.dsyg.interceptor;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cn.common.util.Constants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 多语言拦截器
 * @name LanguageInterceptor.java
 * @author Frank
 * @time 2016-1-4下午10:23:39
 * @version 1.0
 */
public class LanguageInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 4715147911939515984L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request = (HttpServletRequest) arg0.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		String language = request.getParameter(Constants.SYSTEM_LANGUAGE);
		Locale locale = null;
		if(language != null && !"".equals(language)) {
			if("en".equals(language)) {
				//英文
				locale = new Locale("en", "US");
			} else {
				//默认中文
				locale = new Locale("zh", "CN");
				language = "zh";
			}
			ActionContext.getContext().getSession().put(Constants.SYSTEM_LANGUAGE, language);
		} else {
			//判断是否选择了语言
			language = (String) ActionContext.getContext().getSession().get(Constants.SYSTEM_LANGUAGE);
			if(language != null && !"".equals(language)) {
				if("en".equals(language)) {
					//英文
					locale = new Locale("en", "US");
				} else {
					//默认中文
					locale = new Locale("zh", "CN");
					language = "zh";
				}
			} else {
				//默认中文
				locale = new Locale("zh", "CN");
			}
			ActionContext.getContext().getSession().put(Constants.SYSTEM_LANGUAGE, language);
		}
		arg0.getInvocationContext().setLocale(locale);
		return arg0.invoke();
	}
}
