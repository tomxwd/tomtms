package top.tomxwd.tms.service.system.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.tomxwd.tms.mapper.system.CompanySituationMapper;
import top.tomxwd.tms.mapper.system.TaximeterMapper;
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.pojo.system.Taximeter;
import top.tomxwd.tms.service.driver.DriverInfoService;
import top.tomxwd.tms.service.system.CompanySituationService;
import top.tomxwd.tms.vo.MsgObj;

@Service
public class CompanySituationServiceImpl implements CompanySituationService {

	@Autowired
	private DriverInfoService driverInfoService;
	
	@Autowired
	private TaximeterMapper taximeterMapper;
		
	@Autowired
	private CompanySituationMapper mapper;

	@Override
	public List<Map<String, Object>> selectChartDriverEducation() {
		return mapper.selectChartDriverEducation();
	}

	@Override
	public List<Map<String, Object>> selectChartDriverPolitics() {
		return mapper.selectChartDriverPolitics();
	}

	@Override
	public Map<String, Object> selectChartDriverIllegal() {
		Map<String, Object> map = new HashMap<>();
		// 找数据
		List<Map<String, Object>> illegalList = mapper.selectChartDriverIllegal();
		// 横坐标
		List<Object> nameList = new ArrayList<>();
		// 违章数值
		List<Object> valueList = new ArrayList<>();
		for (Map<String, Object> illegal : illegalList) {
			nameList.add(illegal.get("name"));
			valueList.add(illegal.get("value"));
		}
		// 返回map
		map.put("name", nameList);
		map.put("value", valueList);
		return map;
	}

	@Override
	public Map<String, Object> selectchartDriverMaintain() {
		Map<String, Object> map = new HashMap<>();
		// 找数据
		List<Map<String, Object>> illegalList = mapper.selectChartDriverMaintain();
		// 横坐标
		List<Object> nameList = new ArrayList<>();
		// 违章数值
		List<Object> valueList = new ArrayList<>();
		for (Map<String, Object> illegal : illegalList) {
			nameList.add(illegal.get("name"));
			valueList.add(illegal.get("value"));
		}
		// 返回map
		map.put("name", nameList);
		map.put("value", valueList);
		return map;
	}

	@Override
	public MsgObj insertNewTaximeter(Taximeter taximeter) {
		taximeter.setDate(new Date());
		int i = taximeterMapper.insertSelective(taximeter);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==1) {
			msgObj.setMsg("添加成功！");
		}else {
			msgObj.setMsg("系统故障！添加失败！");
		}
		return msgObj;
	}

	@Override
	public Map<String, Object> selectchartDriverTaximeter() {
		Map<String, Object> map = new HashMap<>();
		// 找数据
		List<Map<String, Object>> illegalList = mapper.selectChartDriverTaximeter();
		// 横坐标
		List<Object> nameList = new ArrayList<>();
		// 违章数值
		List<Object> valueList = new ArrayList<>();
		for (Map<String, Object> illegal : illegalList) {
			nameList.add(illegal.get("name"));
			valueList.add(illegal.get("value"));
		}
		// 返回map
		map.put("name", nameList);
		map.put("value", valueList);
		return map;
	}

	@Override
	public Map<String, Object> selectChartDriverPersonalTaximeter() {
		Driver driver = driverInfoService.getCurrentDriver();
		if(driver==null) {
			return null;
		}
		Map<String, Object> map = new HashMap<>();
		// 找数据
		List<Map<String, Object>> illegalList = mapper.selectChartDriverPersonalTaximeter(driver.getId());
		// 横坐标
		List<Object> nameList = new ArrayList<>();
		// 违章数值
		List<Object> valueList = new ArrayList<>();
		for (Map<String, Object> illegal : illegalList) {
			nameList.add(illegal.get("name"));
			valueList.add(illegal.get("value"));
		}
		// 返回map
		map.put("name", nameList);
		map.put("value", valueList);
		return map;
	}

}
