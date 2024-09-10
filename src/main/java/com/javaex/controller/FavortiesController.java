package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
