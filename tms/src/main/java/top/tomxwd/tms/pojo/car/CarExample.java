package top.tomxwd.tms.pojo.car;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyIsNull() {
            addCriterion("fuel_subsidy is null");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyIsNotNull() {
            addCriterion("fuel_subsidy is not null");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyEqualTo(Double value) {
            addCriterion("fuel_subsidy =", value, "fuelSubsidy");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyNotEqualTo(Double value) {
            addCriterion("fuel_subsidy <>", value, "fuelSubsidy");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyGreaterThan(Double value) {
            addCriterion("fuel_subsidy >", value, "fuelSubsidy");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyGreaterThanOrEqualTo(Double value) {
            addCriterion("fuel_subsidy >=", value, "fuelSubsidy");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyLessThan(Double value) {
            addCriterion("fuel_subsidy <", value, "fuelSubsidy");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyLessThanOrEqualTo(Double value) {
            addCriterion("fuel_subsidy <=", value, "fuelSubsidy");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyIn(List<Double> values) {
            addCriterion("fuel_subsidy in", values, "fuelSubsidy");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyNotIn(List<Double> values) {
            addCriterion("fuel_subsidy not in", values, "fuelSubsidy");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyBetween(Double value1, Double value2) {
            addCriterion("fuel_subsidy between", value1, value2, "fuelSubsidy");
            return (Criteria) this;
        }

        public Criteria andFuelSubsidyNotBetween(Double value1, Double value2) {
            addCriterion("fuel_subsidy not between", value1, value2, "fuelSubsidy");
            return (Criteria) this;
        }

        public Criteria andContractCostIsNull() {
            addCriterion("contract_cost is null");
            return (Criteria) this;
        }

        public Criteria andContractCostIsNotNull() {
            addCriterion("contract_cost is not null");
            return (Criteria) this;
        }

        public Criteria andContractCostEqualTo(Double value) {
            addCriterion("contract_cost =", value, "contractCost");
            return (Criteria) this;
        }

        public Criteria andContractCostNotEqualTo(Double value) {
            addCriterion("contract_cost <>", value, "contractCost");
            return (Criteria) this;
        }

        public Criteria andContractCostGreaterThan(Double value) {
            addCriterion("contract_cost >", value, "contractCost");
            return (Criteria) this;
        }

        public Criteria andContractCostGreaterThanOrEqualTo(Double value) {
            addCriterion("contract_cost >=", value, "contractCost");
            return (Criteria) this;
        }

        public Criteria andContractCostLessThan(Double value) {
            addCriterion("contract_cost <", value, "contractCost");
            return (Criteria) this;
        }

        public Criteria andContractCostLessThanOrEqualTo(Double value) {
            addCriterion("contract_cost <=", value, "contractCost");
            return (Criteria) this;
        }

        public Criteria andContractCostIn(List<Double> values) {
            addCriterion("contract_cost in", values, "contractCost");
            return (Criteria) this;
        }

        public Criteria andContractCostNotIn(List<Double> values) {
            addCriterion("contract_cost not in", values, "contractCost");
            return (Criteria) this;
        }

        public Criteria andContractCostBetween(Double value1, Double value2) {
            addCriterion("contract_cost between", value1, value2, "contractCost");
            return (Criteria) this;
        }

        public Criteria andContractCostNotBetween(Double value1, Double value2) {
            addCriterion("contract_cost not between", value1, value2, "contractCost");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNull() {
            addCriterion("car_number is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("car_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("car_number =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("car_number <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("car_number >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_number >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("car_number <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("car_number <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("car_number like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("car_number not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("car_number in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("car_number not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("car_number between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("car_number not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerIsNull() {
            addCriterion("speed_changer is null");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerIsNotNull() {
            addCriterion("speed_changer is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerEqualTo(Integer value) {
            addCriterion("speed_changer =", value, "speedChanger");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerNotEqualTo(Integer value) {
            addCriterion("speed_changer <>", value, "speedChanger");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerGreaterThan(Integer value) {
            addCriterion("speed_changer >", value, "speedChanger");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerGreaterThanOrEqualTo(Integer value) {
            addCriterion("speed_changer >=", value, "speedChanger");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerLessThan(Integer value) {
            addCriterion("speed_changer <", value, "speedChanger");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerLessThanOrEqualTo(Integer value) {
            addCriterion("speed_changer <=", value, "speedChanger");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerIn(List<Integer> values) {
            addCriterion("speed_changer in", values, "speedChanger");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerNotIn(List<Integer> values) {
            addCriterion("speed_changer not in", values, "speedChanger");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerBetween(Integer value1, Integer value2) {
            addCriterion("speed_changer between", value1, value2, "speedChanger");
            return (Criteria) this;
        }

        public Criteria andSpeedChangerNotBetween(Integer value1, Integer value2) {
            addCriterion("speed_changer not between", value1, value2, "speedChanger");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andCarStateIsNull() {
            addCriterion("car_state is null");
            return (Criteria) this;
        }

        public Criteria andCarStateIsNotNull() {
            addCriterion("car_state is not null");
            return (Criteria) this;
        }

        public Criteria andCarStateEqualTo(Integer value) {
            addCriterion("car_state =", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateNotEqualTo(Integer value) {
            addCriterion("car_state <>", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateGreaterThan(Integer value) {
            addCriterion("car_state >", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_state >=", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateLessThan(Integer value) {
            addCriterion("car_state <", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateLessThanOrEqualTo(Integer value) {
            addCriterion("car_state <=", value, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateIn(List<Integer> values) {
            addCriterion("car_state in", values, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateNotIn(List<Integer> values) {
            addCriterion("car_state not in", values, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateBetween(Integer value1, Integer value2) {
            addCriterion("car_state between", value1, value2, "carState");
            return (Criteria) this;
        }

        public Criteria andCarStateNotBetween(Integer value1, Integer value2) {
            addCriterion("car_state not between", value1, value2, "carState");
            return (Criteria) this;
        }

        public Criteria andBuyDateIsNull() {
            addCriterion("buy_date is null");
            return (Criteria) this;
        }

        public Criteria andBuyDateIsNotNull() {
            addCriterion("buy_date is not null");
            return (Criteria) this;
        }

        public Criteria andBuyDateEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date =", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date <>", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateGreaterThan(Date value) {
            addCriterionForJDBCDate("buy_date >", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date >=", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLessThan(Date value) {
            addCriterionForJDBCDate("buy_date <", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("buy_date <=", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateIn(List<Date> values) {
            addCriterionForJDBCDate("buy_date in", values, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("buy_date not in", values, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buy_date between", value1, value2, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("buy_date not between", value1, value2, "buyDate");
            return (Criteria) this;
        }

        public Criteria andEngineNumberIsNull() {
            addCriterion("engine_number is null");
            return (Criteria) this;
        }

        public Criteria andEngineNumberIsNotNull() {
            addCriterion("engine_number is not null");
            return (Criteria) this;
        }

        public Criteria andEngineNumberEqualTo(String value) {
            addCriterion("engine_number =", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberNotEqualTo(String value) {
            addCriterion("engine_number <>", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberGreaterThan(String value) {
            addCriterion("engine_number >", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberGreaterThanOrEqualTo(String value) {
            addCriterion("engine_number >=", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberLessThan(String value) {
            addCriterion("engine_number <", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberLessThanOrEqualTo(String value) {
            addCriterion("engine_number <=", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberLike(String value) {
            addCriterion("engine_number like", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberNotLike(String value) {
            addCriterion("engine_number not like", value, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberIn(List<String> values) {
            addCriterion("engine_number in", values, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberNotIn(List<String> values) {
            addCriterion("engine_number not in", values, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberBetween(String value1, String value2) {
            addCriterion("engine_number between", value1, value2, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andEngineNumberNotBetween(String value1, String value2) {
            addCriterion("engine_number not between", value1, value2, "engineNumber");
            return (Criteria) this;
        }

        public Criteria andCarPriceIsNull() {
            addCriterion("car_price is null");
            return (Criteria) this;
        }

        public Criteria andCarPriceIsNotNull() {
            addCriterion("car_price is not null");
            return (Criteria) this;
        }

        public Criteria andCarPriceEqualTo(Double value) {
            addCriterion("car_price =", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceNotEqualTo(Double value) {
            addCriterion("car_price <>", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceGreaterThan(Double value) {
            addCriterion("car_price >", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("car_price >=", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceLessThan(Double value) {
            addCriterion("car_price <", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceLessThanOrEqualTo(Double value) {
            addCriterion("car_price <=", value, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceIn(List<Double> values) {
            addCriterion("car_price in", values, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceNotIn(List<Double> values) {
            addCriterion("car_price not in", values, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceBetween(Double value1, Double value2) {
            addCriterion("car_price between", value1, value2, "carPrice");
            return (Criteria) this;
        }

        public Criteria andCarPriceNotBetween(Double value1, Double value2) {
            addCriterion("car_price not between", value1, value2, "carPrice");
            return (Criteria) this;
        }

        public Criteria andVinNumIsNull() {
            addCriterion("vin_num is null");
            return (Criteria) this;
        }

        public Criteria andVinNumIsNotNull() {
            addCriterion("vin_num is not null");
            return (Criteria) this;
        }

        public Criteria andVinNumEqualTo(String value) {
            addCriterion("vin_num =", value, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumNotEqualTo(String value) {
            addCriterion("vin_num <>", value, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumGreaterThan(String value) {
            addCriterion("vin_num >", value, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumGreaterThanOrEqualTo(String value) {
            addCriterion("vin_num >=", value, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumLessThan(String value) {
            addCriterion("vin_num <", value, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumLessThanOrEqualTo(String value) {
            addCriterion("vin_num <=", value, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumLike(String value) {
            addCriterion("vin_num like", value, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumNotLike(String value) {
            addCriterion("vin_num not like", value, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumIn(List<String> values) {
            addCriterion("vin_num in", values, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumNotIn(List<String> values) {
            addCriterion("vin_num not in", values, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumBetween(String value1, String value2) {
            addCriterion("vin_num between", value1, value2, "vinNum");
            return (Criteria) this;
        }

        public Criteria andVinNumNotBetween(String value1, String value2) {
            addCriterion("vin_num not between", value1, value2, "vinNum");
            return (Criteria) this;
        }

        public Criteria andCarImgIsNull() {
            addCriterion("car_img is null");
            return (Criteria) this;
        }

        public Criteria andCarImgIsNotNull() {
            addCriterion("car_img is not null");
            return (Criteria) this;
        }

        public Criteria andCarImgEqualTo(String value) {
            addCriterion("car_img =", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgNotEqualTo(String value) {
            addCriterion("car_img <>", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgGreaterThan(String value) {
            addCriterion("car_img >", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgGreaterThanOrEqualTo(String value) {
            addCriterion("car_img >=", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgLessThan(String value) {
            addCriterion("car_img <", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgLessThanOrEqualTo(String value) {
            addCriterion("car_img <=", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgLike(String value) {
            addCriterion("car_img like", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgNotLike(String value) {
            addCriterion("car_img not like", value, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgIn(List<String> values) {
            addCriterion("car_img in", values, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgNotIn(List<String> values) {
            addCriterion("car_img not in", values, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgBetween(String value1, String value2) {
            addCriterion("car_img between", value1, value2, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarImgNotBetween(String value1, String value2) {
            addCriterion("car_img not between", value1, value2, "carImg");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateIsNull() {
            addCriterion("car_deleteState is null");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateIsNotNull() {
            addCriterion("car_deleteState is not null");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateEqualTo(Integer value) {
            addCriterion("car_deleteState =", value, "carDeletestate");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateNotEqualTo(Integer value) {
            addCriterion("car_deleteState <>", value, "carDeletestate");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateGreaterThan(Integer value) {
            addCriterion("car_deleteState >", value, "carDeletestate");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_deleteState >=", value, "carDeletestate");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateLessThan(Integer value) {
            addCriterion("car_deleteState <", value, "carDeletestate");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateLessThanOrEqualTo(Integer value) {
            addCriterion("car_deleteState <=", value, "carDeletestate");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateIn(List<Integer> values) {
            addCriterion("car_deleteState in", values, "carDeletestate");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateNotIn(List<Integer> values) {
            addCriterion("car_deleteState not in", values, "carDeletestate");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateBetween(Integer value1, Integer value2) {
            addCriterion("car_deleteState between", value1, value2, "carDeletestate");
            return (Criteria) this;
        }

        public Criteria andCarDeletestateNotBetween(Integer value1, Integer value2) {
            addCriterion("car_deleteState not between", value1, value2, "carDeletestate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}