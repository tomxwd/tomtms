package top.tomxwd.tms.service.driver;

import java.util.List;

import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.IllegalRecord;

public interface DriverAndCarInfoService {
	
	/**
	 * 获取当前用户与现在车辆的租赁信息
	 * @return
	 */
	DriverAndCar getDriverAndCarInfo();
	
	//维修 违章 
	
	/**
	 * 得到当前车辆与用户的维修信息
	 * @param page 
	 * @return
	 */
	List<CarMaintain> getMaintainInfo(Integer page);
	
	/**
	 * 得到当前车辆与用户的违章信息
	 * @param page 
	 * @return
	 */
	List<IllegalRecord> getIllegalInfo(Integer page);
	
	
}
