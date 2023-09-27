package com.amq.demo.listener;

import com.amq.demo.broker.Message;
import com.amq.demo.broker.Transaction;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TransactionListener {
    @JmsListener(destination = "transactionQueue",containerFactory = "myFactory")
    public  void listenMessageData(Transaction data){
        log.info("Received: {}", data);
    }



//    @JmsListener(destination = "Learning",containerFactory = "myFactory")
//    public  void listenLearningQueue(String data){
//        log.info("Received: {}", data);
//    }
}
