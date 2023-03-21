package com.media.monk.model;

/**
 * This class will act as the Response format for the rest.
 * 
 * @author Santosh.
 *
 */
public class ResponsePayload {
    private boolean success;
    private String message;
    private int status;
    private Object result;

    public boolean isSuccess() {
        return success;
    }

    public ResponsePayload setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponsePayload setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ResponsePayload setStatus(int status) {
        this.status = status;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public ResponsePayload setResult(Object result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "ResponsePayload [success=" + success + ", message=" + message + ", status=" + status
                + ", result=" + result + "]";
    }


}
