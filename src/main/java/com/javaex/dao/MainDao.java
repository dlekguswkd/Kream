package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.MainVo;

@Repository
public class MainDao {
	
	@Autowired
	private SqlSession sqlSession;
	

	/* 메인화면 전체 리스트 */
	public List<MainVo> selectList() {
		System.out.println("MainDao.selectList()");
		
		List<MainVo> mainList = sqlSession.selectList("main.selectList");
		
		return mainList;
	}
	
}
