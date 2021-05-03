package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.ReportBoardVO;
import kr.or.ddit.comm.vo.PagingVO;

public interface IReportService {

	
	/**
	 * 신고 게시판 전체 목록 조회 메서드
	 * @return List<ReportBoardVO>
	 */
	public List<ReportBoardVO> getAllReportBoardList(PagingVO pv);
	
	/**
	 * 신고게시판 모든 글 수 조회 메서드
	 * @return
	 */
	public int getAllReportListCount();
	
	/**
	 * 게시글 조회 메서드
	 * @param reportNm
	 * @return ReportBoardVO
	 */
	public ReportBoardVO getReportBoard(String reportNm);
	
	/**
	 * 게시글 등록 메서드
	 * @param rbv
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int insertReportBoard(ReportBoardVO rbv);
	
	/**
	 * 게시글 수정 메서드
	 * @param rbv
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateReportBoard(ReportBoardVO rbv);
	
	/**
	 * 게시글 삭제 메서드
	 * @param rbv
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteReportBoard(ReportBoardVO rbv);
	
	/**
	 * 게시글 검색 메서드
	 * @param str
	 * @return List<ReportBoardVO>
	 */
	public List<ReportBoardVO> searchReportBoard(String str);
	
	
	
}
