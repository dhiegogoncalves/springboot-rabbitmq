package com.project.springbootrabbitmq.api;

import com.project.springbootrabbitmq.models.MessageQueue;
import com.project.springbootrabbitmq.services.AmqpService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController()
@RequestMapping("/messages")
@RequiredArgsConstructor
public class AmqpApi {

    private final AmqpService amqpService;

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendToQueue(@RequestBody MessageQueue messageQueue) {
        amqpService.sendToQueue(messageQueue);
    }

    @PostMapping("/resend")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void resendToQueue() {
        amqpService.resendToQueue();
    }
}
