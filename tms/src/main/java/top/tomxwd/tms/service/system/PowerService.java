package top.tomxwd.tms.service.system;

import java.util.Map;

import top.tomxwd.tms.pojo.system.Power;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

public interface PowerService {
	
	/**
	 * 查找权限名是否存在
	 * @param powerName
	 * @return
	 */
	Boolean findPowerExistByName(String powerName);
	
	/**
	 * 权限列表
	 * @param map
	 * @return
	 */
	Map<String, Object> powerList(Map<String, Object> map);
	
	/**
	 * 插入新的权限
	 * @param power
	 * @return
	 */
	MsgObj insertPower(Power power);

	/**
	 * 更新权限
	 * @param power
	 * @return
	 */
	MsgObj updatePower(Power power);
	
	/**
	 * 根据id删除权限
	 * @param id
	 * @return
	 */
	MsgObj deletePower(Integer id);
	
	/**
	 * 检查权限名是否相同或者是否已经存在
	 * @param powerName
	 * @param powerNameCheck
	 * @return
	 */
	Boolean findPowerExistOrSameByName(String powerName, String powerNameCheck);
	
	
}
