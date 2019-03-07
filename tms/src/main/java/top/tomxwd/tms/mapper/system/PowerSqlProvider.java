package top.tomxwd.tms.mapper.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import top.tomxwd.tms.pojo.system.Power;
import top.tomxwd.tms.pojo.system.PowerExample;
import top.tomxwd.tms.pojo.system.PowerExample.Criteria;
import top.tomxwd.tms.pojo.system.PowerExample.Criterion;

public class PowerSqlProvider {

    public String countByExample(PowerExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_power");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(PowerExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_power");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Power record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_power");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getPowerName() != null) {
            sql.VALUES("power_name", "#{powerName,jdbcType=VARCHAR}");
        }
        
        if (record.getPowerAction() != null) {
            sql.VALUES("power_action", "#{powerAction,jdbcType=VARCHAR}");
        }
        
        if (record.getPowerDisplay() != null) {
            sql.VALUES("power_display", "#{powerDisplay,jdbcType=INTEGER}");
        }
        
        if (record.getModularId() != null) {
            sql.VALUES("modular_id", "#{modularId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PowerExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("power_name");
        sql.SELECT("power_action");
        sql.SELECT("power_display");
        sql.SELECT("modular_id");
        sql.FROM("t_power");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Power record = (Power) parameter.get("record");
        PowerExample example = (PowerExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_power");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getPowerName() != null) {
            sql.SET("power_name = #{record.powerName,jdbcType=VARCHAR}");
        }
        
        if (record.getPowerAction() != null) {
            sql.SET("power_action = #{record.powerAction,jdbcType=VARCHAR}");
        }
        
        if (record.getPowerDisplay() != null) {
            sql.SET("power_display = #{record.powerDisplay,jdbcType=INTEGER}");
        }
        
        if (record.getModularId() != null) {
            sql.SET("modular_id = #{record.modularId,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_power");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("power_name = #{record.powerName,jdbcType=VARCHAR}");
        sql.SET("power_action = #{record.powerAction,jdbcType=VARCHAR}");
        sql.SET("power_display = #{record.powerDisplay,jdbcType=INTEGER}");
        sql.SET("modular_id = #{record.modularId,jdbcType=INTEGER}");
        
        PowerExample example = (PowerExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Power record) {
        SQL sql = new SQL();
        sql.UPDATE("t_power");
        
        if (record.getPowerName() != null) {
            sql.SET("power_name = #{powerName,jdbcType=VARCHAR}");
        }
        
        if (record.getPowerAction() != null) {
            sql.SET("power_action = #{powerAction,jdbcType=VARCHAR}");
        }
        
        if (record.getPowerDisplay() != null) {
            sql.SET("power_display = #{powerDisplay,jdbcType=INTEGER}");
        }
        
        if (record.getModularId() != null) {
            sql.SET("modular_id = #{modularId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PowerExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
    
    public String selectPowerListByKeyword(String keyword) {
    	//select t1.id,power_name,power_action,power_display,modular_name from t_power t1 join t_modular t2 on t1.modular_id=t2.id 
    	String sql = "select t1.id id,t1.modular_id modularId,power_name powerName,power_action powerAction,power_display powerDisplay,modular_name modularName from t_power t1 join t_modular t2 on t1.modular_id=t2.id ";
		if(!keyword.isEmpty()||!("".equals(keyword))) {
			sql += " where power_name like '%' #{keyword} '%' ";
		}
    	return sql;
    }
    
}