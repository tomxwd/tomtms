package top.tomxwd.tms.pojo.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DriverAndCarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DriverAndCarExample() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andDriverIdIsNull() {
            addCriterion("driver_id is null");
            return (Criteria) this;
        }

        public Criteria andDriverIdIsNotNull() {
            addCriterion("driver_id is not null");
            return (Criteria) this;
        }

        public Criteria andDriverIdEqualTo(Integer value) {
            addCriterion("driver_id =", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotEqualTo(Integer value) {
            addCriterion("driver_id <>", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThan(Integer value) {
            addCriterion("driver_id >", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("driver_id >=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThan(Integer value) {
            addCriterion("driver_id <", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdLessThanOrEqualTo(Integer value) {
            addCriterion("driver_id <=", value, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdIn(List<Integer> values) {
            addCriterion("driver_id in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotIn(List<Integer> values) {
            addCriterion("driver_id not in", values, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdBetween(Integer value1, Integer value2) {
            addCriterion("driver_id between", value1, value2, "driverId");
            return (Criteria) this;
        }

        public Criteria andDriverIdNotBetween(Integer value1, Integer value2) {
            addCriterion("driver_id not between", value1, value2, "driverId");
            return (Criteria) this;
        }

        public Criteria andRentTimeIsNull() {
            addCriterion("rent_time is null");
            return (Criteria) this;
        }

        public Criteria andRentTimeIsNotNull() {
            addCriterion("rent_time is not null");
            return (Criteria) this;
        }

        public Criteria andRentTimeEqualTo(Date value) {
            addCriterion("rent_time =", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeNotEqualTo(Date value) {
            addCriterion("rent_time <>", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeGreaterThan(Date value) {
            addCriterion("rent_time >", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rent_time >=", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeLessThan(Date value) {
            addCriterion("rent_time <", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeLessThanOrEqualTo(Date value) {
            addCriterion("rent_time <=", value, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeIn(List<Date> values) {
            addCriterion("rent_time in", values, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeNotIn(List<Date> values) {
            addCriterion("rent_time not in", values, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeBetween(Date value1, Date value2) {
            addCriterion("rent_time between", value1, value2, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentTimeNotBetween(Date value1, Date value2) {
            addCriterion("rent_time not between", value1, value2, "rentTime");
            return (Criteria) this;
        }

        public Criteria andRentStateIsNull() {
            addCriterion("rent_state is null");
            return (Criteria) this;
        }

        public Criteria andRentStateIsNotNull() {
            addCriterion("rent_state is not null");
            return (Criteria) this;
        }

        public Criteria andRentStateEqualTo(Integer value) {
            addCriterion("rent_state =", value, "rentState");
            return (Criteria) this;
        }

        public Criteria andRentStateNotEqualTo(Integer value) {
            addCriterion("rent_state <>", value, "rentState");
            return (Criteria) this;
        }

        public Criteria andRentStateGreaterThan(Integer value) {
            addCriterion("rent_state >", value, "rentState");
            return (Criteria) this;
        }

        public Criteria andRentStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("rent_state >=", value, "rentState");
            return (Criteria) this;
        }

        public Criteria andRentStateLessThan(Integer value) {
            addCriterion("rent_state <", value, "rentState");
            return (Criteria) this;
        }

        public Criteria andRentStateLessThanOrEqualTo(Integer value) {
            addCriterion("rent_state <=", value, "rentState");
            return (Criteria) this;
        }

        public Criteria andRentStateIn(List<Integer> values) {
            addCriterion("rent_state in", values, "rentState");
            return (Criteria) this;
        }

        public Criteria andRentStateNotIn(List<Integer> values) {
            addCriterion("rent_state not in", values, "rentState");
            return (Criteria) this;
        }

        public Criteria andRentStateBetween(Integer value1, Integer value2) {
            addCriterion("rent_state between", value1, value2, "rentState");
            return (Criteria) this;
        }

        public Criteria andRentStateNotBetween(Integer value1, Integer value2) {
            addCriterion("rent_state not between", value1, value2, "rentState");
            return (Criteria) this;
        }

        public Criteria andRefuseResonIsNull() {
            addCriterion("refuse_reson is null");
            return (Criteria) this;
        }

        public Criteria andRefuseResonIsNotNull() {
            addCriterion("refuse_reson is not null");
            return (Criteria) this;
        }

        public Criteria andRefuseResonEqualTo(String value) {
            addCriterion("refuse_reson =", value, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonNotEqualTo(String value) {
            addCriterion("refuse_reson <>", value, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonGreaterThan(String value) {
            addCriterion("refuse_reson >", value, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonGreaterThanOrEqualTo(String value) {
            addCriterion("refuse_reson >=", value, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonLessThan(String value) {
            addCriterion("refuse_reson <", value, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonLessThanOrEqualTo(String value) {
            addCriterion("refuse_reson <=", value, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonLike(String value) {
            addCriterion("refuse_reson like", value, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonNotLike(String value) {
            addCriterion("refuse_reson not like", value, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonIn(List<String> values) {
            addCriterion("refuse_reson in", values, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonNotIn(List<String> values) {
            addCriterion("refuse_reson not in", values, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonBetween(String value1, String value2) {
            addCriterion("refuse_reson between", value1, value2, "refuseReson");
            return (Criteria) this;
        }

        public Criteria andRefuseResonNotBetween(String value1, String value2) {
            addCriterion("refuse_reson not between", value1, value2, "refuseReson");
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