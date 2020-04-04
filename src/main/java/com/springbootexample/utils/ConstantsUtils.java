package com.springbootexample.utils;

public final class ConstantsUtils {
    private ConstantsUtils() {
    }

    /* message */
    private static final String INTERNAL_SERVER_ERROR_MSG = "Internal server error";
    private static final String USER_INVALID_MSG = "Couldn't find your account";
    private static final String FORM_ERRORS = "Form errors";
    private static final String SUCCESS = "Success";
    /* http status code */
    private static final String RESPONSE_SUCCESS = "200";
    private static final String RESPONSE_BAD_REQUEST = "400";
    private static final String RESPONSE_INTERNAL_SERVER_ERROR = "500";


    public static String getInternalServerErrorMsg() {
        return INTERNAL_SERVER_ERROR_MSG;
    }

    public static String getUserInvalidMsg() {
        return USER_INVALID_MSG;
    }

    public static String getFormErrors() {
        return FORM_ERRORS;
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static String getResponseSuccess() {
        return RESPONSE_SUCCESS;
    }

    public static String getResponseBadRequest() {
        return RESPONSE_BAD_REQUEST;
    }

    public static String getResponseInternalServerError() {
        return RESPONSE_INTERNAL_SERVER_ERROR;
    }
}
