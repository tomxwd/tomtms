/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-03-18 14:27:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.tms;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\"\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\">\n");
      out.write("\n");
      out.write("<title>出租车管理系统-登录</title>\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/font-awesome.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/animate.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/style.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/css/login.css\" rel=\"stylesheet\">\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery.min.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/bootstrap.min.js?v=3.3.6\"></script>\n");
      out.write("\t<!-- layer javascript -->\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/plugins/layer/layer.min.js\"></script>\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("<meta http-equiv=\"refresh\" content=\"0;ie.html\" />\n");
      out.write("<![endif]-->\n");
      out.write("<script>\n");
      out.write("\tif (window.top !== window.self) {\n");
      out.write("\t\twindow.top.location = window.location;\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t//抖动js\n");
      out.write("\tjQuery.fn.shake = function (intShakes /*Amount of shakes*/, intDistance /*Shake distance*/, intDuration /*Time duration*/) {\n");
      out.write("\t\t      this.each(function () {\n");
      out.write("\t\t          var jqNode = $(this);\n");
      out.write("\t\t          jqNode.css({ position: 'relative' });\n");
      out.write("\t\t          for (var x = 1; x <= intShakes; x++) {\n");
      out.write("\t\t        \t  var a = intDuration/intShakes;\n");
      out.write("\t\t        \t  var b = intDuration/intShakes;\n");
      out.write("\t\t        \t  var c = intDuration/intShakes;\n");
      out.write("\t\t            jqNode.animate({left:(intDistance * -1)},(a/4))\n");
      out.write("\t\t              .animate({ left: intDistance }, (b/2))\n");
      out.write("\t\t              .animate({ left: 0 }, (c/4));\n");
      out.write("\t\t          }\n");
      out.write("\t\t     });\n");
      out.write("\t     return this;\n");
      out.write("\t };\n");
      out.write("\t\n");
      out.write("\tfunction changeInput(idName,msg){\n");
      out.write("\t\tvar idNameVal = $(\"#\"+idName).val();\n");
      out.write("\t\tif(!idNameVal){\n");
      out.write("\t\t\t$(\"#\"+idName).attr(\"placeholder\",msg);\n");
      out.write("\t\t\t$(\"#\"+idName).shake(2,10,400);\n");
      out.write("\t\t\t$(\"#\"+idName).css(\"border\",\"1px solid red\");\n");
      out.write("\t\t}else{\n");
      out.write("\t\t\t$(\"#\"+idName).css(\"border\",\"\")\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t$(function(){\n");
      out.write("\t\tvar myMsg = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\n");
      out.write("\t\tif(myMsg.ok==0){\n");
      out.write("\t\t\tlayer.alert(\"<span style='color:black'>\"+myMsg.msg+\"</span>\", {\n");
      out.write("\t\t\t\ttitle:'温馨提示',\n");
      out.write("\t\t\t\tskin: 'layui-layer-lan', //样式类名\n");
      out.write("\t\t\t\toffset : \"auto\",\n");
      out.write("\t\t\t\tshift:4\n");
      out.write("\t\t\t\t},function(index){\n");
      out.write("\t\t\t\t\tlayer.close(index);\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t//为验证码图片以及”看不清“文字绑定事件\n");
      out.write("\t\t/* $(\"#verify_img,#verId2\").click(function(){\n");
      out.write("\t\t\t$(\"#verify_img\").attr(\"src\",\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/validate/image.jsp?time=\"+new Date().getTime());\n");
      out.write("\t\t}); */\n");
      out.write("\t\t//点击登录按钮进行登录操作\n");
      out.write("\t\t$(\"#submit_btn\").click(function(){\n");
      out.write("\t\t\tvar uname = $(\"#uname\").val();\n");
      out.write("\t\t\tvar pwd = $(\"#pwd\").val();\n");
      out.write("\t\t\t//var verify = $(\"#verify_code\").val();\n");
      out.write("\t\t\tif(!uname.length){\n");
      out.write("\t\t\t\t$(\"#uname\").attr(\"placeholder\",\"账号不能为空！\");\n");
      out.write("\t\t\t\t$(\"#uname\").shake(2,10,400);\n");
      out.write("\t\t\t\t$(\"#uname\").css(\"border\",\"1px solid red\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tif(!pwd.length){\n");
      out.write("\t\t\t\t$(\"#pwd\").attr(\"placeholder\",\"密码不能为空！\");\n");
      out.write("\t\t\t\t$(\"#pwd\").shake(2,10,400);\n");
      out.write("\t\t\t\t$(\"#pwd\").css(\"border\",\"1px solid red\");\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t/* if(!verify.length){\n");
      out.write("\t\t\t\t$(\"#verify_code\").attr(\"placeholder\",\"验证码不能为空！\");\n");
      out.write("\t\t\t\t$(\"#verify_code\").shake(2,10,400);\n");
      out.write("\t\t\t\t$(\"#verify_code\").css(\"border\",\"1px solid red\");\n");
      out.write("\t\t\t} */\n");
      out.write("\t\t\tif(uname.length&&pwd.length){\n");
      out.write("\t\t\t\t/* $.post(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/sysuser/login\",{username:uname,password:pwd,verify:verify},function(data){\n");
      out.write("\t\t\t\t\tif(data.ok==0){\n");
      out.write("\t\t\t\t\t\t//$(\"#submit_btn\").before(\"<span style='color:red;font-size:20px'>\"+data.msg+\"</span>\")\n");
      out.write("\t\t\t\t\t\t//$(\"#errorMsg\").text(data.msg);\n");
      out.write("\t\t\t\t\t\t$(\"#submit_btn\").html(\"<span style='color:red;font-weight:bold;font-size:16px'>\"+data.msg+\"</span>\");\n");
      out.write("\t\t\t\t\t\t$(\"#submit_btn\").shake(2,10,400);\n");
      out.write("\t\t\t\t\t\tsetTimeout(function(){\n");
      out.write("\t\t\t\t\t\t\t$(\"#submit_btn\").text(\"登录\");\n");
      out.write("\t\t\t\t\t\t},3000)\n");
      out.write("\t\t\t\t\t}else if(data.ok==1){\n");
      out.write("\t\t\t\t\t\twindow.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/toIndex\"\n");
      out.write("\t\t\t\t\t}else{\n");
      out.write("\t\t\t\t\t\talert(\"网络错误，请稍后再试\");\n");
      out.write("\t\t\t\t\t} \n");
      out.write("\t\t\t\t}); */\n");
      out.write("\t\t\t\t$(\"#loginForm\").submit();\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("<body class=\"signin\">\n");
      out.write("\t<div class=\"signinpanel\">\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col-sm-7\">\n");
      out.write("\t\t\t\t<div class=\"signin-info\">\n");
      out.write("\t\t\t\t\t<div class=\"logopanel m-b\">\n");
      out.write("\t\t\t\t\t\t<!-- <h1>欢迎使用</h1> -->\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"m-b\"></div>\n");
      out.write("\t\t\t\t\t<h4>\n");
      out.write("\t\t\t\t\t\t<!-- tomxwd <strong>出租车管理系统</strong> -->\n");
      out.write("\t\t\t\t\t</h4>\n");
      out.write("\t\t\t\t\t<!-- <strong>还没有账号？ <a href=\"#\">立即注册&raquo;</a></strong> -->\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"col-sm-5\">\n");
      out.write("\t\t\t\t<form id=\"loginForm\" method=\"post\">\n");
      out.write("\t\t\t\t\t<h4 style=\"font-size:20px\" class=\"no-margins\">登录：</h4>\n");
      out.write("\t\t\t\t\t<p class=\"m-t-md\">登录到tomxwd的出租车管理系统</p>\n");
      out.write("\t\t\t\t\t<div class=\"form-group has-error\">\n");
      out.write("\t\t\t\t\t\t<!-- <label class=\"control-label\" for=\"inputError1\" id=\"inputErrorid\">欢迎使用本系统！</label> -->\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<input id=\"uname\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" onblur=\"changeInput('uname','账号不能为空！')\" type=\"text\" class=\"form-control uname\" placeholder=\"用户名\" />\n");
      out.write("\t\t\t\t\t<input id=\"pwd\" name=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${password}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" onblur=\"changeInput('pwd','密码不能为空！')\" type=\"password\" class=\"form-control pword m-b\"\n");
      out.write("\t\t\t\t\t\tplaceholder=\"密码\" />\n");
      out.write("\t\t\t\t\t<p style=\"text-align:right;\">\n");
      out.write("\t\t\t\t\t\t<input style=\"zoom:120%\" type=\"checkbox\" name=\"rememberMe\" id=\"rememberMe\" ><span style=\"color:white;font-weight:bold;\">记住我</span>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<!-- <input style=\"color: black;width: 100px\" type=\"text\"\n");
      out.write("\t\t\t\t\t\t\tname=\"verifycode\" maxlength=\"4\" class=\"form-control  code\t\"\n");
      out.write("\t\t\t\t\t\t\twidth=\"50%\" placeholder=\"验证码\" />  -->\n");
      out.write("\t\t\t\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<!-- <p style=\"text-align:right;\"><a style=\"color: white\" id=\"verId2\">看不清？点击可更换</a></p> -->\n");
      out.write("\t\t\t\t\t<button id=\"submit_btn\" type=\"button\" class=\"btn btn-success btn-block\">登录</button>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t\t\t<p style=\"text-align:right;\">\n");
      out.write("\t\t\t\t\t\t<button id=\"regBtn\" class=\"btn btn-warning .dim btn-outline\" style=\"color:white;font-weight:bold;\">司机注册</button>\n");
      out.write("\t\t\t\t\t</p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"signup-footer\">\n");
      out.write("\t\t\t<div class=\"pull-left\">&copy; 2019 tomxwd的出租车管理系统</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t//为添加用户按钮绑定事件\n");
      out.write("\t$(\"#regBtn\").click(function(){\n");
      out.write("\t\tlayer.open({\n");
      out.write("\t\t\t  type: 2, \n");
      out.write("\t\t\t  title:\"司机注册\",\n");
      out.write("\t\t\t  content: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/driver/toAddDriver\", //这里content是一个普通的String\n");
      out.write("\t\t\t  area: ['800px', '700px'],\n");
      out.write("\t\t\t});\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/tms/login.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/tms/login.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/tms/login.jsp(4,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
