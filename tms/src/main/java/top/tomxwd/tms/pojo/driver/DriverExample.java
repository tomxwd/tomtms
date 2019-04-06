package top.tomxwd.tms.pojo.driver;

import java.util.ArrayList;
import java.util.List;

public class DriverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DriverExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andDriverGenderIsNull() {
            addCriterion("driver_gender is null");
            return (Criteria) this;
        }

        public Criteria andDriverGenderIsNotNull() {
            addCriterion("driver_gender is not null");
            return (Criteria) this;
        }

        public Criteria andDriverGenderEqualTo(Integer value) {
            addCriterion("driver_gender =", value, "driverGender");
            return (Criteria) this;
        }

        public Criteria andDriverGenderNotEqualTo(Integer value) {
            addCriterion("driver_gender <>", value, "driverGender");
            return (Criteria) this;
        }

        public Criteria andDriverGenderGreaterThan(Integer value) {
            addCriterion("driver_gender >", value, "driverGender");
            return (Criteria) this;
        }

        public Criteria andDriverGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("driver_gender >=", value, "driverGender");
            return (Criteria) this;
        }

        public Criteria andDriverGenderLessThan(Integer value) {
            addCriterion("driver_gender <", value, "driverGender");
            return (Criteria) this;
        }

        public Criteria andDriverGenderLessThanOrEqualTo(Integer value) {
            addCriterion("driver_gender <=", value, "driverGender");
            return (Criteria) this;
        }

        public Criteria andDriverGenderIn(List<Integer> values) {
            addCriterion("driver_gender in", values, "driverGender");
            return (Criteria) this;
        }

        public Criteria andDriverGenderNotIn(List<Integer> values) {
            addCriterion("driver_gender not in", values, "driverGender");
            return (Criteria) this;
        }

        public Criteria andDriverGenderBetween(Integer value1, Integer value2) {
            addCriterion("driver_gender between", value1, value2, "driverGender");
            return (Criteria) this;
        }

        public Criteria andDriverGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("driver_gender not between", value1, value2, "driverGender");
            return (Criteria) this;
        }

        public Criteria andDriverEducationIsNull() {
            addCriterion("driver_education is null");
            return (Criteria) this;
        }

        public Criteria andDriverEducationIsNotNull() {
            addCriterion("driver_education is not null");
            return (Criteria) this;
        }

        public Criteria andDriverEducationEqualTo(Integer value) {
            addCriterion("driver_education =", value, "driverEducation");
            return (Criteria) this;
        }

        public Criteria andDriverEducationNotEqualTo(Integer value) {
            addCriterion("driver_education <>", value, "driverEducation");
            return (Criteria) this;
        }

        public Criteria andDriverEducationGreaterThan(Integer value) {
            addCriterion("driver_education >", value, "driverEducation");
            return (Criteria) this;
        }

        public Criteria andDriverEducationGreaterThanOrEqualTo(Integer value) {
            addCriterion("driver_education >=", value, "driverEducation");
            return (Criteria) this;
        }

        public Criteria andDriverEducationLessThan(Integer value) {
            addCriterion("driver_education <", value, "driverEducation");
            return (Criteria) this;
        }

        public Criteria andDriverEducationLessThanOrEqualTo(Integer value) {
            addCriterion("driver_education <=", value, "driverEducation");
            return (Criteria) this;
        }

        public Criteria andDriverEducationIn(List<Integer> values) {
            addCriterion("driver_education in", values, "driverEducation");
            return (Criteria) this;
        }

        public Criteria andDriverEducationNotIn(List<Integer> values) {
            addCriterion("driver_education not in", values, "driverEducation");
            return (Criteria) this;
        }

        public Criteria andDriverEducationBetween(Integer value1, Integer value2) {
            addCriterion("driver_education between", value1, value2, "driverEducation");
            return (Criteria) this;
        }

        public Criteria andDriverEducationNotBetween(Integer value1, Integer value2) {
            addCriterion("driver_education not between", value1, value2, "driverEducation");
            return (Criteria) this;
        }

        public Criteria andDriverAddressIsNull() {
            addCriterion("driver_address is null");
            return (Criteria) this;
        }

        public Criteria andDriverAddressIsNotNull() {
            addCriterion("driver_address is not null");
            return (Criteria) this;
        }

        public Criteria andDriverAddressEqualTo(String value) {
            addCriterion("driver_address =", value, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressNotEqualTo(String value) {
            addCriterion("driver_address <>", value, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressGreaterThan(String value) {
            addCriterion("driver_address >", value, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("driver_address >=", value, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressLessThan(String value) {
            addCriterion("driver_address <", value, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressLessThanOrEqualTo(String value) {
            addCriterion("driver_address <=", value, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressLike(String value) {
            addCriterion("driver_address like", value, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressNotLike(String value) {
            addCriterion("driver_address not like", value, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressIn(List<String> values) {
            addCriterion("driver_address in", values, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressNotIn(List<String> values) {
            addCriterion("driver_address not in", values, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressBetween(String value1, String value2) {
            addCriterion("driver_address between", value1, value2, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andDriverAddressNotBetween(String value1, String value2) {
            addCriterion("driver_address not between", value1, value2, "driverAddress");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusIsNull() {
            addCriterion("politics_status is null");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusIsNotNull() {
            addCriterion("politics_status is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusEqualTo(Integer value) {
            addCriterion("politics_status =", value, "politicsStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusNotEqualTo(Integer value) {
            addCriterion("politics_status <>", value, "politicsStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusGreaterThan(Integer value) {
            addCriterion("politics_status >", value, "politicsStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("politics_status >=", value, "politicsStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusLessThan(Integer value) {
            addCriterion("politics_status <", value, "politicsStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusLessThanOrEqualTo(Integer value) {
            addCriterion("politics_status <=", value, "politicsStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusIn(List<Integer> values) {
            addCriterion("politics_status in", values, "politicsStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusNotIn(List<Integer> values) {
            addCriterion("politics_status not in", values, "politicsStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusBetween(Integer value1, Integer value2) {
            addCriterion("politics_status between", value1, value2, "politicsStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticsStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("politics_status not between", value1, value2, "politicsStatus");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberIsNull() {
            addCriterion("identity_number is null");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberIsNotNull() {
            addCriterion("identity_number is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberEqualTo(String value) {
            addCriterion("identity_number =", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotEqualTo(String value) {
            addCriterion("identity_number <>", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberGreaterThan(String value) {
            addCriterion("identity_number >", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberGreaterThanOrEqualTo(String value) {
            addCriterion("identity_number >=", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLessThan(String value) {
            addCriterion("identity_number <", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLessThanOrEqualTo(String value) {
            addCriterion("identity_number <=", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberLike(String value) {
            addCriterion("identity_number like", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotLike(String value) {
            addCriterion("identity_number not like", value, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberIn(List<String> values) {
            addCriterion("identity_number in", values, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotIn(List<String> values) {
            addCriterion("identity_number not in", values, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberBetween(String value1, String value2) {
            addCriterion("identity_number between", value1, value2, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andIdentityNumberNotBetween(String value1, String value2) {
            addCriterion("identity_number not between", value1, value2, "identityNumber");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdIsNull() {
            addCriterion("taximeter_id is null");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdIsNotNull() {
            addCriterion("taximeter_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdEqualTo(Integer value) {
            addCriterion("taximeter_id =", value, "taximeterId");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdNotEqualTo(Integer value) {
            addCriterion("taximeter_id <>", value, "taximeterId");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdGreaterThan(Integer value) {
            addCriterion("taximeter_id >", value, "taximeterId");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("taximeter_id >=", value, "taximeterId");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdLessThan(Integer value) {
            addCriterion("taximeter_id <", value, "taximeterId");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdLessThanOrEqualTo(Integer value) {
            addCriterion("taximeter_id <=", value, "taximeterId");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdIn(List<Integer> values) {
            addCriterion("taximeter_id in", values, "taximeterId");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdNotIn(List<Integer> values) {
            addCriterion("taximeter_id not in", values, "taximeterId");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdBetween(Integer value1, Integer value2) {
            addCriterion("taximeter_id between", value1, value2, "taximeterId");
            return (Criteria) this;
        }

        public Criteria andTaximeterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("taximeter_id not between", value1, value2, "taximeterId");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNull() {
            addCriterion("headImg is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNotNull() {
            addCriterion("headImg is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgEqualTo(String value) {
            addCriterion("headImg =", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotEqualTo(String value) {
            addCriterion("headImg <>", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThan(String value) {
            addCriterion("headImg >", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThanOrEqualTo(String value) {
            addCriterion("headImg >=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThan(String value) {
            addCriterion("headImg <", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThanOrEqualTo(String value) {
            addCriterion("headImg <=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLike(String value) {
            addCriterion("headImg like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotLike(String value) {
            addCriterion("headImg not like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgIn(List<String> values) {
            addCriterion("headImg in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotIn(List<String> values) {
            addCriterion("headImg not in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgBetween(String value1, String value2) {
            addCriterion("headImg between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotBetween(String value1, String value2) {
            addCriterion("headImg not between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andAcountStateIsNull() {
            addCriterion("acount_state is null");
            return (Criteria) this;
        }

        public Criteria andAcountStateIsNotNull() {
            addCriterion("acount_state is not null");
            return (Criteria) this;
        }

        public Criteria andAcountStateEqualTo(Integer value) {
            addCriterion("acount_state =", value, "acountState");
            return (Criteria) this;
        }

        public Criteria andAcountStateNotEqualTo(Integer value) {
            addCriterion("acount_state <>", value, "acountState");
            return (Criteria) this;
        }

        public Criteria andAcountStateGreaterThan(Integer value) {
            addCriterion("acount_state >", value, "acountState");
            return (Criteria) this;
        }

        public Criteria andAcountStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("acount_state >=", value, "acountState");
            return (Criteria) this;
        }

        public Criteria andAcountStateLessThan(Integer value) {
            addCriterion("acount_state <", value, "acountState");
            return (Criteria) this;
        }

        public Criteria andAcountStateLessThanOrEqualTo(Integer value) {
            addCriterion("acount_state <=", value, "acountState");
            return (Criteria) this;
        }

        public Criteria andAcountStateIn(List<Integer> values) {
            addCriterion("acount_state in", values, "acountState");
            return (Criteria) this;
        }

        public Criteria andAcountStateNotIn(List<Integer> values) {
            addCriterion("acount_state not in", values, "acountState");
            return (Criteria) this;
        }

        public Criteria andAcountStateBetween(Integer value1, Integer value2) {
            addCriterion("acount_state between", value1, value2, "acountState");
            return (Criteria) this;
        }

        public Criteria andAcountStateNotBetween(Integer value1, Integer value2) {
            addCriterion("acount_state not between", value1, value2, "acountState");
            return (Criteria) this;
        }

        public Criteria andDriverNameIsNull() {
            addCriterion("driver_name is null");
            return (Criteria) this;
        }

        public Criteria andDriverNameIsNotNull() {
            addCriterion("driver_name is not null");
            return (Criteria) this;
        }

        public Criteria andDriverNameEqualTo(String value) {
            addCriterion("driver_name =", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotEqualTo(String value) {
            addCriterion("driver_name <>", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameGreaterThan(String value) {
            addCriterion("driver_name >", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameGreaterThanOrEqualTo(String value) {
            addCriterion("driver_name >=", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLessThan(String value) {
            addCriterion("driver_name <", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLessThanOrEqualTo(String value) {
            addCriterion("driver_name <=", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameLike(String value) {
            addCriterion("driver_name like", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotLike(String value) {
            addCriterion("driver_name not like", value, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameIn(List<String> values) {
            addCriterion("driver_name in", values, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotIn(List<String> values) {
            addCriterion("driver_name not in", values, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameBetween(String value1, String value2) {
            addCriterion("driver_name between", value1, value2, "driverName");
            return (Criteria) this;
        }

        public Criteria andDriverNameNotBetween(String value1, String value2) {
            addCriterion("driver_name not between", value1, value2, "driverName");
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