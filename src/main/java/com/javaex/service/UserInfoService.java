package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserInfoDao;
import com.javaex.vo.FavoritesVo;
import com.javaex.vo.PurchaseVo;
import com.javaex.vo.UserVo;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	/* 회원정보 수정 폼 */
	public UserVo exeUserInfo(int userNo) {
		System.out.println("UserInfoService.exeUserInfo()");

		UserVo userVo = userInfoDao.selectInfo(userNo);

		return userVo;
	}

	/* 회원정보 수정 */
	public UserVo exeUserModify(UserVo userVo) {
		System.out.println("UserInfoService.modify()");

		int count = userInfoDao.modifyUser(userVo);

		// 회원번호(no)를 이용해서 수정된 회원의 정보를 객체로 저장
		UserVo modifyUserInfo = userInfoDao.selectInfo(userVo.getUserNo());

		return modifyUserInfo;
	}

	/* 마이페이지 구매내역 */
	public List<PurchaseVo> exeUserPurchase(int userNo) {
		System.out.println("UserInfoService.exeUserPurchase()");

		List<PurchaseVo> purchaseList = userInfoDao.selectPurchase(userNo);

		return purchaseList;

	}

	/* 구매내역 삭제하기 */
	public int exePurchaseDelete(int historyNo) {
		System.out.println("UserInfoService.exePurchaseDelete()");

		int count = userInfoDao.deletePurchase(historyNo);

		return count;

	}

	/* 구매내역 전체 갯수 구하기 */
	public int exeSelectTotalCnt(int userNo) {

		int count = userInfoDao.selectTotalCnt(userNo);

		return count;
	}

	/* 구매내역 준비중 갯수 구하기 */
	public int exeSelectReadyCnt(int userNo) {

		int count = userInfoDao.selectReadyCnt(userNo);

		return count;
	}

	/* 구매내역 배송완료 갯수 구하기 */
	public int exeSelectFinishCnt(int userNo) {

		int count = userInfoDao.selectFinishCnt(userNo);

		return count;
	}

	/* 관심상품 리스트 가져오기 */
	public List<FavoritesVo> exeUserFavorites(int userNo) {
		System.out.println("UserInfoService.exeUserFavorites()");

		List<FavoritesVo> favoritesList = userInfoDao.selectFavoritesList(userNo);

		return favoritesList;
	}

}
