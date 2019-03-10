package top.tomxwd.tms.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import top.tomxwd.tms.service.system.SysuserService;

public class SysUserFiter extends PathMatchingFilter  {
	@Autowired
    private SysuserService service;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        //request.setAttribute(Constants.CURRENT_USER, service.findByUsername(username));
        return true;
    }
}
