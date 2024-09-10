package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.PaymentService;
import com.javaex.vo.PurchaseVo;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	/* 구매하기 버튼 */
	@RequestMapping(value = "/paymentform", method = { RequestMethod.GET, RequestMethod.POST })
	public String shoppingCartPayment(HttpSession session, Model model) {
		System.out.println("ShoppingCartController.shoppingCartPayment()");

		// 로그인한 session 값을 객체로 가져오기
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		List<PurchaseVo> purchaseList = paymentService.exePayment(authUser);

		model.addAttribute("purchaseList", purchaseList);

		return "payment/paymentForm";
		// return "redirect:/payment/paymentForm?userNo=" + authUser.getUserNo();
	}
}
