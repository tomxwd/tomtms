package top.tomxwd.tms.controller.driver;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.driver.DriverService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;
import top.tomxwd.tms.vo.driver.MaintainNoPayException;
import top.tomxwd.tms.vo.driver.IllegalNoPayException;
import top.tomxwd.tms.vo.driver.MaintainExistException;

@Controller
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private DriverService service;

	// 去添加司机页面
	@RequestMapping(value = "/toAddDriver", method = RequestMethod.GET)
	public String toAddDriver() {
		return "driver/addDriver";
	}

	// 去司机列表界面
	@RequestMapping(value = "/toDriverList", method = RequestMethod.GET)
	@RequiresPermissions("driver:listPage")
	public String toDriverList() {
		return "driver/driverList";
	}

	// 注册司机操作
	@RequestMapping(value = "/addDriver", method = RequestMethod.POST)
	@ResponseBody
	public MsgObj addDriver(Driver driver, Sysuser user, MultipartFile myheadImg) {
		return service.insertDriver(driver, user, myheadImg);
	}

	// 司机列表操作
	@RequestMapping(value = "/driverList", method = RequestMethod.POST)
	@RequiresPermissions("driver:list")
	@ResponseBody
	public PageObj<Driver> driverList(PageObj<Driver> pageObj) {
		return service.driverList(pageObj);
	}

	// 删除司机操作
	@RequestMapping(value = "/deleteDriver", method = RequestMethod.GET)
	@RequiresPermissions("driver:delete")
	@ResponseBody
	public MsgObj deleteSysuser(Integer id) {
		MsgObj msgObj = null;
		try {
			msgObj = service.deleteDriver(id);
		} catch (MaintainExistException e) {
			System.out.println("维修未完成");
			return new MsgObj(0, "尚有维修未完成，不可删除");
		} catch (MaintainNoPayException e) {
			System.out.println("维修未缴费");
			return new MsgObj(0,"尚有维修记录未缴费，不可删除");
		} catch (IllegalNoPayException e) {
			System.out.println("违章未缴费");
			return new MsgObj(0,"尚有违章记录未缴费，不可删除");
		}
		return msgObj;
	}

	// 编辑司机
	@RequestMapping(value = "/editDriver", method = RequestMethod.POST)
	@RequiresPermissions("driver:edit")
	@ResponseBody
	public MsgObj editDriver(Driver driver) {
		return service.updateDriver(driver);
	}

	// 审核通过不通过操作
	@RequestMapping(value = "/examinerDriver", method = RequestMethod.GET)
	@RequiresPermissions("driver:examiner")
	@ResponseBody
	public MsgObj examinerDriver(Driver driver) {
		return service.updateExaminerDriverById(driver);
	}

	// 根据车辆id查询司机信息
	@RequestMapping(value = "/getDriverInfoByCarId", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDriverInfoByCarId(Integer id) {
		return service.getDriverInfoByCarId(id);
	}

	// 得到所有司机 id和名字 自动搜全
	@RequestMapping(value = "/allDriver", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> allDriver() {
		return service.getAllDriver();
	}

	// 司机个人报表页面
	@RequestMapping(value = "/toDriverChart", method = RequestMethod.GET)
	public String toDriverChart() {
		return "driver/driverChart";
	}

	@RequestMapping(value = "/chartDriverPersonalTaximeter", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> chartDriverPersonalTaximeter() {
		return service.selectChartDriverPersonalTaximeter();
	}

	@RequestMapping(value = "/chartDriverPersonalIllegal", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> chartDriverPersonalIllegal() {
		return service.selectChartDriverPersonalIllegal();
	}

	@RequestMapping(value = "/chartDriverPersonalMaintain", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> chartDriverPersonalMaintain() {
		return service.selectChartDriverPersonalMaintain();
	}
	
	@RequestMapping(value="/toUseCarRecord",method=RequestMethod.GET)
	public String toUseCarRecord() {
		return "driver/useCarRecord";
	}
	
	@RequestMapping(value="/useCarRecordList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> useCarRecordList(@RequestParam Map<String, Object> map) {
		return service.useCarRecordList(map);
	}

}
