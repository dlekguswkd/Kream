package com.javaex.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MainVo;
import com.javaex.vo.ProductVo;

@Repository
public class MainDao {

	@Autowired
	private SqlSession sqlSession;

	// Fetch product list with pagination
	public List<MainVo> selectProductList(Map<String, Integer> limitMap) {
		return sqlSession.selectList("main.selectProductList", limitMap);
	}

	// Fetch total product count for pagination
	public int getTotalProductCount() {
		return sqlSession.selectOne("main.getTotalProductCount");
	}

	// Fetch all brands
	public List<ProductVo> selectAllBrands() {
		return sqlSession.selectList("main.selectAllBrands");
	}

	// Fetch all colors
	public List<ProductVo> selectAllColors() {
		return sqlSession.selectList("main.selectAllColors");
	}

	public List<ProductVo> selectPopularProductsByBrand() {
		return sqlSession.selectList("main.selectPopularProductsByBrand");
	}

	public ProductVo selectProductDetail(int prodNo) {
		return sqlSession.selectOne("main.selectProductDetail", prodNo);
	}
	
	// Fetch filtered product list based on brand
    public List<ProductVo> selectFilteredProductList(Map<String, Object> filterCriteria) {
        return sqlSession.selectList("main.selectFilteredProductList", filterCriteria);
    }

    // Fetch total filtered product count
    public int getFilteredProductCount(Map<String, Object> filterCriteria) {
        return sqlSession.selectOne("main.getFilteredProductCount", filterCriteria);
    }
    
    // ShoppingCart 테이블에 데이터를 삽입
    public int insertShoppingCart(Map<String, Object> pMap) {
        int count = sqlSession.insert("main.insertShoppingCart", pMap);
        
        return count;
    }
    
    public int insertFavorite(Map<String, Object> pMap) {
        int count = sqlSession.insert("main.insertFavorite", pMap);
        
        return count;
    }
    
    /* 상품번호 이용해서 카테고리명 조회하기 */
	public ProductVo selectCategory(int prodNo) {
		System.out.println("MainDao.selectProductSeriesList()");
		
		ProductVo productVo = sqlSession.selectOne("main.selectCategory", prodNo);
		
		return productVo;
	}
    
    /* 상품 시리즈 리스트 가져오기 */
	public List<ProductVo> selectProductSeriesList(String categoryName) {
		System.out.println("MainDao.selectProductSeriesList()");
		
		List<ProductVo> productSeriesList = sqlSession.selectList("main.selectProductSeries", categoryName);

		return productSeriesList;
	}



}
