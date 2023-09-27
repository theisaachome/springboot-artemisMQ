package com.amq.demo.listener;

import com.amq.demo.broker.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ChatListener {
    @JmsListener(destination = "chat-queues",containerFactory = "myFactory")
    public  void listenMessageData(Message data){
        log.info("Received: {}", data);
    }



//    @JmsListener(destination = "Learning",containerFactory = "myFactory")
//    public  void listenLearningQueue(String data){
//        log.info("Received: {}", data);
//    }
}
