package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.DetailVo;

@Repository
public class DetailDao {
	
	@Autowired
	private SqlSession sqlSession;

	/* 상품설명 메인폼 */
	public List<DetailVo> selectDetailList(int prodNo) {
		System.out.println("DetailDao.selectDetailList");
		
		List<DetailVo> detailList = sqlSession.selectList("detail.selectList",prodNo);

		return detailList;
	}
	
	
}
