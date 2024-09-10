package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.FavoritesDao;
import com.javaex.vo.FavoritesVo;

@Service
public class FavoritesService {

	@Autowired
	private FavoritesDao favoritesDao;

	// Service
	public Map<String, Object> getPagedFavoritesList(int userNo, int crtPage) {
		System.out.println("FavoritesService.getPagedFavoritesList()");

		int listCnt = 5; // 한 페이지에 표시할 글 수
		crtPage = (crtPage > 0) ? crtPage : 1; // 현재 페이지 음수일 때 계산

		// 시작할 행 번호
		int startRowNo = (crtPage - 1) * listCnt;

		// DB로부터 가져올 데이터의 시작 행과 개수 정보를 Map에 저장
		Map<String, Integer> limitMap = new HashMap<>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		limitMap.put("userNo", userNo);

		// 관심 상품 리스트 가져오기
		List<FavoritesVo> favoritesList = favoritesDao.selectPagedFavoritesList(limitMap);

		// DB에서 전체 글 개수 가져오기
		int totalCnt = favoritesDao.selectTotalCnt(userNo);

		// 페이지당 버튼 개수
		int pageBtnCount = 5;

		// 마지막 페이지 번호 계산
		int endPageBtnNo = (int) Math.ceil((crtPage / (double) pageBtnCount)) * pageBtnCount;
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;

		// 다음 버튼 존재 여부
		boolean next = listCnt * endPageBtnNo < totalCnt;
		if (!next) {
			endPageBtnNo = (int) Math.ceil(totalCnt / (double) listCnt);
		}

		// 이전 버튼 존재 여부
		boolean prev = startPageBtnNo != 1;

		// 데이터를 맵에 저장하여 컨트롤러로 전달
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("favoritesList", favoritesList);
		pMap.put("prev", prev);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("next", next);
		
		System.out.println("----");
		System.out.println(startRowNo);
		System.out.println(listCnt);
		System.out.println("----");

		return pMap;
	}

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
