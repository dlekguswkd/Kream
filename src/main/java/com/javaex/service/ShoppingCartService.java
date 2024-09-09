package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.ShoppingCartDao;
import com.javaex.vo.ShoppingCartVo;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	/* 장바구니 리스트 가져오기 */
	public List<ShoppingCartVo> exeGetShoppingList(int userNo) {
		System.out.println("ShoppingCartService.exeGetShoppingList()");

		List<ShoppingCartVo> shoppingList = shoppingCartDao.selectShoppingList(userNo);

		return shoppingList;
	}
	
	/* 장바구니 전체 갯수 구하기 */
	public int exeSelectTotalCnt(int userNo) {
		System.out.println("ShoppingCartService.exeSelectTotalCnt()");

		int count = shoppingCartDao.selectTotalCnt(userNo);

		return count;
	}
	
	/* 장바구니 삭제 */
	public int exeShoppingDelete(int cartNo) {
		System.out.println("ShoppingCartService.exeShoppingDelete()");
		
		int count = shoppingCartDao.deleteShopping(cartNo);
		
		return count;
	}
	
	/* 신발 사이즈 옵션 업데이트 */
	public int exeShoppingUpdate(int prodSize, int userNo) {
		System.out.println("ShoppingCartService.exeShoppingUpdate()");
		
		int count = shoppingCartDao.updateShopping(prodSize, userNo);
		
		return count;
		
	}

}
