package com.jm.httpserver.handler;

import com.jm.httpserver.DTO.HttpResponseDto;

public class DefaultHttpHandler implements HttpHandler{

    @Override
    public HttpResponseDto handle() {
        String responseData = "HTTP/1.1 200 OK\r\n" +
                "Server: \r\n" +
                "Content-type: text/html\r\n\r\n" +
                "<HTML>" +
                "<HEAD><TITLE>200</TITLE></HEAD>" +
                "<BODY>This is \"/\" Response Data!" +
                "</BODY></HTML>";
        return new HttpResponseDto(responseData);
    }
}
