package top.tomxwd.tms.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import top.tomxwd.tms.pojo.system.Power;
import top.tomxwd.tms.pojo.system.Sysuser;
import top.tomxwd.tms.service.system.PowerService;
import top.tomxwd.tms.service.system.SysuserService;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private SysuserService service;
	@Autowired
	private PowerService powerService;

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
		return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
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
		return null;
	}
}
