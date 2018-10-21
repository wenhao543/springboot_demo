package com.wenhao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wenhao.dto.Result;
import com.wenhao.model.TestUser;
import com.wenhao.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/info")
	@ResponseBody
	public Result<TestUser> info(Model model,TestUser user){
		logger.info("获取用户ID:"+user.getId()+"");
		return Result.success(user);
	}
}
