package com.javaex.vo;

public class UserVo {
	//Fields
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userAddress;
	private int favorite;
	
	//constructors
	public UserVo() {
		
	}
	
	public UserVo(int userNum, String userId, String userPw, String userName, String userAddress) {
		this.userNo = userNum;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAddress = userAddress;
	}
	
	public UserVo(int userNum, String userId, String userPw, String userName, String userAddress, int favorite) {
		this.userNo = userNum;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAddress = userAddress;
		this.favorite = favorite;
	}
	
	//GS
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	public int getFavorite() {
		return favorite;
	}
	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}
	
	//Methods
	@Override
	public String toString() {
		return "UserVo [userNum=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userAddress=" + userAddress + ", favorite=" + favorite + "]";
	}

	
	
	
	
}
