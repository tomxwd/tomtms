package top.tomxwd.tms.service.driver.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.mapper.driver.DriverAndCarMapper;
import top.tomxwd.tms.mapper.driver.IllegalRecordMapper;
import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarExample;
import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample;
import top.tomxwd.tms.pojo.driver.IllegalRecord;
import top.tomxwd.tms.pojo.driver.IllegalRecordExample;
import top.tomxwd.tms.pojo.driver.IllegalRecordExample.Criteria;
import top.tomxwd.tms.service.driver.IllegalRecordService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.driver.IllegalRecordPageObj;

@Service
public class IllegalRecordServiceImpl implements IllegalRecordService {

	@Autowired
	private IllegalRecordMapper mapper;
	@Autowired
	private DriverAndCarMapper driverAndCarMapper;

	@Override
	public IllegalRecordPageObj<IllegalRecord> illegalList(IllegalRecordPageObj<IllegalRecord> pageObj) {
		PageHelper.startPage(pageObj.getPage(), pageObj.getRows());
		IllegalRecordExample example = new IllegalRecordExample();
		Criteria criteria = example.createCriteria();
		if (!"".equals(pageObj.getKeyword()) && !pageObj.getKeyword().isEmpty()) {
			criteria.andIllegalResonLike("%" + pageObj.getKeyword() + "%");
		}
		if(pageObj.getStartDate()!=null&&pageObj.getEndDate()!=null) {
			criteria.andRecordDateBetween(pageObj.getStartDate(), pageObj.getEndDate());
		}
		List<IllegalRecord> list = mapper.selectByExample(example);
		pageObj.setRoot(list);
		PageInfo<IllegalRecord> pageInfo = new PageInfo<>(list);
		pageObj.setRecords((int) pageInfo.getTotal());
		pageObj.setTotal(pageInfo.getPages());
		return pageObj;
	}

	@Override
	public Map<String, Object> illegalListMap(Map<String, Object> pageObj){
		PageHelper.startPage(Integer.parseInt(pageObj.get("page").toString()),Integer.parseInt(pageObj.get("rows").toString()));
		String keyword = "";
		String startDate = "";
		String endDate = "";
		if(pageObj.containsKey("keyword")) {
			keyword = pageObj.get("keyword").toString();
		}
		if(pageObj.containsKey("startDate")&&pageObj.containsKey("endDate")) {
			startDate = pageObj.get("startDate").toString();
			endDate = pageObj.get("endDate").toString();
		}
		//List<IllegalRecord> list = mapper.selectByExample(example);
		Map<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		List<Map<String,Object>> list = mapper.selectByKeywordOrStartDateAndEndDate(map);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
		pageObj.put("root", list);
		pageObj.put("records", pageInfo.getTotal());
		pageObj.put("total", pageInfo.getPages());
		return pageObj;
	}

	@Override
	public MsgObj updatePayStateById(Integer id) {
		IllegalRecord record = new IllegalRecord();
		record.setId(id);
		record.setPayState(1);
		record.setPayDate(new Date());
		int i = mapper.updateByPrimaryKeySelective(record);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i>0) {
			msgObj.setMsg("缴费成功！");
		}else {
			msgObj.setMsg("缴费失败！请稍后再试！");
		}
		return msgObj;
	}

	@Override
	public MsgObj deleteIllegalRecordById(Integer id) {
		int i = mapper.deleteByPrimaryKey(id);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i>0) {
			msgObj.setMsg("删除成功！");
		}else {
			msgObj.setMsg("删除失败！请稍后再试！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateIllegalInfoByRecord(IllegalRecord record) {
		int i = mapper.updateByPrimaryKeySelective(record);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i>0) {
			msgObj.setMsg("编辑成功！");
		}else {
			msgObj.setMsg("编辑失败！请稍后再试！");
		}
		return msgObj;
	}

	@Override
	public MsgObj insertNewIllegalRecord(IllegalRecord record) {
		DriverAndCarExample driverAndCarExample = new DriverAndCarExample();
		top.tomxwd.tms.pojo.driver.DriverAndCarExample.Criteria criteria = driverAndCarExample.createCriteria();
		criteria.andDriverIdEqualTo(record.getDriverId());
		criteria.andRentStateEqualTo(1);
		List<DriverAndCar> Driver = driverAndCarMapper.selectByExample(driverAndCarExample);
		if(Driver.size()!=0) {
			record.setCarId(Driver.get(0).getCarId());
		}else {
			return new MsgObj(0, "司机信息异常，请联系管理员解决");
		}
		int i = mapper.insertSelective(record);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i>0) {
			msgObj.setMsg("添加新记录成功！");
		}else {
			msgObj.setMsg("添加失败！请稍后再试！");
		}
		return msgObj;
	}
	
	
	
}
