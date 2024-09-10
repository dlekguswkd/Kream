package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
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

	public List<PurchaseVo> exePurchaseReq(){
		List<PurchaseVo> purchaseReqList = adminpagedao.purchaseRequest();
		return purchaseReqList;
	}
	
	public List<PurchaseVo> exePurchaseReq2(){
		List<PurchaseVo> purchaseReqList = adminpagedao.purchaseRequest2();
		return purchaseReqList;
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
