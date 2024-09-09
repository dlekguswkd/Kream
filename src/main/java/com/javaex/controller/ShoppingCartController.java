package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.ShoppingCartService;
import com.javaex.vo.ShoppingCartVo;

@Controller
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	/* 장바구니 리스트 가져오기 */
	@RequestMapping(value = "/shoppingcart", method = { RequestMethod.GET, RequestMethod.POST })
	public String shoppingCartForm(@RequestParam(value="userNo") int userNo, Model model) {
		System.out.println("ShoppingCartController.shoppingCartForm()");
		
		// 로그인한 회원의 session으로 조회해야함 수정 필요
		List<ShoppingCartVo> shoppingList = shoppingCartService.exeGetShoppingList(userNo);
		int totalCnt = shoppingCartService.exeSelectTotalCnt(userNo);
		
		model.addAttribute("shoppingList", shoppingList);
		model.addAttribute("totalCnt", totalCnt);
		
		return "shoppingCart/shoppingCart";
	}
	
	/* 장바구니 삭제 */
	@RequestMapping(value = "/shoppingcart/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String purchaseDelete(@RequestParam(value = "cartNo") int cartNo) {
		System.out.println("UserInfoController.purchaseDelete()");
		
		shoppingCartService.exeShoppingDelete(cartNo);
	
		// 리다이렉트 해야함
		return "redirect:http://localhost:8888/kream/shoppingcart?userNo=2";
	}
	

}
