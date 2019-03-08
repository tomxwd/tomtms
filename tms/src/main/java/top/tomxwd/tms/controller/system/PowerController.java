package top.tomxwd.tms.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.tomxwd.tms.pojo.system.Power;
import top.tomxwd.tms.service.system.PowerService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@Controller
@RequestMapping("/power")
public class PowerController {

	@Autowired
	private PowerService service;

	// 去添加权限页面
	@RequestMapping(value = "/toAddPower", method = RequestMethod.GET)
	public String toAddPower() {
		return "system/power/addPower";
	}

	// 去权限列表页面
	@RequestMapping(value = "/toPowerList", method = RequestMethod.GET)
	public String toPowerList() {
		return "system/power/powerList";
	}

	// 检查权限名是否存在
	@RequestMapping(value = "/checkPowerName", method = RequestMethod.GET)
	@ResponseBody
	public Boolean checkPowerName(String powerName) {
		return service.findPowerExistByName(powerName);
	}

	// 检查权限名是否存在以及同名
	@RequestMapping(value = "/checkPowerNameExistOrSame", method = RequestMethod.GET)
	@ResponseBody
	public Boolean checkPowerNameExistOrSame(String powerName, String powerNameCheck) {
		return service.findPowerExistOrSameByName(powerName, powerNameCheck);
	}

	// 查询权限列表
	@RequestMapping(value = "/powerList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> powerList(@RequestParam Map<String, Object> map) {
		return service.powerList(map);
	}

	// 添加新权限
	@RequestMapping(value = "/addPower", method = RequestMethod.POST)
	@ResponseBody
	public MsgObj addPower(Power power) {
		return service.insertPower(power);
	}

	// 编辑权限
	@RequestMapping(value = "/editPower", method = RequestMethod.POST)
	@ResponseBody
	public MsgObj editPower(Power power) {
		return service.updatePower(power);
	}

	// 删除权限
	@RequestMapping(value = "/deletePower", method = RequestMethod.GET)
	@ResponseBody
	public MsgObj deletePower(Integer id) {
		return service.deletePower(id);
	}
	
	//查找所有权限，根据模块来划分
	@RequestMapping(value="/getAllPowerToRole",method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getAllPowerToRole() {
		return service.selectAllPowerAndModularName();
	}
	
	//查找该角色拥有的权限，根据角色id来找
	@RequestMapping(value="/getRoleOwnPowers",method=RequestMethod.GET)
	@ResponseBody
	public List<Integer> getRoleOwnPowers(Integer roleId){
		return service.selectRoleOwnPowers(roleId);
	}
	
}
