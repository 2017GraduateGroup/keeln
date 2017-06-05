package com.keeln.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Xianrui Ke on 2017/6/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluateVO {
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
     * user name
     */
    private String evaluateUserName;
}
