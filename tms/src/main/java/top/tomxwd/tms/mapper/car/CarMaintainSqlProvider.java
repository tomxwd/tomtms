package top.tomxwd.tms.mapper.car;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import top.tomxwd.tms.pojo.car.CarMaintain;
import top.tomxwd.tms.pojo.car.CarMaintainExample;
import top.tomxwd.tms.pojo.car.CarMaintainExample.Criteria;
import top.tomxwd.tms.pojo.car.CarMaintainExample.Criterion;

public class CarMaintainSqlProvider {

    public String countByExample(CarMaintainExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_carmaintain");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CarMaintainExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_carmaintain");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CarMaintain record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_carmaintain");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getMaintaintime() != null) {
            sql.VALUES("maintainTime", "#{maintaintime,jdbcType=DATE}");
        }
        
        if (record.getCarId() != null) {
            sql.VALUES("car_id", "#{carId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverId() != null) {
            sql.VALUES("driver_id", "#{driverId,jdbcType=INTEGER}");
        }
        
        if (record.getMaintainCost() != null) {
            sql.VALUES("maintain_cost", "#{maintainCost,jdbcType=DOUBLE}");
        }
        
        if (record.getMaintainReson() != null) {
            sql.VALUES("maintain_reson", "#{maintainReson,jdbcType=VARCHAR}");
        }
        
        if (record.getMaintainDetail() != null) {
            sql.VALUES("maintain_detail", "#{maintainDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getFeedback() != null) {
            sql.VALUES("feedback", "#{feedback,jdbcType=VARCHAR}");
        }
        
        if (record.getInsuranceType() != null) {
            sql.VALUES("insurance_type", "#{insuranceType,jdbcType=INTEGER}");
        }
        
        if (record.getPayState() != null) {
            sql.VALUES("pay_state", "#{payState,jdbcType=INTEGER}");
        }
        
        if (record.getMaintainState() != null) {
            sql.VALUES("maintain_state", "#{maintainState,jdbcType=INTEGER}");
        }
        
        if (record.getCompleteDate() != null) {
            sql.VALUES("complete_date", "#{completeDate,jdbcType=DATE}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CarMaintainExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("maintainTime");
        sql.SELECT("car_id");
        sql.SELECT("driver_id");
        sql.SELECT("maintain_cost");
        sql.SELECT("maintain_reson");
        sql.SELECT("maintain_detail");
        sql.SELECT("feedback");
        sql.SELECT("insurance_type");
        sql.SELECT("pay_state");
        sql.SELECT("maintain_state");
        sql.SELECT("complete_date");
        sql.FROM("t_carmaintain");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CarMaintain record = (CarMaintain) parameter.get("record");
        CarMaintainExample example = (CarMaintainExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_carmaintain");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getMaintaintime() != null) {
            sql.SET("maintainTime = #{record.maintaintime,jdbcType=DATE}");
        }
        
        if (record.getCarId() != null) {
            sql.SET("car_id = #{record.carId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverId() != null) {
            sql.SET("driver_id = #{record.driverId,jdbcType=INTEGER}");
        }
        
        if (record.getMaintainCost() != null) {
            sql.SET("maintain_cost = #{record.maintainCost,jdbcType=DOUBLE}");
        }
        
        if (record.getMaintainReson() != null) {
            sql.SET("maintain_reson = #{record.maintainReson,jdbcType=VARCHAR}");
        }
        
        if (record.getMaintainDetail() != null) {
            sql.SET("maintain_detail = #{record.maintainDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getFeedback() != null) {
            sql.SET("feedback = #{record.feedback,jdbcType=VARCHAR}");
        }
        
        if (record.getInsuranceType() != null) {
            sql.SET("insurance_type = #{record.insuranceType,jdbcType=INTEGER}");
        }
        
        if (record.getPayState() != null) {
            sql.SET("pay_state = #{record.payState,jdbcType=INTEGER}");
        }
        
        if (record.getMaintainState() != null) {
            sql.SET("maintain_state = #{record.maintainState,jdbcType=INTEGER}");
        }
        
        if (record.getCompleteDate() != null) {
            sql.SET("complete_date = #{record.completeDate,jdbcType=DATE}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_carmaintain");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("maintainTime = #{record.maintaintime,jdbcType=DATE}");
        sql.SET("car_id = #{record.carId,jdbcType=INTEGER}");
        sql.SET("driver_id = #{record.driverId,jdbcType=INTEGER}");
        sql.SET("maintain_cost = #{record.maintainCost,jdbcType=DOUBLE}");
        sql.SET("maintain_reson = #{record.maintainReson,jdbcType=VARCHAR}");
        sql.SET("maintain_detail = #{record.maintainDetail,jdbcType=VARCHAR}");
        sql.SET("feedback = #{record.feedback,jdbcType=VARCHAR}");
        sql.SET("insurance_type = #{record.insuranceType,jdbcType=INTEGER}");
        sql.SET("pay_state = #{record.payState,jdbcType=INTEGER}");
        sql.SET("maintain_state = #{record.maintainState,jdbcType=INTEGER}");
        sql.SET("complete_date = #{record.completeDate,jdbcType=DATE}");
        
        CarMaintainExample example = (CarMaintainExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CarMaintain record) {
        SQL sql = new SQL();
        sql.UPDATE("t_carmaintain");
        
        if (record.getMaintaintime() != null) {
            sql.SET("maintainTime = #{maintaintime,jdbcType=DATE}");
        }
        
        if (record.getCarId() != null) {
            sql.SET("car_id = #{carId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverId() != null) {
            sql.SET("driver_id = #{driverId,jdbcType=INTEGER}");
        }
        
        if (record.getMaintainCost() != null) {
            sql.SET("maintain_cost = #{maintainCost,jdbcType=DOUBLE}");
        }
        
        if (record.getMaintainReson() != null) {
            sql.SET("maintain_reson = #{maintainReson,jdbcType=VARCHAR}");
        }
        
        if (record.getMaintainDetail() != null) {
            sql.SET("maintain_detail = #{maintainDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getFeedback() != null) {
            sql.SET("feedback = #{feedback,jdbcType=VARCHAR}");
        }
        
        if (record.getInsuranceType() != null) {
            sql.SET("insurance_type = #{insuranceType,jdbcType=INTEGER}");
        }
        
        if (record.getPayState() != null) {
            sql.SET("pay_state = #{payState,jdbcType=INTEGER}");
        }
        
        if (record.getMaintainState() != null) {
            sql.SET("maintain_state = #{maintainState,jdbcType=INTEGER}");
        }
        
        if (record.getCompleteDate() != null) {
            sql.SET("complete_date = #{completeDate,jdbcType=DATE}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CarMaintainExample example, boolean includeExamplePhrase) {
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
    /**
     * 根据司机姓名可以查找维修记录
     * @param keyword
     * @return
     */
    public String selectCarMaintainListByKeyword(String keyword) {
    	String sql = "select t1.id,t1.driverId,t1.carId,t1.driverName,t1.completeDate,t1.insuranceType,t1.payState,t1.maintainTime,t1.maintainReson,t1.maintainState,t1.driver_address driverAddress,t2.phone,t2.email " + 
    			"from (select t1.id,t1.driver_id driverId,t1.car_id carId,t1.complete_date completeDate,t1.insurance_type insuranceType,t1.pay_state payState,t1.maintainTime maintainTime,t1.maintain_reson maintainReson,t1.maintain_state maintainState,t2.user_id,t2.driver_address,t2.driver_name driverName from t_carmaintain t1 join t_driver t2 on t1.driver_id = t2.id) t1 join t_sysuser t2 on t1.user_id = t2.id";
		if(!keyword.isEmpty()||!("".equals(keyword))) {
			sql += " where driverName like '%' #{keyword} '%' ";
		}
    	return sql;
    }
    
}