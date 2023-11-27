package com.amq.demo.config;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JMSConfig {


    @Value("${artemis.client.truststore}")
    private String trustStorePath;
//    @Value("${artemis.client.keystore}")
//    private String keyStorePath;
    @Value("${artemis.client.trustStorePass}")
    private String trustStorePass;

    @Bean
    public ActiveMQConnectionFactory jmsFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616?&" + "sslEnabled=true&" +
        "trustStorePath=" + trustStorePath + "&trustStorePassword="+trustStorePass);
        factory.setUser("admin");
        factory.setPassword("12345");
        factory.setRetryInterval(1000);
        factory.setRetryIntervalMultiplier(1.0);
        factory.setReconnectAttempts(-1);
        factory.setConfirmationWindowSize(10);
        return factory;
    }

}
