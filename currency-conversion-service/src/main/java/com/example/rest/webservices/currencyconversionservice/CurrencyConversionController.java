package com.example.rest.webservices.currencyconversionservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyConversionController {
	private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);
	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeProxy proxy;
//	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,@PathVariable  BigDecimal quantity) {
//		
//		HashMap<String,String> uriVariables = new HashMap<>();
//		uriVariables.put("from",from );
//		uriVariables.put("to",to);
//		ResponseEntity<CurrencyConversion> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,uriVariables);
//		
//		CurrencyConversion currencyConversion = forEntity.getBody();
//		return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,currencyConversion.getConversionMultiple(),quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment());
//	}
	
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable("from") String from, @PathVariable("to") String to,@PathVariable  BigDecimal quantity) {
		logger.info("calculateCurrencyConversionFeign called with {} to {} with {}", from, to, quantity);

		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversion(currencyConversion.getId(), 
				from, to, quantity, 
				currencyConversion.getConversionMultiple(), 
				quantity.multiply(currencyConversion.getConversionMultiple()), 
				currencyConversion.getEnvironment() + " " + "feign");
	}

}
