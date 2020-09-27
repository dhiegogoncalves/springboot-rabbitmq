package com.project.springbootrabbitmq.services;

import com.project.springbootrabbitmq.models.MessageQueue;

public interface AmqpService {
    void sendToQueue(MessageQueue messageQueue);

    void action(MessageQueue messageQueue);
}
