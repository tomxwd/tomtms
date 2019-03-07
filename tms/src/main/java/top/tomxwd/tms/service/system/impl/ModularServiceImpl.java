package top.tomxwd.tms.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.mapper.system.ModularMapper;
import top.tomxwd.tms.pojo.system.Modular;
import top.tomxwd.tms.pojo.system.ModularExample;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.system.ModularService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;
import top.tomxwd.tms.vo.QueryObj;

@Service
public class ModularServiceImpl implements ModularService {

	@Autowired
	private ModularMapper mapper;

	@Override
	public Boolean findModularExistByName(String modularName) {
		ModularExample example = new ModularExample();
		example.createCriteria().andModularNameEqualTo(modularName);
		long count = mapper.countByExample(example);
		Boolean flag = false;
		if (count == 0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public PageObj<Modular> modularList(PageObj<Modular> pageObj) {
		// pageHelper初始化
		PageHelper.startPage(pageObj.getPage(), pageObj.getRows());
		// 记录
		ModularExample example = new ModularExample();
		if (!"".equals(pageObj.getKeyword()) && !pageObj.getKeyword().isEmpty()) {
			example.createCriteria().andModularNameLike("%"+pageObj.getKeyword()+"%");
		}
		List<Modular> list = mapper.selectByExample(example);
		// 塞入pageObj
		pageObj.setRoot(list);
		// 获得结果信息
		PageInfo<Modular> pageInfo = new PageInfo<>(list);
		// 总条数
		pageObj.setRecords((int) pageInfo.getTotal());
		// 总页数
		pageObj.setTotal(pageInfo.getPages());
		return pageObj;
	}

	@Override
	public MsgObj insertModular(Modular modular) {
		int i = mapper.insertSelective(modular);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if (i == 1) {
			msgObj.setMsg("添加模块成功！");
		} else {
			msgObj.setMsg("系统故障！添加模块失败！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateModular(Modular modular) {
		int i = mapper.updateByPrimaryKeySelective(modular);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==1) {
			msgObj.setMsg("编辑模块成功！");
		}else {
			msgObj.setMsg("系统故障！编辑模块失败！");
		}
		return msgObj;
	}

	@Override
	public MsgObj deleteModularById(Integer id) {
		int i = mapper.deleteByPrimaryKey(id);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==1) {
			msgObj.setMsg("删除模块成功！");
		}else {
			msgObj.setMsg("系统故障！删除模块失败！");
		}
		return msgObj;
	}

	@Override
	public Map<String, Object> getAllModular() {
		Map<String,Object> map = new HashMap<>();
		ModularExample example = new ModularExample();
		List<Modular> list = mapper.selectByExample(example);
		map.put("value", list);
		return map;
	}

}
