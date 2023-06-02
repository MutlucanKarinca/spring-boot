package com.mutlucankarinca.springbootcamp.errorMessages;

import com.mutlucankarinca.springbootcamp.general.BaseErrorMessage;

public enum GeneralErrorMessage implements BaseErrorMessage {
    VALUES_CAN_NOT_BE_NULL("Values can not be null");

    private String message;
    GeneralErrorMessage(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
