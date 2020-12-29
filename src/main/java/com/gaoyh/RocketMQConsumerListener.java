package com.gaoyh;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "TopicTest", consumeMode = ConsumeMode.CONCURRENTLY, consumerGroup = "${rocketmq.consumer.group}")
public class RocketMQConsumerListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        System.out.println("接收到消息：" + s);
    }

}