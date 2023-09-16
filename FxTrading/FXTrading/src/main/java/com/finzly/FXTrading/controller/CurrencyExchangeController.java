package com.finzly.FXTrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.finzly.FXTrading.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	@Autowired
	CurrencyExchangeService ccyService;
	
	
	/**
	 * 
	 * @author Suraj Suryavanshi
	 * It calls the addCurrencyExchange method of a service (ccyService) to add a currency exchange rate.
	 * 
	 * If the operation is successful, it returns the string "Currency Pair Added Successfully" as the response.
	 * 
	 * If an exception of type RuntimeException is thrown during the execution, 
	 * it catches the exception, prints the stack trace, and returns the exception message as the response
	 */
	
	@PostMapping("currency-exchange/{currencyrate}")
	public String addCurrencyExchange(@PathVariable String currencyrate) {
		try {
			
			// Call the addCurrencyExchange method of the ccyService
			ccyService.addCurrencyExchange(currencyrate);
			
			 // If successful, return a success message
			return "Currency Pair Added Succesfully";
		}
		catch(RuntimeException e){
			
			// If an exception of type RuntimeException is thrown, catch it
			e.printStackTrace();
			
			// Return the exception message as a response
			return e.getMessage();
		}
	}
	
	
}
