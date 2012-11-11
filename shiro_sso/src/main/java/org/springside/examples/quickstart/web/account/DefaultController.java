package org.springside.examples.quickstart.web.account;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="default")
public class DefaultController {

	@RequestMapping(method =RequestMethod.GET)
	public String defaultRedirect(){
		Session session = SecurityUtils.getSubject().getSession();
		String url = (String)session.getAttribute("jump_url");
		if(null == url){
			url = "/task";
		}else{
			session.removeAttribute("jump_url");
		}
		return "redirect:"+url;
	}
}
