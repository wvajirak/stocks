package com.wvajirak.core;

import com.wvajirak.enums.TradeType;

import java.util.Date;

/**
 * Trade class for provide trade related functionalities.
 * Created by Vajira Kuruppuarachchi on 01/11/2016.
 */
public class Trade {

    private Date timeStamp;
    private TradeType type;
    private Integer quantity;
    private Double price;
    private Stock stock;

    /**
     * Constructor for Trade.
     * @param timeStamp
     * @param type
     * @param quantity
     * @param price
     * @param stock
     */
    public Trade(Date timeStamp, TradeType type, Integer quantity, Double price, Stock stock) {
        this.timeStamp = timeStamp;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Trade { " +
                "timeStamp = " + timeStamp +
                ", type = " + type +
                ", quantity = " + quantity +
                ", price = " + price +
                ", stock = " + stock.getSymbol() +
                " }";
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public TradeType getType() {
        return type;
    }

    public void setType(TradeType type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
