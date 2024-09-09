package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	
	@RequestMapping(value = "/paymentform", method = { RequestMethod.GET, RequestMethod.POST }) 
	public String paymentForm() {
		
		return "payment/paymentForm";
	}
}
