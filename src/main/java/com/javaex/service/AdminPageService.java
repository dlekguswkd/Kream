package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.AdminPageDao;
import com.javaex.vo.ProductVo;
import com.javaex.vo.PurchaseVo;
import com.javaex.vo.UserVo;

@Service
public class AdminPageService {

	@Autowired
	private AdminPageDao adminpagedao;

	public List<UserVo> exeGetUserInfoList(){
		List<UserVo> userInfoList = adminpagedao.getuserInfoList();
		return userInfoList;
	}

	public List<UserVo> exeGetUserList() {
		List<UserVo> userList = adminpagedao.getUserList();
		return userList;
	}

	public UserVo exeGetUserInfo(int userNo) {
		UserVo userVo = adminpagedao.getUserInfo(userNo);
		return userVo;
	}

	// 유저 정보 업데이트
	public void exeUpdateUserInfo(UserVo userVo) {
		adminpagedao.updateUser(userVo);
	}

	// 유저 정보 삭제
	public void exeDeleteUserInfo(int userNo) {
		adminpagedao.deleteUser(userNo);
	}

	public List<String> exegetBrandName(){
		List<String> brandName = adminpagedao.getBrandName();
		return brandName;
	}

	public List<String> exegetColorName(){
		List<String> colorName = adminpagedao.getColorName();
		return colorName;

	}

	public Map<String, Object> getUserListWithPaging(int crtPage) {
		System.out.println("AdminPageService.getUserListWithPaging()");

		// Number of items per page
		int listCnt = 10;

		// Set default page if crtPage is less than 1
		crtPage = (crtPage > 0) ? crtPage : 1;

		// Calculate starting row number for the query
		int startRowNum = (crtPage - 1) * listCnt;
		Map<String, Integer> limitMap = new HashMap<>();
		limitMap.put("listCnt", listCnt);
		limitMap.put("startRowNum", startRowNum);

		// Fetch paginated user list
		List<UserVo> userList = adminpagedao.getUserListWithPaging(limitMap);

		// Pagination logic (same as your TboardService)
		int pageBtnCount = 5;
		int totalCnt = adminpagedao.selectTotalUserCount(); // Total number of users

		// Last page number
		int endPageBtnNo = (int) Math.ceil(crtPage / (double)pageBtnCount) * pageBtnCount;
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;

		// Next/Previous button logic
		boolean next = listCnt * endPageBtnNo < totalCnt;
		if (!next) {
			endPageBtnNo = (int) Math.ceil(totalCnt / (double)listCnt);
		}
		boolean prev = startPageBtnNo != 1;

		// Prepare pagination map
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("next", next);
		pMap.put("prev", prev);
		pMap.put("userList", userList);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);

		return pMap;
	}

	public Map<String, Object> getProductListWithPaging(int crtPage) {
		System.out.println("AdminPageService.getProductListWithPaging()");

		// Number of items per page
		int listCnt = 10;

		// Ensure the current page is greater than 0
		crtPage = (crtPage > 0) ? crtPage : 1;

		// Calculate starting row number
		int startRowNum = (crtPage - 1) * listCnt;
		Map<String, Integer> limitMap = new HashMap<>();
		limitMap.put("listCnt", listCnt);
		limitMap.put("startRowNum", startRowNum);

		// Fetch paginated product list
		List<ProductVo> productList = adminpagedao.getProductListWithPaging(limitMap);

		// Pagination logic
		int pageBtnCount = 5;
		int totalCnt = adminpagedao.selectTotalProductCount(); // Get the total count of products

		// Calculate last page number
		int endPageBtnNo = (int) Math.ceil(crtPage / (double)pageBtnCount) * pageBtnCount;
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;

		// Next and Previous button logic
		boolean next = listCnt * endPageBtnNo < totalCnt;
		if (!next) {
			endPageBtnNo = (int) Math.ceil(totalCnt / (double)listCnt);
		}
		boolean prev = startPageBtnNo != 1;

		// Prepare pagination map
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("next", next);
		pMap.put("prev", prev);
		pMap.put("productList", productList);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);

		return pMap;
	}



	public String exeUpload(MultipartFile file, String brand, String category, int price, String colorName, String engName, String korName, String modelNo, String releaseDate) {

		//사진 기본 정보 추출
		//저장 파일 폴터
		String saveDir = "/Users/yuchan/Desktop/Kream_products_imgs";

		//윈도우용 
		//String saveDir = "C:\\javaStudy\\fileName";

		//File Name
		String orgName = file.getOriginalFilename();

		//File Type
		String exeName = orgName.substring(orgName.lastIndexOf("."));

		//File Name
		long fileSize = file.getSize();

		//Save Name
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exeName;

		//File path + file
		String filePath = saveDir + "/" + saveName;

		// 파일전체 경로+파일 (윈도우 용)
		//		String filePath1 = saveDir + "\\" + saveName1;
		//		System.out.println(filePath1);

		ProductVo productVo = new ProductVo();
		productVo.setSaveName(saveName);
		productVo.setFilePath(filePath);
		productVo.setEngName(engName);
		productVo.setKorName(korName);
		productVo.setModelNo(modelNo);
		productVo.setFileSize(fileSize);
		productVo.setSaveName(saveName);
		productVo.setOrgName(orgName);

		adminpagedao.insertItems(brand, colorName, category, price, releaseDate, productVo);




		// 파일저장
		try {
			byte[] fileData1 = file.getBytes();
			OutputStream os1 = new FileOutputStream(filePath);
			BufferedOutputStream bos1 = new BufferedOutputStream(os1);

			bos1.write(fileData1);
			bos1.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}





		return "";
	}

	public List<ProductVo> exegetItemList(){
		List<ProductVo> itemList = adminpagedao.itemList();
		return itemList;
	}

	public List<PurchaseVo> exeSaleHistory(){
		List<PurchaseVo> historyList = adminpagedao.salehistory();
		return historyList;
	}

	public List<PurchaseVo> exeSaleHistoryList(){
		List<PurchaseVo> historyList = adminpagedao.salehistory();
		return historyList;
	}

	public List<PurchaseVo> exeSaleHistoryList2(){
		List<PurchaseVo> historyList = adminpagedao.salehistory2();
		return historyList;
	}

	public Map<String, Object> getSalesHistoryWithPaging(int crtPage) {
		System.out.println("AdminPageService.getSalesHistoryWithPaging()");

		// Number of items per page
		int listCnt = 10;

		// Ensure crtPage is greater than 0
		crtPage = (crtPage > 0) ? crtPage : 1;

		// Calculate starting row number
		int startRowNum = (crtPage - 1) * listCnt;
		Map<String, Integer> limitMap = new HashMap<>();
		limitMap.put("listCnt", listCnt);
		limitMap.put("startRowNum", startRowNum);

		// Fetch paginated sales history
		List<PurchaseVo> soldProductList = adminpagedao.getSalesHistoryWithPaging(limitMap);

		// Pagination logic
		int pageBtnCount = 5;
		int totalCnt = adminpagedao.selectTotalSalesCount(); // Get total sales count

		// Calculate last page number
		int endPageBtnNo = (int) Math.ceil(crtPage / (double)pageBtnCount) * pageBtnCount;
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;

		// Next and Previous button logic
		boolean next = listCnt * endPageBtnNo < totalCnt;
		if (!next) {
			endPageBtnNo = (int) Math.ceil(totalCnt / (double)listCnt);
		}
		boolean prev = startPageBtnNo != 1;

		// Prepare pagination map
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("next", next);
		pMap.put("prev", prev);
		pMap.put("soldProductList", soldProductList);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);

		return pMap;
	}


	public List<PurchaseVo> exePurchaseReq(){
		List<PurchaseVo> purchaseReqList = adminpagedao.purchaseRequest();
		return purchaseReqList;
	}

	public List<PurchaseVo> exePurchaseReq2(){
		List<PurchaseVo> purchaseReqList = adminpagedao.purchaseRequest2();
		return purchaseReqList;
	}

	public Map<String, Object> getPurchaseRequestWithPaging(int crtPage) {
		System.out.println("AdminPageService.getPurchaseRequestWithPaging()");

		// Number of items per page
		int listCnt = 10;

		// Ensure the crtPage is greater than 0
		crtPage = (crtPage > 0) ? crtPage : 1;

		// Calculate starting row number
		int startRowNum = (crtPage - 1) * listCnt;
		Map<String, Integer> limitMap = new HashMap<>();
		limitMap.put("listCnt", listCnt);
		limitMap.put("startRowNum", startRowNum);

		// Fetch paginated purchase request list
		List<PurchaseVo> purchaseReqList = adminpagedao.getPurchaseRequestWithPaging(limitMap);

		// Pagination logic
		int pageBtnCount = 5;
		int totalCnt = adminpagedao.selectTotalPurchaseRequestCount(); // Get the total count of purchase requests

		// Calculate last page number
		int endPageBtnNo = (int) Math.ceil(crtPage / (double)pageBtnCount) * pageBtnCount;
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;

		// Next and Previous button logic
		boolean next = listCnt * endPageBtnNo < totalCnt;
		if (!next) {
			endPageBtnNo = (int) Math.ceil(totalCnt / (double)listCnt);
		}
		boolean prev = startPageBtnNo != 1;

		// Prepare pagination map
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("next", next);
		pMap.put("prev", prev);
		pMap.put("purchaseReqList", purchaseReqList);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);

		return pMap;
	}


	public void exeDeleteProduct(int prodNo) {
		adminpagedao.deleteFavorites(prodNo);
		adminpagedao.deleteShoppingChart(prodNo);
		adminpagedao.deleteHistory(prodNo);
		adminpagedao.deleteProduct(prodNo);
	}

	// 배송 상태 업데이트
	public void updateShippingStatus(int historyNo, String status) {
		adminpagedao.updateShippingStatus(historyNo, status);
	}

	// 구매 신청 삭제
	public void deletePurchaseRequest(int historyNo) {
		adminpagedao.deletePurchaseRequest(historyNo);
	}



}
