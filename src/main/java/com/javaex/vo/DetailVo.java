package com.javaex.vo;

public class DetailVo {
	
	private int prodNo;
	private int categoryNo;
	private String engName;
	private String korName;
	private String modelNo;
	private String filePath;
	private int fileSize;
	private String saveName;
	private String orgName;
	private int colorNo;
	private int userNo;
	private int brandNo;
	private int historyNo;
	private int cartNo;
	private int prodSize;
	private int prodPrice;
	
	
	public DetailVo() {
		super();
	}
	
	public DetailVo(int prodNo, int categoryNo, String engName, String korName, String modelNo, String filePath,
			int fileSize, String saveName, String orgName, int colorNo, int brandNo, int historyNo, int cartNo,
			int prodSize, int prodPrice) {
		super();
		this.prodNo = prodNo;
		this.categoryNo = categoryNo;
		this.engName = engName;
		this.korName = korName;
		this.modelNo = modelNo;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.saveName = saveName;
		this.orgName = orgName;
		this.colorNo = colorNo;
		this.brandNo = brandNo;
		this.historyNo = historyNo;
		this.cartNo = cartNo;
		this.prodSize = prodSize;
		this.prodPrice = prodPrice;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
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

	public int getColorNo() {
		return colorNo;
	}

	public void setColorNo(int colorNo) {
		this.colorNo = colorNo;
	}

	public int getBrandNo() {
		return brandNo;
	}

	public void setBrandNo(int brandNo) {
		this.brandNo = brandNo;
	}

	public int getHistoryNo() {
		return historyNo;
	}

	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getProdSize() {
		return prodSize;
	}

	public void setProdSize(int prodSize) {
		this.prodSize = prodSize;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Override
	public String toString() {
		return "DetailVo [prodNo=" + prodNo + ", categoryNo=" + categoryNo + ", engName=" + engName + ", korName="
				+ korName + ", modelNo=" + modelNo + ", filePath=" + filePath + ", fileSize=" + fileSize + ", saveName="
				+ saveName + ", orgName=" + orgName + ", colorNo=" + colorNo + ", brandNo=" + brandNo + ", historyNo="
				+ historyNo + ", cartNo=" + cartNo + ", prodSize=" + prodSize + ", prodPrice=" + prodPrice + "]";
	}
	
	

}
