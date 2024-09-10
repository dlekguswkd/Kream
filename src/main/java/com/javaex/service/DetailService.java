package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.DetailDao;
import com.javaex.vo.DetailVo;

@Service
public class DetailService {
	
	@Autowired
	private DetailDao detailDao;

	/* 상품설명 메인폼 */
	public List<DetailVo> exeDetailList(int prodNo) {
		System.out.println("DetailService.exeDetailList()");

		List<DetailVo> detailList = detailDao.selectDetailList(prodNo);
		
		return detailList;
	}
	 
	
	
}
