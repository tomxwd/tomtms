package top.tomxwd.tms.controller.system;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.tomxwd.tms.pojo.system.Power;
import top.tomxwd.tms.pojo.system.Role;
import top.tomxwd.tms.service.system.RoleService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@RequestMapping("/role")
@Controller
public class RoleController {

	@Autowired
	private RoleService service;

	// 去添加角色界面
	@RequestMapping(value = "/toAddRole", method = RequestMethod.GET)
	@RequiresPermissions("role:listPage")
	public String toAddRole() {
		return "system/role/addRole";
	}

	// 去角色列表界面
	@RequestMapping(value = "/toRoleList", method = RequestMethod.GET)
	@RequiresPermissions("role:addPage")
	public String toPowerList() {
		return "system/role/roleList";
	}

	// 检查角色是否存在
	@RequestMapping(value = "/checkRoleName", method = RequestMethod.GET)
	@ResponseBody
	public Boolean checkRoleName(String roleName) {
		return service.findRoleExistByName(roleName);
	}
	
	//检查角色是否存在以及是否为同名
	@RequestMapping(value = "/checkRoleNameExistOrSame",method=RequestMethod.GET)
	@ResponseBody
	public Boolean checkRoleNameExistOrSame(String roleName,String roleNameCheck) {
		return service.findRoleExistOrSame(roleName,roleNameCheck);
	}

	// 查询角色列表
	@RequestMapping(value = "/roleList", method = RequestMethod.POST)
	@RequiresPermissions("role:list")
	@ResponseBody
	public PageObj<Role> roleList(PageObj<Role> pageObj) {
		return service.roleList(pageObj);
	}

	// 添加新角色
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	@RequiresPermissions("role:add")
	@ResponseBody
	public MsgObj addRole(Role role) {
		return service.insertRole(role);
//		if(role.getPowers()!=null) {
//			List<Integer> powers = role.getPowers();
//			for (Integer power : powers) {
//				System.out.println(power);
//			}
//		}
//		return null;
	}

	// 编辑角色
	@RequestMapping(value = "/editRole", method = RequestMethod.POST)
	@RequiresPermissions("role:edit")
	@ResponseBody
	public MsgObj editRole(Role role) {
		return service.updateRole(role);
	}

	// 删除角色
	@RequestMapping(value = "/deleteRole", method = RequestMethod.GET)
	@RequiresPermissions("role:delete")
	@ResponseBody
	public MsgObj deleteRole(Integer id) {
		return service.deleteRoleById(id);
	}
	
	// 查找所有角色 供用户选择角色用
	@RequestMapping(value="/allRole",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> allRole(){
		return service.getAllRole();
	}
	/*
	 * 
	 * // 查找所有模块
	 * 
	 * @RequestMapping(value="/allModular",method=RequestMethod.GET)
	 * 
	 * @ResponseBody public Map<String, Object> allModular(){ return
	 * service.getAllModular(); }
	 */

}
