package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.MainService;
import com.javaex.vo.MainVo;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	
	/* 메인화면 전체 리스트 */
	//http://localhost:8888/kream/main/mainform
	@RequestMapping(value="/main/mainform", method = {RequestMethod.GET, RequestMethod.POST})
	public String mainForm(Model model) {
		System.out.println("MainController.mainForm()");
		
		List<MainVo> mainList = mainService.exeList();
		
		model.addAttribute("mainList", mainList);
		
		return "main/MainPage";
		
	}

}
