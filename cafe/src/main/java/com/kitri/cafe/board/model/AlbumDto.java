package com.kitri.cafe.board.model;

public class AlbumDto extends BoardDto{
	
	private int aseg;
//	private int seg;
	private String orignPicture;
	private String savePicture;
	private String saveFolder;
	private int type;
	
	public int getAseg() {
		return aseg;
	}
	public void setAseg(int aseg) {
		this.aseg = aseg;
	}
	public String getOrignPicture() {
		return orignPicture;
	}
	public void setOrignPicture(String orignPicture) {
		this.orignPicture = orignPicture;
	}
	public String getSavePicture() {
		return savePicture;
	}
	public void setSavePicture(String savePicture) {
		this.savePicture = savePicture;
	}
	public String getSaveFolder() {
		return saveFolder;
	}
	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
