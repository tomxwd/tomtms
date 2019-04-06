package top.tomxwd.tms.controller.system.notice;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.system.notice.Notice;
import top.tomxwd.tms.pojo.system.notice.NoticeContent;
import top.tomxwd.tms.service.system.notice.NoticeService;
import top.tomxwd.tms.utils.UpLoadUtils;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService service;

	@Autowired
	private UpLoadUtils upload;

	@RequestMapping(value = "/toAddNotice", method = RequestMethod.GET)
	@RequiresPermissions("notice:addPage")
	public String toAddNotice() {
		return "/notice/addNotice";
	}

	@RequestMapping(value = "/imgUpload", method = RequestMethod.POST)
	@RequiresPermissions("notice:upload")
	@ResponseBody
	public String imgUpload(MultipartFile file) {
		return upload.UpLoadNoticeImg(file);
	}

	@RequestMapping(value = "/addNotice", method = RequestMethod.POST)
	@RequiresPermissions("notice:add")
	@ResponseBody
	public MsgObj addNotice(String title, String content) {
		return service.insertNewNotice(title, content);
	}

	@RequestMapping(value = "/toNoticeList", method = RequestMethod.GET)
	@RequiresPermissions("notice:listPage")
	public String toNoticeList() {
		return "notice/noticeList";
	}

	// 公告列表
	@RequestMapping(value = "/noticeList", method = RequestMethod.POST)
	@RequiresPermissions("notice:list")
	@ResponseBody
	public PageObj<Notice> noticeList(PageObj<Notice> pageObj) {
		return service.getNoticeList(pageObj);
	}

	// 根据id查公告内容
	@RequestMapping(value = "/getNoticeContentById", method = RequestMethod.POST)
	@ResponseBody
	public NoticeContent getNoticeContentById(Integer id) {
		return service.getNoticeConentById(id);
	}

	// 展示或撤下公告
	@RequestMapping(value = "/showOrDownNotice", method = RequestMethod.GET)
	@RequiresPermissions("notice:showOrDown")
	@ResponseBody
	public MsgObj showOrDownNotice(Notice notice) {
		return service.updateNoticeShow(notice);
	}

	// 删除或恢复公告
	@RequestMapping(value = "/deleteOrRestroeNoticeById", method = RequestMethod.GET)
	@RequiresPermissions("notice:deleteOrRestroe")
	@ResponseBody
	public MsgObj deleteOrRestroeNoticeById(Notice notice) {
		return service.updateNoticeStatus(notice);
	}

	// 根据id查公告内容 并跳转页面
	@RequestMapping(value = "/lookNoticeContentDetailById", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView lookNoticeContentDetailById(Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("notice/noticeContent");
		Map<String, Object> map = service.getNoticeAndContentById(id);
		mv.addObject("notice", map);
		return mv;
	}

	// 公共的公告 即未删除的
	@RequestMapping(value = "/toPublicNoticeList", method = RequestMethod.GET)
	public String publicNoticeList() {
		return "notice/publicNotice";
	}

	// 公共的公告列表
	@RequestMapping(value = "/publicNoticeList", method = RequestMethod.POST)
	@ResponseBody
	public PageObj<Notice> publicNoticeList(PageObj<Notice> pageObj) {
		return service.getPublicNoticeList(pageObj);
	}

}
