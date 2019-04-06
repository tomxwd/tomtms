package top.tomxwd.tms.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.tomxwd.tms.pojo.system.Modular;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.system.ModularService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;
import top.tomxwd.tms.vo.QueryObj;

@Controller
@RequestMapping("/modular")
public class ModularController {

	@Autowired
	private ModularService service;

	// 去添加模块界面
	@RequestMapping(value = "/toAddModular", method = RequestMethod.GET)
	@RequiresPermissions("modular:addPage")
	public String toAddModular() {
		return "system/modular/addModular";
	}

	// 去模块列表界面
	@RequestMapping(value = "/toModularList", method = RequestMethod.GET)
	@RequiresPermissions("modular:listPage")
	public String toSysuserList() {
		return "system/modular/modularList";
	}

	// 检查模块名是否存在
	@RequestMapping(value = "/checkModularName", method = RequestMethod.GET)
	@ResponseBody
	public Boolean checkModularName(String modularName) {
		return service.findModularExistByName(modularName);
	}

	// 查询模块列表
	@RequestMapping(value = "/modularList", method = RequestMethod.POST)
	@RequiresPermissions("modular:list")
	@ResponseBody
	public PageObj<Modular> modularList(PageObj<Modular> pageObj) {
		return service.modularList(pageObj);
	}

	// 添加新模块
	@RequestMapping(value = "/addModular", method = RequestMethod.POST)
	@RequiresPermissions("modular:add")
	@ResponseBody
	public MsgObj addModular(Modular modular) {
		return service.insertModular(modular);
	}

	// 编辑模块
	@RequestMapping(value = "/editModular", method = RequestMethod.POST)
	@RequiresPermissions("modular:edit")
	@ResponseBody
	public MsgObj editModular(Modular modular) {
		return service.updateModular(modular);
	}

	// 删除模块
	@RequestMapping(value = "/deleteModular", method = RequestMethod.GET)
	@RequiresPermissions("modular:delete")
	@ResponseBody
	public MsgObj deleteModular(Integer id) {
		return service.deleteModularById(id);
	}
	
	// 查找所有模块
	@RequestMapping(value="/allModular",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> allModular(){
		return service.getAllModular();
	}

}
