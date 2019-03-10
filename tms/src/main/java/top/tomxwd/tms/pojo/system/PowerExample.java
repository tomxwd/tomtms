package top.tomxwd.tms.pojo.system;

import java.util.ArrayList;
import java.util.List;

public class PowerExample {
	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PowerExample() {
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

        public Criteria andPowerNameIsNull() {
            addCriterion("power_name is null");
            return (Criteria) this;
        }

        public Criteria andPowerNameIsNotNull() {
            addCriterion("power_name is not null");
            return (Criteria) this;
        }

        public Criteria andPowerNameEqualTo(String value) {
            addCriterion("power_name =", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotEqualTo(String value) {
            addCriterion("power_name <>", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameGreaterThan(String value) {
            addCriterion("power_name >", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameGreaterThanOrEqualTo(String value) {
            addCriterion("power_name >=", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameLessThan(String value) {
            addCriterion("power_name <", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameLessThanOrEqualTo(String value) {
            addCriterion("power_name <=", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameLike(String value) {
            addCriterion("power_name like", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotLike(String value) {
            addCriterion("power_name not like", value, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameIn(List<String> values) {
            addCriterion("power_name in", values, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotIn(List<String> values) {
            addCriterion("power_name not in", values, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameBetween(String value1, String value2) {
            addCriterion("power_name between", value1, value2, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerNameNotBetween(String value1, String value2) {
            addCriterion("power_name not between", value1, value2, "powerName");
            return (Criteria) this;
        }

        public Criteria andPowerActionIsNull() {
            addCriterion("power_action is null");
            return (Criteria) this;
        }

        public Criteria andPowerActionIsNotNull() {
            addCriterion("power_action is not null");
            return (Criteria) this;
        }

        public Criteria andPowerActionEqualTo(String value) {
            addCriterion("power_action =", value, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionNotEqualTo(String value) {
            addCriterion("power_action <>", value, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionGreaterThan(String value) {
            addCriterion("power_action >", value, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionGreaterThanOrEqualTo(String value) {
            addCriterion("power_action >=", value, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionLessThan(String value) {
            addCriterion("power_action <", value, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionLessThanOrEqualTo(String value) {
            addCriterion("power_action <=", value, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionLike(String value) {
            addCriterion("power_action like", value, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionNotLike(String value) {
            addCriterion("power_action not like", value, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionIn(List<String> values) {
            addCriterion("power_action in", values, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionNotIn(List<String> values) {
            addCriterion("power_action not in", values, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionBetween(String value1, String value2) {
            addCriterion("power_action between", value1, value2, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerActionNotBetween(String value1, String value2) {
            addCriterion("power_action not between", value1, value2, "powerAction");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayIsNull() {
            addCriterion("power_display is null");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayIsNotNull() {
            addCriterion("power_display is not null");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayEqualTo(Integer value) {
            addCriterion("power_display =", value, "powerDisplay");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayNotEqualTo(Integer value) {
            addCriterion("power_display <>", value, "powerDisplay");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayGreaterThan(Integer value) {
            addCriterion("power_display >", value, "powerDisplay");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayGreaterThanOrEqualTo(Integer value) {
            addCriterion("power_display >=", value, "powerDisplay");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayLessThan(Integer value) {
            addCriterion("power_display <", value, "powerDisplay");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayLessThanOrEqualTo(Integer value) {
            addCriterion("power_display <=", value, "powerDisplay");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayIn(List<Integer> values) {
            addCriterion("power_display in", values, "powerDisplay");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayNotIn(List<Integer> values) {
            addCriterion("power_display not in", values, "powerDisplay");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayBetween(Integer value1, Integer value2) {
            addCriterion("power_display between", value1, value2, "powerDisplay");
            return (Criteria) this;
        }

        public Criteria andPowerDisplayNotBetween(Integer value1, Integer value2) {
            addCriterion("power_display not between", value1, value2, "powerDisplay");
            return (Criteria) this;
        }

        public Criteria andModularIdIsNull() {
            addCriterion("modular_id is null");
            return (Criteria) this;
        }

        public Criteria andModularIdIsNotNull() {
            addCriterion("modular_id is not null");
            return (Criteria) this;
        }

        public Criteria andModularIdEqualTo(Integer value) {
            addCriterion("modular_id =", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdNotEqualTo(Integer value) {
            addCriterion("modular_id <>", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdGreaterThan(Integer value) {
            addCriterion("modular_id >", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("modular_id >=", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdLessThan(Integer value) {
            addCriterion("modular_id <", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdLessThanOrEqualTo(Integer value) {
            addCriterion("modular_id <=", value, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdIn(List<Integer> values) {
            addCriterion("modular_id in", values, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdNotIn(List<Integer> values) {
            addCriterion("modular_id not in", values, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdBetween(Integer value1, Integer value2) {
            addCriterion("modular_id between", value1, value2, "modularId");
            return (Criteria) this;
        }

        public Criteria andModularIdNotBetween(Integer value1, Integer value2) {
            addCriterion("modular_id not between", value1, value2, "modularId");
            return (Criteria) this;
        }

        public Criteria andPrecodeIsNull() {
            addCriterion("precode is null");
            return (Criteria) this;
        }

        public Criteria andPrecodeIsNotNull() {
            addCriterion("precode is not null");
            return (Criteria) this;
        }

        public Criteria andPrecodeEqualTo(String value) {
            addCriterion("precode =", value, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeNotEqualTo(String value) {
            addCriterion("precode <>", value, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeGreaterThan(String value) {
            addCriterion("precode >", value, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeGreaterThanOrEqualTo(String value) {
            addCriterion("precode >=", value, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeLessThan(String value) {
            addCriterion("precode <", value, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeLessThanOrEqualTo(String value) {
            addCriterion("precode <=", value, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeLike(String value) {
            addCriterion("precode like", value, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeNotLike(String value) {
            addCriterion("precode not like", value, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeIn(List<String> values) {
            addCriterion("precode in", values, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeNotIn(List<String> values) {
            addCriterion("precode not in", values, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeBetween(String value1, String value2) {
            addCriterion("precode between", value1, value2, "precode");
            return (Criteria) this;
        }

        public Criteria andPrecodeNotBetween(String value1, String value2) {
            addCriterion("precode not between", value1, value2, "precode");
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