package com.example.booking.response;

public class LoginResponse {
    private String token;
    private long toknExpirationTime;

    public LoginResponse(String token, long toknExpirationTime) {
        this.token = token;
        this.toknExpirationTime = toknExpirationTime;
    }

    public LoginResponse()
    {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getToknExpirationTime() {
        return toknExpirationTime;
    }

    public void setToknExpirationTime(long toknExpirationTime) {
        this.toknExpirationTime = toknExpirationTime;
    }
}
