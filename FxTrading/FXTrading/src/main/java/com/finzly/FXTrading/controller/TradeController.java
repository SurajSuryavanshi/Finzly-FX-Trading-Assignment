package com.finzly.FXTrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.FXTrading.entity.Trade;
import com.finzly.FXTrading.service.TradeService;

@RestController
@RequestMapping("trade")
public class TradeController {
	
	
	@Autowired
	TradeService tradeService;
	
	/**
	 * 
	 * @author Suraj Suryvanshi
	 * this method attempts to call the doTrade method of the tradeService. 
	 * If successful, it returns the string "Trade booked successfully." 
	 * If an exception of type RuntimeException is thrown during the execution, 
	 * it prints the stack trace and returns the exception message.
	 */
	
	
	@PostMapping("do-trade")
	public String doTrade(@RequestBody Trade trade)
	{
		System.out.println();
		try{
			tradeService.doTrade(trade);
			return "Trade booked successfully";
		}
		catch(RuntimeException exception) {
			exception.printStackTrace();
			return exception.getMessage();
		}
	}
	
	
	/**
	 * @author Suraj Suryvanshi
	 * It calls the getBookedTradeList method of the tradeService 
	 * and returns the result all successfully booked trade list.
	 */
	
	@GetMapping("TradeList")
	public Object getBookedTradeList() {
		return tradeService.getBookedTradeList();
	}

}
