package top.tomxwd.tms.mapper.driver;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import top.tomxwd.tms.pojo.driver.DriverAndCar;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample.Criteria;
import top.tomxwd.tms.pojo.driver.DriverAndCarExample.Criterion;

public class DriverAndCarSqlProvider {

    public String countByExample(DriverAndCarExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_driver_car");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(DriverAndCarExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_driver_car");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(DriverAndCar record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_driver_car");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCarId() != null) {
            sql.VALUES("car_id", "#{carId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverId() != null) {
            sql.VALUES("driver_id", "#{driverId,jdbcType=INTEGER}");
        }
        
        if (record.getRentTime() != null) {
            sql.VALUES("rent_time", "#{rentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRentState() != null) {
            sql.VALUES("rent_state", "#{rentState,jdbcType=INTEGER}");
        }
        
        if (record.getRefuseReson() != null) {
            sql.VALUES("refuse_reson", "#{refuseReson,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(DriverAndCarExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("car_id");
        sql.SELECT("driver_id");
        sql.SELECT("rent_time");
        sql.SELECT("rent_state");
        sql.SELECT("refuse_reson");
        sql.FROM("t_driver_car");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        DriverAndCar record = (DriverAndCar) parameter.get("record");
        DriverAndCarExample example = (DriverAndCarExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_driver_car");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCarId() != null) {
            sql.SET("car_id = #{record.carId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverId() != null) {
            sql.SET("driver_id = #{record.driverId,jdbcType=INTEGER}");
        }
        
        if (record.getRentTime() != null) {
            sql.SET("rent_time = #{record.rentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRentState() != null) {
            sql.SET("rent_state = #{record.rentState,jdbcType=INTEGER}");
        }
        
        if (record.getRefuseReson() != null) {
            sql.SET("refuse_reson = #{record.refuseReson,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_driver_car");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("car_id = #{record.carId,jdbcType=INTEGER}");
        sql.SET("driver_id = #{record.driverId,jdbcType=INTEGER}");
        sql.SET("rent_time = #{record.rentTime,jdbcType=TIMESTAMP}");
        sql.SET("rent_state = #{record.rentState,jdbcType=INTEGER}");
        sql.SET("refuse_reson = #{record.refuseReson,jdbcType=VARCHAR}");
        
        DriverAndCarExample example = (DriverAndCarExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(DriverAndCar record) {
        SQL sql = new SQL();
        sql.UPDATE("t_driver_car");
        
        if (record.getCarId() != null) {
            sql.SET("car_id = #{carId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverId() != null) {
            sql.SET("driver_id = #{driverId,jdbcType=INTEGER}");
        }
        
        if (record.getRentTime() != null) {
            sql.SET("rent_time = #{rentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRentState() != null) {
            sql.SET("rent_state = #{rentState,jdbcType=INTEGER}");
        }
        
        if (record.getRefuseReson() != null) {
            sql.SET("refuse_reson = #{refuseReson,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, DriverAndCarExample example, boolean includeExamplePhrase) {
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
}