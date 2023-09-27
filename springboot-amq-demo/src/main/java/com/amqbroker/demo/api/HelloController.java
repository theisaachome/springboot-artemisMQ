package com.amqbroker.demo.api;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@AllArgsConstructor
@RequestMapping("/api/messages")
public class HelloController {
    private  final JmsTemplate jmsTemplate;

    @PostMapping
    public String sendMessage(@RequestBody String data){
        log.info("Send this message to jms queue: " + data);
        jmsTemplate.convertAndSend("mySMS",data);
        return "Sent Message: "+ data;
    }

    @GetMapping("/queue/sendMessage")
    public String sendSMS(@RequestParam("message") String data){
        log.info("Send this message to jms queue: " + data);
        jmsTemplate.convertAndSend("mySMS",data);
        return "Sent SMS: "+ data;
    }
}
