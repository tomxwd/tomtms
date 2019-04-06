package top.tomxwd.tms.service.car;

import java.util.List;

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.IllegalRecord;

/**
 * 完全关于车辆信息
 */
public interface CarInfoService {
	
	/**
	 * 获取车辆信息
	 * @return
	 */
	Car getCarInfo();
	
	/**
	 * 获取车辆被租赁以及审核的信息
	 * @return
	 */
	List<DriverAndCar> getDriverAndCarInfo();
	
	/**
	 * 获取车辆的维修记录
	 * @return
	 */
	List<CarMaintain> getMaintainInfo(); 
	
	/**
	 * 获取车辆的违章记录
	 * @return
	 */
	List<IllegalRecord> getIllegalRecord();
	
}
