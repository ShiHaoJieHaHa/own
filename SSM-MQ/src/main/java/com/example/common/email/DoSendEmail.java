package com.example.common.email;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component("doSendSmsMessage")
public class DoSendEmail implements MessageListener {
    @Autowired
    private EmailSender emailSender;

    @Override
    public void onMessage(Message message) {
        TextMessage textMsg = (TextMessage) message;
        System.out.println("---------------------------------------消费开始----");
        try {
            JSONObject jsonObject = JSON.parseObject(textMsg.getText());
            emailSender.sendEmail(jsonObject.getString("email"),jsonObject.getString("code"),jsonObject.getString("username"));
        } catch (JMSException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------消费结束----");

    }
}
