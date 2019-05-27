package com.task.utils;

/**
 * Logic Exception class
 *
 * @author
 * @date May 27, 2019
 */
public class LogicException extends Exception {

    private static final long serialVersionUID = -9074078564538764799L;

    public LogicException() {

    }

    public LogicException(String message) {
        super(message);
    }

    public LogicException(String arg0, Throwable throwable) {
        super(arg0, throwable);
    }

}