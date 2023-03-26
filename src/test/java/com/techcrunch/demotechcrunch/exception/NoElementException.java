package com.techcrunch.demotechcrunch.exception;

import org.openqa.selenium.NoSuchElementException;

public class NoElementException extends NoSuchElementException {

    public NoElementException(String reason) {
        super(reason);
    }

    public NoElementException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
