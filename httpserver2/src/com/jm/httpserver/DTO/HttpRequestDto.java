package com.jm.httpserver.DTO;

import java.util.ArrayList;
import java.util.Arrays;

public class HttpRequestDto {
    private String method;
    private String requestUrl;
    public HttpRequestDto(String httpRequest){
        ArrayList<String> requestList = new ArrayList<>(Arrays.asList(httpRequest.split(" ")));
        this.method = requestList.get(0);
        this.requestUrl = requestList.get(1);
    }

    public String getMethod() {
        return method;
    }

    public String getRequestUrl() {
        return requestUrl;
    }
}
