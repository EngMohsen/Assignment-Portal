package com.segula.portal.data.entity;


public enum RequestStatus {
    SENT("S"),
    RECEIVED("R"),
    ACCEPTED("A"),
    REJECTED("J"),
    APPLIED("P"),
    SIGNED("G");

    private String code;

    private RequestStatus(String code) {
        this.code=code;
    }


}