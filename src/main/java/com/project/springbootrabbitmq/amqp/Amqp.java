package com.project.springbootrabbitmq.amqp;

public interface Amqp<T> {

    void producer(T t);

    void consumer(T t);
}
