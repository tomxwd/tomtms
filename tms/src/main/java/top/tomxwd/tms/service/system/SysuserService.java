package top.tomxwd.tms.service.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;
import top.tomxwd.tms.vo.QueryObj;

public interface SysuserService {
	
	/**
	 * 用户登录功能，校验验证码，用户名密码，以及将用户信息存储到Cookie中
	 * @param user
	 * @param verify
	 * @param req
	 * @param resp
	 * @return
	 */
	MsgObj findSysuserByInfo(Sysuser user, String verify, HttpServletRequest req, HttpServletResponse resp);
	
	/**
	 * 检查用户名是否存在
	 * @param username
	 * @return
	 */
	boolean findSysuserExistByUsername(String username);
	
	/**
	 * 添加用户操作
	 * @param user
	 * @param headImg 
	 * @return
	 */
	MsgObj insertSysuser(Sysuser user, MultipartFile headImg);
	
	/**
	 * 用户列表界面，展示用户列表信息，包括查询功能
	 * @param pageObj
	 * @param queryObj
	 * @return
	 */
	PageObj<Sysuser> sysuserList(PageObj<Sysuser> pageObj);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * @return
	 */
	MsgObj deleteSysuser(Integer id);
	
	/**
	 * 离职或复职操作，若为1则改为0，若为0则改为1
	 * @param id
	 * @param delstatus
	 * @return
	 */
	MsgObj updateDelstatusById(Integer id, Integer delstatus);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	MsgObj updateSysuser(Sysuser user);
	
	/**
	 * shiro使用
	 * 根据用户名,返回用户信息
	 * @param username
	 * @return
	 */
	Sysuser findSysuserInfoByUserName(String username);
	
}
