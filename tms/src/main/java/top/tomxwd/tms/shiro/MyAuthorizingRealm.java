package top.tomxwd.tms.shiro;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * <shiro:hasPermission name="showcase:tree:create or showcase:tree:update or showcase:tree:delete">
 * @author xieweicong
 *
 */
public abstract class MyAuthorizingRealm extends AuthorizingRealm{
	private static final String OR_OPERATOR = " or ";  
	private static final String AND_OPERATOR = " and ";  
	private static final String NOT_OPERATOR = "not ";  
	/** 
	 * 支持or and not 关键词  不支持and or混用 
	 * @param principals 
	 * @param permission 
	 * @return 
	 */  
	public boolean isPermitted(PrincipalCollection principals, String permission) {  
	    if(permission.contains(OR_OPERATOR)) {  
	        String[] permissions = permission.split(OR_OPERATOR);  
	        for(String orPermission : permissions) {  
	            if(isPermittedWithNotOperator(principals, orPermission)) {  
	                return true;  
	            }  
	        }  
	        return false;  
	    } else if(permission.contains(AND_OPERATOR)) {  
	        String[] permissions = permission.split(AND_OPERATOR);  
	        for(String orPermission : permissions) {  
	            if(!isPermittedWithNotOperator(principals, orPermission)) {  
	                return false;  
	            }  
	        }  
	        return true;  
	    } else {  
	        return isPermittedWithNotOperator(principals, permission);  
	    }  
	}  
	  
	private boolean isPermittedWithNotOperator(PrincipalCollection principals, String permission) {  
	    if(permission.startsWith(NOT_OPERATOR)) {  
	        return !super.isPermitted(principals, permission.substring(NOT_OPERATOR.length()));  
	    } else {  
	        return super.isPermitted(principals, permission);  
	    }  
	}

}
