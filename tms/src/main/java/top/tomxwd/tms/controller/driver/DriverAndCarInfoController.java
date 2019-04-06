package top.tomxwd.tms.controller.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.driver.IllegalRecord;
import top.tomxwd.tms.service.driver.DriverAndCarInfoService;

@Controller
@RequestMapping("/driverAndCarInfo")
public class DriverAndCarInfoController {
	
	@Autowired
	private DriverAndCarInfoService service;
	
	@RequestMapping(value="/getMaintainInfo",method=RequestMethod.GET)
	@ResponseBody
	public List<CarMaintain> getMaintainInfo(Integer page){
		return service.getMaintainInfo(page);
	}
	
	@RequestMapping(value="/getIllegalInfo",method=RequestMethod.GET)
	@ResponseBody
	public List<IllegalRecord> getIllegalInfo(Integer page){
		return service.getIllegalInfo(page);
	}
	
	
}
