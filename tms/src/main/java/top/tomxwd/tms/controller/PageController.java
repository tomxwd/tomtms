package top.tomxwd.tms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.utils.CookieUtils;
import top.tomxwd.tms.vo.MsgObj;

@Controller
@RequestMapping("/")
public class PageController {
		
	//去登录页面
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	//去主页
	@RequestMapping(value= {"/","/toIndex"})
	public String toIndex(HttpServletRequest req,HttpServletResponse resp) {
//		String cookieValue = CookieUtils.getCookieValue(req, "current_user", true);
//		Sysuser sysuser = JSON.parseObject(cookieValue, Sysuser.class);
		
		Subject subject = SecurityUtils.getSubject();
		Sysuser sysuser = (Sysuser) subject.getPrincipal();
		Sysuser current_user = (Sysuser) subject.getPrincipal();
		System.out.println(sysuser);
		System.out.println(current_user);
		current_user.setPassword("");
		req.setAttribute("sysuser", sysuser);
		String sysuser_Json = JSON.toJSONString(sysuser);
		CookieUtils.setCookie(req, resp, "current_user", sysuser_Json, 259200, true);//保存3天
		return "index";
	}
	
	//无权限页面
	@RequestMapping("/toRefuse")
	public String toRefuse() {
		return "refuse";
	}
	
	//退出
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req,HttpServletResponse resp) {
		SecurityUtils.getSubject().logout(); // session删除、RememberMe cookie也将被删除
		req.getSession().invalidate();//清除 session 中的所有信息
		return "login";
	}
	
}
