package com.boot.drools.react.controller;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.drools.react.droolsconfig.DroolsConfig;
import com.boot.drools.react.model.Decision;

@RestController
public class RestMainController {
	
	@Autowired
	private DroolsConfig droolsConfig;
	
	@RequestMapping(value = "/drools", method = RequestMethod.GET)
	public Decision getDecision(@RequestParam("value") int value) throws DroolsParserException, IOException {
		System.out.println(value);
		return droolsConfig.executeDrools(value);
	}
 
}
