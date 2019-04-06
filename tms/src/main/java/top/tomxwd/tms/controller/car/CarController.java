package top.tomxwd.tms.controller.car;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.car.CarService;
import top.tomxwd.tms.service.driver.DriverAndCarService;
import top.tomxwd.tms.utils.CookieUtils;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@Controller
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService service;
	
	//去添加车辆页面
	@RequestMapping(value="/toAddCar",method=RequestMethod.GET)
	@RequiresPermissions("car:addPage")
	public String toAddCar() {
		return "car/addCar";
	}
	
	//去车辆列表页面
	@RequestMapping(value="/toCarList",method=RequestMethod.GET)
	@RequiresPermissions("car:listPage")
	public String toCarList() {
		return "car/carList";
	}
	
	//TODO 
	//去车辆使用记录列表页面
	@RequestMapping(value="/toCarUseRecordList",method=RequestMethod.GET)
	public String toCarUseRecordList() {
		return "car/carUseRecord";
	}
	
	//去租车页面
	@RequestMapping(value="/toRentCar",method=RequestMethod.GET)
	@RequiresPermissions("car:rentPage")
	public String toRentCar() {
		return "car/rentCarList";
	}
	//去个人车辆信息页面
	@RequestMapping(value="/toCarInfo",method=RequestMethod.GET)
	@RequiresPermissions("car:infoPage")
	public String toCarInfo() {
		return "car/carInfo";
	}
	
	//添加车辆操作
	@RequestMapping(value="/addCar",method=RequestMethod.POST)
	@RequiresPermissions("car:add")
	@ResponseBody
	public MsgObj addCar(Car car,@RequestParam("car_Img")MultipartFile carImgFile) {
		return service.insertCar(car,carImgFile);
	}
	
	//车辆列表操作
	@RequestMapping(value="/carList",method=RequestMethod.POST)
	@RequiresPermissions("car:carlist")
	@ResponseBody
	public PageObj<Car> carList(PageObj<Car> pageObj){
		return service.carList(pageObj);
	}
	
	//租车列表操作 必须是未使用的
	@RequestMapping(value="/rentCarList",method=RequestMethod.POST)
	@RequiresPermissions("car:rentList")
	@ResponseBody
	public PageObj<Car> rentCarList(PageObj<Car> pageObj){
		return service.rentCarList(pageObj);
	}
	
	//删除车辆操作
	@RequestMapping(value="/deleteCar",method=RequestMethod.GET)
	@RequiresPermissions("car:delete")
	@ResponseBody
	public MsgObj deleteCar(Integer id) {
		return service.deleteCar(id);
	}
	
	//审核通过操作
	@RequestMapping(value="/examinerPassDriverAndCar",method=RequestMethod.GET)
	@RequiresPermissions("car:examinerPass")
	@ResponseBody
	public MsgObj examinerPassDriverAndCar(Integer id,Integer carState,Integer rentState) {
		return service.updateDriverAndCarAndCarStatePass(id,carState,rentState);
	}
	
	//审核未通过操作
	@RequestMapping(value="/examinerRefuseDriver",method=RequestMethod.POST)
	@RequiresPermissions("car:examinerRefuse")
	@ResponseBody
	public MsgObj examinerRefuseDriver(@RequestParam("reson_car_id") Integer id,Integer carState,String refuseReson,Integer rentState) {
		//租借状态 0审核中 1使用中 2使用审核未通过 3退车审核未通过 4已作废
		return service.updateDriverAndCarAndCarStateRefuse(id,carState,refuseReson,rentState);
	}
	
	//根据id获取车辆信息
	@RequestMapping(value="/getOneCarInfo",method=RequestMethod.GET)
	@ResponseBody
	public Car getOneCarInfo(Integer id) {
		return service.getOneCarInfoById(id);
	}
	
	//根据当前用户获取车辆信息
	@RequestMapping(value="/getCarInfoByCurrentDriver",method=RequestMethod.GET)
	@ResponseBody
	public Car getCarInfoByCurrentDriver() {
		//return service.getCarInfoByCurrentDriver();
		return null;
	}
	
	//编辑车辆操作
	@RequestMapping(value="/editCar",method=RequestMethod.POST)
	@RequiresPermissions("car:edit")
	@ResponseBody
	public MsgObj editCar(Car car,MultipartFile car_Img) {
		return service.updateCar(car,car_Img);
	}
	
	//检查该用户是否租借了车
	@RequestMapping(value="/checkDriverOwnCar",method=RequestMethod.GET)
	@ResponseBody
	public MsgObj checkDriverOwnCar() {
		return service.checkDriverOwnCar();
	}
	
	//检查该用户是否还有审核未完成
	@RequestMapping(value="/checkDriverOwnExam",method=RequestMethod.GET)
	@ResponseBody
	public MsgObj checkDriverOwnExam() {
		return service.checkDriverOwnExam();
	}
	
	//检查该用户车辆是否拥有车辆以及是否已经在维修
	@RequestMapping(value="/checkDriverOwnMaintain",method=RequestMethod.GET)
	@ResponseBody
	public MsgObj checkDriverOwnMaintain() {
		return service.checkDriverOwnMaintain();
	}
	
	
	//租车操作
	@RequestMapping(value="/rentCarByCarId",method=RequestMethod.GET)
	@RequiresPermissions("car:rent")
	@ResponseBody
	public MsgObj rentCarByCarId(Integer id) {
		return service.insertRentCarRecord(id);
	}
	
	//退车操作
	@RequestMapping(value="/backCarByCarId",method=RequestMethod.GET)
	@RequiresPermissions("car:back")
	@ResponseBody
	public MsgObj backCarByCarId() {
		return service.updateRentCarRecord();
	}
	
}
