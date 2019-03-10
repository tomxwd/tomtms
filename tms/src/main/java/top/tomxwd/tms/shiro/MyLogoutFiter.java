package top.tomxwd.tms.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;

public class MyLogoutFiter extends LogoutFilter {
	@Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        String redirectUrl = getRedirectUrl(request, response, subject);
//        Session session = subject.getSession();
//        session.stop();
        try {
            subject.logout();
        } catch (Exception ise) {
            ise.printStackTrace();
        }
        issueRedirect(request, response, redirectUrl);
        return false;
    }

}
