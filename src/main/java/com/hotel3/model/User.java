package com.hotel3.model;

    import lombok.Data;

/**
* <p>
    *
    * </p>
*
* @author mww
* @since 2019-05-27
*/
    @Data
    public class User {

    private Integer userId;

    private String userSex;

    private String userName;

    private String userPassword;

    private String userType;
}
