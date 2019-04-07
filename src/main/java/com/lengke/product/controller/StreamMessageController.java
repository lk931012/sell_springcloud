package com.lengke.product.controller;

import com.lengke.product.message.MyOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther : 冷科
 * @Date : 2019/4/6 21:22
 */
@RestController
public class StreamMessageController {

    @Autowired
    private Source source;
//    @Autowired
//    private MyOutputStream myOutputStream;

    @GetMapping("/stream/send")
    public void send(){
       source.output().send(MessageBuilder.withPayload("hello world!").build());
    }
}
