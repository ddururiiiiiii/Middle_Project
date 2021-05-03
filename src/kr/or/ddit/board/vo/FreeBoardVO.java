package kr.or.ddit.board.vo;

public class FreeBoardVO {
	
	private String freeNm;
	private int boardNm;
	private String freeTitle;
	private String freeContent;
	private String freeDate;
	private String freeWriter;
	private long atchFileId = -1;
	private int rNum;
	
	public String getFreeNm() {
		return freeNm;
	}
	public void setFreeNm(String freeNm) {
		this.freeNm = freeNm;
	}
	public int getBoardNm() {
		return boardNm;
	}
	public void setBoardNm(int boardNm) {
		this.boardNm = boardNm;
	}
	public String getFreeTitle() {
		return freeTitle;
	}
	public void setFreeTitle(String freeTitle) {
		this.freeTitle = freeTitle;
	}
	public String getFreeContent() {
		return freeContent;
	}
	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}
	public String getFreeDate() {
		return freeDate;
	}
	public void setFreeDate(String freeDate) {
		this.freeDate = freeDate;
	}
	public String getFreeWriter() {
		return freeWriter;
	}
	public void setFreeWriter(String freeWriter) {
		this.freeWriter = freeWriter;
	}
	public long getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}
	public int getRNum() {
		return rNum;
	}
	public void setRNum(int rNum) {
		this.rNum = rNum;
	}
	
	
}
