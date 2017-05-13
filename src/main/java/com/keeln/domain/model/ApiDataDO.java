package com.keeln.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiDataDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column api_data.id
     */
    private Long id;

    /**
     * This field corresponds to the database column api_data.title
     */
    private String title;

    /**
     * This field corresponds to the database column api_data.grade
     */
    private String grade;

    /**
     * This field corresponds to the database column api_data.price_min
     */
    private String priceMin;

    /**
     * This field corresponds to the database column api_data.comm_cnt
     */
    private String commCnt;

    /**
     * This field corresponds to the database column api_data.cityid
     */
    private String cityid;

    /**
     * This field corresponds to the database column api_data.address
     */
    private String address;

    /**
     * This field corresponds to the database column api_data.sid
     */
    private String sid;

    /**
     * This field corresponds to the database column api_data.url
     */
    private String url;

    /**
     * This field corresponds to the database column api_data.imgurl
     */
    private String imgurl;

    /**
     * This field corresponds to the database column api_data.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column api_data.gmt_modified
     */
    private Date gmtModified;

}