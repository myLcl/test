package com.httpClient.lcl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


@SuppressWarnings("deprecation")
public class HttpClientUtl {
	private static PoolingHttpClientConnectionManager connMgr;
	private static final int MAX_TIMEOUT = 70000;
	
	@SuppressWarnings("unused")
	private static RequestConfig requestConfig;
	
	static {  
        // 设置连接池  
        connMgr = new PoolingHttpClientConnectionManager();  
        connMgr.setMaxTotal(100);  
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());  
  
        RequestConfig.Builder configBuilder = RequestConfig.custom();  
        configBuilder.setConnectTimeout(MAX_TIMEOUT);  
        configBuilder.setSocketTimeout(MAX_TIMEOUT);  
        configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);  
        configBuilder.setStaleConnectionCheckEnabled(true);  
        
        requestConfig = configBuilder.build();  
    }  

	/**
	 * post 方式提交
	 * @param url  访问地址
	 * @param data  参数
	 * @return
	 */
	public static String doPost(String url, Map<String, String> params) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = null;
		String result = null;
		
		try {
			
			//设置url和参数
			post = new HttpPost(url);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			
			if(params != null) {
				Set<String> set = params.keySet();
				if(set.size() > 0) {
					for (String key : set) {
						nvps.add(new BasicNameValuePair(key, params.get(key)));
					}
				}
				post.setEntity(new UrlEncodedFormEntity(nvps));
			}
			
			//获取响应
			CloseableHttpResponse httpResponse = httpclient.execute(post);
			int code = httpResponse.getStatusLine().getStatusCode();
			if (code == HttpStatus.SC_OK) {
				HttpEntity httpEntity = httpResponse.getEntity();
				result = EntityUtils.toString(httpEntity, "utf8");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (post != null) {
				post.releaseConnection();// 释放连接
			}
		}

		return result;
	}
	
	
}
