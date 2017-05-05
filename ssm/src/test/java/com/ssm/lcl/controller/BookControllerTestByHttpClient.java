package com.ssm.lcl.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.httpClient.lcl.HttpClientUtl;
import com.ssm.lcl.BaseTest;

/**
 *HttpClient访问: 需要部署项目到Tomcat
 */
public class BookControllerTestByHttpClient extends BaseTest{
	private Map<String,String> params = new HashMap<String, String>(); 
	
	/**
	 * 通过httpClient测试controller
	 * 需要启动tomcat
	 */
	@Test
	public void test01(){
		String url = "http://127.0.0.1:8088/ssm/book/list";
		HttpClientUtl.doPost(url, params);
	}
	
}
