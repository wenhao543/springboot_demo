/**
 * 
 */
package com.wenhao.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.wenhao.validator.IsMobileNo;

/**
 * @author wenhao
 *
 */
public class LoginVo {

	@NotNull
	@IsMobileNo
	private String mobile;
	@NotNull
	private String password;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginVo [mobile=" + mobile + ", password=" + password + ", getMobile()=" + getMobile()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
