package top.tomxwd.tms.service.car.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.tomxwd.tms.mapper.car.CarMaintainMapper;
import top.tomxwd.tms.mapper.car.CarMapper;
import top.tomxwd.tms.mapper.driver.DriverAndCarMapper;
import top.tomxwd.tms.mapper.driver.IllegalRecordMapper;
import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.car.CarMaintainExample;
import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample;
import top.tomxwd.tms.pojo.driver.IllegalRecord;
import top.tomxwd.tms.pojo.driver.IllegalRecordExample;
import top.tomxwd.tms.service.car.CarInfoService;
import top.tomxwd.tms.service.driver.DriverAndCarInfoService;
import top.tomxwd.tms.service.driver.DriverInfoService;

@Service
public class CarInfoServiceImpl implements CarInfoService{
	
	@Autowired
	private DriverInfoService driverService;
	@Autowired
	private DriverAndCarInfoService driverAndCarInfoService;
	@Autowired
	private CarMapper mapper;
	@Autowired
	private DriverAndCarMapper driverAndCarMapper;
	@Autowired
	private IllegalRecordMapper illegalMapper;
	@Autowired
	private CarMaintainMapper maintainMapper;
	
	
	@Override
	public Car getCarInfo() {
		DriverAndCar driverAndCarInfo = driverAndCarInfoService.getDriverAndCarInfo();
		if(driverAndCarInfo==null) {
			return null;
		}
		Car car = mapper.selectByPrimaryKey(driverAndCarInfo.getCarId());
		return car;
	}

	@Override
	public List<DriverAndCar> getDriverAndCarInfo() {
		Car car = this.getCarInfo();
		if(car==null) {
			return null;
		}
		DriverAndCarExample example = new DriverAndCarExample();
		example.createCriteria().andCarIdEqualTo(car.getId());
		List<DriverAndCar> list = driverAndCarMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<CarMaintain> getMaintainInfo() {
		Car car = this.getCarInfo();
		if(car==null) {
			return null;
		}
		CarMaintainExample example = new CarMaintainExample();
		example.createCriteria().andCarIdEqualTo(car.getId());
		List<CarMaintain> list = maintainMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<IllegalRecord> getIllegalRecord() {
		Car car = this.getCarInfo();
		if(car==null) {
			return null;
		}
		IllegalRecordExample example = new IllegalRecordExample();
		example.createCriteria().andCarIdEqualTo(car.getId());
		List<IllegalRecord> list = illegalMapper.selectByExample(example);
		return list;
	}
	
	
}
