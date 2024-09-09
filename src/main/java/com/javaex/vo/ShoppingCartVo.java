package com.javaex.vo;

public class ShoppingCartVo {

	private int cartNo;
	private int userNo;
	private int prodNo;
	private int prodSize;
	private String engName;
	private String korName;
	private String modelNo;
	private int prodPrice;
	private int totalPrice;
	private String filePath;
	private String saveName;
	private String orgName;

	public ShoppingCartVo() {

	}

	public ShoppingCartVo(int cartNo, int userNo, int prodNo, int prodSize, String engName, String korName,
			String modelNo, int prodPrice, int totalPrice, String filePath, String saveName, String orgName) {
		this.cartNo = cartNo;
		this.userNo = userNo;
		this.prodNo = prodNo;
		this.prodSize = prodSize;
		this.engName = engName;
		this.korName = korName;
		this.modelNo = modelNo;
		this.prodPrice = prodPrice;
		this.totalPrice = totalPrice;
		this.filePath = filePath;
		this.saveName = saveName;
		this.orgName = orgName;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
		return "ShoppingCartVo [cartNo=" + cartNo + ", userNo=" + userNo + ", prodNo=" + prodNo + ", prodSize="
				+ prodSize + ", engName=" + engName + ", korName=" + korName + ", modelNo=" + modelNo + ", prodPrice="
				+ prodPrice + ", totalPrice=" + totalPrice + ", filePath=" + filePath + ", saveName=" + saveName
				+ ", orgName=" + orgName + "]";
	}

}
