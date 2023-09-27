package com.amqbroker.demo.broker;

import com.amqbroker.demo.dto.Transaction;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class TransactionListener {

    @JmsListener(destination = "mySMS")
    public void listenMessage(String data){
        log.info("Received: {}", data);
    }
    @JmsListener(destination = "transactions",containerFactory="myFactory")
    public  void receiveTransaction(Transaction data){
        log.info("Received: {}", data);
    }



}
