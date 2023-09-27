package com.amq.demo.api;


import com.amq.demo.broker.Message;
import com.amq.demo.service.ChatService;
import com.amq.demo.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/queue/chat/messages")
@RequiredArgsConstructor
public class ChatController {


    private  final ChatService messageService;

    @PostMapping
    public ResponseEntity<String> sendSMS(@RequestBody Message data){
        messageService.sendSMS(data);
        return  new ResponseEntity<>("Send! Message ", HttpStatus.OK);
    }
}
