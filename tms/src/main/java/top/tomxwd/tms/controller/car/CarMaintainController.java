package top.tomxwd.tms.controller.car;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.service.car.CarMaintainService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@Controller
@RequestMapping("/carMaintain")
public class CarMaintainController {

	@Autowired
	private CarMaintainService service;

	// 去维修记录列表页面
	@RequestMapping(value = "/toCarMaintainList", method = RequestMethod.GET)
	@RequiresPermissions("maintain:listPage")
	public String toCarList() {
		return "car/carMaintainList";
	}

	// 维修记录列表操作
	@RequestMapping(value = "/carMaintainList", method = RequestMethod.POST)
	@RequiresPermissions("maintain:list")
	@ResponseBody
	public Map<String, Object> carMaintainList(@RequestParam Map<String, Object> map) {
		return service.carMaintainList(map);
	}

	// 维修反馈
	@RequestMapping(value = "/maintainFeedBack", method = RequestMethod.POST)
	@RequiresPermissions("maintain:feedback")
	@ResponseBody
	public MsgObj maintainFeedBack(CarMaintain maintain) {
		return service.updateMaintainByCarId(maintain);
	}

	// 查找当前维修记录 根据车辆id
	@RequestMapping(value = "/getMaintainInfoByCarId", method = RequestMethod.GET)
	@ResponseBody
	public CarMaintain getMaintainInfoByCarId(Integer carId) {
		return service.getMaintainInfoByCarId(carId);
	}

	// 查找当前维修记录 根据维修记录id
	@RequestMapping(value="/getMaintainInfoById",method=RequestMethod.GET)
	@ResponseBody
	public CarMaintain getMaintainInfoById(Integer id) {
		return service.getMaintainInfoById(id);
	}
	
	@RequestMapping(value="/addMaintain",method=RequestMethod.POST)
	@RequiresPermissions("maintain:add")
	@ResponseBody
	public MsgObj addMaintain(CarMaintain maintain) {
		return service.insertNewMaintainRecord(maintain);
	}
	
	@RequestMapping(value="/payMaintain",method=RequestMethod.POST)
	@ResponseBody
	public MsgObj payMaintain(Integer id) {
		return service.updateMaintainPayState(id);
	}

}
