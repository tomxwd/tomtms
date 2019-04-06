package top.tomxwd.tms.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.alibaba.druid.util.StringUtils;

import top.tomxwd.tms.pojo.system.Sysuser;

public class MyFormFiter extends FormAuthenticationFilter {

	/**
	 * 因为发现设置的successUrl没生效，所以追踪源码发现如果SavedRequest对象不为null,则它会覆盖掉我们设置
	 * 的successUrl，所以我们要重写onLoginSuccess方法，在它覆盖掉我们设置的successUrl之前，去除掉
	 * SavedRequest对象,SavedRequest对象的获取方式为： savedRequest = (SavedRequest)
	 * session.getAttribute(SAVED_REQUEST_KEY); public static final String
	 * SAVED_REQUEST_KEY = "shiroSavedRequest"; 解决方案：从session对象中移出shiroSavedRequest
	 */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		if (!StringUtils.isEmpty(getSuccessUrl())) {
			// getSession(false)：如果当前session为null,则返回null,而不是创建一个新的session
			Session session = subject.getSession(false);
			if (session != null) {
				session.removeAttribute("shiroSavedRequest");
			}
		}
		return super.onLoginSuccess(token, subject, request, response);
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (isLoginRequest(request, response)) {
			if (isLoginSubmission(request, response)) {
				// 本次用户登陆账号
				String username = this.getUsername(request);
				Subject subject = this.getSubject(request, response);
				// 之前登陆的用户
				Sysuser user = (Sysuser) subject.getPrincipal();
				// 如果两次登陆的用户不一样，则先退出之前登陆的用户
				if (username != null && user != null && !username.equals(user.getUsername())) {
					subject.logout();
				} else {
					subject.logout();
				}
			}
		}

		return super.isAccessAllowed(request, response, mappedValue);
	}

}
