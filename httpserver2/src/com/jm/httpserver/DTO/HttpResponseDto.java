package com.jm.httpserver.DTO;

public class HttpResponseDto {
    private String responseData;

    public HttpResponseDto(String responseData){
        this.responseData = responseData;
    }

    public String getResponseData() {
        return responseData;
    }
}
