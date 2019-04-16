package com.lengke.product.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * @Auther : 冷科
 * @Date : 2019/4/7 09:48
 */
public interface StreamInput {

    String INPUT = "output";

    @Input(StreamInput.INPUT)
    MessageChannel output();
}
