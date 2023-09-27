package com.amq.demo.service;


import com.amq.demo.broker.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.TextMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class ChatService {
    private  final JmsTemplate jmsTemplate;
    private final    String DESTINATION="chat-queues";

    public void sendSMS (Message data){
        jmsTemplate.send(DESTINATION,mc-> {
            try {
               TextMessage tm = mc.createTextMessage(new ObjectMapper().writeValueAsString(data));
                tm.setJMSType(Message.class.getTypeName());
                tm.setStringProperty("_type", Message.class.getTypeName());
                return tm;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        });
        log.info("Message sent : {}",data);

    }
}
