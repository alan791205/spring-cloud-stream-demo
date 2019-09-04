package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Processor.class)
@SpringBootApplication
public class DemoApp {
    public static void main(String[] args){
        SpringApplication.run(DemoApp.class, "--management.endpoints.web.exposure.include=bindings");
    }

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String input(String value){
        System.out.println("Value:  " + value);
        return value + "  " + new java.util.Date();
    }
}
