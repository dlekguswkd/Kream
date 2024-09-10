package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.FavoritesDao;
import com.javaex.vo.FavoritesVo;

@Service
public class FavoritesService {

	@Autowired
	private FavoritesDao favoritesDao;

	/* 관심 상품 리스트 가져오기 */
	public List<FavoritesVo> exeGetList(int userNo) {
		System.out.println("FavoritesService.exeGetList()");

		List<FavoritesVo> favoritesList = favoritesDao.selectFavoritesList(userNo);

		return favoritesList;
	}

	/* 관심 상품 삭제 */
	public int exeFavoriteDelete(int favoriteNo, int userNo) {
		System.out.println("FavoritesService.exeFavoriteDelete()");

		int count = favoritesDao.deleteFavorites(favoriteNo, userNo);

		return count;
	}

	// 관심 상품 -> 장바구니 추가
	public int exeShoppingAdd(int favoriteNo, int userNo) {

		// 1. 유저 번호로 장바구니 조회
		List<FavoritesVo> favoritesList = favoritesDao.selectFavoritesList(favoriteNo, userNo);

		System.out.println(favoritesList);
		for (int i = 0; i < favoritesList.size(); i++) {
			// ShoppingCart 테이블에 insert
			favoritesDao.insertShoppingCart(favoritesList.get(i));
		}

		// 3. 유저번호로 관심 상품 삭제
		favoritesDao.deleteFavorites(favoriteNo, userNo);

		return 0;
	}

}
