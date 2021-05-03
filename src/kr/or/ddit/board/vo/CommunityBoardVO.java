package kr.or.ddit.board.vo;

import java.util.List;

import kr.or.ddit.project.vo.ProjectVO;

public class CommunityBoardVO {
	private String cbNm;
	private String pjNm; //프로젝트 번호
	private String pjName; //프로젝트 이름	
	private String cbTitle;
	private String cbContent;
	private String cbDate;
	private String cbWriter;
	private long atchFileId = -1;
	
	private List<ProjectVO> projectVOList;
	
	public String getCbNm() {
		return cbNm;
	}
	public void setCbNm(String cbNm) {
		this.cbNm = cbNm;
	}
	public String getPjNm() {
		return pjNm;
	}
	public void setPjNm(String pjNm) {
		this.pjNm = pjNm;
	}
	public String getPjName() {
		return pjName;
	}
	public void setPjName(String pjName) {
		this.pjName = pjName;
	}
	public String getCbTitle() {
		return cbTitle;
	}
	public void setCbTitle(String cbTitle) {
		this.cbTitle = cbTitle;
	}
	public String getCbContent() {
		return cbContent;
	}
	public void setCbContent(String cbContent) {
		this.cbContent = cbContent;
	}
	public String getCbDate() {
		return cbDate;
	}
	public void setCbDate(String cbDate) {
		this.cbDate = cbDate;
	}
	public long getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}
	
	public String getCbWriter() {
		return cbWriter;
	}
	public void setCbWriter(String cbWriter) {
		this.cbWriter = cbWriter;
	}
	public List<ProjectVO> getProjectVOList() {
		return projectVOList;
	}
	public void setProjectVOList(List<ProjectVO> projectVOList) {
		this.projectVOList = projectVOList;
	}
		
}
