package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.ReportBoardVO;
import kr.or.ddit.comm.vo.PagingVO;


public interface IReportBoardDao {
	/**
	 * 글 목록 전체를 가져오는 메서드
	 * @param smc
	 * @param pv
	 * @return
	 * @throws SQLException
	 */
	public List<ReportBoardVO> getAllReportBoard(SqlMapClient smc, PagingVO pv) throws SQLException;
	
	/**
	 * 게시글의 총 수를 가져오는 메서드
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public int getAllReportListCount(SqlMapClient smc) throws SQLException;
	
	/**
	 * 게시글 조회
	 * @param smc
	 * @param QnaNm
	 * @return
	 * @throws SQLException
	 */
	public ReportBoardVO getReportBoard(SqlMapClient smc, String QnaNm) throws SQLException;

	/**
	 * 게시글 등록
	 * @param smc
	 * @param rbv
	 * @return
	 * @throws SQLException
	 */
	public int insertReportBoard(SqlMapClient smc, ReportBoardVO rbv) throws SQLException;
	
	/**
	 * 게시글 수정
	 * @param smc
	 * @param rbv
	 * @return
	 * @throws SQLException
	 */
	public int updateReportBoard(SqlMapClient smc, ReportBoardVO rbv) throws SQLException;
	
	/**
	 * 게시글 삭제
	 * @param smc
	 * @param rbv
	 * @return
	 * @throws SQLException
	 */
	public int deleteReportBoard(SqlMapClient smc, ReportBoardVO rbv) throws SQLException;
	
	/**
	 * 게시글 검색
	 * @param smc
	 * @param str
	 * @return
	 * @throws SQLException
	 */
	public List<ReportBoardVO> searchReportBoard(SqlMapClient smc, String str) throws SQLException;
}
