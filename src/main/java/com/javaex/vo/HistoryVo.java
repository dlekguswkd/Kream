package com.javaex.vo;

public class HistoryVo {

	private int historyNo;
	private int userNo;
	private int prodNo;
	private String shippingStatus;
	private int prodPrice;
	private int prodSize;
	private String purchaseDate;

	public HistoryVo(int historyNo, int userNo, int prodNo, String shippingStatus, int prodPrice, int prodSize,
			String purchaseDate) {
		this.historyNo = historyNo;
		this.userNo = userNo;
		this.prodNo = prodNo;
		this.shippingStatus = shippingStatus;
		this.prodPrice = prodPrice;
		this.prodSize = prodSize;
		this.purchaseDate = purchaseDate;
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

	@Override
	public String toString() {
		return "HistoryVo [historyNo=" + historyNo + ", userNo=" + userNo + ", prodNo=" + prodNo + ", shippingStatus="
				+ shippingStatus + ", prodPrice=" + prodPrice + ", prodSize=" + prodSize + ", purchaseDate="
				+ purchaseDate + "]";
	}

}
