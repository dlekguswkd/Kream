package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.FavoritesService;
import com.javaex.vo.FavoritesVo;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class FavortiesController {

	@Autowired
	private FavoritesService favoritesService;

	/* 관심 페이지 폼 */
	@RequestMapping(value = "/favorites", method = { RequestMethod.GET, RequestMethod.POST })
	public String favoritesForm(HttpSession session, Model model) {
		System.out.println("FavortiesController.favoritesForm()");

		// 로그인한 session 값을 객체로 가져오기
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		if (authUser == null) {
			return "redirect:/user/loginform";
		} else {
			List<FavoritesVo> favoritesList = favoritesService.exeGetList(authUser.getUserNo());

			model.addAttribute("favoritesList", favoritesList);

			return "favorites/favorites";
		}

	}

	/* 관심 삭제 */
	@RequestMapping(value = "/favorites/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String favoritesDelete(HttpSession session, @RequestParam(value = "favoriteNo") int favoriteNo) {
		System.out.println("FavortiesController.shoppingCartDelete()");

		// 로그인한 session 값을 객체로 가져오기
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		int count = favoritesService.exeFavoriteDelete(favoriteNo, authUser.getUserNo());

		// 리다이렉트 해야함
		return "redirect:/favorites?userNo=" + authUser.getUserNo();
	}

	/* 관심 상품을 장바구니에 추가 */
	@RequestMapping(value = "/shoppingcart/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String addProductToCart(@RequestParam(value = "userNo") int userNo, @RequestParam(value = "favoriteNo") int favoriteNo) {
		System.out.println("ShoppingCartController.addProductToCart()");

		// 로그인한 session 값을 객체로 가져오기
		//UserVo authUser = (UserVo) session.getAttribute("authUser");

		System.out.println(favoriteNo);
		favoritesService.exeShoppingAdd(favoriteNo, userNo);

		// 장바구니 페이지로 리다이렉트
		return "redirect:/shoppingcart";
	}

}
