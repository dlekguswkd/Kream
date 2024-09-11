package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.MainDao;
import com.javaex.vo.MainVo;
import com.javaex.vo.ProductVo;

@Service
public class MainService {

	@Autowired
	private MainDao mainDao;

	public Map<String, Object> getProductList(int crtPage) {
		int listCnt = 10; // Items per page
		crtPage = (crtPage > 0) ? crtPage : 1;
		int startRowNum = (crtPage - 1) * listCnt;

		Map<String, Integer> limitMap = new HashMap<>();
		limitMap.put("listCnt", listCnt);
		limitMap.put("startRowNum", startRowNum);

		// Fetch paginated product list
		List<MainVo> productList = mainDao.selectProductList(limitMap);

		// Fetch total product count for pagination
		int totalCnt = mainDao.getTotalProductCount();

		// Fetch all brands and colors
		List<ProductVo> brandList = mainDao.selectAllBrands();
		List<ProductVo> colorList = mainDao.selectAllColors();

		// Pagination logic
		int pageBtnCount = 5;
		int endPageBtnNo = (int) Math.ceil((double) crtPage / pageBtnCount) * pageBtnCount;
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;

		boolean next = listCnt * endPageBtnNo < totalCnt;
		if (!next) {
			endPageBtnNo = (int) Math.ceil((double) totalCnt / listCnt);
		}
		boolean prev = (startPageBtnNo != 1);

		Map<String, Object> pMap = new HashMap<>();
		pMap.put("next", next);
		pMap.put("prev", prev);
		pMap.put("productList", productList);
		pMap.put("brandList", brandList);
		pMap.put("colorList", colorList);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);

		return pMap;
	}

	public Map<String, Object> getFilteredProducts(Map<String, Object> filterCriteria) {
		int crtPage = (int) filterCriteria.get("crtPage");
		int listCnt = 10; // Items per page
		crtPage = (crtPage > 0) ? crtPage : 1;
		int startRowNum = (crtPage - 1) * listCnt;

		filterCriteria.put("listCnt", listCnt);
		filterCriteria.put("startRowNum", startRowNum);

		// Fetch filtered product list
		List<ProductVo> productList = mainDao.selectFilteredProductList(filterCriteria);

		// Fetch total product count for pagination
		int totalCnt = mainDao.getFilteredProductCount(filterCriteria);
		List<ProductVo> brandList = mainDao.selectAllBrands();
		List<ProductVo> colorList = mainDao.selectAllColors();
		// Pagination logic
		int pageBtnCount = 5;
		int endPageBtnNo = (int) Math.ceil((double) crtPage / pageBtnCount) * pageBtnCount;
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;

		boolean next = listCnt * endPageBtnNo < totalCnt;
		if (!next) {
			endPageBtnNo = (int) Math.ceil((double) totalCnt / listCnt);
		}
		boolean prev = (startPageBtnNo != 1);

		Map<String, Object> pMap = new HashMap<>();
		pMap.put("next", next);
		pMap.put("prev", prev);
		pMap.put("productList", productList);
		pMap.put("brandList", brandList);
		pMap.put("colorList", colorList);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);

		return pMap;
	}

	public List<ProductVo> getPopularProductsByBrand() {
		return mainDao.selectPopularProductsByBrand();
	}

	public ProductVo getProductDetail(int prodNo) {
		return mainDao.selectProductDetail(prodNo);
	}

	// 구매버튼 클릭시 History 테이블에 추가
	public int exeShoppingCartInsert(int userNo, int prodNo, int prodSize) {
		// HistoryVo 생성 및 값 설정
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userNo", userNo);
		pMap.put("prodNo", prodNo);
		pMap.put("prodSize", prodSize);
		System.out.println(pMap);

		// DAO를 통해 데이터베이스에 삽입
		int count = mainDao.insertShoppingCart(pMap);

		return count;
	}
	
	public int exefavoriteInsert(int userNo, int prodNo, int prodSize) {
		// HistoryVo 생성 및 값 설정
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("userNo", userNo);
		pMap.put("prodNo", prodNo);
		pMap.put("prodSize", prodSize);
		System.out.println(pMap);

		// DAO를 통해 데이터베이스에 삽입
		int count = mainDao.insertFavorite(pMap);

		return count;
	}

}
