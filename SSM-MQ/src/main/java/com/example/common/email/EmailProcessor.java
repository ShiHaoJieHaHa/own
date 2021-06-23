package com.example.common.email;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class EmailProcessor {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendEmaillToQueue(Destination destination, String message) {
        System.out.println("---------------------------------------生产----");
        jmsTemplate.convertAndSend(destination, message);
    }
}
