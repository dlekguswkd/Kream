package com.javaex.vo;

public class FavoritesVo {

	private int favoriteNo;
	private int userNo;
	private int prodNo;
	private String brandName;
	private String userName;
	private String userId;
	private int prodPrice;
	private int prodSize;
	private String engName;
	private String korName;
	private String filePath;
	private int fileSize;
	private String saveName;
	private String orgName;

	public FavoritesVo() {

	}

	public FavoritesVo(int favoriteNo, int userNo, int prodNo, String brandName, String userName, String userId,
			int prodPrice, int prodSize, String engName, String korName, String filePath, int fileSize, String saveName,
			String orgName) {
		this.favoriteNo = favoriteNo;
		this.userNo = userNo;
		this.prodNo = prodNo;
		this.brandName = brandName;
		this.userName = userName;
		this.userId = userId;
		this.prodPrice = prodPrice;
		this.prodSize = prodSize;
		this.engName = engName;
		this.korName = korName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.saveName = saveName;
		this.orgName = orgName;
	}

	public int getFavoriteNo() {
		return favoriteNo;
	}

	public void setFavoriteNo(int favoriteNo) {
		this.favoriteNo = favoriteNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdSize() {
		return prodSize;
	}

	public void setProdSize(int prodSize) {
		this.prodSize = prodSize;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getKorName() {
		return korName;
	}

	public void setKorName(String korName) {
		this.korName = korName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return "FavoritesVo [favoriteNo=" + favoriteNo + ", userNo=" + userNo + ", prodNo=" + prodNo + ", brandName="
				+ brandName + ", userName=" + userName + ", userId=" + userId + ", prodPrice=" + prodPrice
				+ ", prodSize=" + prodSize + ", engName=" + engName + ", korName=" + korName + ", filePath=" + filePath
				+ ", fileSize=" + fileSize + ", saveName=" + saveName + ", orgName=" + orgName + "]";
	}

}
