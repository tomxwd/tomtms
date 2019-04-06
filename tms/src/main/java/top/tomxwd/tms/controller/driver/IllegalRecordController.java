package top.tomxwd.tms.controller.driver;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.driver.IllegalRecord;
import top.tomxwd.tms.service.driver.IllegalRecordService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;
import top.tomxwd.tms.vo.driver.IllegalRecordPageObj;

@RequestMapping("/illegal")
@Controller
public class IllegalRecordController {

	@Autowired
	private IllegalRecordService service;

	// 去违章记录列表界面
	@RequestMapping(value = "/toIllegalList", method = RequestMethod.GET)
	@RequiresPermissions("illegal:listPage")
	public String toIllegalList() {
		return "driver/illegalList";
	}
	
	// 去添加违章记录界面
	@RequestMapping(value="/toAddIllegal",method=RequestMethod.GET)
	@RequiresPermissions("illegal:addPage")
	public String toAddIllegal() {
		return "driver/addIllegal";
	}
	
	// 缴费
	@RequestMapping(value="/payIllegal",method=RequestMethod.POST)
	@ResponseBody
	public MsgObj payIllegal(Integer id) {
		return service.updatePayStateById(id);
	}
	
	//删除记录
	@RequestMapping(value="/deleteIllegalRecord",method=RequestMethod.GET)
	@RequiresPermissions("illegal:delete")
	@ResponseBody
	public MsgObj deleteIllegalRecord(Integer id) {
		return service.deleteIllegalRecordById(id);
	}
	
	//编辑记录
	@RequestMapping(value="/editIllegalRecord",method=RequestMethod.POST)
	@RequiresPermissions("illegal:edit")
	@ResponseBody
	public MsgObj editIllegalRecord(IllegalRecord record) {
		return service.updateIllegalInfoByRecord(record);
	}

	// 违章记录列表操作
//	@RequestMapping(value = "/illegalList", method = RequestMethod.POST)
//	@ResponseBody
//	public IllegalRecordPageObj<IllegalRecord> illegalList(IllegalRecordPageObj<IllegalRecord> pageObj) {
//		return service.illegalList(pageObj);
//	}
	@RequestMapping(value = "/illegalList", method = RequestMethod.POST)
	@RequiresPermissions("illegal:list")
	@ResponseBody
	public Map<String, Object> illegalList(@RequestParam Map<String,Object> pageObj) {
		return service.illegalListMap(pageObj);
	}
	
	@RequestMapping(value="/addIllegal",method=RequestMethod.POST)
	@RequiresPermissions("illegal:add")
	@ResponseBody
	public MsgObj addIllegal(IllegalRecord record) {
		return service.insertNewIllegalRecord(record);
	}
}
