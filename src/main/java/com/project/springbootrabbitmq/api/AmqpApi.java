package com.project.springbootrabbitmq.api;

import com.project.springbootrabbitmq.models.MessageQueue;
import com.project.springbootrabbitmq.services.AmqpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmqpApi {

    @Autowired
    private AmqpService amqpService;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendToQueue(@RequestBody MessageQueue messageQueue) {
        amqpService.sendToQueue(messageQueue);
    }
}
