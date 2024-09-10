package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ProductVo;
import com.javaex.vo.PurchaseVo;
import com.javaex.vo.UserVo;

@Repository
public class AdminPageDao {

	@Autowired
	private SqlSession sqlsession;

	public List<UserVo> getuserInfoList() {
		List<UserVo> userInfoList = sqlsession.selectList("admin.getUserInfoList5");
		return userInfoList;
	}

	public List<UserVo> getUserList(){
		List<UserVo> userList = sqlsession.selectList("admin.getUserList");
		return userList;
	}

	public UserVo getUserInfo(int userNo) {
		UserVo userVo = sqlsession.selectOne("admin.getUserInfo", userNo);
		return userVo;
	}

	// 유저 정보 업데이트
	public void updateUser(UserVo userVo) {
		sqlsession.update("admin.updateUser", userVo);
	}

	// 유저 정보 삭제
	public void deleteUser(int userNo) {
		sqlsession.delete("admin.deleteShoppingList", userNo);
		sqlsession.delete("admin.deleteFavorites", userNo);
		sqlsession.delete("admin.deleteHistories", userNo);
		sqlsession.delete("admin.deleteUser", userNo);

	}

	public List<UserVo> getUserListWithPaging(Map<String, Integer> limitMap) {
		System.out.println("AdminPageDao.getUserListWithPaging()");
		return sqlsession.selectList("admin.getUserListWithPaging", limitMap);
	}

	public int selectTotalUserCount() {
		System.out.println("AdminPageDao.selectTotalUserCount()");
		return sqlsession.selectOne("admin.selectTotalUserCount");
	}


	public List<String> getBrandName(){
		List<String> brandName = sqlsession.selectList("admin.getBrandName");
		return brandName;
	}

	public List<String> getColorName(){
		List<String> colorName = sqlsession.selectList("admin.getColorName");
		return colorName;
	}

	public void insertItems(String brand, String color, String category, 
			int price, String releaseDate, ProductVo productVo) {

		int colorNo = sqlsession.selectOne("admin.getColorCode",color);
		int brandNo = sqlsession.selectOne("admin.getBrandCode",brand);
		Map<String,Object> params = new HashMap<>();
		params.put("brandNo", brandNo);
		params.put("colorNo", colorNo);
		params.put("categoryName", category);
		params.put("prodPrice", price);
		params.put("releaseDate", releaseDate);
		sqlsession.insert("admin.insertCategory",params);
		int categoryNo = sqlsession.selectOne("admin.getCategoryNo", params);
		productVo.setCategoryNo(categoryNo);
		sqlsession.insert("admin.insertProduct", productVo);

	}

	public List<ProductVo> itemList(){
		List<ProductVo> itemList = sqlsession.selectList("admin.getItemList");
		return itemList;
	}

	public List<ProductVo> getProductListWithPaging(Map<String, Integer> limitMap) {
		System.out.println("AdminPageDao.getProductListWithPaging()");
		return sqlsession.selectList("admin.getProductListWithPaging", limitMap);
	}

	public int selectTotalProductCount() {
		System.out.println("AdminPageDao.selectTotalProductCount()");
		return sqlsession.selectOne("admin.selectTotalProductCount");
	}


	public void deleteFavorites(int prodNo) {
		sqlsession.delete("admin.deletefromFavorites", prodNo);
	}

	public void deleteShoppingChart(int prodNo) {
		sqlsession.delete("admin.deletefromShoppingChart", prodNo);
	}

	public void deleteHistory(int prodNo) {
		sqlsession.delete("admin.deletefromHistory", prodNo);
	}

	public void deleteProduct(int prodNo) {
		sqlsession.delete("admin.deletefromProduct", prodNo);
	}

	public List<PurchaseVo> salehistory(){
		List<PurchaseVo> salehistory = sqlsession.selectList("admin.getSaleHistory");
		return salehistory;
	}

	public List<PurchaseVo> salehistory2(){
		List<PurchaseVo> salehistory = sqlsession.selectList("admin.getSaleHistory");
		return salehistory;
	}

	public List<PurchaseVo> getSalesHistoryWithPaging(Map<String, Integer> limitMap) {
	    System.out.println("AdminPageDao.getSalesHistoryWithPaging()");
	    return sqlsession.selectList("admin.getSalesHistoryWithPaging", limitMap);
	}

	public int selectTotalSalesCount() {
	    System.out.println("AdminPageDao.selectTotalSalesCount()");
	    return sqlsession.selectOne("admin.selectTotalSalesCount");
	}



	public List<PurchaseVo> salehistoryList(){
		List<PurchaseVo> salehistory = sqlsession.selectList("admin.getSaleHistory2");
		return salehistory;
	}

	public List<PurchaseVo> purchaseRequest(){
		List<PurchaseVo> purchaseReqList = sqlsession.selectList("admin.getPurchaseReqList");
		return purchaseReqList;
	}

	public List<PurchaseVo> purchaseRequest2(){
		List<PurchaseVo> purchaseReqList = sqlsession.selectList("admin.getPurchaseReqList2");
		return purchaseReqList;
	}
	
	public List<PurchaseVo> getPurchaseRequestWithPaging(Map<String, Integer> limitMap) {
	    System.out.println("AdminPageDao.getPurchaseRequestWithPaging()");
	    return sqlsession.selectList("admin.getPurchaseRequestWithPaging", limitMap);
	}

	public int selectTotalPurchaseRequestCount() {
	    System.out.println("AdminPageDao.selectTotalPurchaseRequestCount()");
	    return sqlsession.selectOne("admin.selectTotalPurchaseRequestCount");
	}


	// 배송 상태 업데이트
	public void updateShippingStatus(int historyNo, String status) {
		Map<String, Object> params = new HashMap<>();
		params.put("historyNo", historyNo);
		params.put("status", status);
		sqlsession.update("admin.updateShippingStatus", params);
	}

	// 구매 신청 삭제
	public void deletePurchaseRequest(int historyNo) {
		sqlsession.delete("admin.deletePurchaseRequest", historyNo);
	}

}
