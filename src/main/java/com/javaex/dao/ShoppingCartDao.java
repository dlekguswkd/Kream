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
public class ShoppingCartDao {

	@Autowired
	private SqlSession sqlSession;

	/* 장바구니 리스트 가져오기 */
	public List<ShoppingCartVo> selectShoppingList(int userNo) {
		System.out.println("ShoppingCartDao.selectShoppingList");

		List<ShoppingCartVo> shoppingList = sqlSession.selectList("shopingCart.selectList", userNo);

		return shoppingList;
	}

	/* 장바구니 전체 갯수 구하기 */
	public int selectTotalCnt(int userNo) {

		int count = sqlSession.selectOne("shopingCart.selectTotalCnt", userNo);

		return count;
	}

	/* 장바구니 삭제 */
	public int deleteShopping(int cartNo) {

		int count = sqlSession.delete("shopingCart.deleteShopping", cartNo);

		return count;
	}

	/* 신발 사이즈 옵션 업데이트 */
	public int updateShopping(int prodSize, int userNo) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("prodSize", prodSize);
		params.put("userNo", userNo);

		int count = sqlSession.update("shopingCart.updateShopping", params);

		return count;
	}

}
