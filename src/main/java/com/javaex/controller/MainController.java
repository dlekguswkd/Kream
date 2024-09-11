package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		// 선택한 상품의 같은 카테고리 시리즈 가져오기
		List<ProductVo> productSeries = mainService.exeGetProductSeries(prodNo);

		// JSP에 상품 정보를 전달
		model.addAttribute("product", product);
		model.addAttribute("productSeries", productSeries);
		
		return "detail/detailList"; // JSP 파일 경로
	}

	/* 구매하기 버튼을 누르면 History 테이블에 insert */
	@RequestMapping(value = "/api/shoppingcart/insert", method = RequestMethod.POST)
	public ResponseEntity<String> paymentInsert(HttpSession session, @RequestBody ProductVo productVo) {
	    System.out.println("MainController.paymentInsert()");

	    System.out.println(productVo);

	    // 로그인한 session 값을 객체로 가져오기
	    UserVo authUser = (UserVo) session.getAttribute("authUser");
	    System.out.println(authUser);
	    if (authUser == null) {
	        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
	    }

	    mainService.exeShoppingCartInsert(authUser.getUserNo(), productVo.getProdNo(), productVo.getProdSize());

	    return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	
	@RequestMapping(value = "/api/favorite/insert", method = RequestMethod.POST)
	public ResponseEntity<String> favoriteInsert(HttpSession session, @RequestBody ProductVo productVo) {
	    System.out.println("MainController.favoriteInsert()");

	    System.out.println(productVo);

	    // 로그인한 session 값을 객체로 가져오기
	    UserVo authUser = (UserVo) session.getAttribute("authUser");
	    System.out.println(authUser);
	    if (authUser == null) {
	        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
	    }

	    mainService.exefavoriteInsert(authUser.getUserNo(), productVo.getProdNo(), productVo.getProdSize());

	    return new ResponseEntity<>("Success", HttpStatus.OK);
	}


}
