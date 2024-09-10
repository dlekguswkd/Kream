package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

	@Service
	public class UserService {
		
		//필드
		@Autowired
		private UserDao userDao;
		
		
		/* 회원가입 */
		public int exeRegister(UserVo userVo) {	 
			System.out.println("UserService.exeRegister()");
			
			int count = userDao.insertUser(userVo);
			
			return count;
			
		}
	
		
		/* 로그인 */
		public UserVo exeLogin(UserVo userVo) {
			System.out.println("UserService.exeLogin()");
			
			UserVo authUser = userDao.selectUser(userVo);
			
			return authUser;
		}
		
		
		/* 아이디 중복체크 */
		public boolean exeIdCheck(String id) {
			System.out.println("UserService.exeIdCheck()");

			int count = userDao.selectUserById(id);
			
			if(count >= 1) {
				return false;	
			}else {
				return true;		
			}
			
		}

		
		
	}



