package top.tomxwd.tms.service.system.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Array;

import top.tomxwd.tms.mapper.system.ModularMapper;
import top.tomxwd.tms.mapper.system.PowerMapper;
import top.tomxwd.tms.pojo.system.Modular;
import top.tomxwd.tms.pojo.system.ModularExample;
import top.tomxwd.tms.pojo.system.Power;
import top.tomxwd.tms.pojo.system.PowerExample;
import top.tomxwd.tms.service.system.PowerService;
import top.tomxwd.tms.vo.MsgObj;

@Service
public class PowerServiceImpl implements PowerService {
	
	@Autowired
	private PowerMapper mapper;
	@Autowired
	private ModularMapper modularMapper;
	
	@Override
	public Boolean findPowerExistByName(String powerName) {
		PowerExample example = new PowerExample();
		example.createCriteria().andPowerNameEqualTo(powerName);
		long count = mapper.countByExample(example);
		if(count==0) {
			return true;
		}
		return false;
	}
	
	@Override
	public Boolean findPowerExistOrSameByName(String powerName, String powerNameCheck) {
		Boolean b = false;
		if(powerName.equals(powerNameCheck)) {
			b = true;
		}else {
			b = findPowerExistByName(powerName);
		}
		return b;
	}
	
	@Override
	public Map<String, Object> powerList(Map<String, Object> map) {
		PageHelper.startPage(Integer.parseInt(map.get("page").toString()),Integer.parseInt(map.get("rows").toString()));
		String keyword = "";
		if(map.containsKey("keyword")) {
			keyword = map.get("keyword").toString();
		}
		List<Map<String,Object>> list = mapper.selectPowerListByKeyword(keyword);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
		map.put("root", list);
		map.put("records", pageInfo.getTotal());
		map.put("total", pageInfo.getPages());
		return map;
	}
	
	@Override
	public MsgObj insertPower(Power power) {
		int i = mapper.insertSelective(power);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==1) {
			msgObj.setMsg("添加权限成功！");
		}else {
			msgObj.setMsg("系统故障，添加权限失败！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updatePower(Power power) {
		int i = mapper.updateByPrimaryKeySelective(power);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==1) {
			msgObj.setMsg("编辑权限成功！");
		}else {
			msgObj.setMsg("系统故障，编辑权限失败！");
		}
		return msgObj;
	}

	@Override
	public MsgObj deletePower(Integer id) {
		int i = mapper.deleteByPrimaryKey(id);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==1) {
			msgObj.setMsg("删除权限成功！");
		}else {
			msgObj.setMsg("系统故障，删除权限失败！");
		}
		return msgObj;
	}

	@Override
	public List<Map<String, Object>> selectAllPowerAndModularName() {
		List<Map<String,Object>> list= new ArrayList<>();
		//找所有模块
		List<Modular> modularList = modularMapper.selectByExample(new ModularExample());
		List<Power> powerList;
		PowerExample example;
		Map<String,Object> map;
		for (Modular modular : modularList) {
			//找到模块对应权限
			example = new PowerExample();
			example.createCriteria().andModularIdEqualTo(modular.getId());
			powerList = mapper.selectByExample(example);
			map = new HashMap<>();
			map.put("modular", modular);
			map.put("powers",powerList);
			list.add(map);
		}
		return list;
	}

	@Override
	public List<Integer> selectRoleOwnPowers(Integer roleId) {
		return mapper.selectPowersByRoleId(roleId);
	}

	@Override
	public List<Power> selectUserPowersByUserId(Integer userId) {
		return mapper.selectUserPowersByUserId(userId);
	}

	



	

}
