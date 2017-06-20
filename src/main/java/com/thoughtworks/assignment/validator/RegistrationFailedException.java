package com.thoughtworks.assignment.validator;

/**
 * Created by vrushali on 6/19/17.
 */
public class RegistrationFailedException extends Exception {

    private RegistrationErrorCode errorCode;

    public RegistrationFailedException( RegistrationErrorCode registrationErrorCode,String message) {
        super(message);
        this.errorCode = registrationErrorCode;
    }

    public RegistrationErrorCode getErrorCode() {
        return errorCode;
    }
}
