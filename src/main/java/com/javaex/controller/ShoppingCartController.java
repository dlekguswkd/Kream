package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.ShoppingCartService;
import com.javaex.vo.ShoppingCartVo;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	/* 장바구니 리스트 가져오기 */
	@RequestMapping(value = "/shoppingcart", method = { RequestMethod.GET, RequestMethod.POST })
	public String shoppingCartForm(HttpSession session, Model model) {
		System.out.println("ShoppingCartController.shoppingCartForm()");

		// 로그인한 session 값을 객체로 가져오기
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		// 로그인한 회원의 session으로 조회해야함 수정 필요
		List<ShoppingCartVo> shoppingList = shoppingCartService.exeGetShoppingList(authUser.getUserNo());
		int totalCnt = shoppingCartService.exeSelectTotalCnt(authUser.getUserNo());

		model.addAttribute("shoppingList", shoppingList);
		model.addAttribute("totalCnt", totalCnt);
		System.out.println(shoppingList);

		return "shoppingCart/shoppingCart";
	}

	/* 장바구니 삭제 */
	@RequestMapping(value = "/shoppingcart/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String shoppingCartDelete(HttpSession session, @RequestParam(value = "cartNo") int cartNo) {
		System.out.println("ShoppingCartController.shoppingCartDelete()");

		// 로그인한 session 값을 객체로 가져오기
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		shoppingCartService.exeShoppingDelete(cartNo);

		// 리다이렉트 해야함
		return "redirect:/shoppingcart?userNo=" + authUser.getUserNo();
	}

	/* 신발 사이즈 옵션 업데이트 */
	@ResponseBody
	@RequestMapping(value = "/api/shoppingcart/update", method = { RequestMethod.GET, RequestMethod.POST })
	public int shoppingCartUpdate(HttpSession session, @ModelAttribute ShoppingCartVo shoppingCartVo) {
		System.out.println("ShoppingCartController.shoppingCartVo()");

		// 로그인한 session 값을 객체로 가져오기
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		int count = shoppingCartService.exeShoppingUpdate(shoppingCartVo.getProdSize(), authUser.getUserNo());

		// 리다이렉트 해야함
		return count;
	}

}
