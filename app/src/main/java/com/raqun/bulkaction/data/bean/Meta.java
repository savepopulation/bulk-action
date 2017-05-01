package com.raqun.bulkaction.data.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tyln on 01/05/2017.
 */

final class Meta {
    @SerializedName("error_type")
    private String errorType;
    @SerializedName("code")
    private int code;
    @SerializedName("error_message")
    private String errorMessage;

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
