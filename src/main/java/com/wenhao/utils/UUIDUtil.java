/**
 * 
 */
package com.wenhao.utils;

import java.util.UUID;

/**
 * @author admin
 *
 */
public class UUIDUtil {
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
