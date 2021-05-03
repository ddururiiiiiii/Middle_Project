package kr.or.ddit.comm.vo;

import java.util.Date;

public class AtchFileVO {
	
	private long atchFileId = -1;
	private Date createDate;
	private long fileSn = -1;
	private String fileStreCours;
	private String streFileNm;
	private String orignlFileNm;
	private String fileExtsn;
	private String fileCn;
	private long fileSize = 0;
	private String userId;
	private String imgUrl;
	
	
	
	public String getImgUrl() {
		String result = getFileStreCours();
		String[] modNum = result.split("/");
		String arr7 = modNum[6];
		String arr8 = modNum[7];
		
		String result1 = "../" + arr7 + "/" + arr8;
		return result1;
	}
	private String tempPath;//임시경로
	
	public long getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public long getFileSn() {
		return fileSn;
	}
	public void setFileSn(long fileSn) {
		this.fileSn = fileSn;
	}
	public String getFileStreCours() {
		return fileStreCours;
	}
	public void setFileStreCours(String fileStreCours) {
		this.fileStreCours = fileStreCours;
	}
	public String getStreFileNm() {
		return streFileNm;
	}
	public void setStreFileNm(String streFileNm) {
		this.streFileNm = streFileNm;
	}
	public String getOrignlFileNm() {
		return orignlFileNm;
	}
	public void setOrignlFileNm(String orignlFileNm) {
		this.orignlFileNm = orignlFileNm;
	}
	public String getFileExtsn() {
		return fileExtsn;
	}
	public void setFileExtsn(String fileExtsn) {
		this.fileExtsn = fileExtsn;
	}
	public String getFileCn() {
		return fileCn;
	}
	public void setFileCn(String fileCn) {
		this.fileCn = fileCn;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTempPath() {
		return tempPath;
	}
	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	

}
