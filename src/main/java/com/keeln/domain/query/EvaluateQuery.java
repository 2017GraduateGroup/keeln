package com.keeln.domain.query;


import com.keeln.mybatisgenerate.query.BaseQuery;
import com.keeln.mybatisgenerate.query.BaseCriteria;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvaluateQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public EvaluateQuery() {
        super();
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        super.oredCriteria.add(criteria);
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

    /**
     * This class corresponds to the database table evaluate
     */
         protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andEvaluateIdIsNull() {
            addCriterion("evaluate_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdIsNotNull() {
            addCriterion("evaluate_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdEqualTo(Long value) {
            addCriterion("evaluate_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotEqualTo(Long value) {
            addCriterion("evaluate_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria anEvaluateIdGreaterThan(Long value) {
            addCriterion("evaluate_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("evaluate_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdLessThan(Long value) {
            addCriterion("evaluate_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdLessThanOrEqualTo(Long value) {
            addCriterion("evaluate_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdIn(List<Long> values) {
            addCriterion("evaluate_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotIn(List<Long> values) {
            addCriterion("evaluate_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdBetween(Long value1, Long value2) {
            addCriterion("evaluate_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEvaluateIdNotBetween(Long value1, Long value2) {
            addCriterion("evaluate_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("content like", strValue, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("content not like", strValue, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdIsNull() {
            addCriterion("scenic_region_id is null");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdIsNotNull() {
            addCriterion("scenic_region_id is not null");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdEqualTo(Long value) {
            addCriterion("scenic_region_id =", value, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdNotEqualTo(Long value) {
            addCriterion("scenic_region_id <>", value, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdGreaterThan(Long value) {
            addCriterion("scenic_region_id >", value, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("scenic_region_id >=", value, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdLessThan(Long value) {
            addCriterion("scenic_region_id <", value, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("scenic_region_id <=", value, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdLike(Long value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("scenic_region_id like", strValue, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdNotLike(Long value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("scenic_region_id not like", strValue, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdIn(List<Long> values) {
            addCriterion("scenic_region_id in", values, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdNotIn(List<Long> values) {
            addCriterion("scenic_region_id not in", values, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdBetween(Long value1, Long value2) {
            addCriterion("scenic_region_id between", value1, value2, "scenicRegionId");
            return (Criteria) this;
        }

        public Criteria andScenicRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("scenic_region_id not between", value1, value2, "scenicRegionId");
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

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(Long value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("user_id like", strValue, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(Long value) {
            String strValue = "%"+value.toString()+"%";
            addCriterion("user_id not like", strValue, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table evaluate
    */
    public  static class Criteria extends GeneratedCriteria{
        protected Criteria() {
            super();
        }
    }



    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}