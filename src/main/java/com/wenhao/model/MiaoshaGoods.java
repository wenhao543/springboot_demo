package com.wenhao.model;

import java.math.BigDecimal;
import java.util.Date;

public class MiaoshaGoods {
    private Long id;

    private Long goodsId;

    private BigDecimal miaoshaoPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

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

	@Override
	public String toString() {
		return "MiaoshaGoods [id=" + id + ", goodsId=" + goodsId + ", miaoshaoPrice=" + miaoshaoPrice + ", stockCount="
				+ stockCount + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
    
}