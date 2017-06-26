package com.axia.global.messaging.kafka;

public interface TopicProducer {

	public void init();

	public void shutdown();

	public boolean publish(Object message, String groupId);

	public String getTopicName();

}
