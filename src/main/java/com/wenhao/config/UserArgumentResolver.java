/**
 * 
 */
package com.wenhao.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.wenhao.model.TestUser;
import com.wenhao.service.UserService;

/**
 * @author admin
 *
 */
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
	
	@Autowired
	UserService userSerivce;

	/* (non-Javadoc)
	 * @see org.springframework.web.method.support.HandlerMethodArgumentResolver#supportsParameter(org.springframework.core.MethodParameter)
	 */
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> clazz = parameter.getParameterType();
		return clazz == TestUser.class;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.method.support.HandlerMethodArgumentResolver#resolveArgument(org.springframework.core.MethodParameter, org.springframework.web.method.support.ModelAndViewContainer, org.springframework.web.context.request.NativeWebRequest, org.springframework.web.bind.support.WebDataBinderFactory)
	 */
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
		String paramToken = request.getParameter(UserService.COOKIE_NAME);
		String cookieToken = getCookieValue(request,UserService.COOKIE_NAME);
		if(StringUtils.isEmpty(paramToken)&&StringUtils.isEmpty(cookieToken)) {
			return null;
		}
		String token = StringUtils.isEmpty(cookieToken)?paramToken:cookieToken;
		return userSerivce.getByToken(token, response);
	}

	private String getCookieValue(HttpServletRequest request, String cookieName) {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookieName.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}
		return null;
	}

}
