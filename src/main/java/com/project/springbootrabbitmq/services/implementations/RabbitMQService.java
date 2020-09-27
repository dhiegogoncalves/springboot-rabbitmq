package com.project.springbootrabbitmq.services.implementations;

import com.project.springbootrabbitmq.amqp.Amqp;
import com.project.springbootrabbitmq.models.MessageQueue;
import com.project.springbootrabbitmq.services.AmqpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService implements AmqpService {

    @Autowired
    private Amqp<MessageQueue> amqp;

    @Override
    public void sendToQueue(MessageQueue messageQueue) {
        amqp.producer(messageQueue);
    }

    @Override
    public void action(MessageQueue messageQueue) {
        System.out.println("Msg: - ".concat(messageQueue.getText()));
    }
}
