package com.amq.demo.service;

import com.amq.demo.broker.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class MessageService {

    private  final JmsTemplate jmsTemplate;
    private final    String DESTINATION="Learning";
    public void sendMessage (String data){
         jmsTemplate.convertAndSend(DESTINATION,data);
         log.info("Message sent : {}",data);

    }

    public void sendSMS (String data){
        jmsTemplate.convertAndSend(DESTINATION,data);
        log.info("Message sent : {}",data);

    }

}
