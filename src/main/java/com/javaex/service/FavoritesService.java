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
		System.out.println("FavoritesDao.exeGetList()");

		List<FavoritesVo> favoritesList = favoritesDao.selectFavoritesList(userNo);

		return favoritesList;
	}

}
