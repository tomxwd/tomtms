package top.tomxwd.tms.mapper.driver;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import top.tomxwd.tms.pojo.driver.Driver;
import top.tomxwd.tms.pojo.driver.DriverExample;
import top.tomxwd.tms.pojo.driver.DriverExample.Criteria;
import top.tomxwd.tms.pojo.driver.DriverExample.Criterion;

public class DriverSqlProvider {

    public String countByExample(DriverExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_driver");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(DriverExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_driver");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Driver record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_driver");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverGender() != null) {
            sql.VALUES("driver_gender", "#{driverGender,jdbcType=INTEGER}");
        }
        
        if (record.getDriverEducation() != null) {
            sql.VALUES("driver_education", "#{driverEducation,jdbcType=INTEGER}");
        }
        
        if (record.getDriverAddress() != null) {
            sql.VALUES("driver_address", "#{driverAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getPoliticsStatus() != null) {
            sql.VALUES("politics_status", "#{politicsStatus,jdbcType=INTEGER}");
        }
        
        if (record.getIdentityNumber() != null) {
            sql.VALUES("identity_number", "#{identityNumber,jdbcType=CHAR}");
        }
        
        if (record.getTaximeterId() != null) {
            sql.VALUES("taximeter_id", "#{taximeterId,jdbcType=INTEGER}");
        }
        
        if (record.getHeadimg() != null) {
            sql.VALUES("headImg", "#{headimg,jdbcType=VARCHAR}");
        }
        
        if (record.getAcountState() != null) {
            sql.VALUES("acount_state", "#{acountState,jdbcType=INTEGER}");
        }
        
        if (record.getDriverName() != null) {
            sql.VALUES("driver_name", "#{driverName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(DriverExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("user_id");
        sql.SELECT("driver_gender");
        sql.SELECT("driver_education");
        sql.SELECT("driver_address");
        sql.SELECT("politics_status");
        sql.SELECT("identity_number");
        sql.SELECT("taximeter_id");
        sql.SELECT("headImg");
        sql.SELECT("acount_state");
        sql.SELECT("driver_name");
        sql.FROM("t_driver");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Driver record = (Driver) parameter.get("record");
        DriverExample example = (DriverExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_driver");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverGender() != null) {
            sql.SET("driver_gender = #{record.driverGender,jdbcType=INTEGER}");
        }
        
        if (record.getDriverEducation() != null) {
            sql.SET("driver_education = #{record.driverEducation,jdbcType=INTEGER}");
        }
        
        if (record.getDriverAddress() != null) {
            sql.SET("driver_address = #{record.driverAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getPoliticsStatus() != null) {
            sql.SET("politics_status = #{record.politicsStatus,jdbcType=INTEGER}");
        }
        
        if (record.getIdentityNumber() != null) {
            sql.SET("identity_number = #{record.identityNumber,jdbcType=CHAR}");
        }
        
        if (record.getTaximeterId() != null) {
            sql.SET("taximeter_id = #{record.taximeterId,jdbcType=INTEGER}");
        }
        
        if (record.getHeadimg() != null) {
            sql.SET("headImg = #{record.headimg,jdbcType=VARCHAR}");
        }
        
        if (record.getAcountState() != null) {
            sql.SET("acount_state = #{record.acountState,jdbcType=INTEGER}");
        }
        
        if (record.getDriverName() != null) {
            sql.SET("driver_name = #{record.driverName,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_driver");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("user_id = #{record.userId,jdbcType=INTEGER}");
        sql.SET("driver_gender = #{record.driverGender,jdbcType=INTEGER}");
        sql.SET("driver_education = #{record.driverEducation,jdbcType=INTEGER}");
        sql.SET("driver_address = #{record.driverAddress,jdbcType=VARCHAR}");
        sql.SET("politics_status = #{record.politicsStatus,jdbcType=INTEGER}");
        sql.SET("identity_number = #{record.identityNumber,jdbcType=CHAR}");
        sql.SET("taximeter_id = #{record.taximeterId,jdbcType=INTEGER}");
        sql.SET("headImg = #{record.headimg,jdbcType=VARCHAR}");
        sql.SET("acount_state = #{record.acountState,jdbcType=INTEGER}");
        sql.SET("driver_name = #{record.driverName,jdbcType=VARCHAR}");
        
        DriverExample example = (DriverExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Driver record) {
        SQL sql = new SQL();
        sql.UPDATE("t_driver");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getDriverGender() != null) {
            sql.SET("driver_gender = #{driverGender,jdbcType=INTEGER}");
        }
        
        if (record.getDriverEducation() != null) {
            sql.SET("driver_education = #{driverEducation,jdbcType=INTEGER}");
        }
        
        if (record.getDriverAddress() != null) {
            sql.SET("driver_address = #{driverAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getPoliticsStatus() != null) {
            sql.SET("politics_status = #{politicsStatus,jdbcType=INTEGER}");
        }
        
        if (record.getIdentityNumber() != null) {
            sql.SET("identity_number = #{identityNumber,jdbcType=CHAR}");
        }
        
        if (record.getTaximeterId() != null) {
            sql.SET("taximeter_id = #{taximeterId,jdbcType=INTEGER}");
        }
        
        if (record.getHeadimg() != null) {
            sql.SET("headImg = #{headimg,jdbcType=VARCHAR}");
        }
        
        if (record.getAcountState() != null) {
            sql.SET("acount_state = #{acountState,jdbcType=INTEGER}");
        }
        
        if (record.getDriverName() != null) {
            sql.SET("driver_name = #{driverName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, DriverExample example, boolean includeExamplePhrase) {
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
     * 根据车牌号可以查找车辆使用记录
     * @param keyword
     * @return
     */
    public String selectUseCarRecordListByKeyword(Map<String, String> params) {
    	String sql = "select t1.car_id carId,t1.rent_time rentTime,t1.rent_state rentState,t1.refuse_reson refuseReson,t2.car_number carNumber,t2.car_state carState,t2.car_deleteState deleteState from t_driver_car t1 join t_car t2 on t1.car_id = t2.id where t1.driver_id=#{id} ";
    	String keyword = params.get("keyword");
		if(!keyword.isEmpty()||!("".equals(keyword))) {
			sql += " and t2.car_number like '%' #{keyword} '%' ";
		}
		sql+="order by t1.id desc";
    	return sql;
    }
}