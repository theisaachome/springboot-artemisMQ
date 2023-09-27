package com.amq.demo.api;

import com.amq.demo.broker.Message;
import com.amq.demo.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/queue/")
@RequiredArgsConstructor
public class MessageController {

    private  final MessageService messageService;
    @GetMapping("/messages")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String data){
        messageService.sendMessage(data);
        return  new ResponseEntity<>("Send! Message ", HttpStatus.OK);
    }

    @PostMapping("/messages")
    public ResponseEntity<String> sendSMS(@RequestBody String data){
        messageService.sendSMS(data);
        return  new ResponseEntity<>("Send! Message ", HttpStatus.OK);
    }

}
