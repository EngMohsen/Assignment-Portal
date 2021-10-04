package com.segula.portal.data.entity;


public enum UserType {
    CONSULTANT("C"),
    BUSINESS_UNIT_MANAGER("BUM");

    private String code;

    private UserType(String code) {
        this.code=code;
    }


}