package top.tomxwd.tms.service.car.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.mapper.car.CarMaintainMapper;
import top.tomxwd.tms.mapper.car.CarMapper;
import top.tomxwd.tms.mapper.driver.DriverAndCarMapper;
import top.tomxwd.tms.mapper.driver.DriverMapper;
import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.car.CarMaintainExample;
import top.tomxwd.tms.pojo.car.CarMaintainExample.Criteria;
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample;
import top.tomxwd.tms.pojo.driver.DriverExample;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.car.CarMaintainService;
import top.tomxwd.tms.vo.MsgObj;

@Service
public class CarMaintainServiceImpl implements CarMaintainService {

	@Autowired
	private CarMaintainMapper mapper;
	@Autowired
	private DriverAndCarMapper driverAndCarMapper;
	@Autowired
	private DriverMapper driverMapper;
	@Autowired
	private CarMapper carMapper;

	@Override
	public CarMaintain getMaintainInfoByCarId(Integer carId) {
		CarMaintainExample example = new CarMaintainExample();
		Criteria criteria = example.createCriteria();
		criteria.andCarIdEqualTo(carId);
		criteria.andMaintainStateEqualTo(0);
		List<CarMaintain> list = mapper.selectByExample(example);
		CarMaintain carMaintain = null;
		if (list.size() != 0) {
			carMaintain = list.get(0);
		}
		return carMaintain;
	}

	@Override
	public MsgObj updateMaintainByCarId(CarMaintain maintain) {
		// 修改车辆状态
		Car car = new Car();
		car.setId(maintain.getCarId());
		car.setCarState(1);
		int i = carMapper.updateByPrimaryKeySelective(car);
		// 修改维修记录
		CarMaintain oldRecord = this.getMaintainInfoByCarId(maintain.getCarId());
		maintain.setId(oldRecord.getId());
		maintain.setCompleteDate(new Date());
		if (maintain.getInsuranceType() == 1) {
			maintain.setPayState(1);
		}
		maintain.setMaintainState(1);
		int j = mapper.updateByPrimaryKeySelective(maintain);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if (i != 0 && j != 0) {
			msgObj.setMsg("反馈成功！");
		} else {
			msgObj.setMsg("维修反馈失败！请稍后再试！");
		}
		return msgObj;
	}

	@Override
	public Map<String, Object> carMaintainList(Map<String, Object> map) {
		PageHelper.startPage(Integer.parseInt(map.get("page").toString()),
				Integer.parseInt(map.get("rows").toString()));
		String keyword = "";
		if (map.containsKey("keyword")) {
			keyword = map.get("keyword").toString();
		}
		List<Map<String, Object>> list = mapper.selectCarMaintainListByKeyword(keyword);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
		map.put("root", list);
		map.put("records", pageInfo.getTotal());
		map.put("total", pageInfo.getPages());
		return map;
	}

	@Override
	public CarMaintain getMaintainInfoById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public MsgObj insertNewMaintainRecord(CarMaintain maintain) {
		// shiro获取用户信息
		Sysuser user = (Sysuser) SecurityUtils.getSubject().getPrincipal();
		// 根据用户信息得到司机信息
		DriverExample driverExample = new DriverExample();
		driverExample.createCriteria().andUserIdEqualTo(user.getId());
		List<Driver> list = driverMapper.selectByExample(driverExample);
		Driver driver = null;
		if (list.size() != 0) {
			driver = list.get(0);
		} else {
			return new MsgObj(0, "您的身份可能不是司机，不能进行此操作，若有疑问请与管理员联系！");
		}
		// 如果不为司机，则不可以报修
		Integer roleId = user.getRoleId();
		if (roleId != 1) {
			return new MsgObj(0, "对不起，您的身份不能报修车辆！");
		}
		// 根据用户id查找是否有符合条件的租赁记录
		DriverAndCarExample example = new DriverAndCarExample();
		top.tomxwd.tms.pojo.driver.DriverAndCarExample.Criteria criteria = example.createCriteria();
		criteria.andDriverIdEqualTo(driver.getId());
		ArrayList<Integer> arrlist = new ArrayList<>();
		//一定要使用中的车辆
		arrlist.add(1);
		criteria.andRentStateIn(arrlist);
		long i = driverAndCarMapper.countByExample(example);
		MsgObj msgObj = new MsgObj();
		if (i == 1) {
			// 查看车辆是否维修中
			DriverAndCarExample driverAndCarExample = new DriverAndCarExample();
			driverAndCarExample.createCriteria().andDriverIdEqualTo(driver.getId()).andRentStateEqualTo(1);
			List<DriverAndCar> driverAndCars = driverAndCarMapper.selectByExample(driverAndCarExample);
			DriverAndCar driverAndCar = null;
			if (driverAndCars.size() != 0) {
				driverAndCar = driverAndCars.get(0);
			} else {
				return new MsgObj(0, "获取车辆信息异常，请与管理员联系!");
			}
			// 获取车辆信息
			Car car = carMapper.selectByPrimaryKey(driverAndCar.getCarId());
			if (car.getCarState() == 2) {
				msgObj.setOk(0);
				msgObj.setMsg("您的车辆已报修，请不要重复报修，或请联系工作人员尽快处理！");
			} else {
				//实际业务位置
				maintain.setCarId(car.getId());
				maintain.setDriverId(driver.getId());
				maintain.setMaintaintime(new Date());
				int j = mapper.insertSelective(maintain);
				car.setCarState(2);
				int k = carMapper.updateByPrimaryKeySelective(car);
				if(j==1&&k==1) {
					msgObj.setOk(1);
					msgObj.setMsg("报修成功，请等待维修处理！");
				}else {
					msgObj.setOk(0);
					msgObj.setMsg("系统错误，报修失败！");
				}
			}
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("您还没有租车，请先进行租车操作！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateMaintainPayState(Integer id) {
		MsgObj msgObj = new MsgObj();
		CarMaintain maintain = new CarMaintain();
		maintain.setId(id);
		maintain.setPayState(1);
		int i = mapper.updateByPrimaryKeySelective(maintain);
		msgObj.setOk(i);
		if(i==1) {
			msgObj.setMsg("缴费成功！");
		}else {
			msgObj.setMsg("系统故障！缴费失败！");
		}
		return msgObj;
	}

}
