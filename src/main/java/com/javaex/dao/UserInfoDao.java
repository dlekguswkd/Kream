package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.FavoritesVo;
import com.javaex.vo.PurchaseVo;
import com.javaex.vo.UserVo;

@Repository
public class UserInfoDao {

	@Autowired
	private SqlSession sqlSession;

	/* 회원정보 1개 가져오기 */
	public UserVo selectInfo(int userNo) {
		System.out.println("UserInfoDao.selectInfo()");

		UserVo userVo = sqlSession.selectOne("user.selectInfo", userNo);

		return userVo;
	}

	/* 회원정보 수정 */
	public int modifyUser(UserVo userVo) {
		System.out.println("UserInfoDao.modifyUser()");

		int count = sqlSession.update("user.update", userVo);

		return count;
	}

	/* 마이페이지 구매내역 */
	public List<PurchaseVo> selectPurchase(int userNo) {

		List<PurchaseVo> purchaseList = sqlSession.selectList("user.selectPurchase", userNo);

		return purchaseList;
	}

	/* 구매내역 삭제하기 */
	public int deletePurchase(int historyNo) {

		int count = sqlSession.delete("user.deletePurchase", historyNo);

		return count;
	}

	/* 구매내역 전체 갯수 구하기 */
	public int selectTotalCnt(int userNo) {

		int count = sqlSession.selectOne("user.selectTotalCnt", userNo);

		return count;
	}

	/* 구매내역 준비중 갯수 구하기 */
	public int selectReadyCnt(int userNo) {

		int count = sqlSession.selectOne("user.selectReadyCnt", userNo);

		return count;
	}

	/* 구매내역 배송완료 갯수 구하기 */
	public int selectFinishCnt(int userNo) {

		int count = sqlSession.selectOne("user.selectFinishCnt", userNo);

		return count;
	}
	
	/* 관심 상품 리스트 가져오기 */
	public List<FavoritesVo> selectFavoritesList(int userNo) {
		System.out.println("UserInfoDao.selectFavoritesList()");

		List<FavoritesVo> favoritesList = sqlSession.selectList("user.selectFavoritesList", userNo);

		return favoritesList;
	}

}
