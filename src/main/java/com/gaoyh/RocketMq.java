/**
 * Copyright 2014 NAVER Corp.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gaoyh;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jongho Moon
 */
@RestController
public class RocketMq {
   /* @Autowired
    private DefaultMQProducer producer;
    @GetMapping("send")
    public String send() throws Exception {
        for (int i = 0; i < 1; i++) {
            final int index = i;
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" *//* Topic *//*,
                                      "TagA" *//* Tag *//*,
                                      ("Hello RocketMQ " +
                                       i).getBytes(RemotingHelper.DEFAULT_CHARSET) *//* Message body *//*
            );
            //Call send message to deliver message to one of brokers.
            producer.send(msg);
        }
        return "success";
    }

    @GetMapping("sendAsync")
    public String sendAsync() throws Exception {
        for (int i = 0; i < 1; i++) {
            final int index = i;
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" *//* Topic *//*,
                                      "TagA" *//* Tag *//*,
                                      ("Hello RocketMQ " +
                                       i).getBytes(RemotingHelper.DEFAULT_CHARSET) *//* Message body *//*
            );
            //Call send message to deliver message to one of brokers.
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }
        return "success";
    }

    @PostConstruct
    public void consume() throws Exception {
        // Instantiate with specified consumer group name.
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("mytest");

        // Specify name server addresses.
        consumer.setNamesrvAddr("localhost:9876");

        // Subscribe one more more topics to consume.
        consumer.subscribe("TopicTest", "*");
        // Register callback to execute on arrival of messages fetched from brokers.
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        //Launch the consumer instance.
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }

    @Bean
    public DefaultMQProducer producer() throws MQClientException {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("TopicTest");
        // Specify name server addresses.
        producer.setNamesrvAddr("localhost:9876");
        //Launch the instance.
        producer.start();
        return producer;
    }*/

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("template/send")
    public boolean sendMessage(String addMessageReq) {
        //指定topic，tag
        rocketMQTemplate.convertAndSend("TopicTest", "hello word");
        return true;
    }

    @GetMapping("template/sendAsync")
    public boolean syncSendMessage() {
        rocketMQTemplate.asyncSend("TopicTest", "syncSendMessage hello word", new SendCallback() {
            // 实现消息发送成功的后续处理
            @Override
            public void onSuccess(SendResult var1) {
                System.out.println("async onSucess SendResult："+ var1);
            }
            // 实现消息发送失败的后续处理
            @Override
            public void onException(Throwable var1) {
                System.out.println("async onException Throwable"+ var1);

            }
        });
        return true;
    }

}