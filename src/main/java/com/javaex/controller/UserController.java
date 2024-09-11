package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	// 필드
	@Autowired
	private UserService userService;

	/* 회원가입폼 */
	// http://localhost:8888/kream/user/registerForm
	@RequestMapping(value = "/user/registerForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String registerForm() {
		System.out.println("UserController.registerForm()");

		return "user/registerForm";
	}

	/* 회원가입 */
	// http://localhost:8888/kream/user/register
	@RequestMapping(value = "/user/register", method = { RequestMethod.GET, RequestMethod.POST })
	public String register(@ModelAttribute UserVo userVo) {
		System.out.println("UserController.register()");

		userService.exeRegister(userVo);
		System.out.println(userVo);

		// 포워드
		return "redirect:/user/loginform";
	}

	/* 아이디 중복체크 */
	// http://localhost:8888/kream/api/user/idcheck
	@ResponseBody
	@RequestMapping(value = "/api/user/idcheck", method = { RequestMethod.GET, RequestMethod.POST })
	public boolean idCheck(@RequestParam(value = "id") String id) {
		System.out.println("UserController.idCheck()");

		boolean can = userService.exeIdCheck(id);
		return can;

	}

	// -----------------------------------------------------------------------------

	/* 로그인폼 */
	// http://localhost:8888/kream/user/loginform
	@RequestMapping(value = "/user/loginform", method = { RequestMethod.GET, RequestMethod.POST })
	public String loginForm() {
		System.out.println("UserController.loginForm()");

		return "user/loginForm";
	}

	/* 로그인 */
	@RequestMapping(value = "/user/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(@ModelAttribute UserVo userVo, HttpSession session, Model model) {
		System.out.println("UserController.loginForm()");

		// 로그인 실행
		UserVo authUser = userService.exeLogin(userVo);

		// 만약 userId가 'admin'일 경우 adminSession만 생성
		if (authUser != null && "admin".equals(authUser.getUserId())) {
			session.setAttribute("admin", authUser);
			System.out.println("관리자세션");
			System.out.println(authUser);
		} else {
			// 일반 사용자인 경우 authUser 세션 생성
			session.setAttribute("authUser", authUser);
			System.out.println("유저세션");
			System.out.println(authUser);
		}
		
		// 만약에 없는 userId 일 경우
	    if (authUser == null) {
	        // 인증 실패 (없는 아이디일 경우) - 오류 메시지 설정
	        model.addAttribute("errorMessage", "아이디와 비밀번호를 다시 확인해주세요.");
	        // 로그인 폼으로 리다이렉트
	        return "user/loginForm"; 
	    }

		// 메인 페이지로 리다이렉트
		return "redirect:/main/mainform";
	}

	/* 로그아웃 */
	// http://localhost:8888/kream/user/logout
	@RequestMapping(value = "/user/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		System.out.println("UserController.logout()");

		session.invalidate();

		return "redirect:/main/mainform";
	}

	// -----------------------------------------------------------------------------

}
