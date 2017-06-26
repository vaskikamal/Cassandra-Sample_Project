package com.axia.global.messaging.kafka;

public class KakfaMessage {

	private Object message;
	private String groupId;

	/**
	 * 
	 * @param message
	 * @param groupId
	 */
	public KakfaMessage(Object message, String groupId) {
		super();
		this.message = message;
		this.groupId = groupId;
	}

	/**
	 * 
	 * @param message
	 * @param groupId
	 */
	public KakfaMessage(byte[] message, String groupId) {
		super();
		this.message = message;
		this.groupId = groupId;
	}
}
