package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.UserInfoService;
import com.javaex.vo.PurchaseVo;
import com.javaex.vo.UserVo;

@Controller
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	// 로그인 sessio으로 수정해야함. @RequestParam으로 임시 테스트
	
	/* 마이페이지 폼 */
	@RequestMapping(value = "/user/mypage", method = { RequestMethod.GET, RequestMethod.POST })
	public String myPageForm(@RequestParam(value = "userNo") int userNo, Model model) {
		System.out.println("UserInfoController.myPageForm()");
		
		// 로그인한 session 값을 객체로 가져오기
		// UserVo authUser = (UserVo)session.getAttribute("authUser");

		// session의 userNo 값으로 회원정보 가져오기
		UserVo userVo = userInfoService.exeUserInfo(userNo);
		
		// session의 userNo 값으로 구매내역 갯수 가져오기
		int totalCnt = userInfoService.exeSelectTotalCnt(userNo);
		int readyCnt = userInfoService.exeSelectReadyCnt(userNo);
		int finishCnt = userInfoService.exeSelectFinishCnt(userNo);
		
		model.addAttribute("userVo", userVo);
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("readyCnt", readyCnt);
		model.addAttribute("finishCnt", finishCnt);
		
		return "user/mypage";
	}

	/* 마이페이지 회원정보 수정폼 */
	@RequestMapping(value = "/user/userinfo", method = { RequestMethod.GET, RequestMethod.POST })
	public String modifyForm(@RequestParam(value = "userNo") int userNo, Model model) {
		System.out.println("UserInfoController.modifyForm()");

		// 로그인한 session 값을 객체로 가져오기
		// UserVo authUser = (UserVo)session.getAttribute("authUser");

		// session의 userNo 값으로 회원정보 가져오기
		UserVo userVo = userInfoService.exeUserInfo(userNo);

		model.addAttribute("userVo", userVo);

		return "user/userInfo";
	}

	// 세션으로 이용하는걸로 수정해야함 - 컨트롤러, 서비스
	/* 회원정보 수정 */
	@RequestMapping(value = "/user/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String modify(@ModelAttribute UserVo userVo) {
		System.out.println("UserInfoController.modify()");
		
		int count = userInfoService.exeUserModify(userVo);
		System.out.println(count);
		
		// UserVo authUser = userService.exeUserModify(userVo);
		
		// 수정된 회원정보를 session에 전달
		//session.setAttribute("authUser", authUser);

		return "user/mypage";
	}

	/* 마이페이지 구매내역 폼 */
	@RequestMapping(value = "/user/purchaselist", method = { RequestMethod.GET, RequestMethod.POST })
	public String purchaseListForm(@RequestParam(value = "userNo") int userNo, Model model) {
		System.out.println("UserInfoController.purchaseListForm()");
		
		// 회원의 세션번호로 구매내역 불러오기
		// 한사람이 여러개를 사면 결과값이 1개 이상이므로
		List<PurchaseVo> purchaseList = userInfoService.exeUserPurchase(userNo);
		
		model.addAttribute("purchaseList", purchaseList);
		
		return "user/purchaseList";
	}
	
	/* 마이페이지 구매내역 삭제 */
	@RequestMapping(value = "/user/purchasedelete", method = { RequestMethod.GET, RequestMethod.POST })
	public String purchaseDelete(@RequestParam(value = "historyNo") int historyNo) {
		System.out.println("UserInfoController.purchaseDelete()");
		
		userInfoService.exePurchaseDelete(historyNo);
	
		// 리다이렉트 해야함
		return "redirect:/user/purchaseList";
	}
	
	
}
