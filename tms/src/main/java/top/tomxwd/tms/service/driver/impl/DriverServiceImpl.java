package top.tomxwd.tms.service.driver.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.mapper.car.CarMaintainMapper;
import top.tomxwd.tms.mapper.car.CarMapper;
import top.tomxwd.tms.mapper.driver.DriverAndCarMapper;
import top.tomxwd.tms.mapper.driver.DriverMapper;
import top.tomxwd.tms.mapper.system.SysuserMapper;
import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.car.CarMaintainExample;
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample;
import top.tomxwd.tms.pojo.driver.DriverExample;
import top.tomxwd.tms.pojo.driver.DriverExample.Criteria;
import top.tomxwd.tms.pojo.system.Modular;
import top.tomxwd.tms.pojo.system.ModularExample;
import top.tomxwd.tms.pojo.system.Role;
import top.tomxwd.tms.pojo.system.RoleExample;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.driver.DriverService;
import top.tomxwd.tms.service.system.SysuserService;
import top.tomxwd.tms.utils.UpLoadUtils;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverMapper mapper;
	@Autowired
	private SysuserService userService;
	@Autowired
	private UpLoadUtils upload;
	@Autowired
	private SysuserMapper userMapper;
	@Autowired
	private DriverAndCarMapper driverAndCarMapper;
	@Autowired
	private CarMapper carMapper;
	@Autowired
	private CarMaintainMapper maintainMapper;

	@Override
	public PageObj<Driver> driverList(PageObj<Driver> pageObj) {
		PageHelper.startPage(pageObj.getPage(),pageObj.getRows());
		DriverExample example = new DriverExample();
		if (!"".equals(pageObj.getKeyword()) && !pageObj.getKeyword().isEmpty()) {
			example.createCriteria().andDriverNameLike("%"+pageObj.getKeyword()+"%");
		}
		example.setOrderByClause("acount_state asc");
		List<Driver> list = mapper.selectByExample(example);
		pageObj.setRoot(list);
		PageInfo<Driver> pageInfo = new PageInfo<>(list);
		pageObj.setRecords((int)pageInfo.getTotal());
		pageObj.setTotal(pageInfo.getPages());
		return pageObj;
	}

	@Override
	public MsgObj deleteDriver(Integer id) {
		//离职司机 使其账户不可用
		//1.找到司机信息
		Driver driver = mapper.selectByPrimaryKey(id);
		//2.找到其账户
		Sysuser sysuser = userMapper.selectByPrimaryKey(driver.getUserId());
		//3.将账号设为不可用
		sysuser.setDelstatus(0);
		//4.更新账户
		int i = userMapper.updateByPrimaryKeySelective(sysuser);
		
		//退车
		//1.找到车和司机的中间表记录
		DriverAndCar driverAndCar = null;
		DriverAndCarExample driverAndCarExample = new DriverAndCarExample();
		top.tomxwd.tms.pojo.driver.DriverAndCarExample.Criteria driverAndCarCriteria = driverAndCarExample.createCriteria();
		driverAndCarCriteria.andDriverIdEqualTo(id);
		//租借状态 0审核中 1使用中 2使用审核未通过 3退车审核未通过 4已作废
		driverAndCarCriteria.andRentStateBetween(0,1);
		List<DriverAndCar> driverAndCarList = driverAndCarMapper.selectByExample(driverAndCarExample);
		if(driverAndCarList.size()!=0) {
			driverAndCar = driverAndCarList.get(0);
		}
		if(driverAndCar!=null) {
			driverAndCar.setRentState(4);
			int k = driverAndCarMapper.updateByPrimaryKeySelective(driverAndCar);
			if(k==0) {
				return new MsgObj(0, "系统故障！删除失败！");
			}
			//2.找到车的记录并更改车辆状态
			Car car = carMapper.selectByPrimaryKey(driverAndCar.getCarId());
			//车辆状态，0未使用，1已使用，2维修中，3租车审核 4退车审核
			if(car.getCarState()==2) {
				//维修中要把维修记录修改
				CarMaintainExample carMaintainExample = new CarMaintainExample();
				top.tomxwd.tms.pojo.car.CarMaintainExample.Criteria maintainCriteria = carMaintainExample.createCriteria();
				maintainCriteria.andCarIdEqualTo(car.getId());
				maintainCriteria.andMaintainStateEqualTo(0);
				List<CarMaintain> maintainList = maintainMapper.selectByExample(carMaintainExample);
				if(maintainList.size()!=0) {
					CarMaintain carMaintain = maintainList.get(0);
					//维修状态 0维修中 1已完成维修
					carMaintain.setMaintainState(1);
					carMaintain.setFeedback("由于删除车主导致的修改维修记录，若未缴费请及时通知缴费！");
					int l = maintainMapper.updateByPrimaryKeySelective(carMaintain);
					if(l==0) {
						return new MsgObj(0, "系统故障！删除失败！");
					}
					
				}
			}
			car.setCarState(0);
			int l = carMapper.updateByPrimaryKeySelective(car);
			if(l==0) {
				return new MsgObj(0, "系统故障！删除失败！");
			}
		}
		
		//返回信息
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==0) {
			msgObj.setMsg("删除失败，请稍后再试！");
		}else {
			msgObj.setMsg("删除成功！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateDriver(Driver driver) {
		
		return null;
	}

	@Override
	public MsgObj updateExaminerDriverById(Driver driver) {
		int i = mapper.updateByPrimaryKeySelective(driver);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==0) {
			msgObj.setMsg("审核失败！请稍后再试！");
		}else {
			msgObj.setMsg("审核成功！");
		}
		return msgObj;
	}

	@Override
	public MsgObj insertDriver(Driver driver, Sysuser user, MultipartFile myheadImg) {
		user.setNickname(driver.getDriverName());
		user.setRegtime(new Date());
		user.setRoleId(1);
		Integer userId = userService.insertNewDriverUser(user, myheadImg);
		MsgObj msgObj = new MsgObj();
		if(userId==0) {
			msgObj.setOk(0);
			msgObj.setMsg("注册失败，请稍后再试！");
		}else {
			driver.setUserId(userId);
			String img = upload.UpLoadDriverHeadImg(myheadImg);
			driver.setHeadimg(img);
			int i = mapper.insertSelective(driver);
			msgObj.setOk(i);
			if(i==0) {
				msgObj.setMsg("注册失败，请稍后再试！");
			}else {
				msgObj.setMsg("注册成功！请等待审核！");
			}
		}
		return msgObj;
	}

	@Override
	public Map<String, Object> getDriverInfoByCarId(Integer id) {
		return mapper.getDriverInfoByCarId(id);
	}

	@Override
	public Map<String, Object> getAllDriver() {
		Map<String,Object> map = new HashMap<>();
		List<Driver> list = mapper.selectAllDriverAndHaveCar();
		map.put("value", list);
		return map;
	}

}
