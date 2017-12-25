package com.redhat.btison.enmasse.jms.consumer.sb.service;


public interface MessageConsumerService {

    void processMessage(String msg);

}
