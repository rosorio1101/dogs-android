package com.rosorio.data.api.response;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public abstract class DogsApiResponse<T> {
    private String status;
    private T message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
