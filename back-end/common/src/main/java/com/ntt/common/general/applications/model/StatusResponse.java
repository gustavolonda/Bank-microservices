package com.ntt.common.general.applications.model;
import lombok.Getter;

@Getter
public enum StatusResponse {
    OK("Ok"), ERROR("Error");
    private String value;

    private StatusResponse(String value) {
        this.value = value;
    }
}

