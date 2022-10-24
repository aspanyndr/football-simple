package com.myexample.footballdemo.model.dto;

public class DefaultResponse<T> {

    private Boolean status;
    private String messege;
    private T data;
    

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessege() {
        return this.messege;
    }

    public void setMessege(String messege) {
        this.messege = messege;
    }

}
