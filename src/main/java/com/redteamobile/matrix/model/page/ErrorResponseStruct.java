package com.redteamobile.matrix.model.page;

/**
 * Created by Jamc on 11/9/16.
 */
public class ErrorResponseStruct {

    private boolean success = false;
    private String errorCode;
    private String errorMsg;

    public boolean isSuccess() {
        return success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
