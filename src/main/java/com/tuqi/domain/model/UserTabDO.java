package com.tuqi.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTabDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column user_tab.id
     */
    private Long id;

    /**
     * This field corresponds to the database column user_tab.username
     */
    private String username;

    /**
     * This field corresponds to the database column user_tab.userage
     */
    private String userage;

}