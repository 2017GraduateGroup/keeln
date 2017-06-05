package com.keeln.domain.model;

import lombok.Data;

import java.util.List;

/**
 * Created by Xianrui Ke on 2017/6/4.
 */
@Data
public class BizResult {
    private String code;
    private String data;
    private String message;
    private List list;
}
