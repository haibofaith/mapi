package com.haibo.future.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class MapiInfo {

	/** 
	 * 业务线
	 *
	 * String MapiContext.java serviceName
	 */
	private String serviceName;

	/** 
	 * 产品线
	 *
	 * String MapiContext.java productName
	 */
	private String productName;

	/** 
	 * 方法名
	 *
	 * String MapiContext.java methodName
	 */
	private String methodName;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
}
