package com.keeln.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScenicRegionDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column scenic_region.id
     */
    private Long id;

    /**
     * This field corresponds to the database column scenic_region.title
     */
    private String title;

    /**
     * This field corresponds to the database column scenic_region.grade
     */
    private String grade;

    /**
     * This field corresponds to the database column scenic_region.price_min
     */
    private String priceMin;

    /**
     * This field corresponds to the database column scenic_region.address
     */
    private String address;

    /**
     * This field corresponds to the database column scenic_region.url
     */
    private String url;

    /**
     * This field corresponds to the database column scenic_region.area
     */
    private Integer area;

    /**
     * This field corresponds to the database column scenic_region.hot_flag
     */
    private Integer hotFlag;

    /**
     * This field corresponds to the database column scenic_region.imgurl
     */
    private String imgurl;

    /**
     * This field corresponds to the database column scenic_region.detail
     */
    private String detail;

    /**
     * This field corresponds to the database column scenic_region.gmt_create
     */
    private Date gmtCreate;

    /**
     * This field corresponds to the database column scenic_region.gmt_modified
     */
    private Date gmtModified;

}