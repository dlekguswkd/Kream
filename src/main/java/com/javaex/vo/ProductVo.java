package com.javaex.vo;

public class ProductVo {
	private int prodNo;
	private int brandNo;
	private String brandName;
	private int categoryNo;
	private String categoryName;
	private int colorNo;
	private int prodSize;
	private int prodPrice;
	private String releaseDate;
	private String colorName;
	private String colorCode;
	private String engName;
	private String korName;
	private String modelNo;
	private String filePath;
	private long fileSize;
	private String saveName;
	private String orgName;

	public ProductVo() {

	}

	public ProductVo(int prodNo, int brandNo, String brandName, int categoryNo, String categoryName, int colorNo,
			int prodSize, int prodPrice, String releaseDate, String colorName, String colorCode, String engName,
			String korName, String modelNo, String filePath, long fileSize, String saveName, String orgName) {
		this.prodNo = prodNo;
		this.brandNo = brandNo;
		this.brandName = brandName;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.colorNo = colorNo;
		this.prodSize = prodSize;
		this.prodPrice = prodPrice;
		this.releaseDate = releaseDate;
		this.colorName = colorName;
		this.colorCode = colorCode;
		this.engName = engName;
		this.korName = korName;
		this.modelNo = modelNo;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.saveName = saveName;
		this.orgName = orgName;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public int getBrandNo() {
		return brandNo;
	}

	public void setBrandNo(int brandNo) {
		this.brandNo = brandNo;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getColorNo() {
		return colorNo;
	}

	public void setColorNo(int colorNo) {
		this.colorNo = colorNo;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
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

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
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
		return "ProductVo [prodNo=" + prodNo + ", brandNo=" + brandNo + ", brandName=" + brandName + ", categoryNo="
				+ categoryNo + ", categoryName=" + categoryName + ", colorNo=" + colorNo + ", prodSize=" + prodSize
				+ ", prodPrice=" + prodPrice + ", releaseDate=" + releaseDate + ", colorName=" + colorName
				+ ", colorCode=" + colorCode + ", engName=" + engName + ", korName=" + korName + ", modelNo=" + modelNo
				+ ", filePath=" + filePath + ", fileSize=" + fileSize + ", saveName=" + saveName + ", orgName="
				+ orgName + "]";
	}

}