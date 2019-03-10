package top.tomxwd.tms.service.system.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.utils.CookieUtils;
import top.tomxwd.tms.utils.UpLoadUtils;
import top.tomxwd.tms.mapper.system.SysuserMapper;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.pojo.system.SysuserExample;
import top.tomxwd.tms.service.system.SysuserService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;
import top.tomxwd.tms.vo.QueryObj;

@Service
public class SysuserServiceImpl implements SysuserService{
	
	@Autowired
	private SysuserMapper sysuserMapper;

	@Override
	public MsgObj findSysuserByInfo(Sysuser user, String verify, HttpServletRequest req, HttpServletResponse resp) {
		//得到session中的验证码
		String rand = req.getSession().getAttribute("rand").toString();
		MsgObj msgObj = new MsgObj(0, "用户名或密码错误");
		if(rand!=null&&rand.toUpperCase().equals(verify.toUpperCase())) {
			SysuserExample example = new SysuserExample();
			example.createCriteria().andUsernameEqualTo(user.getUsername());
			List<Sysuser> list = sysuserMapper.selectByExample(example);
			if(!list.isEmpty()) {
				Sysuser sysUser = list.get(0);
				if(sysUser==null) {
					return msgObj;
				}else {
					String pwd = sysUser.getPassword();
					if(user.getPassword().equals(pwd)) {
						msgObj.setOk(1);
						msgObj.setMsg("登录成功");
						sysUser.setPassword("");//需要将用户密码设为空再放入到cookie中去
						String sysuser_Json = JSON.toJSONString(sysUser);
						CookieUtils.setCookie(req, resp, "current_user", sysuser_Json, 259200, true);//保存3天
						return msgObj;
					}
				}
			}else {
				return msgObj;
			}
		}else {
			msgObj.setMsg("验证码错误，请重新输入");
			return msgObj;
		}
		return msgObj;
	}

	@Override
	public boolean findSysuserExistByUsername(String username) {
		SysuserExample example = new SysuserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<Sysuser> list = sysuserMapper.selectByExample(example);
		if(list.size()==0) {
			return true;
		}
		return false;
	}

	@Override
	public MsgObj insertSysuser(Sysuser user,MultipartFile headImg) {
		//System.getProperty("user.dir")+"/src/main/webapp/"
		String savePath = System.getProperty("user.dir")+"/src/main/webapp/tmsresource/headImg/";
		String headImgName = UpLoadUtils.UpLoadFile(savePath, headImg);
		user.setImg("/tmsresource/headImg/"+headImgName);
		int i = sysuserMapper.insertSelective(user);
		MsgObj msgObj = new MsgObj();
		if(i==1) {
			msgObj.setOk(1);
			msgObj.setMsg("添加成功！");
		}else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障，添加失败!");
		}
		return msgObj;
	}

	@Override
	public PageObj<Sysuser> sysuserList(PageObj<Sysuser> pageObj) {
		//初始化
		//queryObj.init(pageObj.getPage(),pageObj.getRows());
		//System.out.println(queryObj);
		//pageHelper初始化
		PageHelper.startPage(pageObj.getPage(),pageObj.getRows());
		//记录
		List<Sysuser> list = sysuserMapper.sysuserList(pageObj.getKeyword());
//		SysuserExample example = new SysuserExample();
//		List<Sysuser> list = sysuserMapper.selectByExample(example);
		pageObj.setRoot(list);
		//总条数
//		pageObj.setRecords(list.size());
		PageInfo<Sysuser> pageInfo = new PageInfo<>(list);
		pageObj.setTotal(pageInfo.getPages());
		pageObj.setRecords((int)pageInfo.getTotal());
		//计算总页数
//		pageObj.calcTotal();
		return pageObj;
	}

	@Override
	public MsgObj deleteSysuser(Integer id) {
		int i = sysuserMapper.deleteByPrimaryKey(id);
		MsgObj msgObj = new MsgObj();
		if(i!=0) {
			msgObj.setOk(1);
			msgObj.setMsg("删除成功！");
		}else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障，删除失败！");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateDelstatusById(Integer id, Integer delstatus) {
		MsgObj msg = new MsgObj();
		Sysuser user = new Sysuser();
		user.setId(id);
		if(delstatus==1) {
			//执行离职 1-->0
			user.setDelstatus(0);
		}else {
			//执行复职 0-->1
			user.setDelstatus(1);
		}
		int i = sysuserMapper.updateByPrimaryKeySelective(user);
		if(i==1&&delstatus==1) {
			msg.setOk(1);
			msg.setMsg("离职成功！");
		}else if(i==1&&delstatus==0) {
			msg.setOk(1);
			msg.setMsg("复职成功！");
		}else {
			msg.setOk(0);
			msg.setMsg("系统故障，请稍后再试！");
		}
		return msg;
	}

	@Override
	public MsgObj updateSysuser(Sysuser user) {
		int i = sysuserMapper.updateByPrimaryKeySelective(user);
		MsgObj msgObj = new MsgObj();
		if(i==1){
			msgObj.setOk(1);
			msgObj.setMsg("编辑成功！");
		}else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障，编辑失败！");
		}
		return msgObj;
	}

	@Override
	public Sysuser findSysuserInfoByUserName(String username) {
		Sysuser user = null;
		SysuserExample example = new SysuserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<Sysuser> list = sysuserMapper.selectByExample(example);
		if(list.size()!=0) {
			user = list.get(0);
		}
		return user;
	}

}
