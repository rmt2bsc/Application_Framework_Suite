package com.api.persistence.db.orm;

import com.api.persistence.DatabaseException;

/**
 * This exception is thrown in cases where the database connection is closed.
 * 
 * @author roy.terrell
 * 
 */
public class OrmInitialziationException extends DatabaseException {
    private static final long serialVersionUID = -6755175657939760814L;

    /**
     * Default constructor which its message is null.
     * 
     */
    public OrmInitialziationException() {
        super();
    }

    /**
     * Constructs an DatabaseConnectionClosedException object with a message.
     * 
     * @param msg
     *            The exception's message.
     */
    public OrmInitialziationException(String msg) {
        super(msg);
    }

    /**
     * Constructs an DatabaseConnectionClosedException object with an integer
     * code and the message is null.
     * 
     * @param code
     *            The exception code
     */
    // public DatabaseException(int code) {
    // super(code);
    // }
    /**
     * Constructs an DatabaseConnectionClosedException object with a message and
     * a code.
     * 
     * @param msg
     *            The exception message.
     * @param code
     *            The exception code.
     */
    public OrmInitialziationException(String msg, int code) {
        super(msg, code);
    }

    /**
     * Constructs an DatabaseConnectionClosedException using an Exception
     * object.
     * 
     * @param e
     *            Exception
     */
    public OrmInitialziationException(Exception e) {
        super(e);
    }

    /**
     * Creates a new DatabaseConnectionClosedException with a the specified
     * message and the causing throwable instance.
     * 
     * @param msg
     *            the message that explains the error.
     * @param cause
     *            the cause (which is saved for later retrieval by the
     *            Throwable.getCause() method). (A null value is permitted, and
     *            indicates that the cause is nonexistent or unknown.)
     * 
     */
    public OrmInitialziationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
