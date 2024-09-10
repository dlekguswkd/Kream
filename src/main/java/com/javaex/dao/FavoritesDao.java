package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FavoritesVo;

@Repository
public class FavoritesDao {

	@Autowired
	public SqlSession sqlSession;

	/* 관심 상품 리스트 가져오기 */
	public List<FavoritesVo> selectFavoritesList(int userNo) {
		System.out.println("FavoritesDao.selectShoppingList");

		List<FavoritesVo> favoritesList = sqlSession.selectList("favorites.selectList", userNo);

		return favoritesList;
	}

}
