package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FavoritesVo;
import com.javaex.vo.ShoppingCartVo;

@Repository
public class FavoritesDao {

	@Autowired
	public SqlSession sqlSession;

	// DAO
	public List<FavoritesVo> selectPagedFavoritesList(Map<String, Integer> limitMap) {
		System.out.println("FavoritesDao.selectPagedFavoritesList");

		return sqlSession.selectList("favorites.selectPagedList", limitMap);
	}

	// 전체 글 개수 구하기
	public int selectTotalCnt(int userNo) {
		return sqlSession.selectOne("favorites.selectTotalCnt", userNo);
	}

	/* 관심 상품 리스트 가져오기 */
	public List<FavoritesVo> selectFavoritesList(int userNo) {
		System.out.println("FavoritesDao.selectShoppingList");

		List<FavoritesVo> favoritesList = sqlSession.selectList("favorites.selectList", userNo);

		return favoritesList;
	}

	/* 유저번호와 관심번호 이용해서 관심상품 조회 */
	public List<FavoritesVo> selectFavoritesList(int favoriteNo, int userNo) {
		System.out.println("shopingCart.selectFavoritesList");

		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("favoriteNo", favoriteNo);
		params.put("userNo", userNo);

		List<FavoritesVo> favoritesList = sqlSession.selectList("favorites.selectFavoritesList", params);

		return favoritesList;
	}

	/* 관심상품 삭제 */
	public int deleteFavorites(int favoriteNo, int userNo) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("favoriteNo", favoriteNo);
		params.put("userNo", userNo);

		int count = sqlSession.delete("favorites.deleteFavorites", params);

		return count;
	}

	// ShoppingCart 테이블에 결제 정보 삽입
	public int insertShoppingCart(FavoritesVo favoritesVo) {

		int count = sqlSession.insert("favorites.insertShoppingCart", favoritesVo);

		return count;
	}

}
