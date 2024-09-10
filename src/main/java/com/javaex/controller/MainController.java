package com.javaex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.MainService;
import com.javaex.vo.ProductVo;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    // Product listing with pagination
    @RequestMapping(value = "/main/mainform", method = {RequestMethod.GET, RequestMethod.POST})
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
    @RequestMapping(value = "/main/mainpageFiltered", method = {RequestMethod.GET, RequestMethod.POST})
    public String filterProductByBrand(@RequestParam(value = "brandNo", required = false) List<Integer> brandNos,
                                       @RequestParam(value = "crtpage", required = false, defaultValue = "1") int crtPage,
                                       Model model) {

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
    
  
    
    @RequestMapping(value = "/product/detail", method = {RequestMethod.GET, RequestMethod.POST})
    public String productDetail(@RequestParam("prodNo") int prodNo, Model model) {
        // 상품 정보를 가져온다
        ProductVo product = mainService.getProductDetail(prodNo);

        // JSP에 상품 정보를 전달
        model.addAttribute("product", product);
        return "detail/detailList"; // JSP 파일 경로
    }    
   
}
