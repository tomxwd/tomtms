package top.tomxwd.tms.service.car.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.mapper.car.CarMaintainMapper;
import top.tomxwd.tms.mapper.car.CarMapper;
import top.tomxwd.tms.mapper.driver.DriverAndCarMapper;
import top.tomxwd.tms.mapper.driver.DriverMapper;
import top.tomxwd.tms.mapper.driver.IllegalRecordMapper;
import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarExample;
import top.tomxwd.tms.pojo.car.CarMaintainExample;
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample.Criteria;
import top.tomxwd.tms.pojo.driver.DriverExample;
import top.tomxwd.tms.pojo.driver.IllegalRecordExample;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.car.CarService;
import top.tomxwd.tms.utils.UpLoadUtils;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarMapper mapper;
	@Autowired
	private UpLoadUtils upload;
	@Autowired
	private DriverMapper driverMapper;
	@Autowired
	private CarMaintainMapper maintainMapper;
	@Autowired
	private DriverAndCarMapper driverAndCarMapper;
	@Autowired
	private IllegalRecordMapper illegalMapper;

	@Override
	public MsgObj insertCar(Car car, MultipartFile carImgFile) {
		String img = upload.UpLoadCarImg(carImgFile);
		car.setCarImg(img);
		int i = mapper.insertSelective(car);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if (i == 0) {
			msgObj.setMsg("添加车辆失败！");
		} else {
			msgObj.setMsg("添加成功！");
		}
		return msgObj;
	}

	@Override
	public PageObj<Car> carList(PageObj<Car> pageObj) {
		PageHelper.startPage(pageObj.getPage(), pageObj.getRows());
		CarExample example = new CarExample();
		top.tomxwd.tms.pojo.car.CarExample.Criteria carCriteria = example.createCriteria();
		if (!"".equals(pageObj.getKeyword()) && !pageObj.getKeyword().isEmpty()) {
			carCriteria.andCarNumberLike("%" + pageObj.getKeyword() + "%");
		}
		example.setOrderByClause("car_state asc");
		List<Car> list = mapper.selectByExample(example);
		pageObj.setRoot(list);
		PageInfo<Car> pageInfo = new PageInfo<>(list);
		pageObj.setRecords((int) pageInfo.getTotal());
		pageObj.setTotal(pageInfo.getPages());
		return pageObj;
	}

	@Override
	public MsgObj deleteCar(Integer id) {
		// 删除车辆 假删除 状态改为0
		Car car = mapper.selectByPrimaryKey(id);
		car.setCarDeletestate(0);
		int i = mapper.updateByPrimaryKeySelective(car);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if (i == 1) {
			msgObj.setMsg("删除成功！");
		} else {
			msgObj.setMsg("删除失败，请稍后再试！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateCar(Car car, MultipartFile car_Img) {
		if (!StringUtils.isEmpty(car_Img.getOriginalFilename())) {
			String carImg = upload.UpLoadCarImg(car_Img);
			car.setCarImg(carImg);
		}
		int i = mapper.updateByPrimaryKeySelective(car);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if (i == 0) {
			msgObj.setMsg("修改车辆信息失败！请稍后再试！");
		} else {
			msgObj.setMsg("修改成功！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateDriverAndCarAndCarStatePass(Integer id, Integer carState, Integer rentState) {
		System.out.println(carState);
		System.out.println(rentState);
		// 审核通过
		// 1 更新车辆状态
		Car car = new Car();
		car.setId(id);
		car.setCarState(carState);
		int i = mapper.updateByPrimaryKeySelective(car);
		// 2 更改车辆租借状态
		DriverAndCarExample example = new DriverAndCarExample();
		Criteria criteria = example.createCriteria();
		criteria.andCarIdEqualTo(id);
		criteria.andRentStateEqualTo(0);
		List<DriverAndCar> list = driverAndCarMapper.selectByExample(example);
		DriverAndCar driverAndCar = list.get(0);
		driverAndCar.setRentState(rentState);
		if (rentState == 1) {
			driverAndCar.setRentTime(new Date());
		}
		int j = driverAndCarMapper.updateByPrimaryKeySelective(driverAndCar);
		MsgObj msgObj = new MsgObj();
		if (i != 0 && j != 0) {
			msgObj.setOk(1);
			msgObj.setMsg("审核成功！");
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("审核失败，请稍后再试！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateDriverAndCarAndCarStateRefuse(Integer id, Integer carState, String refuseReson,
			Integer rentState) {
		// 审核不通过
		// 1 更新车辆状态
		Car car = new Car();
		car.setId(id);
		car.setCarState(carState);
		int i = mapper.updateByPrimaryKeySelective(car);
		// 2 更改车辆租借状态
		DriverAndCarExample example = new DriverAndCarExample();
		Criteria criteria = example.createCriteria();
		criteria.andCarIdEqualTo(id);
		criteria.andRentStateEqualTo(0);
		example.setOrderByClause("rent_time desc");
		List<DriverAndCar> list = driverAndCarMapper.selectByExample(example);
		DriverAndCar driverAndCar = list.get(0);
		int j = 0;
		int k = 0;
		if (carState == 0) {
			// 若为0 租车拒绝 不产生新记录
			driverAndCar.setRentState(rentState);
			driverAndCar.setRefuseReson(refuseReson);
			j = driverAndCarMapper.updateByPrimaryKeySelective(driverAndCar);
		} else {
			// 退车拒绝，生成新的记录 旧记录改为使用中 新记录再插入拒绝理由
			driverAndCar.setRentState(1);
			// 旧记录修改
			k = driverAndCarMapper.updateByPrimaryKeySelective(driverAndCar);
			// 新记录拒绝理由
			driverAndCar.setRentState(rentState);
			driverAndCar.setRefuseReson(refuseReson);
			driverAndCar.setId(null);
			j = driverAndCarMapper.insertSelective(driverAndCar);
		}
		MsgObj msgObj = new MsgObj();
		if ((carState == 0 && i != 0 && j != 0) || (carState == 1 && i != 0 && j != 0 && k != 0)) {
			msgObj.setOk(1);
			msgObj.setMsg("审核成功！");
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("审核失败，请稍后再试！");
		}
		return msgObj;
	}

	@Override
	public Car getOneCarInfoById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public PageObj<Car> rentCarList(PageObj<Car> pageObj) {
		PageHelper.startPage(pageObj.getPage(), pageObj.getRows());
		CarExample example = new CarExample();
		top.tomxwd.tms.pojo.car.CarExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCarStateEqualTo(0);
		if (!"".equals(pageObj.getKeyword()) && !pageObj.getKeyword().isEmpty()) {
			createCriteria.andCarNumberLike("%" + pageObj.getKeyword() + "%");
		}
		List<Car> list = mapper.selectByExample(example);
		pageObj.setRoot(list);
		PageInfo<Car> pageInfo = new PageInfo<>(list);
		pageObj.setRecords((int) pageInfo.getTotal());
		pageObj.setTotal(pageInfo.getPages());
		return pageObj;
	}

	@Override
	public MsgObj checkDriverOwnCar() {
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
		// 如果不为司机，则不可以租车
		Integer roleId = user.getRoleId();
		if (roleId != 1) {
			return new MsgObj(0, "对不起，您的身份不能租车！");
		}
		// 根据司机id查找是否有符合条件的租赁记录
		DriverAndCarExample example = new DriverAndCarExample();
		Criteria criteria = example.createCriteria();
		criteria.andDriverIdEqualTo(driver.getId());
		ArrayList<Integer> arrlist = new ArrayList<>();
		arrlist.add(0);
		arrlist.add(1);
		criteria.andRentStateIn(arrlist);
		long i = driverAndCarMapper.countByExample(example);
		MsgObj msgObj = new MsgObj();
		if (i == 0) {
			msgObj.setOk(1);
			msgObj.setMsg("可以租车");
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("您已租车或车辆正在退车审核中，若有疑问请与管理员联系！");
		}
		return msgObj;
	}

	@Override
	public MsgObj insertRentCarRecord(Integer id) {
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
		// 获取当前车辆信息
		Car car = mapper.selectByPrimaryKey(id);
		// 更改车辆租赁信息
		car.setCarState(3);
		int i = mapper.updateByPrimaryKeySelective(car);
		// 插入一条租赁信息
		DriverAndCar driverAndCar = new DriverAndCar();
		driverAndCar.setCarId(car.getId());
		driverAndCar.setDriverId(driver.getId());
		driverAndCar.setRentState(0);
		int j = driverAndCarMapper.insertSelective(driverAndCar);
		MsgObj msgObj = new MsgObj();
		if (i != 0 && j != 0) {
			msgObj.setOk(1);
			msgObj.setMsg("租车成功，请等待审核！");
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障，租车失败！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateRentCarRecord() {
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
		// 得到租赁信息
		DriverAndCarExample example = new DriverAndCarExample();
		Criteria criteria = example.createCriteria();
		criteria.andDriverIdEqualTo(driver.getId());
		criteria.andRentStateEqualTo(1);
		List<DriverAndCar> driverAndCarList = driverAndCarMapper.selectByExample(example);
		DriverAndCar driverAndCar = null;
		if (driverAndCarList.size() != 0) {
			driverAndCar = driverAndCarList.get(0);
		} else {
			return new MsgObj(0, "租赁信息异常，请与管理员联系！");
		}
		driverAndCar.setRentState(0);
		// 得到车辆信息
		Car car = mapper.selectByPrimaryKey(driverAndCar.getCarId());
		car.setCarState(4);
		// 更新租赁信息以及车辆信息
		int i = driverAndCarMapper.updateByPrimaryKeySelective(driverAndCar);
		int j = mapper.updateByPrimaryKeySelective(car);
		MsgObj msgObj = new MsgObj();
		if (i != 0 && j != 0) {
			msgObj.setOk(1);
			msgObj.setMsg("提交退车审核成功！");
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("提交退车审核失败！请稍后再试！");
		}
		return msgObj;
	}

	@Override
	public MsgObj checkDriverOwnExam() {
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
		// 如果不为司机，则不可以退车
		Integer roleId = user.getRoleId();
		if (roleId != 1) {
			return new MsgObj(0, "对不起，您的身份不能退车！");
		}
		// 根据用户id查找是否有符合条件的租赁记录
		DriverAndCarExample example = new DriverAndCarExample();
		Criteria criteria = example.createCriteria();
		criteria.andDriverIdEqualTo(driver.getId());
		ArrayList<Integer> arrlist = new ArrayList<>();
		arrlist.add(0);
		criteria.andRentStateIn(arrlist);
		long i = driverAndCarMapper.countByExample(example);
		MsgObj msgObj = new MsgObj();
		if (i == 0) {
			// 查看车辆是否维修中
			DriverAndCarExample driverAndCarExample = new DriverAndCarExample();
			driverAndCarExample.createCriteria().andDriverIdEqualTo(driver.getId()).andRentStateEqualTo(1);
			List<DriverAndCar> driverAndCars = driverAndCarMapper.selectByExample(driverAndCarExample);
			DriverAndCar driverAndCar = null;
			if (driverAndCars.size() != 0) {
				driverAndCar = driverAndCars.get(0);
				System.out.println(driverAndCars);
			} else {
				return new MsgObj(0, "获取车辆信息异常，请与管理员联系!");
			}
			// 获取车辆信息
			Car car = mapper.selectByPrimaryKey(driverAndCar.getCarId());
			CarMaintainExample maintainExample = new CarMaintainExample();
			maintainExample.createCriteria().andCarIdEqualTo(car.getId()).andMaintainStateEqualTo(0);
			IllegalRecordExample illegalRecordExample = new IllegalRecordExample();
			illegalRecordExample.createCriteria().andCarIdEqualTo(car.getId()).andDriverIdEqualTo(driver.getId()).andPayStateEqualTo(0);
			long illegalPayCount = illegalMapper.countByExample(illegalRecordExample);
			long maintainCount = maintainMapper.countByExample(maintainExample);
			if (car.getCarState() == 2) {
				msgObj.setOk(0);
				msgObj.setMsg("车辆正在维修中，不可进行退车操作！");
			} else if(maintainCount != 0){
				msgObj.setOk(0);
				msgObj.setMsg("车辆维修后未进行缴费，请缴费后再进行退车操作！");
			} else if(illegalPayCount!=0){
				msgObj.setOk(0);
				msgObj.setMsg("车辆违章后未进行缴费，请缴费后再进行退车操作！");
			}else {
				msgObj.setOk(1);
				msgObj.setMsg("可以退车");
			}
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("您已提交审核，请不要重复退车，或请联系工作人员尽快处理！");
		}
		return msgObj;
	}

	@Override
	public MsgObj checkDriverOwnMaintain() {
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
		// 如果不为司机，则不可以维修
		Integer roleId = user.getRoleId();
		if (roleId != 1) {
			return new MsgObj(0, "对不起，您的身份不能报修！");
		}
		MsgObj msgObj = new MsgObj();
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
		Car car = mapper.selectByPrimaryKey(driverAndCar.getCarId());
		if (car.getCarState() == 2) {
			msgObj.setOk(0);
			msgObj.setMsg("车辆正在维修中，不可再进行报修操作！");
		} else {
			msgObj.setOk(1);
			msgObj.setMsg("可以报修车辆");
		}
		return msgObj;
	}

}
