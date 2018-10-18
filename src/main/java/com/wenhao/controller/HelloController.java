package com.wenhao.controller;

import com.wenhao.dao.ProductInfoMapper;
import com.wenhao.dto.CodeMsg;
import com.wenhao.dto.Result;
import com.wenhao.emun.BizContant;
import com.wenhao.model.ProductInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Autowired
	private ProductInfoMapper productInfoMapper;

    @RequestMapping(value = "resultS")
    @ResponseBody
    public Result<String> returnResultS(){
        return Result.success("wenhao");
    }

    @RequestMapping(value = "resultF")
    @ResponseBody
    public Result<String> returnResultF(){
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @RequestMapping("hello")
    public String hello(Model model) {
        model.addAttribute("name","wenhao");
        return "hello";
    }
    
    @RequestMapping("dbtest")
    @ResponseBody
    public Result<ProductInfo> getProductInfo() {
    	ProductInfo product = productInfoMapper.selectByPrimaryKey("111111");
    	return Result.success(product);
    }
} 
