package top.tomxwd.tms.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.tomxwd.tms.pojo.system.Role;
import top.tomxwd.tms.service.system.RoleService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@RequestMapping("/role")
@Controller
public class RoleController {
	
	@Autowired
	private RoleService service;
	
	//去添加角色界面
	@RequestMapping(value="/toAddRole",method=RequestMethod.GET)
	public String toAddRole() {
		return "system/role/addRole";
	}
	
	//去角色列表界面
	@RequestMapping(value="toPowerList",method=RequestMethod.GET)
	public String toPowerList() {
		return "system/role/roleList";
	}
	
	//检查角色是否存在
	@RequestMapping(value="/checkRoleName",method=RequestMethod.GET)
	@ResponseBody
	public Boolean checkRoleName(String roleName) {
		return service.findRoleExistByName(roleName);
	}
	
	//查询角色列表
	@RequestMapping(value="/powerList",method=RequestMethod.POST)
	@ResponseBody
	public PageObj<Role> powerList(PageObj<Role> pageObj){
		return service.powerList(pageObj);
	}
	
	//添加新角色
	@RequestMapping(value="/addRole",method=RequestMethod.POST)
	@ResponseBody
	public MsgObj addRole(Role role) {
		return service.insertRole(role);
	}
	
	//编辑角色
	@RequestMapping(value="/editRole",method=RequestMethod.POST)
	@ResponseBody
	public MsgObj editRole(Role role) {
		return service.updateRole(role);
	}
	
	//删除角色
	@RequestMapping(value="deleteRole",method=RequestMethod.GET)
	@ResponseBody
	public MsgObj deleteRole(Integer id) {
		return service.deleteRoleById(id);
	}
	
	/*

	// 查找所有模块
	@RequestMapping(value="/allModular",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> allModular(){
		return service.getAllModular();
	}
	 */
	
}
