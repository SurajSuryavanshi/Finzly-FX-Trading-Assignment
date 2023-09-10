package com.finzly.FXTrading.model;

import org.springframework.stereotype.Component;

@Component
public class Trade {
		private static long tradeCounter = 1L;
		private long tradeNo;
	    private String currencyPair;
	    private String customerName;
	    private double amount;
	    private double rate=66.00;
	    
	    private double indianAmount;
	    
	    public Trade() {
	    	
	    }
	    
	    public Trade(String currencyPair, String customerName, double amount, double rate) {
	        this.tradeNo = tradeCounter++;
	        this.currencyPair = currencyPair;
	        this.customerName = customerName;
	        this.amount = amount;
	        this.rate = rate;
	    }

	    public long getTradeNo() {
	        return tradeNo;
	    }

	    public void setTradeNo1(long tradeNo) {
	        this.tradeNo = tradeNo;
	    }

	    public String getCurrencyPair() {
	        return currencyPair;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public double getRate() {
	        return rate;
	    }

	    public void setRate(double rate) {
	        this.rate = rate;
	    }
	    public double getIndianAmount() {
	    	return indianAmount;
	    }
	    public void setIndianAmount(double indianAmount) {
	    	this.indianAmount=indianAmount;
			
		}
	}