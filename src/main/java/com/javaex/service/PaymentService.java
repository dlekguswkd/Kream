package com.javaex.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PaymentDao;
import com.javaex.vo.PurchaseVo;
import com.javaex.vo.ShoppingCartVo;
import com.javaex.vo.UserVo;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	// 구매하기 폼
	public Map<String, Object> exePayment(UserVo userVo) {

		// 1. 유저 번호로 장바구니 조회
		List<ShoppingCartVo> shoppingList = paymentDao.selectShoppingList(userVo.getUserNo());
		
		// user가 추가한 상품 리스트중에 첫번째 shoppingCart의 cartNo를 가져온다.
		int reciptNo = shoppingList.get(0).getCartNo();
		int totalPrice = 0;
		
		System.out.println(shoppingList);
		
		for (int i = 0; i < shoppingList.size(); i++) {
			
			// 가져온 첫번째 reciptNo를 다른 리스트의 reciptNo에 똑같이 넣어준다.
			shoppingList.get(i).setReciptNo(reciptNo);
			
			// History(구매내역) 테이블에 insert
			paymentDao.insertPayment(shoppingList.get(i));
			
			// 총 상품금액 구하기
			totalPrice += shoppingList.get(i).getProdPrice();
		}
		
		// 3. 유저번호로 장바구니 삭제
		paymentDao.deleteShoppingCart(userVo.getUserNo());
		
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		pMap.put("userNo", userVo.getUserNo());
		pMap.put("reciptNo", reciptNo);

		// 4. 리스트 보여주기
		List<PurchaseVo> paymentList = paymentDao.selectPayment(pMap);
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		rMap.put("paymentList", paymentList);
		rMap.put("totalPrice", totalPrice);
		
		return rMap;
	}

}
