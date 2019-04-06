package top.tomxwd.tms.shiro;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

public class MyWebSessionManager extends DefaultWebSessionManager {
	
	/**
	 * https://blog.csdn.net/suruiliang/article/details/78824448
	 * 使用servlet的session
	 * 若使用shiro的session则默认返回false，支持企业级分布式用
	 */
	@Override
	public boolean isServletContainerSessions() {
		return false;
	}
	
}
