package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.MainService;
import com.javaex.vo.ProductVo;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;

	// Product listing with pagination
	@RequestMapping(value = "/main/mainform", method = { RequestMethod.GET, RequestMethod.POST })
	public String productList(Model model,
			@RequestParam(value = "crtpage", required = false, defaultValue = "1") int crtPage) {

		// Fetch product list with pagination, brands, and colors
		Map<String, Object> pMap = mainService.getProductList(crtPage);
		List<ProductVo> popularProducts = mainService.getPopularProductsByBrand();

		// Add to model for JSP
		model.addAttribute("pMap", pMap);
		model.addAttribute("popularProductList", popularProducts);

		return "main/MainPage";
	}

	// Filtering products by brand
	@RequestMapping(value = "/main/mainpageFiltered", method = { RequestMethod.GET, RequestMethod.POST })
	public String filterProductByBrand(@RequestParam(value = "brandNo", required = false) List<Integer> brandNos,
			@RequestParam(value = "crtpage", required = false, defaultValue = "1") int crtPage, Model model) {

		Map<String, Object> filterCriteria = new HashMap<>();
		filterCriteria.put("brandNos", brandNos);
		filterCriteria.put("crtPage", crtPage);

		// Fetch filtered product list
		Map<String, Object> pMap = mainService.getFilteredProducts(filterCriteria);
		List<ProductVo> popularProducts = mainService.getPopularProductsByBrand();

		// Add to model for JSP
		model.addAttribute("pMap", pMap);
		model.addAttribute("popularProductList", popularProducts);

		return "main/MainPageFiltered";
	}

	@RequestMapping(value = "/product/detail", method = { RequestMethod.GET, RequestMethod.POST })
	public String productDetail(@RequestParam("prodNo") int prodNo, Model model) {
		// 상품 정보를 가져온다
		ProductVo product = mainService.getProductDetail(prodNo);

		// JSP에 상품 정보를 전달
		model.addAttribute("product", product);
		return "detail/detailList"; // JSP 파일 경로
	}

	/* 장바구니 이동 버튼을 누르면 ShoppingCart 테이블에 insert */
	@RequestMapping(value = "/api/shoppingcart/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String shoppingCartInsert(HttpSession session, @ModelAttribute ProductVo procudtVo) {
		System.out.println("MainController.paymentInsert()");

		System.out.println(procudtVo);

		// 로그인한 session 값을 객체로 가져오기
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		System.out.println(authUser);
		if (authUser == null) {
			return "redirect:/user/loginform";
		}

		//mainService.exeShoppingCartInsert(authUser.getUserNo(), procudtVo.getProdNo(), procudtVo.getProdSize());

		return "redirect:/product/detail";
	}
	
	/* 관심상품 버튼을 누르면 Favorites 테이블에 insert */
	@RequestMapping(value = "/api/favorites/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String FavoritesInsert(HttpSession session, @ModelAttribute ProductVo procudtVo) {
		System.out.println("MainController.FavoritesInsert()");

		System.out.println(procudtVo);

		// 로그인한 session 값을 객체로 가져오기
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		System.out.println(authUser);
		if (authUser == null) {
			return "redirect:/user/loginform";
		}

		mainService.exeFavoritesInsert(authUser.getUserNo(), procudtVo.getProdNo(), procudtVo.getProdSize());

		return "redirect:/product/detail";
	}

}
