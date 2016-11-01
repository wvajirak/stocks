package com.wvajirak.core;

import com.wvajirak.enums.StockType;

/**
 * Stock Class to provide stock related functionalities
 *
 * Created by Vajira Kuruppuarachchi on 01/11/2016.
 */
public class Stock {
    private String symbol;
    private StockType type;
    private Double lastDividend;
    private Double fixedDividend;
    private Double parValue;
    private Double lastPrice;

    /**
     * Stock Constructor
     * @param symbol
     * @param type
     * @param lastDividend
     * @param fixedDividend
     * @param parValue
     * @param lastPrice
     */
    public Stock(String symbol, StockType type, Double lastDividend, Double fixedDividend, Double parValue, Double lastPrice) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
        this.lastPrice = lastPrice;
    }


    @Override
    public String toString() {
        return "Stock { " +
                "Symbol = " + this.symbol +
                ", Type = " + this.type +
                ", Last Dividend =: " +this.lastDividend +
                (this.type.equals(StockType.PREFERRED) ? (", Fixed Dividend =: " +  this.fixedDividend): "") +
                ", Par Value = " + this.parValue +
                ", Last Price = " + this.lastPrice +
                " }";
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public StockType getType() {
        return type;
    }

    public void setType(StockType type) {
        this.type = type;
    }

    public Double getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(Double lastDividend) {
        this.lastDividend = lastDividend;
    }

    public Double getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(Double fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    public Double getParValue() {
        return parValue;
    }

    public void setParValue(Double parValue) {
        this.parValue = parValue;
    }

    public Double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Double lastPrice) {
        this.lastPrice = lastPrice;
    }

    /**
     * Calculate the dividend yield for given price.
     * @return dividend yield
     */
    public Double dividendYield(){

        if((lastPrice != 0.0 ) && this.getType().equals(StockType.PREFERRED)){
            return this.getFixedDividend() * this.getParValue() / lastPrice;
        }
        else if ((lastPrice != 0.0 ) && this.getType().equals(StockType.COMMON)){
            return this.getLastDividend() / lastPrice;
        }
        else {
            return 0.0;
        }

    }

    /**
     * Calculate the P/E ratio for given ticker price.
     * @return p/e ratio
     */
    public Double PERatio() {
        return lastPrice / this.getLastDividend();
    }


}
