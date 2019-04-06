package top.tomxwd.tms.service.car;

import java.util.Map;

import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.vo.MsgObj;

public interface CarMaintainService {
	
	/**
	 * 根据车辆id 查询正在维修的记录
	 * @param carId
	 * @return
	 */
	CarMaintain getMaintainInfoByCarId(Integer carId);
	
	/**
	 * 完善维修记录 根据车辆id查询
	 * @param maintain
	 * @return
	 */
	MsgObj updateMaintainByCarId(CarMaintain maintain);
	
	/**
	 * 维修记录列表，返回车主姓名 联系电话
	 * @param map
	 * @return
	 */
	Map<String, Object> carMaintainList(Map<String, Object> map);
	
	/**
	 * 根据维修记录id查询维修记录
	 * @param id
	 * @return
	 */
	CarMaintain getMaintainInfoById(Integer id);
	
	/**
	 * 车主报修
	 * @param maintain
	 * @return
	 */
	MsgObj insertNewMaintainRecord(CarMaintain maintain);
	
	/**
	 * 缴费
	 * @param id
	 * @return
	 */
	MsgObj updateMaintainPayState(Integer id);

}
