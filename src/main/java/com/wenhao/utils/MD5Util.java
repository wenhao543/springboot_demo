package com.wenhao.utils;

import java.security.MessageDigest;

public class MD5Util {
	public final static String md5(byte[] buffer) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(buffer);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	
	private static final String salt = "1a2b3c4d";
	
	public static String inputPassFormPass(String inputPass) {
		String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
		System.out.println(str);
		return md5(str.getBytes());
	}
	
	public static String inputPassToDBPass(String inputPass,String salt) {
		String str = salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
		return md5(str.getBytes());
	}
	
	public static String inputPassToFormPass(String formPass,String salt) {
		String pwdPre = inputPassFormPass(formPass);
		return inputPassToDBPass(pwdPre, salt);
	}
	
	public static void main(String[] args) {
		System.out.println(inputPassFormPass("111111"));
		System.out.println(inputPassToFormPass("111111","111111"));
	}
}
