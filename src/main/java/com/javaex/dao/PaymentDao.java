package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PurchaseVo;
import com.javaex.vo.ShoppingCartVo;

@Repository
public class PaymentDao {

	@Autowired
	private SqlSession sqlSession;

	/* 유저번호 장바구니 조회 */
	public List<ShoppingCartVo> selectShoppingList(int userNo) {
		System.out.println("PaymentDao.selectShoppingList");

		List<ShoppingCartVo> shoppingList = sqlSession.selectList("payment.selectShoppingList", userNo);

		return shoppingList;
	}

	// History 테이블에 결제 정보 삽입
	public int insertPayment(ShoppingCartVo shoppingCartVo) {

		int count = sqlSession.insert("payment.insertPayment", shoppingCartVo);

		return count;
	}

	// 장바구니 삭제
	public int deleteShoppingCart(int userNo) {

		int count = sqlSession.delete("payment.deleteShoppingCart", userNo);

		return count;
	}

	// 구매내역 조회
	public List<PurchaseVo> selectPayment(Map<String, Integer> pMap) {
		System.out.println(pMap);
		List<PurchaseVo> purchaseList = sqlSession.selectList("payment.selectPayment", pMap);

		return purchaseList;
	}

}
