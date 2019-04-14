package top.tomxwd.tms.service.driver;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;


import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;
import top.tomxwd.tms.vo.driver.MaintainNoPayException;
import top.tomxwd.tms.vo.driver.IllegalNoPayException;
import top.tomxwd.tms.vo.driver.MaintainExistException;

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
	 * @throws DelelteException 
	 */
	MsgObj deleteDriver (Integer id);
	
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
	
	/**
	 * 司机薪资个人报表
	 * @return
	 */
	Map<String, Object> selectChartDriverPersonalTaximeter();
	
	/**
	 * 司机违章记录个人报表
	 * @return
	 */
	Map<String, Object> selectChartDriverPersonalIllegal();
	
	/**
	 * 司机维修记录个人报表
	 * @return
	 */
	Map<String, Object> selectChartDriverPersonalMaintain();
	
	/**
	 * 司机使用记录
	 * @param map
	 * @return
	 */
	Map<String, Object> useCarRecordList(Map<String, Object> map);

}
