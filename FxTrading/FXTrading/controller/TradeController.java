package com.finzly.FXTrading.controller;
import com.finzly.FXTrading.model.Trade;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

	 private final List<Trade> trades = new ArrayList<>();
	    private long tradeCounter = 1;

	    @PostMapping("/book")
	    public ResponseEntity<Object> bookTrade(@RequestBody Trade trade) {
	        
	        if (!isValidName(trade.getCustomerName())) {
	            return ResponseEntity.badRequest().body("Invalid customer name.");
	        }

	        if (!isValidCurrencyPair(trade.getCurrencyPair())) {
	            return ResponseEntity.badRequest().body("Invalid currency pair. Only USDINR is supported.");
	        }

	        if (trade.getAmount() <= 0) {
	            return ResponseEntity.badRequest().body("Amount must be greater than 0.");
	        }
	        double indianAmount=trade.getAmount()*trade.getRate();
	        trade.setIndianAmount(indianAmount);
	        trade.setTradeNo1(tradeCounter++);

	        // Add trade to the list
	        trades.add(trade);

	        return ResponseEntity.status(HttpStatus.CREATED).body(trade);
	    }

	    @GetMapping("/list")
	    public ResponseEntity<List<Trade>> listTrades() {
	        return ResponseEntity.ok(trades);
	    }

	    private boolean isValidName(String name) {
	        
	        String regex = "^[a-zA-Z\\s]+$";
	        // Create a Pattern object
	        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
	        java.util.regex.Matcher matcher = pattern.matcher(name);

	        // Check if the input matches the pattern
	        return matcher.matches();
	    }

	    private boolean isValidCurrencyPair(String currencyPair) {
	        return currencyPair.equals("USDINR");
	    }
	}