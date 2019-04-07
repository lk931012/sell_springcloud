package com.lengke.product.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

/**
 * @Auther : 冷科
 * @Date : 2019/4/7 09:48
 */
public interface MyOutputStream {

    String MY_MESSAGE = "output";

    @Output(MyOutputStream.MY_MESSAGE)
    MessageChannel output();
}
