package com.jm.httpserver;

import com.jm.httpserver.DTO.HttpRequestDto;
import com.jm.httpserver.DTO.HttpResponseDto;
import com.jm.httpserver.handler.Dispatcher;
import com.jm.httpserver.handler.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 이 예제는 소켓을 활용하여 HTTP서버를 만들어 보기 위한 예제입니다.
// 테스트를 위해 HTTP 동작만 확인했기 때문에, 코드를 참조할 경우
// HTTP request or response 코드만 확인하시고,
// 소켓 관련 코드는 추가적인 정보를 찾아 올바른 코드를 활용하시기 바랍니다.
public class WebSocket {
    public static void main(String[] args) {
        System.out.println("Server has started on 127.0.0.1:8080 \nWaiting for a connection...");
        try {
            while(true){
                ServerSocket socket = new ServerSocket(8080);
                Socket client = socket.accept();
                System.out.println("Client connected!");

                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();
                Scanner s = new Scanner(in,"UTF-8");
                String requestData = null;
                if(s.hasNextLine()){
                    requestData = s.nextLine();
                }

                HttpRequestDto httpRequestDto = new HttpRequestDto(requestData);
                Dispatcher dispatcher = new Dispatcher();
                HttpHandler httpHandler = dispatcher.dispatch(httpRequestDto);
                HttpResponseDto httpResponseDto = httpHandler.handle();
                out.write(httpResponseDto.getResponseData().getBytes());

                s.close();
                in.close();
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
