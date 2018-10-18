package com.wenhao.controller;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.wenhao.dto.CodeMsg;
import com.wenhao.dto.Result;
import com.wenhao.emun.BizContant;
import com.wenhao.service.UserService;
import com.wenhao.utils.ValidatorUtil;
import com.wenhao.vo.LoginVo;

@Controller
@RequestMapping("login")
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("to_login")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("do_login")
	@ResponseBody
	public Result<CodeMsg> doLogin(HttpServletResponse resp,@Valid LoginVo loginVo){
		logger.info(loginVo.toString());
		
		//参数检验
		/*String mobile = loginVo.getMobile();
		String password = loginVo.getPassword();
		if(StringUtils.isEmpty(mobile)) {
			return Result.error(BizContant.RESP_CODE_1);
		}
		if(!ValidatorUtil.isMobile(mobile)) {
			return Result.error(BizContant.RESP_CODE_3);
		}
		if(StringUtils.isEmpty(password)) {
			return Result.error(BizContant.RESP_CODE_2);
		}*/
		
		userService.login(resp,loginVo);
//		if(!CodeMsg.SUCCESS.getCode().equals(cm.getCode())) {
//			return Result.error(cm);
//		}
		return Result.success(CodeMsg.SUCCESS);
	}

}
