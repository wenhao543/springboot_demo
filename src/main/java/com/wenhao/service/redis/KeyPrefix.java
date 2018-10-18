package com.wenhao.service.redis;

public interface KeyPrefix {

	public int expireSeconds();
	
	public String getPreifx();
}
