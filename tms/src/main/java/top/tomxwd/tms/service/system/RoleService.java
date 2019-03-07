package top.tomxwd.tms.service.system;

import top.tomxwd.tms.pojo.system.Role;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

public interface RoleService {
	
	/**
	 * 检查角色名是否存在
	 * @param roleName
	 * @return
	 */
	Boolean findRoleExistByName(String roleName);
	
	/**
	 * 查询角色列表
	 * @param pageObj
	 * @return
	 */
	PageObj<Role> powerList(PageObj<Role> pageObj);
	
	/**
	 * 添加新角色
	 * @param role
	 * @return
	 */
	MsgObj insertRole(Role role);
	
	/**
	 * 更新角色信息
	 * @param role
	 * @return
	 */
	MsgObj updateRole(Role role);
	
	/**
	 * 根据角色id删除该角色记录
	 * @param id
	 * @return
	 */
	MsgObj deleteRoleById(Integer id);

	
	
}
