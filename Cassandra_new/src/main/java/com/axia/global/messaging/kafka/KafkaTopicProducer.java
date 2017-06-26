package com.axia.global.messaging.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

public class KafkaTopicProducer {

	private static Producer<Integer, String> producer;
    private final Properties properties = new Properties();

    public KafkaTopicProducer() {
        properties.put("metadata.broker.list", "localhost:9092");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("request.required.acks", "1");
        producer = new Producer<>(new ProducerConfig(properties));
    }

    public static void main(String[] args) {
        new KafkaTopicProducer();
        String topic = "axiatext";
        String msg = "Tes Messsage";
        KeyedMessage<Integer, String> data = new KeyedMessage<>(topic, msg);
        producer.send(data);
        producer.close();
    }
}
