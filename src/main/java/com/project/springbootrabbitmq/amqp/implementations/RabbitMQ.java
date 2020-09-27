package com.project.springbootrabbitmq.amqp.implementations;

import com.project.springbootrabbitmq.amqp.Amqp;
import com.project.springbootrabbitmq.models.MessageQueue;
import com.project.springbootrabbitmq.services.AmqpService;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQ implements Amqp<MessageQueue> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpService amqpService;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Override
    public void producer(MessageQueue messageQueue) {
        try {
            rabbitTemplate.convertAndSend(exchange, queue, messageQueue);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(MessageQueue messageQueue) {
        try {
            amqpService.action(messageQueue);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
