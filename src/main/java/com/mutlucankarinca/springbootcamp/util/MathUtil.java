package com.mutlucankarinca.springbootcamp.util;

import com.mutlucankarinca.springbootcamp.errorMessages.GeneralErrorMessage;
import com.mutlucankarinca.springbootcamp.general.BusinessException;

import java.math.BigDecimal;

public class MathUtil {
    public  static BigDecimal sum(BigDecimal number1, BigDecimal number2){

        if(number1==null || number2==null){
            throw new BusinessException(GeneralErrorMessage.VALUES_CAN_NOT_BE_NULL);
        }

    return number1.add(number2);
    }
}
