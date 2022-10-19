package com.jm.httpserver.handler;

import com.jm.httpserver.DTO.HttpRequestDto;

public class Dispatcher {
    public HttpHandler dispatch(HttpRequestDto requestDto) throws Exception {
        String method = requestDto.getMethod();
        String requestUrl = requestDto.getRequestUrl();
        if(method.equals("GET")){
            if(requestUrl.equals("/")){
                return new DefaultHttpHandler();
            }else if(requestUrl.equals("/hello")){
                return new HelloHttpHandler();
            }else if(requestUrl.equals("/favicon.ico")){
                return new HelloHttpHandler();
            }
        }else{
            throw new Exception("Not supported Method!");
        }
        return null;
    }
}
