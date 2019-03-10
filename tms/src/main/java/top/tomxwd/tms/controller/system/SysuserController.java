package top.tomxwd.tms.controller.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.system.SysuserService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;


@Controller
@RequestMapping("/sysuser")
public class SysuserController {

	@Autowired
	private SysuserService sysuserService;

	// 用户登录
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	@ResponseBody
//	public MsgObj login(Sysuser user,String verify,HttpServletRequest req,HttpServletResponse resp) {
//		return sysuserService.findSysuserByInfo(user,verify,req,resp);
//	}

	/*
	 * 
	 * (验证) authc: AuthencationException: AuthenticationException
	 * 异常是Shiro在登录认证过程中，认证失败需要抛出的异常。
	 * 
	 * AuthenticationException包含以下子类：
	 * 
	 *         CredentitalsException 凭证异常
	 * 
	 *         IncorrectCredentialsException 不正确的凭证
	 * 
	 *         ExpiredCredentialsException 凭证过期
	 * 
	 *     	   AccountException 账号异常
	 * 
	 *         ConcurrentAccessException 并发访问异常（多个用户同时登录时抛出）
	 * 
	 *         UnknownAccountException 未知的账号
	 * 
	 *         ExcessiveAttemptsException 认证次数超过限制
	 * 
	 *         DisabledAccountException 禁用的账号             
	 * 
	 * 		   LockedAccountException 账号被锁定
	 * 
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(String verify,HttpServletRequest req,HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView("/login");
		//return sysuserService.findSysuserByInfo(user,verify,req,resp);
		System.out.println("123");
		String className = (String) req.getAttribute("shiroLoginFailure");
		System.out.println(className);
		// AuthenticationException子类
		if (UnknownAccountException.class.getName().equals(className)) {
			// 抛出自定义异常，用户名或密码不正确
			//msgObj.setMsg("账号或密码不正确");
			mv.addObject("msg", "用户名或密码不正确");
		} else if (IncorrectCredentialsException.class.getName().equals(className)) {
			// 抛出自定义异常，
			//msgObj.setMsg("密码不正确");
			mv.addObject("msg", "密码错误");
		} else if (className==null){
			mv.addObject("msg","无异常");
		} else {
			System.out.println("成");
			//msgObj.setMsg("登陆成功");
			mv.addObject("msg", "系统异常");
		}
//		return "toLogin";
		return mv;
	}

	// 去添加用户界面
	@RequestMapping(value = "/toAddSysuser", method = RequestMethod.GET)
	public String toAddSysuser() {
		return "system/sysuser/addSysuser";
	}

	// 去用户列表界面
	@RequestMapping(value = "/toSysuserList", method = RequestMethod.GET)
	public String toSysuserList() {
		return "system/sysuser/sysuserList";
	}

	// 添加用户时，异步查询用户名是否存在
	@RequestMapping(value = "/checkSysuserName", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkUsername(@RequestParam("uname") String username) {
		return sysuserService.findSysuserExistByUsername(username);
	}

	// 添加用户操作
	@RequestMapping(value = "/addSysuser", method = RequestMethod.POST)
	@ResponseBody
	public MsgObj addSysuser(Sysuser user, MultipartFile headImg) {
		return sysuserService.insertSysuser(user, headImg);
	}

	// 用户列表数据
	@RequestMapping(value = "/sysuserList", method = RequestMethod.POST)
	@ResponseBody
	public PageObj<Sysuser> sysuserList(PageObj<Sysuser> pageObj) {
		return sysuserService.sysuserList(pageObj);
	}

	// 删除该用户
	@RequestMapping(value = "/deleteSysuser", method = RequestMethod.GET)
	@ResponseBody
	public MsgObj deleteSysuser(Integer id) {
		return sysuserService.deleteSysuser(id);
	}

	// 离职或复职操作
	@RequestMapping(value = "/dimissOrRestore", method = RequestMethod.GET)
	@ResponseBody
	public MsgObj dimissOrRestore(Integer id, Integer delstatus) {
		MsgObj msgObj = sysuserService.updateDelstatusById(id, delstatus);
		return msgObj;
	}

	// 修改用户信息
	@RequestMapping(value = "/editSysuser", method = RequestMethod.POST)
	@ResponseBody
	public MsgObj editSysuser(Sysuser user) {
		return sysuserService.updateSysuser(user);
	}

}
