/**
 * 
 */
package com.wenhao.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.util.StringUtils;
import com.wenhao.model.TestUser;
import com.wenhao.service.UserService;
import com.wenhao.service.redis.RedisSerivce;
import com.wenhao.service.redis.key.UserKey;

/**
 * @author admin
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private RedisSerivce redisService;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/orderlist")
	public String orderlist(Model model,TestUser user
//			,
//			@CookieValue(value=UserService.COOKIE_NAME,required = false) String cookieToken,
//			@RequestParam(value=UserService.COOKIE_NAME,required = false) String paramToken,
//			HttpServletResponse resp
			) {
//		if(StringUtils.isEmpty(paramToken)&&StringUtils.isEmpty(cookieToken)) {
//			return "login";
//		}
		
//		String token = StringUtils.isEmpty(cookieToken)?paramToken:cookieToken;
//		redisService.set(UserKey.getByToken, token, user);
//		TestUser user = userService.getByToken(token,resp);
		if(user == null) {
			return "login";
		}
		model.addAttribute("user",user);
		return "orderlist";
	}
}
