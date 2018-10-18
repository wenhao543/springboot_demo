/**
 * 
 */
package com.wenhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.util.StringUtils;
import com.wenhao.model.TestUser;
import com.wenhao.service.GoodsService;
import com.wenhao.service.UserService;
import com.wenhao.service.redis.RedisSerivce;
import com.wenhao.service.redis.key.UserKey;
import com.wenhao.vo.GoodsVo;

/**
 * @author admin
 *
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/to_list")
	public String goodslist(Model model,TestUser user) {
		List<GoodsVo> goodsList = goodsService.listGoodsVo();
		model.addAttribute("goodsList",goodsList);
		return "goods_list";
	}
	
	@RequestMapping("/to_detail/{goodsId}")
	public String goodsdetail(Model model,TestUser user,@PathVariable("goodsId") long goodsId) {
		
		return "goods_detail";
	}
}
