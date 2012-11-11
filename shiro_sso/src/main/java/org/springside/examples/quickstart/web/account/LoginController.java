package org.springside.examples.quickstart.web.account;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springside.examples.quickstart.service.account.AccountService;
import org.springside.examples.quickstart.service.account.MyFilter;
import org.springside.examples.quickstart.service.account.MyToken;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，

 * 真正登录的POST请求由Filter完成,
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private AccountService as;
	
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "account/login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String fail(@RequestParam(MyFilter.DEFAULT_USERNAME_PARAM) String username,@RequestParam(value=MyFilter.DEFAULT_PASSWORD_PARAM) String password,HttpServletRequest request, Model model) {
		Subject subject = SecurityUtils.getSubject();
		String jumpUrl = "account/login";
		if(subject.isAuthenticated()){
			//switch to another user
			MyToken token = new MyToken(username, password, false,request.getRemoteHost());
			subject.login(token);
			jumpUrl = "redirect:/";
		}else{
			model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
		}
		return jumpUrl;
	}

	@RequestMapping(value="SSOEntryPoint",method=RequestMethod.POST)
	public String ssoPoint(@RequestParam(MyFilter.DEFAULT_USERNAME_PARAM) String username,@RequestParam(MyFilter.URL)String url,@RequestParam(MyFilter.KEY)String key,HttpServletRequest request){
		
		MyToken token = new MyToken(username, "pass", false, request.getRemoteHost(), url, key);
		SecurityUtils.getSubject().login(token);
		return "redirect:"+url;
	}
}
