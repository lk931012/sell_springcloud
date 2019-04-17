package com.lengke.product.controller;

import com.lengke.entity.ProductInfo;
import com.lengke.product.message.StreamOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息发送测试端
 * @Auther : 冷科
 * @Date : 2019/4/6 21:22
 */
@RestController
public class StreamMessageController {

    @Autowired
    private Source source;
//    目前自定义接口自动注入会报错
/*    @Autowired
    private StreamOutput streamOutput;*/

    @GetMapping("/stream/send")
    public void send(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        source.output().send(MessageBuilder.withPayload(productInfo).build());
    }
}
