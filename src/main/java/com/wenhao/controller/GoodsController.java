/**
 * 
 */
package com.wenhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("/to_list")
	public String goodslist(Model model,TestUser user) {
		List<GoodsVo> goodsList = goodsService.listGoodsVo();
		model.addAttribute("user",user);
		model.addAttribute("goodsList",goodsList);
		return "goods_list";
	}
	
	@RequestMapping("/to_detail/{goodsId}")
	public String goodsdetail(Model model,TestUser user,@PathVariable("goodsId") long goodsId) {
		GoodsVo goodsVo = goodsService.getGoodsVoByGoodsId(goodsId);
		model.addAttribute("goods", goodsVo);
		model.addAttribute("user", user);
		
		long startAt = goodsVo.getStartDate().getTime();
		long endAt = goodsVo.getEndDate().getTime();
		
		long now = System.currentTimeMillis();
		
		int miaoshaStatus = 0;
		int remainSeconds = 0;
		
		if(now < startAt) {//还未开始
			miaoshaStatus = 0;
			remainSeconds = (int) ((startAt - now)/100);
		}else if(now > endAt) {//已经过期
			miaoshaStatus = 0;
			remainSeconds = -1;
		}else {//秒杀进行中
			miaoshaStatus = 1;
			remainSeconds = 0;
		}
		
		model.addAttribute("miaoshaStatus", miaoshaStatus);
		model.addAttribute("remainSeconds", remainSeconds);
		return "goods_detail";
	}
}
