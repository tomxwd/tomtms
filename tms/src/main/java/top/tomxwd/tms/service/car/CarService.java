package top.tomxwd.tms.service.car;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

public interface CarService {
	
	/**
	 * 插入新车辆操作
	 * @param car
	 * @param carImgFile 
	 * @return
	 */
	MsgObj insertCar(Car car, MultipartFile carImgFile);
	
	/**
	 * 查询车辆列表操作
	 * @param pageObj
	 * @return
	 */
	PageObj<Car> carList(PageObj<Car> pageObj);
	
	/**
	 * 根据id删除车辆操作
	 * @param id
	 * @return
	 */
	MsgObj deleteCar(Integer id);

	/**
	 * 更新车辆信息操作
	 * @param car
	 * @param car_Img
	 * @return
	 */
	MsgObj updateCar(Car car,MultipartFile car_Img);
	
	/**
	 * 司机租车成功或退车成功
	 * @param id
	 * @param carState
	 * @param rentState 
	 * @return
	 */
	MsgObj updateDriverAndCarAndCarStatePass(Integer id, Integer carState, Integer rentState);
	
	/**
	 * 司机租车失败 或 退车失败
	 * @param id
	 * @param carState
	 * @param refuseReson
	 * @param rentState
	 * @return
	 */
	MsgObj updateDriverAndCarAndCarStateRefuse(Integer id, Integer carState, String refuseReson, Integer rentState);
	
	/**
	 * 查找车辆信息 根据车辆id
	 * @param id
	 * @return
	 */
	Car getOneCarInfoById(Integer id);
	
	/**
	 * 查找租车信息 必须是未使用中的
	 * @param pageObj
	 * @return
	 */
	PageObj<Car> rentCarList(PageObj<Car> pageObj);
	
	/**
	 * 用户信息在shiro中取
	 * 检查该用户是否已经拥有车
	 * @return
	 */
	MsgObj checkDriverOwnCar();
	
	/**
	 * 插入新的车辆租赁记录，并更改车辆状态
	 * @param id
	 * @return
	 */
	MsgObj insertRentCarRecord(Integer id);
	
	/**
	 * 申请退车操作
	 * @return
	 */
	MsgObj updateRentCarRecord();
	
	/**
	 * 检查用户是否还有审核未完成，防止重复提交审核
	 * @return
	 */
	MsgObj checkDriverOwnExam();
	
	/**
	 * 检查用户是否拥有车辆以及是否正在维修，防止重复提交
	 * @return
	 */
	MsgObj checkDriverOwnMaintain();

}
