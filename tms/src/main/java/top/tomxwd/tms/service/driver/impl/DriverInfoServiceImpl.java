package top.tomxwd.tms.service.driver.impl;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.tomxwd.tms.mapper.car.CarMaintainMapper;
import top.tomxwd.tms.mapper.car.CarMapper;
import top.tomxwd.tms.mapper.driver.DriverAndCarMapper;
import top.tomxwd.tms.mapper.driver.DriverMapper;
import top.tomxwd.tms.mapper.driver.IllegalRecordMapper;
import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.car.CarMaintainExample;
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample.Criteria;
import top.tomxwd.tms.pojo.driver.DriverExample;
import top.tomxwd.tms.pojo.driver.IllegalRecord;
import top.tomxwd.tms.pojo.driver.IllegalRecordExample;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.driver.DriverInfoService;

@Service
public class DriverInfoServiceImpl implements DriverInfoService {

	@Autowired
	private DriverMapper driverMapper;
	@Autowired
	private CarMapper carMapper;
	@Autowired
	private DriverAndCarMapper driverAndCarMapper;
	@Autowired
	private IllegalRecordMapper illegalMapper;
	@Autowired
	private CarMaintainMapper maintainMapper;

	@Override
	public Sysuser getCurrentUser() {
		// 通过shiro获取用户信息
		Sysuser user = (Sysuser) SecurityUtils.getSubject().getPrincipal();
		return user;
	}

	@Override
	public Driver getCurrentDriver() {
		Sysuser user = this.getCurrentUser();
		if(user==null) {
			return null;
		}
		if(user.getRoleId()!=1) {
			return null;
		}
		// 根据用户信息得到司机信息
		DriverExample driverExample = new DriverExample();
		driverExample.createCriteria().andUserIdEqualTo(user.getId());
		List<Driver> list = driverMapper.selectByExample(driverExample);
		Driver driver = null;
		if (list.size() != 0) {
			driver = list.get(0);
		} else {
			return null;
		}
		return driver;
	}

	
	@Override
	public List<DriverAndCar> getCurrentDriverAndCarRecord() {
		Driver driver = this.getCurrentDriver();
		if(driver==null) {
			return null;
		}
		// 根据司机id查找租赁记录
		DriverAndCarExample example = new DriverAndCarExample();
		Criteria criteria = example.createCriteria();
		criteria.andDriverIdEqualTo(driver.getId());
		List<DriverAndCar> list = driverAndCarMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<CarMaintain> getCurrentDriverMaintainRecord() {
		Driver driver = this.getCurrentDriver();
		if(driver==null) {
			return null;
		}
		//根据司机id查找维修记录
		CarMaintainExample example = new CarMaintainExample();
		example.createCriteria().andDriverIdEqualTo(driver.getId());
		List<CarMaintain> list = maintainMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<IllegalRecord> getCurrentDriverIllegalRecord() {
		Driver driver = this.getCurrentDriver();
		if(driver==null) {
			return null;
		}
		//根据司机id查找违章记录
		IllegalRecordExample example = new IllegalRecordExample();
		example.createCriteria().andDriverIdEqualTo(driver.getId());
		List<IllegalRecord> list = illegalMapper.selectByExample(example);
		return list;
	}

	
}
