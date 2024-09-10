package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.DetailService;
import com.javaex.vo.DetailVo;
import com.javaex.vo.ShoppingCartVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class DetailController {
	
	@Autowired
	private DetailService detailService;

	
	/* 상품설명 메인폼 */
	//http://localhost:8888/kream/detail/detailform
	@RequestMapping(value="/detail/detailform", method = {RequestMethod.GET, RequestMethod.POST})
	public String detailForm(HttpSession session, Model model) { // param
		System.out.println("DetailController.detailForm()");
		
		// 고른 상품 가져오기
		DetailVo prod = (DetailVo) session.getAttribute("prod");
		
		//List<ShoppingCartVo> shoppingList = shoppingCartService.exeGetShoppingList(authUser.getUserNo());
		//model.addAttribute("shoppingList", shoppingList);
		List<DetailVo> detailList = detailService.exeDetailList(prod.getProdNo());
		model.addAttribute("detailList", detailList);
		
		return "detail/detailList";
	}
		

	
}
