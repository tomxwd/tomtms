package top.tomxwd.tms.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import top.tomxwd.tms.pojo.system.notice.Notice;
import top.tomxwd.tms.service.system.PublicPageService;

@Controller
@RequestMapping("/public")
public class PublicPageController {
	
	@Autowired
	private PublicPageService service;
	
	// 首页
	@RequestMapping("/publicIndex")
	public ModelAndView indexPage() {
		ModelAndView mv = new ModelAndView();
		List<Notice> notices = service.getPublicNotice();
		mv.addObject("notices", notices);
		mv.setViewName("publicIndex");
		return mv;
	}
}
