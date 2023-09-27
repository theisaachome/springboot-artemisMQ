package com.amqbroker.demo.api;


import com.amqbroker.demo.dto.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.jms.TextMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.activemq.artemis.commons.shaded.json.JsonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/transactions")
@Log4j2
public class TransactionController {

    private  final JmsTemplate jmsTemplate;


    @PostMapping
    public ResponseEntity<String> makeTransaction(@RequestBody Transaction data){
        log.info("Send message to jms queue: " + data);
        jmsTemplate.send("transactions",mc->{
            try{
                TextMessage tm = mc.createTextMessage(new ObjectMapper().writeValueAsString(data));
                tm.setJMSType(Transaction.class.getTypeName());
                tm.setStringProperty("mytypeid", Transaction.class.getTypeName());
                return tm;
            }catch (JsonProcessingException e){
                throw new RuntimeException(e);
            }
        });
        return  new ResponseEntity<>("Transfer ", HttpStatus.CREATED);
    }
}
