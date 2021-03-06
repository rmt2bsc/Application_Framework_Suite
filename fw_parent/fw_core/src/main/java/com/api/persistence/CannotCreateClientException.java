package com.api.persistence;


/**
 * This exception inherits the Exception class and is used in cases where the
 * Persistence Storage cannot create schema to use the API as required. At this
 * point, top level use needs to decide whether to continue or abort.
 * 
 * @author Roy Terrell
 */

public class CannotCreateClientException extends DatabaseException {

    private static final long serialVersionUID = 5849320232601197106L;

    public CannotCreateClientException(String msg) {
        super(msg);
    }

    public CannotCreateClientException(Exception e) {
        super(e);
    }

    public CannotCreateClientException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
