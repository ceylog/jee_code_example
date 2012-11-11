package org.springside.examples.quickstart.service.account;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class MyFilter extends FormAuthenticationFilter {

	public static final String URL = "url";
	public static final String KEY = "key";

	private String url = URL;
	private String key = KEY;

	public String getUrl() {
		return url;
	}

	public String getKey() {
		return key;
	}

	protected String getUrl(ServletRequest request) {
		return WebUtils.getCleanParam(request, getUrl());
	}

	protected String getKey(ServletRequest request) {
		return WebUtils.getCleanParam(request, getKey());
	}

	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) {

		String username = getUsername(request);
		
		String password = getPassword(request);
		
		String url = getUrl(request);
		
		String key = getKey(request);

		boolean rememberMe = isRememberMe(request);

		String host = getHost(request);
		return new MyToken(username, password, rememberMe, host, url,key);

	}

}
