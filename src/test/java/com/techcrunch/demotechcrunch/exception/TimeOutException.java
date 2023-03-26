package com.techcrunch.demotechcrunch.exception;

import org.openqa.selenium.WebDriverException;

public class TimeOutException extends WebDriverException{

    public TimeOutException(String message){
        super(message);
    }

}
