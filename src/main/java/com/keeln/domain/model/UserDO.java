package com.keeln.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * This field corresponds to the database column user.user_id
     */
    private Long userId;

    /**
     * This field corresponds to the database column user.user_name
     */
    private String userName;

    /**
     * This field corresponds to the database column user.password
     */
    private String password;

    /**
     * This field corresponds to the database column user.nick_name
     */
    private String nickName;

    /**
     * This field corresponds to the database column user.user_gender
     */
    private String userGender;

    /**
     * This field corresponds to the database column user.user_identify_id
     */
    private Integer userIdentifyId;

}