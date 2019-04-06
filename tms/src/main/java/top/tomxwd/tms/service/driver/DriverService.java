package top.tomxwd.tms.service.driver;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

public interface DriverService {
	
	
	/**
	 * 司机列表
	 * @param pageObj
	 * @return
	 */
	PageObj<Driver> driverList(PageObj<Driver> pageObj);
	
	/**
	 * 删除司机
	 * @param id
	 * @return
	 */
	MsgObj deleteDriver(Integer id);
	
	/**
	 * 更新司机信息
	 * @param driver
	 * @return
	 */
	MsgObj updateDriver(Driver driver);
	
	/**
	 * 审核司机
	 * @param driver
	 * @return
	 */
	MsgObj updateExaminerDriverById(Driver driver);
	
	/**
	 * 注册新司机，未审核
	 * @param driver
	 * @param user
	 * @param myheadImg
	 * @return
	 */
	MsgObj insertDriver(Driver driver, Sysuser user, MultipartFile myheadImg);
	
	/**
	 * 根据车辆id查询司机信息
	 * @param id
	 * @return
	 */
	Map<String, Object> getDriverInfoByCarId(Integer id);
	
	/**
	 * 得到所有司机的名字和id 前提是其拥有车
	 * @return
	 */
	Map<String, Object> getAllDriver();

}
