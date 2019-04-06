package top.tomxwd.tms.pojo.car;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CarMaintainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarMaintainExample() {
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

        public Criteria andMaintaintimeIsNull() {
            addCriterion("maintainTime is null");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeIsNotNull() {
            addCriterion("maintainTime is not null");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeEqualTo(Date value) {
            addCriterionForJDBCDate("maintainTime =", value, "maintaintime");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("maintainTime <>", value, "maintaintime");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeGreaterThan(Date value) {
            addCriterionForJDBCDate("maintainTime >", value, "maintaintime");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("maintainTime >=", value, "maintaintime");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeLessThan(Date value) {
            addCriterionForJDBCDate("maintainTime <", value, "maintaintime");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("maintainTime <=", value, "maintaintime");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeIn(List<Date> values) {
            addCriterionForJDBCDate("maintainTime in", values, "maintaintime");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("maintainTime not in", values, "maintaintime");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("maintainTime between", value1, value2, "maintaintime");
            return (Criteria) this;
        }

        public Criteria andMaintaintimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("maintainTime not between", value1, value2, "maintaintime");
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

        public Criteria andMaintainCostIsNull() {
            addCriterion("maintain_cost is null");
            return (Criteria) this;
        }

        public Criteria andMaintainCostIsNotNull() {
            addCriterion("maintain_cost is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainCostEqualTo(Double value) {
            addCriterion("maintain_cost =", value, "maintainCost");
            return (Criteria) this;
        }

        public Criteria andMaintainCostNotEqualTo(Double value) {
            addCriterion("maintain_cost <>", value, "maintainCost");
            return (Criteria) this;
        }

        public Criteria andMaintainCostGreaterThan(Double value) {
            addCriterion("maintain_cost >", value, "maintainCost");
            return (Criteria) this;
        }

        public Criteria andMaintainCostGreaterThanOrEqualTo(Double value) {
            addCriterion("maintain_cost >=", value, "maintainCost");
            return (Criteria) this;
        }

        public Criteria andMaintainCostLessThan(Double value) {
            addCriterion("maintain_cost <", value, "maintainCost");
            return (Criteria) this;
        }

        public Criteria andMaintainCostLessThanOrEqualTo(Double value) {
            addCriterion("maintain_cost <=", value, "maintainCost");
            return (Criteria) this;
        }

        public Criteria andMaintainCostIn(List<Double> values) {
            addCriterion("maintain_cost in", values, "maintainCost");
            return (Criteria) this;
        }

        public Criteria andMaintainCostNotIn(List<Double> values) {
            addCriterion("maintain_cost not in", values, "maintainCost");
            return (Criteria) this;
        }

        public Criteria andMaintainCostBetween(Double value1, Double value2) {
            addCriterion("maintain_cost between", value1, value2, "maintainCost");
            return (Criteria) this;
        }

        public Criteria andMaintainCostNotBetween(Double value1, Double value2) {
            addCriterion("maintain_cost not between", value1, value2, "maintainCost");
            return (Criteria) this;
        }

        public Criteria andMaintainResonIsNull() {
            addCriterion("maintain_reson is null");
            return (Criteria) this;
        }

        public Criteria andMaintainResonIsNotNull() {
            addCriterion("maintain_reson is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainResonEqualTo(String value) {
            addCriterion("maintain_reson =", value, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonNotEqualTo(String value) {
            addCriterion("maintain_reson <>", value, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonGreaterThan(String value) {
            addCriterion("maintain_reson >", value, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonGreaterThanOrEqualTo(String value) {
            addCriterion("maintain_reson >=", value, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonLessThan(String value) {
            addCriterion("maintain_reson <", value, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonLessThanOrEqualTo(String value) {
            addCriterion("maintain_reson <=", value, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonLike(String value) {
            addCriterion("maintain_reson like", value, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonNotLike(String value) {
            addCriterion("maintain_reson not like", value, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonIn(List<String> values) {
            addCriterion("maintain_reson in", values, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonNotIn(List<String> values) {
            addCriterion("maintain_reson not in", values, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonBetween(String value1, String value2) {
            addCriterion("maintain_reson between", value1, value2, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainResonNotBetween(String value1, String value2) {
            addCriterion("maintain_reson not between", value1, value2, "maintainReson");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailIsNull() {
            addCriterion("maintain_detail is null");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailIsNotNull() {
            addCriterion("maintain_detail is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailEqualTo(String value) {
            addCriterion("maintain_detail =", value, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailNotEqualTo(String value) {
            addCriterion("maintain_detail <>", value, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailGreaterThan(String value) {
            addCriterion("maintain_detail >", value, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailGreaterThanOrEqualTo(String value) {
            addCriterion("maintain_detail >=", value, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailLessThan(String value) {
            addCriterion("maintain_detail <", value, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailLessThanOrEqualTo(String value) {
            addCriterion("maintain_detail <=", value, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailLike(String value) {
            addCriterion("maintain_detail like", value, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailNotLike(String value) {
            addCriterion("maintain_detail not like", value, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailIn(List<String> values) {
            addCriterion("maintain_detail in", values, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailNotIn(List<String> values) {
            addCriterion("maintain_detail not in", values, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailBetween(String value1, String value2) {
            addCriterion("maintain_detail between", value1, value2, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andMaintainDetailNotBetween(String value1, String value2) {
            addCriterion("maintain_detail not between", value1, value2, "maintainDetail");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNull() {
            addCriterion("feedback is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIsNotNull() {
            addCriterion("feedback is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackEqualTo(String value) {
            addCriterion("feedback =", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotEqualTo(String value) {
            addCriterion("feedback <>", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThan(String value) {
            addCriterion("feedback >", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackGreaterThanOrEqualTo(String value) {
            addCriterion("feedback >=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThan(String value) {
            addCriterion("feedback <", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLessThanOrEqualTo(String value) {
            addCriterion("feedback <=", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackLike(String value) {
            addCriterion("feedback like", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotLike(String value) {
            addCriterion("feedback not like", value, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackIn(List<String> values) {
            addCriterion("feedback in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotIn(List<String> values) {
            addCriterion("feedback not in", values, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackBetween(String value1, String value2) {
            addCriterion("feedback between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andFeedbackNotBetween(String value1, String value2) {
            addCriterion("feedback not between", value1, value2, "feedback");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeIsNull() {
            addCriterion("insurance_type is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeIsNotNull() {
            addCriterion("insurance_type is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeEqualTo(Integer value) {
            addCriterion("insurance_type =", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeNotEqualTo(Integer value) {
            addCriterion("insurance_type <>", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeGreaterThan(Integer value) {
            addCriterion("insurance_type >", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("insurance_type >=", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeLessThan(Integer value) {
            addCriterion("insurance_type <", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("insurance_type <=", value, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeIn(List<Integer> values) {
            addCriterion("insurance_type in", values, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeNotIn(List<Integer> values) {
            addCriterion("insurance_type not in", values, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeBetween(Integer value1, Integer value2) {
            addCriterion("insurance_type between", value1, value2, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andInsuranceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("insurance_type not between", value1, value2, "insuranceType");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNull() {
            addCriterion("pay_state is null");
            return (Criteria) this;
        }

        public Criteria andPayStateIsNotNull() {
            addCriterion("pay_state is not null");
            return (Criteria) this;
        }

        public Criteria andPayStateEqualTo(Integer value) {
            addCriterion("pay_state =", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotEqualTo(Integer value) {
            addCriterion("pay_state <>", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThan(Integer value) {
            addCriterion("pay_state >", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_state >=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThan(Integer value) {
            addCriterion("pay_state <", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateLessThanOrEqualTo(Integer value) {
            addCriterion("pay_state <=", value, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateIn(List<Integer> values) {
            addCriterion("pay_state in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotIn(List<Integer> values) {
            addCriterion("pay_state not in", values, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateBetween(Integer value1, Integer value2) {
            addCriterion("pay_state between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andPayStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_state not between", value1, value2, "payState");
            return (Criteria) this;
        }

        public Criteria andMaintainStateIsNull() {
            addCriterion("maintain_state is null");
            return (Criteria) this;
        }

        public Criteria andMaintainStateIsNotNull() {
            addCriterion("maintain_state is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainStateEqualTo(Integer value) {
            addCriterion("maintain_state =", value, "maintainState");
            return (Criteria) this;
        }

        public Criteria andMaintainStateNotEqualTo(Integer value) {
            addCriterion("maintain_state <>", value, "maintainState");
            return (Criteria) this;
        }

        public Criteria andMaintainStateGreaterThan(Integer value) {
            addCriterion("maintain_state >", value, "maintainState");
            return (Criteria) this;
        }

        public Criteria andMaintainStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("maintain_state >=", value, "maintainState");
            return (Criteria) this;
        }

        public Criteria andMaintainStateLessThan(Integer value) {
            addCriterion("maintain_state <", value, "maintainState");
            return (Criteria) this;
        }

        public Criteria andMaintainStateLessThanOrEqualTo(Integer value) {
            addCriterion("maintain_state <=", value, "maintainState");
            return (Criteria) this;
        }

        public Criteria andMaintainStateIn(List<Integer> values) {
            addCriterion("maintain_state in", values, "maintainState");
            return (Criteria) this;
        }

        public Criteria andMaintainStateNotIn(List<Integer> values) {
            addCriterion("maintain_state not in", values, "maintainState");
            return (Criteria) this;
        }

        public Criteria andMaintainStateBetween(Integer value1, Integer value2) {
            addCriterion("maintain_state between", value1, value2, "maintainState");
            return (Criteria) this;
        }

        public Criteria andMaintainStateNotBetween(Integer value1, Integer value2) {
            addCriterion("maintain_state not between", value1, value2, "maintainState");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIsNull() {
            addCriterion("complete_date is null");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIsNotNull() {
            addCriterion("complete_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteDateEqualTo(Date value) {
            addCriterionForJDBCDate("complete_date =", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("complete_date <>", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateGreaterThan(Date value) {
            addCriterionForJDBCDate("complete_date >", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("complete_date >=", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLessThan(Date value) {
            addCriterionForJDBCDate("complete_date <", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("complete_date <=", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIn(List<Date> values) {
            addCriterionForJDBCDate("complete_date in", values, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("complete_date not in", values, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("complete_date between", value1, value2, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("complete_date not between", value1, value2, "completeDate");
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