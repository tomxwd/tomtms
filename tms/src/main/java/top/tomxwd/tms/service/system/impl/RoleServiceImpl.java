package top.tomxwd.tms.service.system.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.mapper.system.RoleAndPowerMapper;
import top.tomxwd.tms.mapper.system.RoleMapper;
import top.tomxwd.tms.pojo.system.Role;
import top.tomxwd.tms.pojo.system.RoleAndPower;
import top.tomxwd.tms.pojo.system.RoleAndPowerExample;
import top.tomxwd.tms.pojo.system.RoleExample;
import top.tomxwd.tms.service.system.RoleService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper mapper;
	@Autowired
	private RoleAndPowerMapper roleAndPowerMapper;
	
	@Override
	public Boolean findRoleExistByName(String roleName) {
		RoleExample example = new RoleExample();
		example.createCriteria().andRoleNameEqualTo(roleName);
		long count = mapper.countByExample(example);
		Boolean flag = false;
		if(count==0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public Boolean findRoleExistOrSame(String roleName, String roleNameCheck) {
		Boolean b = false;
		if(roleName.equals(roleNameCheck)) {
			b = true;
		}else {
			b = findRoleExistByName(roleName);
		}
		return b;
	}
	
	@Override
	public PageObj<Role> roleList(PageObj<Role> pageObj) {
		//PageHelper初始化
		PageHelper.startPage(pageObj.getPage(), pageObj.getRows());
		RoleExample example = new RoleExample();
		if (!"".equals(pageObj.getKeyword()) && !pageObj.getKeyword().isEmpty()) {
			example.createCriteria().andRoleNameLike("%"+pageObj.getKeyword()+"%");
		}
		List<Role> list = mapper.selectByExample(example);
		pageObj.setRoot(list);
		PageInfo<Role> pageInfo = new PageInfo<>(list);
		pageObj.setRecords((int)pageInfo.getTotal());
		pageObj.setTotal(pageInfo.getPages());
		return pageObj;
	}

	@Override
	public MsgObj insertRole(Role role) {
		int i = mapper.insertSelective(role);
		int j = roleAndPowerMapper.insertAllRecords(role);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i!=0&&j!=0) {
			msgObj.setMsg("添加角色成功！");
		}else {
			msgObj.setMsg("系统故障!添加角色失败！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateRole(Role role) {
		int i = mapper.updateByPrimaryKeySelective(role);
		RoleAndPowerExample example = new RoleAndPowerExample();
		example.createCriteria().andRoleIdEqualTo(role.getId());
		int j = roleAndPowerMapper.deleteByExample(example);
		int k = roleAndPowerMapper.insertAllRecords(role);
		MsgObj msgObj = new MsgObj();
		if(i==1&&j!=0&&k!=0) {
			msgObj.setOk(1);
			msgObj.setMsg("编辑角色成功！");
		}else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障!编辑角色失败！");
		}
		return msgObj;
	}

	@Override
	public MsgObj deleteRoleById(Integer id) {
		int i = mapper.deleteByPrimaryKey(id);
		RoleAndPowerExample example = new RoleAndPowerExample();
		example.createCriteria().andRoleIdEqualTo(id);
		int j = roleAndPowerMapper.deleteByExample(example);
		MsgObj msgObj = new MsgObj();
		if(i==1&&j!=0) {
			msgObj.setOk(1);
			msgObj.setMsg("删除角色成功！");
		}else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障！删除角色失败！");
		}
		return msgObj;
	}

	@Override
	public Map<String, Object> getAllRole() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String,Object>> list = mapper.selectAllRole();
		map.put("value", list);
		return map;
	}


}
