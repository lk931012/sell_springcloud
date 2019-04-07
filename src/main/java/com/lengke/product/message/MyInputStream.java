package com.lengke.product.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Auther : 冷科
 * @Date : 2019/4/7 09:48
 */
public interface MyInputStream {

    String INPUT = "output";

    @Input(MyInputStream.INPUT)
    MessageChannel output();
}
