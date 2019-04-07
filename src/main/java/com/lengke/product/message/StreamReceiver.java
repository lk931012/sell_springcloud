package com.lengke.product.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Component;

/**
 * 消息接收
 * @Auther : 冷科
 * @Date : 2019/4/6 21:16
 */
@Component
@EnableBinding(Processor.class)
@Slf4j
public class StreamReceiver {
    @StreamListener(MyInputStream.INPUT)
    public void receiver(Object message){
        log.info("message:"+message);
    }
}
