package com.wenhao.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.wenhao.model.Goods;

public class GoodsVo extends Goods{
	private String goodsId;
	
	private BigDecimal miaoshaoPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;

	public BigDecimal getMiaoshaoPrice() {
		return miaoshaoPrice;
	}

	public void setMiaoshaoPrice(BigDecimal miaoshaoPrice) {
		this.miaoshaoPrice = miaoshaoPrice;
	}

	public Integer getStockCount() {
		return stockCount;
	}

	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	@Override
	public String toString() {
		return "GoodsVo [goodsId=" + goodsId + ", miaoshaoPrice=" + miaoshaoPrice + ", stockCount=" + stockCount
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
