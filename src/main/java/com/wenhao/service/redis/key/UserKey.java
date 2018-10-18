package com.wenhao.service.redis.key;

import com.wenhao.service.redis.BasePrefix;

public class UserKey extends BasePrefix{
	
	public static final int TOKEN_EXPRIE_TIME =  3600*24*2;

	public UserKey(String prefix) {
		super(prefix, 0);
	}
	
	public UserKey(String prefix, int expireSeconds) {
		super(prefix, expireSeconds);
	}
	
	public static UserKey getById = new UserKey("id");
	public static UserKey getByName = new UserKey("name");
	public static UserKey getByToken = new UserKey("token",TOKEN_EXPRIE_TIME);
	

}
