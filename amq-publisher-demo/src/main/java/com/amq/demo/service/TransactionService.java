package com.amq.demo.service;

import com.amq.demo.broker.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.TextMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class TransactionService {

    private final JmsTemplate jmsTemplate;

    @Value("${amq.destination}")
    private String destination;
    public  void  sendMessage(Transaction transaction){
        jmsTemplate.send(destination,mc->{
            try{
                TextMessage textMessage = mc.createTextMessage(new ObjectMapper().writeValueAsString(transaction));
                textMessage.setJMSType(Transaction.class.getTypeName());
                textMessage.setStringProperty("_type", Transaction.class.getTypeName());
                return  textMessage;
            }catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        log.info("Message sent : {}",transaction);
    }
}
