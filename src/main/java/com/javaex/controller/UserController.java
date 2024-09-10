package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

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
		return "redirect:/user/loginform";
	}
	
	/* 아이디 중복체크 */
	//http://localhost:8888/kream/api/user/idcheck
	@ResponseBody
	@RequestMapping(value="/api/user/idcheck", method = {RequestMethod.GET, RequestMethod.POST})
	public boolean idCheck(@RequestParam(value="id") String id) {
		System.out.println("UserController.idCheck()");
		
		boolean can = userService.exeIdCheck(id);
		return can;
		
	}
	
	
	
	// -----------------------------------------------------------------------------

	/* 로그인폼 */
	//http://localhost:8888/kream/user/loginform
	@RequestMapping(value = "/user/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		System.out.println("UserController.loginForm()");
		
		return "user/loginForm";
	}
	
	
	/* 로그인 */
	//http://localhost:8888/kream/user/login
	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("UserController.loginForm()");
		
		UserVo authUser = userService.exeLogin(userVo);
		
		session.setAttribute("authUser", authUser);
		System.out.println(authUser);
		
		return "redirect:/main/mainform";		
	}
	
	
	/* 로그아웃 */
	//http://localhost:8888/kream/user/logout
	@RequestMapping(value="/user/logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");
		
		session.invalidate();
	
		return "redirect:/main/mainform";		
	}
	
	
	
	// -----------------------------------------------------------------------------
	
	
	
	
	
}
