package com.proxyserver.proxyserver.model;

public class Resource {

    private int time;
    private int bytes;

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getBytes() {
        return this.bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }
    
    @Override
    public String toString() {
        return "{" +
            " time='" + getTime() + "'" +
            ", bytes='" + getBytes() + "'" +
            "}";
    }

}
