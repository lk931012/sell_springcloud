package com.lengke.product.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 队列简单运用
 * @Auther : 冷科
 * @Date : 2019/4/6 16:55
 */

@Slf4j
@Component
public class MyQueue {
    //@RabbitListener(queues = "myQueue")
    //自动创建队列
    //@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //自动创建队列并绑定exchange
    /*@RabbitListener(bindings = @QueueBinding( value = @Queue("myQueue"),exchange = @Exchange("order")))
    public void receiver(String msg){
        log.info("msg="+msg);
    }*/
}
