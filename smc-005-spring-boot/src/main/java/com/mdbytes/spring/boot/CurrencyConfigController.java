package com.mdbytes.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigController {

	@Autowired
	private CurrencyServiceConfiguration currencyServiceConfig;

	@GetMapping("/config")
	public CurrencyServiceConfiguration retrieveAllCourses() {
		return currencyServiceConfig;

	}

}
