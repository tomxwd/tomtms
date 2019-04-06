package top.tomxwd.tms.service.driver.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.mapper.car.CarMaintainMapper;
import top.tomxwd.tms.mapper.driver.DriverAndCarMapper;
import top.tomxwd.tms.mapper.driver.IllegalRecordMapper;
import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.car.CarMaintainExample;
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample;
import top.tomxwd.tms.pojo.driver.IllegalRecord;
import top.tomxwd.tms.pojo.driver.IllegalRecordExample;
import top.tomxwd.tms.pojo.system.notice.Notice;
import top.tomxwd.tms.pojo.system.notice.NoticeExample;
import top.tomxwd.tms.service.driver.DriverAndCarInfoService;
import top.tomxwd.tms.service.driver.DriverInfoService;

@Service
public class DriverAndCarInfoServiceImpl implements DriverAndCarInfoService {
	
	@Autowired
	private DriverInfoService driverService;
	@Autowired
	private DriverAndCarMapper mapper;
	@Autowired
	private CarMaintainMapper maintainMapper;
	@Autowired
	private IllegalRecordMapper illegalMapper;
	
	@Override
	public DriverAndCar getDriverAndCarInfo() {
		Driver driver = driverService.getCurrentDriver();
		if(driver==null) {
			return null;
		}
		DriverAndCarExample example = new DriverAndCarExample();
		example.createCriteria().andDriverIdEqualTo(driver.getId()).andRentStateEqualTo(1);
		List<DriverAndCar> list = mapper.selectByExample(example);
		DriverAndCar driverAndCar;
		if(list.size()!=0) {
			driverAndCar = list.get(0);
		}else {
			return null;
		}
		return driverAndCar;
	}

	@Override
	public List<CarMaintain> getMaintainInfo(Integer page) {
		DriverAndCar driverAndCar = this.getDriverAndCarInfo();
		if(driverAndCar==null) {
			return null;
		}
		if(page==null) {
			page=1;
		}
		PageHelper.startPage(page,5);
		CarMaintainExample example = new CarMaintainExample();
		example.createCriteria().andCarIdEqualTo(driverAndCar.getCarId()).andDriverIdEqualTo(driverAndCar.getDriverId());
		example.setOrderByClause("pay_state asc,id desc");
		List<CarMaintain> list = maintainMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<IllegalRecord> getIllegalInfo(Integer page) {
		DriverAndCar driverAndCar = this.getDriverAndCarInfo();
		if(driverAndCar==null) {
			return null;
		}
		if(page==null) {
			page=1;
		}
		PageHelper.startPage(page,5);
		IllegalRecordExample example = new IllegalRecordExample();
		example.createCriteria().andCarIdEqualTo(driverAndCar.getCarId()).andDriverIdEqualTo(driverAndCar.getDriverId());
		example.setOrderByClause("pay_state asc,id desc");
		List<IllegalRecord> list = illegalMapper.selectByExample(example);
		return list;
	}
	
}
