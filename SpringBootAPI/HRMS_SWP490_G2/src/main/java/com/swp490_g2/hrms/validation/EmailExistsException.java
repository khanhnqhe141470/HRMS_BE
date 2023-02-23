package com.swp490_g2.hrms.validation;

@SuppressWarnings("serial")
public class EmailExistsException extends Throwable{

    public EmailExistsException(final String message){
        super(message);
    }
}
