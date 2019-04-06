package top.tomxwd.tms.service.driver;

import java.util.List;

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.IllegalRecord;
import top.tomxwd.tms.pojo.system.Sysuser;

/**
 * 此处获得的全部是关于司机本人的相关信息
 */
public interface DriverInfoService {
	
	/**
	 * 获取当前用户信息
	 * @return
	 */
	Sysuser getCurrentUser();
	
	/**
	 * 获取当前司机信息
	 * @return
	 */
	Driver getCurrentDriver();
	
	/**
	 * 获取当前司机租赁记录
	 * @return
	 */
	List<DriverAndCar> getCurrentDriverAndCarRecord();
	
	/**
	 * 获取当前司机的维修记录史
	 * @return
	 */
	List<CarMaintain> getCurrentDriverMaintainRecord();
	
	/**
	 * 获取当前司机的所有违章记录
	 * @return
	 */
	List<IllegalRecord> getCurrentDriverIllegalRecord();
	

	
}
