package top.tomxwd.tms.controller.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.service.car.CarInfoService;

@RequestMapping("/carInfo")
@Controller
public class CarInfoController {
	
	@Autowired
	private CarInfoService service;
	
	@RequestMapping(value="/getCarInfo",method=RequestMethod.GET)
	@ResponseBody
	public Car getCarInfo() {
		return service.getCarInfo();
	}
	
}
