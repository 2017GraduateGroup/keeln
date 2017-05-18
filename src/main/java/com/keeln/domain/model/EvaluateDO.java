package com.keeln.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluateDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column evaluate.evaluate_id
     */
    private Long evaluateId;

    /**
     * This field corresponds to the database column evaluate.content
     */
    private String content;

    /**
     * This field corresponds to the database column evaluate.scenic_region_id
     */
    private Long scenicRegionId;

    /**
     * This field corresponds to the database column evaluate.user_id
     */
    private Long userId;

    /**
     * This field corresponds to the database column evaluate.gmt_creat
     */
    private Date gmtCreat;

    /**
     * This field corresponds to the database column evaluate.gmt_modified
     */
    private Date gmtModified;

}