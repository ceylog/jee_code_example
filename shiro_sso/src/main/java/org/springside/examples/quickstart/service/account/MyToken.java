package org.springside.examples.quickstart.service.account;

import org.apache.shiro.authc.UsernamePasswordToken;

@SuppressWarnings("serial")
public class MyToken extends UsernamePasswordToken {

	private String url;
	private String key;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public MyToken() {
		super();
	}

	public MyToken(String username, char[] password, boolean rememberMe,
			String host) {
		super(username, password, rememberMe, host);
	}

	public MyToken(String username, String password, boolean rememberMe,
			String host) {
		super(username, password, rememberMe, host);
	}

	public MyToken(String username, char[] password, boolean rememberMe,
			String host, String url, String key) {
		super(username, password, rememberMe, host);
		this.url = url;
		this.key = key;
	}

	public MyToken(String username, String password, boolean rememberMe,
			String host, String url, String key) {
		super(username, password, rememberMe, host);
		this.url = url;
		this.key = key;
	}
}
