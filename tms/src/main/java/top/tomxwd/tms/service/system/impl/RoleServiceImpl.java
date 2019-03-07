package top.tomxwd.tms.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.mapper.system.RoleMapper;
import top.tomxwd.tms.pojo.system.Role;
import top.tomxwd.tms.pojo.system.RoleExample;
import top.tomxwd.tms.service.system.RoleService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper mapper;
	
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
	public PageObj<Role> powerList(PageObj<Role> pageObj) {
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
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==1) {
			msgObj.setMsg("添加角色成功！");
		}else {
			msgObj.setMsg("系统故障!添加角色失败！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateRole(Role role) {
		int i = mapper.updateByPrimaryKeySelective(role);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==1) {
			msgObj.setMsg("编辑角色成功！");
		}else {
			msgObj.setMsg("系统故障!编辑角色失败！");
		}
		return msgObj;
	}

	@Override
	public MsgObj deleteRoleById(Integer id) {
		int i = mapper.deleteByPrimaryKey(id);
		MsgObj msgObj = new MsgObj();
		msgObj.setOk(i);
		if(i==1) {
			msgObj.setMsg("删除角色成功！");
		}else {
			msgObj.setMsg("系统故障！删除角色失败！");
		}
		return msgObj;
	}

}
