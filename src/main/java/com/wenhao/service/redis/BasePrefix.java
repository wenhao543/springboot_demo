/**
 * 
 */
package com.wenhao.service.redis;

/**
 * @author wenhao
 *
 */
public abstract class BasePrefix implements KeyPrefix {
	
	private String prefix;
	
	private int expireSeconds;
	
	public BasePrefix(String prefix, int expireSeconds) {
		this.prefix = prefix;
		this.expireSeconds = expireSeconds;
	}

	/* (non-Javadoc)
	 * @see com.wenhao.service.redis.KeyPrefix#expireSeconds()
	 */
	@Override
	public int expireSeconds() {//默认0表示永不过期
		return expireSeconds;
	}

	/* (non-Javadoc)
	 * @see com.wenhao.service.redis.KeyPrefix#getPreifx()
	 */
	@Override
	public String getPreifx() {
		String className = getClass().getSimpleName();
		return className+":"+prefix;
	}

}
