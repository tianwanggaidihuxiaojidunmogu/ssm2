package com.racing.redis.exception;

public class RedisException extends RuntimeException {

	private static final long serialVersionUID = -2618585119309195085L;

	public RedisException() {

	}

	public RedisException(String message) {
		super(message);
	}

}
