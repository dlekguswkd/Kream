package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.AdminPageService;
import com.javaex.vo.ProductVo;
import com.javaex.vo.PurchaseVo;
import com.javaex.vo.UserVo;

@Controller
public class AdminPageController {

	@Autowired
	private AdminPageService adminPageService;

	@RequestMapping(value ="/admin/adminPage", method = {RequestMethod.GET, RequestMethod.POST} )
	public String adminPage(Model model) {
		System.out.println("AdminPageController.adminPage()");
		List<UserVo> userInfoList = adminPageService.exeGetUserInfoList();
		model.addAttribute("userInfoList",userInfoList);

		List<PurchaseVo> soldProductList = adminPageService.exeSaleHistoryList2();
		model.addAttribute("soldProductList",soldProductList);

		List<PurchaseVo> purchaseReqList = adminPageService.exePurchaseReq2();
		model.addAttribute("purchaseReqList",purchaseReqList);

		return "admin/adminPage";
	}



	//	@RequestMapping(value ="/admin/editUser", method = {RequestMethod.GET, RequestMethod.POST} )
	//	public String adminUserList(Model model) {
	//		System.out.println("AdminPageController.adminUserList()");
	//		List<UserVo> userList = adminPageService.exeGetUserList();
	//		model.addAttribute("userList",userList);
	//		return "admin/adminPage_editUser";
	//	}

	@RequestMapping(value ="/admin/editUser", method = {RequestMethod.GET, RequestMethod.POST} )
	public String adminUserList(Model model, 
			@RequestParam(value = "crtpage", required = false, defaultValue = "1") int crtPage) {
		System.out.println("AdminPageController.adminUserList()");

		Map<String, Object> pMap = adminPageService.getUserListWithPaging(crtPage);
		model.addAttribute("pMap", pMap);

		return "admin/adminPage_editUser";
	}



	// 유저 정보 업데이트
	@RequestMapping(value ="/admin/userInfoEdit", method = {RequestMethod.GET, RequestMethod.POST} )
	public String adminEditPage(Model model, @RequestParam("userNo") int userNo) {
		System.out.println("AdminPageController.adminEditPage()");
		UserVo userVo = adminPageService.exeGetUserInfo(userNo);
		model.addAttribute("userVo", userVo);
		return "admin/adminPage_userInfoEdit";
	}


	@RequestMapping(value = "/admin/updateUser", method = RequestMethod.POST)
	public String updateUserInfo(@RequestParam("userNo") int userNo,
			@RequestParam("user-name") String userName,
			@RequestParam("user-email") String userId,
			@RequestParam("user-password") String userPw,
			@RequestParam("user-address") String userAddress) {
		System.out.println("AdminPageController.updateUserInfo()");
		UserVo userVo = new UserVo(userNo, userId, userPw, userName, userAddress);
		adminPageService.exeUpdateUserInfo(userVo);
		// Redirect to /admin/editUser after update
		return "redirect:/admin/editUser";
	}

	@RequestMapping(value = "/admin/deleteUser", method = RequestMethod.POST)
	public String deleteUserInfo(@RequestParam("userNo") int userNo) {
		System.out.println("Deleting user with userNo: " + userNo);
		adminPageService.exeDeleteUserInfo(userNo);

		// Redirect to /admin/editUser after delete
		return "redirect:/admin/editUser";
	}



	@RequestMapping(value = "/admin/addItems", method = {RequestMethod.GET, RequestMethod.POST} )
	public String adminAddItems(Model model) {
		System.out.println("AdminPageController.adminAddItems()");
		List<String> brandName = adminPageService.exegetBrandName();
		model.addAttribute("brandName",brandName);
		return "admin/adminPage_addItems";
	}



	@RequestMapping(value = "/admin/addItems2", method = {RequestMethod.GET, RequestMethod.POST} )
	public String adminAddItems2(@RequestParam("brand") String brand,
			@RequestParam("category") String category,
			@RequestParam("price") int price,
			@RequestParam("release-date") String releaseDate,
			Model model) {
		System.out.println("AdminPageController.adminAddItems()");
		List<String> colorName = adminPageService.exegetColorName();
		model.addAttribute("colorName",colorName);
		model.addAttribute("brand",brand);
		model.addAttribute("category",category);
		model.addAttribute("price",price);
		model.addAttribute("releaseDate",releaseDate);

		return "admin/adminPage_addItems2";
	}

	@RequestMapping(value = "/admin/uploadItem", method = {RequestMethod.GET, RequestMethod.POST} )
	public String adminUploadItem(@RequestParam(value = "photo-upload") MultipartFile file,
			@RequestParam("brand") String brand,
			@RequestParam("category") String category,
			@RequestParam("price") int price,
			@RequestParam("color") String colorName,
			@RequestParam("english-name") String engName,
			@RequestParam("korean-name") String korName,
			@RequestParam("model-number") String modelNo,
			@RequestParam("releaseDate") String releaseDate	) {
		adminPageService.exeUpload(file, brand, category, price, colorName, engName, korName, modelNo, releaseDate);


		return "redirect:/admin/itemList";
	}





	//	@RequestMapping(value = "/admin/itemList", method = {RequestMethod.GET, RequestMethod.POST} )
	//	public String adminItemList(Model model) {
	//		List<ProductVo> itemList = adminPageService.exegetItemList();
	//		model.addAttribute("itemList",itemList);
	//
	//		return "admin/adminPage_itemList";
	//	}
	@RequestMapping(value = "/admin/itemList", method = {RequestMethod.GET, RequestMethod.POST} )
	public String adminItemList(Model model, 
			@RequestParam(value = "crtpage", required = false, defaultValue = "1") int crtPage) {
		System.out.println("AdminPageController.adminItemList()");

		Map<String, Object> pMap = adminPageService.getProductListWithPaging(crtPage);
		model.addAttribute("pMap", pMap);

		return "admin/adminPage_itemList";
	}

	@RequestMapping(value = "/admin/deleteProduct", method = {RequestMethod.GET, RequestMethod.POST} )
	public String adminDeleteProduct(@RequestParam(value ="prodNo") int prodNo) {
		adminPageService.exeDeleteProduct(prodNo);

		return "redirect:/admin/itemList";
	}





	//	@RequestMapping(value = "/admin/saleshistory", method = {RequestMethod.GET, RequestMethod.POST} )
	//	public String adminSalesHistory(Model model) {
	//		List<PurchaseVo> soldProductList = adminPageService.exeSaleHistory();
	//		model.addAttribute("soldProductList",soldProductList);
	//		return "admin/adminPage_saleHistory";
	//	}

	@RequestMapping(value = "/admin/saleshistory", method = {RequestMethod.GET, RequestMethod.POST})
	public String adminSalesHistory(Model model, 
			@RequestParam(value = "crtpage", required = false, defaultValue = "1") int crtPage) {
		System.out.println("AdminPageController.adminSalesHistory()");

		Map<String, Object> pMap = adminPageService.getSalesHistoryWithPaging(crtPage);
		model.addAttribute("pMap", pMap);

		return "admin/adminPage_saleHistory";
	}


//	@RequestMapping(value = "/admin/purchaseRequest", method = {RequestMethod.GET, RequestMethod.POST} )
//	public String adminPurchaseRequest(Model model) {
//		List<PurchaseVo> purchaseReqList = adminPageService.exePurchaseReq();
//		model.addAttribute("purchaseReqList",purchaseReqList);
//		return "admin/adminPage_purchaseReq";
//	}
	
	@RequestMapping(value = "/admin/purchaseRequest", method = {RequestMethod.GET, RequestMethod.POST})
	public String adminPurchaseRequest(Model model, 
	                                   @RequestParam(value = "crtpage", required = false, defaultValue = "1") int crtPage) {
	    System.out.println("AdminPageController.adminPurchaseRequest()");
	    
	    Map<String, Object> pMap = adminPageService.getPurchaseRequestWithPaging(crtPage);
	    model.addAttribute("pMap", pMap);

	    return "admin/adminPage_purchaseReq";
	}


	// 승인 처리
	@RequestMapping(value = "/admin/approvePurchase", method = RequestMethod.POST)
	public String approvePurchase(@RequestParam("historyNo") int historyNo) {
		// shippingStatus를 '배송완료'로 업데이트
		adminPageService.updateShippingStatus(historyNo, "배송완료");
		return "redirect:/admin/purchaseRequest";  // 승인 후 다시 구매 요청 목록 페이지로 이동
	}

	// 거부 처리
	@RequestMapping(value = "/admin/rejectPurchase", method = RequestMethod.POST)
	public String rejectPurchase(@RequestParam("historyNo") int historyNo) {
		// History 테이블에서 해당 기록 삭제
		adminPageService.deletePurchaseRequest(historyNo);
		return "redirect:/admin/purchaseRequest";  // 거부 후 다시 구매 요청 목록 페이지로 이동
	}






}
