package com.diamondmarket.users.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diamondmarket.users.model.Response;



public interface DiamondClient {

	@RequestMapping(value = "/supplier", 
			produces = { "application/json" },
	        method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Response> deleteSupplier(@RequestHeader HttpHeaders httpHeaders, @RequestParam("supplierId") String supplierId);
	
	
	
}
