package top.tomxwd.tms.mapper.driver;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import top.tomxwd.tms.pojo.driver.IllegalRecord;
import top.tomxwd.tms.pojo.driver.IllegalRecordExample;
import top.tomxwd.tms.pojo.driver.IllegalRecordExample.Criteria;
import top.tomxwd.tms.pojo.driver.IllegalRecordExample.Criterion;

public class IllegalRecordProvider {

    public String countByExample(IllegalRecordExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_illegalrecord");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(IllegalRecordExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_illegalrecord");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(IllegalRecord record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_illegalrecord");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCarId() != null) {
            sql.VALUES("car_id", "#{carId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverId() != null) {
            sql.VALUES("driver_id", "#{driverId,jdbcType=INTEGER}");
        }
        
        if (record.getRecordDate() != null) {
            sql.VALUES("record_date", "#{recordDate,jdbcType=DATE}");
        }
        
        if (record.getIllegalReson() != null) {
            sql.VALUES("illegal_reson", "#{illegalReson,jdbcType=VARCHAR}");
        }
        
        if (record.getIllegalCost() != null) {
            sql.VALUES("illegal_cost", "#{illegalCost,jdbcType=DOUBLE}");
        }
        
        if (record.getPayState() != null) {
            sql.VALUES("pay_state", "#{payState,jdbcType=INTEGER}");
        }
        
        if (record.getPayDate() != null) {
            sql.VALUES("pay_date", "#{payDate,jdbcType=DATE}");
        }
        
        return sql.toString();
    }

    public String selectByExample(IllegalRecordExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("car_id");
        sql.SELECT("driver_id");
        sql.SELECT("record_date");
        sql.SELECT("illegal_reson");
        sql.SELECT("illegal_cost");
        sql.SELECT("pay_state");
        sql.SELECT("pay_date");
        sql.FROM("t_illegalrecord");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        IllegalRecord record = (IllegalRecord) parameter.get("record");
        IllegalRecordExample example = (IllegalRecordExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_illegalrecord");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCarId() != null) {
            sql.SET("car_id = #{record.carId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverId() != null) {
            sql.SET("driver_id = #{record.driverId,jdbcType=INTEGER}");
        }
        
        if (record.getRecordDate() != null) {
            sql.SET("record_date = #{record.recordDate,jdbcType=DATE}");
        }
        
        if (record.getIllegalReson() != null) {
            sql.SET("illegal_reson = #{record.illegalReson,jdbcType=VARCHAR}");
        }
        
        if (record.getIllegalCost() != null) {
            sql.SET("illegal_cost = #{record.illegalCost,jdbcType=DOUBLE}");
        }
        
        if (record.getPayState() != null) {
            sql.SET("pay_state = #{record.payState,jdbcType=INTEGER}");
        }
        
        if (record.getPayDate() != null) {
            sql.SET("pay_date = #{record.payDate,jdbcType=DATE}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_illegalrecord");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("car_id = #{record.carId,jdbcType=INTEGER}");
        sql.SET("driver_id = #{record.driverId,jdbcType=INTEGER}");
        sql.SET("record_date = #{record.recordDate,jdbcType=DATE}");
        sql.SET("illegal_reson = #{record.illegalReson,jdbcType=VARCHAR}");
        sql.SET("illegal_cost = #{record.illegalCost,jdbcType=DOUBLE}");
        sql.SET("pay_state = #{record.payState,jdbcType=INTEGER}");
        sql.SET("pay_date = #{record.payDate,jdbcType=DATE}");
        
        IllegalRecordExample example = (IllegalRecordExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(IllegalRecord record) {
        SQL sql = new SQL();
        sql.UPDATE("t_illegalrecord");
        
        if (record.getCarId() != null) {
            sql.SET("car_id = #{carId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverId() != null) {
            sql.SET("driver_id = #{driverId,jdbcType=INTEGER}");
        }
        
        if (record.getRecordDate() != null) {
            sql.SET("record_date = #{recordDate,jdbcType=DATE}");
        }
        
        if (record.getIllegalReson() != null) {
            sql.SET("illegal_reson = #{illegalReson,jdbcType=VARCHAR}");
        }
        
        if (record.getIllegalCost() != null) {
            sql.SET("illegal_cost = #{illegalCost,jdbcType=DOUBLE}");
        }
        
        if (record.getPayState() != null) {
            sql.SET("pay_state = #{payState,jdbcType=INTEGER}");
        }
        
        if (record.getPayDate() != null) {
            sql.SET("pay_date = #{payDate,jdbcType=DATE}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, IllegalRecordExample example, boolean includeExamplePhrase) {
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
    
    
    
    public String selectByKeywordOrStartDateAndEndDate(Map<String, String> map){
    	String sql = "select t1.id id,t1.car_id carId,t1.driver_id driverId,t1.illegal_cost illegalCost,t1.illegal_reson illegalReson,t1.record_date recordDate,t1.pay_state payState,t1.pay_date payDate,t2.driver_name driverName from t_illegalrecord t1 join t_driver t2 on t1.driver_id = t2.id where 1=1 ";
    	String keyword = map.get("keyword");
    	String startDate = map.get("startDate");
    	String endDate = map.get("endDate");
		if(!keyword.isEmpty()||!("".equals(keyword))) {
			sql += " and t2.driver_name like '%' #{keyword} '%' ";
		}
		if((!startDate.isEmpty()||!("".equals(startDate))&&(!endDate.isEmpty()||!("".equals(endDate))))) {
			sql += " and t1.record_date between #{startDate} and #{endDate}";
		}
    	return sql;
    }
    
}