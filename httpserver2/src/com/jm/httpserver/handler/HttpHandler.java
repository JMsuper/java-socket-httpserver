package com.jm.httpserver.handler;

import com.jm.httpserver.DTO.HttpResponseDto;

public interface HttpHandler {
    HttpResponseDto handle();
}
