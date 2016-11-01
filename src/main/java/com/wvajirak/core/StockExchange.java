package com.wvajirak.core;

import com.wvajirak.enums.StockType;
import com.wvajirak.enums.TradeType;

import java.util.*;

/**
 * Stock Exchange class provide stock and trade management functionalities.
 *
 * Created by Vajira Kuruppuarachchi on 01/11/2016.
 */
public class StockExchange {
    private ArrayList<Stock> stocks;
    private TreeMap<Date, Trade> trades;

    /**
     * Constructor for StockExchange.
     * this generate sample stock items(as given in the requirements).
     */
    public StockExchange() {
        stocks = new ArrayList<Stock>();
        trades = new TreeMap<Date, Trade>();
        generateSampleStock();
    }

    public Double stockPrice(){
        Double stockPrice = 0.0;
        Date now = new Date();
        Date startTime = new Date(now.getTime() - (15 * 60 * 1000));
        SortedMap<Date, Trade> tempTrades = this.trades.tailMap(startTime);

        Integer quantity = 0;
        Double price = 0.0;
        for (Trade trade: trades.values()) {
            price += trade.getPrice() * trade.getQuantity();
            quantity += trade.getQuantity();
        }
        stockPrice = price / quantity;
        return stockPrice;
    }

    public double calculateGBCE(){
        Double stockValuesMultiplications = 1.0;
        for (Stock stock: stocks) {
            stockValuesMultiplications *= stock.getLastPrice();
        }

        return Math.pow(stockValuesMultiplications, 1.0 / stocks.size());
    }

    public void buyStock(Integer quantity, Double price){
        recordTrade(quantity, price, TradeType.BUY);
    }

    public void sellStock(Integer quantity, Double price){
        recordTrade(quantity, price, TradeType.SELL);
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public TreeMap<Date, Trade> getTrades() {
        return trades;
    }

    private void generateSampleStock(){
        stocks.add(new Stock("TEA", StockType.COMMON, 0.0, 0.0, 100.0, 100.0));
        stocks.add(new Stock("POP", StockType.COMMON, 8.0, 0.0, 100.0, 100.0));
        stocks.add(new Stock("ALE", StockType.COMMON, 23.0, 0.0, 60.0, 60.0));
        stocks.add(new Stock("GIN", StockType.PREFERRED, 8.0, 0.2, 100.0, 100.0));
        stocks.add(new Stock("JOE", StockType.COMMON, 13.0, 0.0, 250.0, 250.0));
    }

    private void recordTrade(Integer quantity, Double price, TradeType type) {
        Integer size = stocks.size();
        Random random = new Random();
        Integer index = random.nextInt(size);
        Trade trade = new Trade(new Date(), type, quantity, price, stocks.get(index));
        Stock temp = stocks.get(index);
        temp.setLastPrice(price);
        stocks.set(index, temp);
        this.trades.put(trade.getTimeStamp(), trade);
        System.out.println("New Trade happened... " + trade.toString());
    }


}
