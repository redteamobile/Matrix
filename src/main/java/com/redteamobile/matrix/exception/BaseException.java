package com.redteamobile.matrix.exception;

public class BaseException extends Throwable {

    private static final long serialVersionUID = 1831611793249206868L;

    /** 每一个错误编码表示一个错误, TODO(shengl: 考虑一个更合理的exception组织方式) */
    public static final BaseException JDBC_WRAPPER_RUNTIME_EXCEPTION = new BaseException("7001",
            "something wrong with made in sihuidong");

    public BaseException() {
        super();
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String getLocalizedMessage() {
        return this.getErrorMessage();
    }
}
