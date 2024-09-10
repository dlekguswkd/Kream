package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PaymentDao;
import com.javaex.dao.ShoppingCartDao;
import com.javaex.vo.PurchaseVo;
import com.javaex.vo.ShoppingCartVo;

@Service
public class PaymentService {
	
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	private PaymentDao paymentDao;
	
	public String exePayment(int userNo) {
		
		// 1. 유저 번호로 장바구니 조회
		List<ShoppingCartVo> shoppingList = shoppingCartDao.selectShoppingList(userNo);
		
		// 2. 조회된 리스트를 History 테이블에 insert
		
		// 3. 유저번호로 장바구니 삭제

		//4. 리스트 보여주기
		
		return "";
	}

}
