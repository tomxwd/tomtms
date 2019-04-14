package top.tomxwd.tms.shiro;

import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import top.tomxwd.tms.mapper.driver.DriverAndCarMapper;
import top.tomxwd.tms.mapper.driver.DriverMapper;
import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample;
import top.tomxwd.tms.pojo.driver.DriverExample;
import top.tomxwd.tms.pojo.system.Power;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.driver.DriverInfoService;
import top.tomxwd.tms.service.system.PowerService;
import top.tomxwd.tms.service.system.SysuserService;

public class UserRealm extends MyAuthorizingRealm {

	@Autowired
	private SysuserService service;
	@Autowired
	private PowerService powerService;
	@Autowired
	private DriverMapper driverMapper;
	@Autowired
	private DriverAndCarMapper driverAndCarMapper;

	@Override
	public String getName() {
		return "UserRealm";
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("----------------认证-------------------");
		String username = token.getPrincipal().toString();
		Sysuser user = service.findSysuserInfoByUserName(username);
		if(user!=null) {
			if(user.getRoleId()==1) {
				DriverExample driverExample = new DriverExample();
				driverExample.createCriteria().andUserIdEqualTo(user.getId());
				List<Driver> drivers = driverMapper.selectByExample(driverExample);
				Driver driver = null;
				if(drivers.size()!=0) {
					driver =drivers.get(0);
				}else {
					throw new DriverDontFindException();
				}
				if(driver.getAcountState()==0) {
					throw new NoExamException();
				}else if(driver.getAcountState()==2) {
					throw new DontPassExamException();
				}
			}
			if(user.getDelstatus()==0) {
				throw new DmissAccountException();
			}
		}else {
			throw new UnknownAccountException();
		}
		return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("----------------授权-------------------");
		Sysuser user = (Sysuser) principals.getPrimaryPrincipal();
		if (user == null) {
			return null;
		}
		List<Power> list = powerService.selectUserPowersByUserId(user.getId());
		if(list.size()==0||list==null) {
			return null;
		}
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for (Power power : list) {
			info.addStringPermission(power.getPrecode());
		}
		return info;
	}
	
	//清理缓存
	public void clearCache(PrincipalCollection principals) {
		Subject subject = SecurityUtils.getSubject();
		super.clearCache(subject.getPrincipals());
	}
	
}
