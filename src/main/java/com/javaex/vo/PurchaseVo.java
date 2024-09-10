package com.javaex.vo;

public class PurchaseVo {

	private int historyNo;
	private int userNo;
	private String userName;
	private String userId;
	private String userAddress;
	private int prodNo;
	private String shippingStatus;
	private int prodPrice;
	private int totalPrice;
	private int prodSize;
	private String purchaseDate;
	private String engName;
	private String korName;
	private String filePath;
	private int fileSize;
	private String saveName;
	private String orgName;
	private int reciptNo;

	public PurchaseVo() {

	}

	public PurchaseVo(int historyNo, int userNo, String userName, String userId, String userAddress, int prodNo,
			String shippingStatus, int prodPrice, int totalPrice, int prodSize, String purchaseDate, String engName,
			String korName, String filePath, int fileSize, String saveName, String orgName, int reciptNo) {
		this.historyNo = historyNo;
		this.userNo = userNo;
		this.userName = userName;
		this.userId = userId;
		this.userAddress = userAddress;
		this.prodNo = prodNo;
		this.shippingStatus = shippingStatus;
		this.prodPrice = prodPrice;
		this.totalPrice = totalPrice;
		this.prodSize = prodSize;
		this.purchaseDate = purchaseDate;
		this.engName = engName;
		this.korName = korName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.saveName = saveName;
		this.orgName = orgName;
		this.reciptNo = reciptNo;
	}

	public int getHistoryNo() {
		return historyNo;
	}

	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
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

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
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

	public int getProdSize() {
		return prodSize;
	}

	public void setProdSize(int prodSize) {
		this.prodSize = prodSize;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
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

	public int getReciptNo() {
		return reciptNo;
	}

	public void setReciptNo(int reciptNo) {
		this.reciptNo = reciptNo;
	}

	@Override
	public String toString() {
		return "PurchaseVo [historyNo=" + historyNo + ", userNo=" + userNo + ", userName=" + userName + ", userId="
				+ userId + ", userAddress=" + userAddress + ", prodNo=" + prodNo + ", shippingStatus=" + shippingStatus
				+ ", prodPrice=" + prodPrice + ", totalPrice=" + totalPrice + ", prodSize=" + prodSize
				+ ", purchaseDate=" + purchaseDate + ", engName=" + engName + ", korName=" + korName + ", filePath="
				+ filePath + ", fileSize=" + fileSize + ", saveName=" + saveName + ", orgName=" + orgName
				+ ", reciptNo=" + reciptNo + "]";
	}

}
