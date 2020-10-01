package com.project.springbootrabbitmq.services;

import com.project.springbootrabbitmq.models.MessageQueue;

public interface AmqpService {
    void sendToQueue(MessageQueue messageQueue);

    void consumeQueue(MessageQueue messageQueue);

    void resendToQueue();
}
