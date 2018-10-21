package com.wenhao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wenhao.dto.CodeMsg;
import com.wenhao.model.MiaoshaOrder;
import com.wenhao.model.OrderInfo;
import com.wenhao.model.TestUser;
import com.wenhao.service.GoodsService;
import com.wenhao.service.MiaoshaService;
import com.wenhao.service.OrderService;
import com.wenhao.vo.GoodsVo;

@Controller
@RequestMapping("miaosha")
public class MiaoShaController {
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MiaoshaService miaoshaSercie;
	
	@RequestMapping("do_miaosha")
	public String toMiaosha(Model model,TestUser user,@RequestParam("goodsId") long goodsId) {
		model.addAttribute("user", user);
		if(user == null) {
			return "login";
		}
		//判断库存
		GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
		int stock = goods.getStockCount();
		if(stock <= 0) {
			model.addAttribute("errmsg", CodeMsg.MIAOSHA_OVER.getMsg());
			return "miaosha_fail";
		}
		//判断是否已经秒杀到了
		MiaoshaOrder order = miaoshaSercie.getMiaoshaOrderByUserIdAndGoodsId(user.getId(),goodsId);
		if(order != null) {
			model.addAttribute("errmsg", CodeMsg.MIAOSHA_REPEAT.getMsg());
			return "miaosha_fail";
		}
		//1.减库存
		OrderInfo orderInfo = miaoshaSercie.miaosha(user,goods);
		model.addAttribute("orderInfo", orderInfo);
		model.addAttribute("goods", goods);
		return "order_detail";
	}
}
