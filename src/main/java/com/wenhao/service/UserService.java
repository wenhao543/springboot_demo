/**
 * 
 */
package com.wenhao.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wenhao.dao.TestUserMapper;
import com.wenhao.dto.CodeMsg;
import com.wenhao.emun.BizContant;
import com.wenhao.exception.GlobalException;
import com.wenhao.model.TestUser;
import com.wenhao.service.redis.RedisSerivce;
import com.wenhao.service.redis.key.UserKey;
import com.wenhao.utils.MD5Util;
import com.wenhao.utils.UUIDUtil;
import com.wenhao.vo.LoginVo;

/**
 * @author wenhao
 *
 */
@Service
public class UserService {
	
	@Autowired
	private TestUserMapper testUserMapper;

	@Autowired
	private RedisSerivce redisService;
	
	public final static String COOKIE_NAME = "USER_C";
	
	public boolean login(HttpServletResponse resp,LoginVo loginVo) {
		// TODO Auto-generated method stub
		String mobile = loginVo.getMobile();
		String password = loginVo.getPassword();
		
		TestUser user = testUserMapper.selectByPrimaryKey(Long.parseLong(mobile));
		if(user == null) {
			throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
		}
		//验证密码
		String salt = user.getSalt();
		String passwd = MD5Util.inputPassToDBPass(password, salt);
		String passworddb = user.getPassword();
		if(!passwd.equals(passworddb)) {
			throw new GlobalException(CodeMsg.PASSWORD_ERROR);
		}
		String token = UUIDUtil.uuid();
		addCookie(user, token, resp);
		return true;
	}

	public TestUser getByToken(String token,HttpServletResponse resp) {
		if(StringUtils.isEmpty(token)) {
			return null;
		}
		TestUser user = redisService.get(UserKey.getByToken, token, TestUser.class);
		if(user != null) {
			addCookie(user, token, resp);
		}
		return user;
	}
	
	public void addCookie(TestUser user,String token,HttpServletResponse resp) {
		redisService.set(UserKey.getByToken, token, user);
		Cookie cookie = new Cookie(COOKIE_NAME, token);
		cookie.setMaxAge(UserKey.getByToken.expireSeconds());
		cookie.setPath("/");
		resp.addCookie(cookie);
		
	}
	
	
}
