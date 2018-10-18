package com.wenhao.exception;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wenhao.dto.CodeMsg;
import com.wenhao.dto.Result;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler
	public Result<String> exceptionHandler(HttpServletRequest request,Exception e){
		if(e instanceof GlobalException) {
			GlobalException ex = (GlobalException)e;
			Result.error(ex.getCodeMsg());
		}else if(e instanceof BindException) {
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
		}
		return null;
	}
}
