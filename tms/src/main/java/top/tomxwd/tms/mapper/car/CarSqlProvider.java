package top.tomxwd.tms.mapper.car;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import top.tomxwd.tms.pojo.car.Car;
import top.tomxwd.tms.pojo.car.CarExample;
import top.tomxwd.tms.pojo.car.CarExample.Criteria;
import top.tomxwd.tms.pojo.car.CarExample.Criterion;

public class CarSqlProvider {

    public String countByExample(CarExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_car");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CarExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_car");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Car record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_car");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getFuelSubsidy() != null) {
            sql.VALUES("fuel_subsidy", "#{fuelSubsidy,jdbcType=DOUBLE}");
        }
        
        if (record.getContractCost() != null) {
            sql.VALUES("contract_cost", "#{contractCost,jdbcType=DOUBLE}");
        }
        
        if (record.getCarNumber() != null) {
            sql.VALUES("car_number", "#{carNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getSpeedChanger() != null) {
            sql.VALUES("speed_changer", "#{speedChanger,jdbcType=INTEGER}");
        }
        
        if (record.getBrand() != null) {
            sql.VALUES("brand", "#{brand,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.VALUES("model", "#{model,jdbcType=VARCHAR}");
        }
        
        if (record.getCarState() != null) {
            sql.VALUES("car_state", "#{carState,jdbcType=INTEGER}");
        }
        
        if (record.getBuyDate() != null) {
            sql.VALUES("buy_date", "#{buyDate,jdbcType=DATE}");
        }
        
        if (record.getEngineNumber() != null) {
            sql.VALUES("engine_number", "#{engineNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCarPrice() != null) {
            sql.VALUES("car_price", "#{carPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getVinNum() != null) {
            sql.VALUES("vin_num", "#{vinNum,jdbcType=VARCHAR}");
        }
        
        if (record.getCarImg() != null) {
            sql.VALUES("car_img", "#{carImg,jdbcType=VARCHAR}");
        }
        
        if (record.getCarDeletestate() != null) {
            sql.VALUES("car_deleteState", "#{carDeletestate,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CarExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("fuel_subsidy");
        sql.SELECT("contract_cost");
        sql.SELECT("car_number");
        sql.SELECT("speed_changer");
        sql.SELECT("brand");
        sql.SELECT("model");
        sql.SELECT("car_state");
        sql.SELECT("buy_date");
        sql.SELECT("engine_number");
        sql.SELECT("car_price");
        sql.SELECT("vin_num");
        sql.SELECT("car_img");
        sql.SELECT("car_deleteState");
        sql.FROM("t_car");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Car record = (Car) parameter.get("record");
        CarExample example = (CarExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_car");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getFuelSubsidy() != null) {
            sql.SET("fuel_subsidy = #{record.fuelSubsidy,jdbcType=DOUBLE}");
        }
        
        if (record.getContractCost() != null) {
            sql.SET("contract_cost = #{record.contractCost,jdbcType=DOUBLE}");
        }
        
        if (record.getCarNumber() != null) {
            sql.SET("car_number = #{record.carNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getSpeedChanger() != null) {
            sql.SET("speed_changer = #{record.speedChanger,jdbcType=INTEGER}");
        }
        
        if (record.getBrand() != null) {
            sql.SET("brand = #{record.brand,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.SET("model = #{record.model,jdbcType=VARCHAR}");
        }
        
        if (record.getCarState() != null) {
            sql.SET("car_state = #{record.carState,jdbcType=INTEGER}");
        }
        
        if (record.getBuyDate() != null) {
            sql.SET("buy_date = #{record.buyDate,jdbcType=DATE}");
        }
        
        if (record.getEngineNumber() != null) {
            sql.SET("engine_number = #{record.engineNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCarPrice() != null) {
            sql.SET("car_price = #{record.carPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getVinNum() != null) {
            sql.SET("vin_num = #{record.vinNum,jdbcType=VARCHAR}");
        }
        
        if (record.getCarImg() != null) {
            sql.SET("car_img = #{record.carImg,jdbcType=VARCHAR}");
        }
        
        if (record.getCarDeletestate() != null) {
            sql.SET("car_deleteState = #{record.carDeletestate,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_car");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("fuel_subsidy = #{record.fuelSubsidy,jdbcType=DOUBLE}");
        sql.SET("contract_cost = #{record.contractCost,jdbcType=DOUBLE}");
        sql.SET("car_number = #{record.carNumber,jdbcType=VARCHAR}");
        sql.SET("speed_changer = #{record.speedChanger,jdbcType=INTEGER}");
        sql.SET("brand = #{record.brand,jdbcType=VARCHAR}");
        sql.SET("model = #{record.model,jdbcType=VARCHAR}");
        sql.SET("car_state = #{record.carState,jdbcType=INTEGER}");
        sql.SET("buy_date = #{record.buyDate,jdbcType=DATE}");
        sql.SET("engine_number = #{record.engineNumber,jdbcType=VARCHAR}");
        sql.SET("car_price = #{record.carPrice,jdbcType=DOUBLE}");
        sql.SET("vin_num = #{record.vinNum,jdbcType=VARCHAR}");
        sql.SET("car_img = #{record.carImg,jdbcType=VARCHAR}");
        sql.SET("car_deleteState = #{record.carDeletestate,jdbcType=INTEGER}");
        
        CarExample example = (CarExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Car record) {
        SQL sql = new SQL();
        sql.UPDATE("t_car");
        
        if (record.getFuelSubsidy() != null) {
            sql.SET("fuel_subsidy = #{fuelSubsidy,jdbcType=DOUBLE}");
        }
        
        if (record.getContractCost() != null) {
            sql.SET("contract_cost = #{contractCost,jdbcType=DOUBLE}");
        }
        
        if (record.getCarNumber() != null) {
            sql.SET("car_number = #{carNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getSpeedChanger() != null) {
            sql.SET("speed_changer = #{speedChanger,jdbcType=INTEGER}");
        }
        
        if (record.getBrand() != null) {
            sql.SET("brand = #{brand,jdbcType=VARCHAR}");
        }
        
        if (record.getModel() != null) {
            sql.SET("model = #{model,jdbcType=VARCHAR}");
        }
        
        if (record.getCarState() != null) {
            sql.SET("car_state = #{carState,jdbcType=INTEGER}");
        }
        
        if (record.getBuyDate() != null) {
            sql.SET("buy_date = #{buyDate,jdbcType=DATE}");
        }
        
        if (record.getEngineNumber() != null) {
            sql.SET("engine_number = #{engineNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getCarPrice() != null) {
            sql.SET("car_price = #{carPrice,jdbcType=DOUBLE}");
        }
        
        if (record.getVinNum() != null) {
            sql.SET("vin_num = #{vinNum,jdbcType=VARCHAR}");
        }
        
        if (record.getCarImg() != null) {
            sql.SET("car_img = #{carImg,jdbcType=VARCHAR}");
        }
        
        if (record.getCarDeletestate() != null) {
            sql.SET("car_deleteState = #{carDeletestate,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CarExample example, boolean includeExamplePhrase) {
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