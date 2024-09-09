package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	//필드
	@Autowired		
	private UserService userService;
	
	
	/* 회원가입폼 */
	//http://localhost:8888/kream/user/registerForm
	@RequestMapping(value="/user/registerForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String registerForm() {
		System.out.println("UserController.registerForm()");
		
		return "user/registerForm";
	}
	
	
	/* 회원가입 */
	//http://localhost:8888/kream/user/register
	@RequestMapping(value="/user/register", method= {RequestMethod.GET, RequestMethod.POST})
	public String register(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.register()");
		
		userService.exeRegister(userVo);
		System.out.println(userVo);
	
		// 포워드
		return "";	// 메인페이지로 바꾸기
	}
	
	// -----------------------------------------------------------------------------

	/* 로그인폼 */
	//http://localhost:8888/kream/user/loginform
	@RequestMapping(value = "/user/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		System.out.println("UserController.loginForm()");

		
		
		
		return "user/loginForm";
	}
	
}
