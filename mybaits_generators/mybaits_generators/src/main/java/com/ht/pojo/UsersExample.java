package com.ht.pojo;

import java.util.ArrayList;
import java.util.List;

public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersExample() {
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

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andMarryIsNull() {
            addCriterion("marry is null");
            return (Criteria) this;
        }

        public Criteria andMarryIsNotNull() {
            addCriterion("marry is not null");
            return (Criteria) this;
        }

        public Criteria andMarryEqualTo(String value) {
            addCriterion("marry =", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryNotEqualTo(String value) {
            addCriterion("marry <>", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryGreaterThan(String value) {
            addCriterion("marry >", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryGreaterThanOrEqualTo(String value) {
            addCriterion("marry >=", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryLessThan(String value) {
            addCriterion("marry <", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryLessThanOrEqualTo(String value) {
            addCriterion("marry <=", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryLike(String value) {
            addCriterion("marry like", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryNotLike(String value) {
            addCriterion("marry not like", value, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryIn(List<String> values) {
            addCriterion("marry in", values, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryNotIn(List<String> values) {
            addCriterion("marry not in", values, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryBetween(String value1, String value2) {
            addCriterion("marry between", value1, value2, "marry");
            return (Criteria) this;
        }

        public Criteria andMarryNotBetween(String value1, String value2) {
            addCriterion("marry not between", value1, value2, "marry");
            return (Criteria) this;
        }

        public Criteria andAihaoIsNull() {
            addCriterion("aihao is null");
            return (Criteria) this;
        }

        public Criteria andAihaoIsNotNull() {
            addCriterion("aihao is not null");
            return (Criteria) this;
        }

        public Criteria andAihaoEqualTo(String value) {
            addCriterion("aihao =", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoNotEqualTo(String value) {
            addCriterion("aihao <>", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoGreaterThan(String value) {
            addCriterion("aihao >", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoGreaterThanOrEqualTo(String value) {
            addCriterion("aihao >=", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoLessThan(String value) {
            addCriterion("aihao <", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoLessThanOrEqualTo(String value) {
            addCriterion("aihao <=", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoLike(String value) {
            addCriterion("aihao like", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoNotLike(String value) {
            addCriterion("aihao not like", value, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoIn(List<String> values) {
            addCriterion("aihao in", values, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoNotIn(List<String> values) {
            addCriterion("aihao not in", values, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoBetween(String value1, String value2) {
            addCriterion("aihao between", value1, value2, "aihao");
            return (Criteria) this;
        }

        public Criteria andAihaoNotBetween(String value1, String value2) {
            addCriterion("aihao not between", value1, value2, "aihao");
            return (Criteria) this;
        }

        public Criteria andJianjieIsNull() {
            addCriterion("jianjie is null");
            return (Criteria) this;
        }

        public Criteria andJianjieIsNotNull() {
            addCriterion("jianjie is not null");
            return (Criteria) this;
        }

        public Criteria andJianjieEqualTo(String value) {
            addCriterion("jianjie =", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieNotEqualTo(String value) {
            addCriterion("jianjie <>", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieGreaterThan(String value) {
            addCriterion("jianjie >", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieGreaterThanOrEqualTo(String value) {
            addCriterion("jianjie >=", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieLessThan(String value) {
            addCriterion("jianjie <", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieLessThanOrEqualTo(String value) {
            addCriterion("jianjie <=", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieLike(String value) {
            addCriterion("jianjie like", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieNotLike(String value) {
            addCriterion("jianjie not like", value, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieIn(List<String> values) {
            addCriterion("jianjie in", values, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieNotIn(List<String> values) {
            addCriterion("jianjie not in", values, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieBetween(String value1, String value2) {
            addCriterion("jianjie between", value1, value2, "jianjie");
            return (Criteria) this;
        }

        public Criteria andJianjieNotBetween(String value1, String value2) {
            addCriterion("jianjie not between", value1, value2, "jianjie");
            return (Criteria) this;
        }

        public Criteria andDeptnoIsNull() {
            addCriterion("deptno is null");
            return (Criteria) this;
        }

        public Criteria andDeptnoIsNotNull() {
            addCriterion("deptno is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnoEqualTo(Integer value) {
            addCriterion("deptno =", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotEqualTo(Integer value) {
            addCriterion("deptno <>", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoGreaterThan(Integer value) {
            addCriterion("deptno >", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("deptno >=", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoLessThan(Integer value) {
            addCriterion("deptno <", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoLessThanOrEqualTo(Integer value) {
            addCriterion("deptno <=", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoIn(List<Integer> values) {
            addCriterion("deptno in", values, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotIn(List<Integer> values) {
            addCriterion("deptno not in", values, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoBetween(Integer value1, Integer value2) {
            addCriterion("deptno between", value1, value2, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotBetween(Integer value1, Integer value2) {
            addCriterion("deptno not between", value1, value2, "deptno");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNull() {
            addCriterion("hiredate is null");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNotNull() {
            addCriterion("hiredate is not null");
            return (Criteria) this;
        }

        public Criteria andHiredateEqualTo(String value) {
            addCriterion("hiredate =", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotEqualTo(String value) {
            addCriterion("hiredate <>", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThan(String value) {
            addCriterion("hiredate >", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThanOrEqualTo(String value) {
            addCriterion("hiredate >=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThan(String value) {
            addCriterion("hiredate <", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThanOrEqualTo(String value) {
            addCriterion("hiredate <=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLike(String value) {
            addCriterion("hiredate like", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotLike(String value) {
            addCriterion("hiredate not like", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateIn(List<String> values) {
            addCriterion("hiredate in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotIn(List<String> values) {
            addCriterion("hiredate not in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateBetween(String value1, String value2) {
            addCriterion("hiredate between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotBetween(String value1, String value2) {
            addCriterion("hiredate not between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andBookIsNull() {
            addCriterion("book is null");
            return (Criteria) this;
        }

        public Criteria andBookIsNotNull() {
            addCriterion("book is not null");
            return (Criteria) this;
        }

        public Criteria andBookEqualTo(String value) {
            addCriterion("book =", value, "book");
            return (Criteria) this;
        }

        public Criteria andBookNotEqualTo(String value) {
            addCriterion("book <>", value, "book");
            return (Criteria) this;
        }

        public Criteria andBookGreaterThan(String value) {
            addCriterion("book >", value, "book");
            return (Criteria) this;
        }

        public Criteria andBookGreaterThanOrEqualTo(String value) {
            addCriterion("book >=", value, "book");
            return (Criteria) this;
        }

        public Criteria andBookLessThan(String value) {
            addCriterion("book <", value, "book");
            return (Criteria) this;
        }

        public Criteria andBookLessThanOrEqualTo(String value) {
            addCriterion("book <=", value, "book");
            return (Criteria) this;
        }

        public Criteria andBookLike(String value) {
            addCriterion("book like", value, "book");
            return (Criteria) this;
        }

        public Criteria andBookNotLike(String value) {
            addCriterion("book not like", value, "book");
            return (Criteria) this;
        }

        public Criteria andBookIn(List<String> values) {
            addCriterion("book in", values, "book");
            return (Criteria) this;
        }

        public Criteria andBookNotIn(List<String> values) {
            addCriterion("book not in", values, "book");
            return (Criteria) this;
        }

        public Criteria andBookBetween(String value1, String value2) {
            addCriterion("book between", value1, value2, "book");
            return (Criteria) this;
        }

        public Criteria andBookNotBetween(String value1, String value2) {
            addCriterion("book not between", value1, value2, "book");
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