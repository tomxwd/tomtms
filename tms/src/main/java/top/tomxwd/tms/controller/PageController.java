package top.tomxwd.tms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.utils.CookieUtils;

@Controller
@RequestMapping("/")
public class PageController {
		
	//去登录页面
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	//去主页
	@RequestMapping("/toIndex")
	public String toIndex(HttpServletRequest req,HttpServletResponse resp) {
		String cookieValue = CookieUtils.getCookieValue(req, "current_user", true);
		Sysuser sysuser = JSON.parseObject(cookieValue, Sysuser.class);
		req.setAttribute("sysuser", sysuser);
		return "index";
	}
	
}
