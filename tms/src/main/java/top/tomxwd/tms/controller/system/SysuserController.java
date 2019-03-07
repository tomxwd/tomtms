package top.tomxwd.tms.controller.system;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.system.SysuserService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;
import top.tomxwd.tms.vo.QueryObj;

@Controller
@RequestMapping("/sysuser")
public class SysuserController {
	
	@Autowired
	private SysuserService sysuserService;
	
	//用户登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public MsgObj login(Sysuser user,String verify,HttpServletRequest req,HttpServletResponse resp) {
		return sysuserService.findSysuserByInfo(user,verify,req,resp);
	}
	
	//去添加用户界面
	@RequestMapping(value="/toAddSysuser",method=RequestMethod.GET)
	public String toAddSysuser() {
		return "system/sysuser/addSysuser";
	}
	
	//去用户列表界面
	@RequestMapping(value="/toSysuserList",method=RequestMethod.GET)
	public String toSysuserList() {
		return "system/sysuser/sysuserList";
	}
	
	//添加用户时，异步查询用户名是否存在
	@RequestMapping(value="/checkSysuserName",method=RequestMethod.GET)
	@ResponseBody
	public boolean checkUsername(@RequestParam("uname")String username) {
		return sysuserService.findSysuserExistByUsername(username);
	}
	
	//添加用户操作
	@RequestMapping(value="/addSysuser",method=RequestMethod.POST)
	@ResponseBody
	public MsgObj addSysuser(Sysuser user,MultipartFile headImg) {
		return sysuserService.insertSysuser(user,headImg);
	}
	
	//用户列表数据
	@RequestMapping(value="/sysuserList",method=RequestMethod.POST)
	@ResponseBody
	public PageObj<Sysuser> sysuserList(PageObj<Sysuser> pageObj){
		return sysuserService.sysuserList(pageObj);
	}
	
	//删除该用户
	@RequestMapping(value="/deleteSysuser",method=RequestMethod.GET)
	@ResponseBody
	public MsgObj deleteSysuser(Integer id) {
		return sysuserService.deleteSysuser(id);
	}
	
	//离职或复职操作
	@RequestMapping(value="/dimissOrRestore",method=RequestMethod.GET)
	@ResponseBody
	public MsgObj dimissOrRestore(Integer id,Integer delstatus) {
		MsgObj msgObj = sysuserService.updateDelstatusById(id, delstatus);
		return msgObj;
	}
	
	//修改用户信息
	@RequestMapping(value="/editSysuser",method=RequestMethod.POST)
	@ResponseBody
	public MsgObj editSysuser(Sysuser user) {
		return sysuserService.updateSysuser(user);
	}
	
	
	
	
}
