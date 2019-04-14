package top.tomxwd.tms.service.system.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import top.tomxwd.tms.utils.CookieUtils;
import top.tomxwd.tms.utils.UpLoadUtils;
import top.tomxwd.tms.mapper.driver.DriverMapper;
import top.tomxwd.tms.mapper.system.SysuserMapper;
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.driver.DriverExample;
import top.tomxwd.tms.pojo.driver.DriverExample.Criteria;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.pojo.system.SysuserExample;
import top.tomxwd.tms.service.system.SysuserService;
import top.tomxwd.tms.vo.MsgObj;
import top.tomxwd.tms.vo.PageObj;
import top.tomxwd.tms.vo.QueryObj;

@Service
public class SysuserServiceImpl implements SysuserService {

	@Autowired
	private SysuserMapper sysuserMapper;
	@Autowired
	private DriverMapper driverMapper;

	@Autowired
	private UpLoadUtils upload;

	@Override
	public MsgObj findSysuserByInfo(Sysuser user, String verify, HttpServletRequest req, HttpServletResponse resp) {
		// 得到session中的验证码
		String rand = req.getSession().getAttribute("rand").toString();
		MsgObj msgObj = new MsgObj(0, "用户名或密码错误");
		if (rand != null && rand.toUpperCase().equals(verify.toUpperCase())) {
			SysuserExample example = new SysuserExample();
			example.createCriteria().andUsernameEqualTo(user.getUsername());
			List<Sysuser> list = sysuserMapper.selectByExample(example);
			if (!list.isEmpty()) {
				Sysuser sysUser = list.get(0);
				if (sysUser == null) {
					return msgObj;
				} else {
					String pwd = sysUser.getPassword();
					if (user.getPassword().equals(pwd)) {
						msgObj.setOk(1);
						msgObj.setMsg("登录成功");
						sysUser.setPassword("");// 需要将用户密码设为空再放入到cookie中去
						String sysuser_Json = JSON.toJSONString(sysUser);
						CookieUtils.setCookie(req, resp, "current_user", sysuser_Json, 259200, true);// 保存3天
						return msgObj;
					}
				}
			} else {
				return msgObj;
			}
		} else {
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
		if (list.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public MsgObj insertSysuser(Sysuser user, MultipartFile headImg) {
		// System.getProperty("user.dir")+"/src/main/webapp/"
//		String savePath = System.getProperty("user.dir")+"/src/main/webapp/tmsresource/headImg/";
		// String headImgName = UpLoadUtils.UpLoadFile(savePath, headImg);
		String headImgName = upload.UpLoadUserHeadImg(headImg);
		user.setImg(headImgName);
		// 生成盐（部分，需要存入数据库中）
		String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
		user.setSalt(salt);
		// 将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
		String result = new Md5Hash(user.getPassword(), salt, 2).toString();
		user.setPassword(result);
		user.setDelstatus(1);
		int i = sysuserMapper.insertSelective(user);
		MsgObj msgObj = new MsgObj();
		if (i == 1) {
			msgObj.setOk(1);
			msgObj.setMsg("添加成功！");
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障，添加失败!");
		}
		return msgObj;
	}

	@Override
	public Map<String, Object> sysuserList(Map<String, Object> map) {
		// public PageObj<Sysuser> sysuserList(PageObj<Sysuser> pageObj) {
		// 初始化
		// queryObj.init(pageObj.getPage(),pageObj.getRows());
		// System.out.println(queryObj);
		// pageHelper初始化

		// PageHelper.startPage(pageObj.getPage(),pageObj.getRows());

		PageHelper.startPage(Integer.parseInt(map.get("page").toString()),
				Integer.parseInt(map.get("rows").toString()));
		String keyword = "";
		if (map.containsKey("keyword")) {
			keyword = map.get("keyword").toString();
		}
		List<Map<String, Object>> list = sysuserMapper.sysuserList(keyword);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(list);
		map.put("root", list);
		map.put("records", pageInfo.getTotal());
		map.put("total", pageInfo.getPages());
		return map;

		// 记录

		// List<Sysuser> list = sysuserMapper.sysuserList(pageObj.getKeyword());

//		SysuserExample example = new SysuserExample();
//		List<Sysuser> list = sysuserMapper.selectByExample(example);

		// pageObj.setRoot(list);

		// 总条数
//		pageObj.setRecords(list.size());

		// PageInfo<Sysuser> pageInfo = new PageInfo<>(list);
		// pageObj.setTotal(pageInfo.getPages());
		// pageObj.setRecords((int)pageInfo.getTotal());

		// 计算总页数
//		pageObj.calcTotal();

		// return pageObj;
	}

	@Override
	public MsgObj deleteSysuser(Integer id) {
		int i = sysuserMapper.deleteByPrimaryKey(id);
		MsgObj msgObj = new MsgObj();
		if (i != 0) {
			msgObj.setOk(1);
			msgObj.setMsg("删除成功！");
		} else {
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
		if (delstatus == 1) {
			// 执行离职 1-->0
			user.setDelstatus(0);
		} else {
			// 执行复职 0-->1
			user.setDelstatus(1);
		}
		int i = sysuserMapper.updateByPrimaryKeySelective(user);
		if (i == 1 && delstatus == 1) {
			msg.setOk(1);
			msg.setMsg("离职成功！");
		} else if (i == 1 && delstatus == 0) {
			msg.setOk(1);
			msg.setMsg("复职成功！");
		} else {
			msg.setOk(0);
			msg.setMsg("系统故障，请稍后再试！");
		}
		return msg;
	}

	@Override
	public MsgObj updateSysuser(Sysuser user) {
		int i = sysuserMapper.updateByPrimaryKeySelective(user);
		MsgObj msgObj = new MsgObj();
		if (i == 1) {
			msgObj.setOk(1);
			msgObj.setMsg("编辑成功！");
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障，编辑失败！");
		}
		return msgObj;
	}

	@Override
	public Sysuser findSysuserInfoByUserName(String username) {
		Sysuser user = null;
		SysuserExample example = new SysuserExample();
		top.tomxwd.tms.pojo.system.SysuserExample.Criteria userCriteria = example.createCriteria();
		userCriteria.andUsernameEqualTo(username);
		List<Sysuser> list = sysuserMapper.selectByExample(example);
		if (list.size() != 0) {
			user = list.get(0);
			if (user.getRoleId() == 1) {
				DriverExample driverExample = new DriverExample();
				Criteria criteria = driverExample.createCriteria();
				criteria.andAcountStateEqualTo(1);
				criteria.andUserIdEqualTo(user.getId());
				long i = driverMapper.countByExample(driverExample);
				if (i == 0) {
					user.setDelstatus(0);
					return user;
				}
			}
		}
		
		return user;
	}

	public static void main(String[] args) {
		// 生成盐（部分，需要存入数据库中）
		String random = new SecureRandomNumberGenerator().nextBytes().toHex();
		// 将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
		System.out.println(random);
		String result = new Md5Hash("admin", "tomxwd", 2).toString();
		System.out.println(result);
	}

	@Override
	public Integer insertNewDriverUser(Sysuser user, MultipartFile file) {
		String headImgName = upload.UpLoadUserHeadImg(file);
		user.setImg(headImgName);
		// 生成盐（部分，需要存入数据库中）
		String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
		user.setSalt(salt);
		// 将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
		String result = new Md5Hash(user.getPassword(), salt, 2).toString();
		user.setPassword(result);
		int i = sysuserMapper.insertSelective(user);
		if(i==0) {
			return 0;
		}else {
			return user.getId();
		}
	}

	@Override
	public MsgObj updateSysuserHeadImg(MultipartFile headImg) {
		String headImgName = upload.UpLoadUserHeadImg(headImg);
		Sysuser user = (Sysuser) SecurityUtils.getSubject().getPrincipal();
		Sysuser currentUser = sysuserMapper.selectByPrimaryKey(user.getId());
		currentUser.setImg(headImgName);
		int i = sysuserMapper.updateByPrimaryKeySelective(currentUser);
		MsgObj msgObj = new MsgObj();
		if (i == 1) {
			msgObj.setOk(1);
			msgObj.setMsg("修改头像成功！");
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障，修改失败!");
		}
		return msgObj;
	}

	@Override
	public MsgObj updateSysuserPassword(String password) {
		Sysuser user = (Sysuser) SecurityUtils.getSubject().getPrincipal();
		Sysuser currentUser = sysuserMapper.selectByPrimaryKey(user.getId());
		// 生成盐（部分，需要存入数据库中）
		String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
		currentUser.setSalt(salt);
		// 将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
		String result = new Md5Hash(password, salt, 2).toString();
		currentUser.setPassword(result);
		int i = sysuserMapper.updateByPrimaryKey(currentUser);
		MsgObj msgObj = new MsgObj();
		if (i == 1) {
			msgObj.setOk(1);
			msgObj.setMsg("修改密码成功！");
		} else {
			msgObj.setOk(0);
			msgObj.setMsg("系统故障，修改失败!");
		}
		return msgObj;
	}

}
