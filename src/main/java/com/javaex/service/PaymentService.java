package com.javaex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PaymentDao;
import com.javaex.vo.PurchaseVo;
import com.javaex.vo.ShoppingCartVo;

@Service
public class PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	// 구매하기 폼
	public List<PurchaseVo> exePayment(int userNo) {
		
		// 1. 유저 번호로 장바구니 조회
		List<ShoppingCartVo> shoppingList = paymentDao.selectShoppingList(userNo);

		// 2. 조회된 리스트를 History 테이블에 insert
		List<PurchaseVo> paymentList = new ArrayList<>(); // PurchaseVo 객체를 담을 리스트 생성
		for (ShoppingCartVo item : shoppingList) {
			PurchaseVo purchaseVo = new PurchaseVo();
			// 필요한 필드를 설정
			purchaseVo.setUserNo(userNo);
			purchaseVo.setProdNo(item.getProdNo());
			purchaseVo.setProdPrice(item.getProdPrice());
			purchaseVo.setProdSize(item.getProdSize());

			// History 테이블에 insert
			paymentDao.insertPayment(purchaseVo);

			// 결과 리스트에 추가
			paymentList.add(purchaseVo);
		}

		// 3. 유저번호로 장바구니 삭제
		paymentDao.deleteShoppingCart(userNo);

		// 4. 리스트 보여주기

		return paymentList;
	}

}
