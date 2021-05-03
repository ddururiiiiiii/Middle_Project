package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.FaqBoardVO;
import kr.or.ddit.comm.vo.PagingVO;

public interface IFaqBoardDao {

	/**
	 * 게시글 전체 조회
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public List<FaqBoardVO> getAllFaqBoard(SqlMapClient smc, PagingVO pagingVO) throws SQLException;
	
	/**
	 * 게시글 조회
	 * @param smc
	 * @param faqNm
	 * @return
	 * @throws SQLException
	 */
	public FaqBoardVO getFaqBoard(SqlMapClient smc, String faqNm) throws SQLException;

	/**
	 * 게시글 등록
	 * @param smc
	 * @param fbv
	 * @return
	 * @throws SQLException
	 */
	public int insertFaqBoard(SqlMapClient smc, FaqBoardVO fbv) throws SQLException;
	
	/**
	 * 게시글 수정
	 * @param smc
	 * @param fbv
	 * @return
	 * @throws SQLException
	 */
	public int updateFaqBoard(SqlMapClient smc, FaqBoardVO fbv) throws SQLException;
	
	/**
	 * 게시글 삭제
	 * @param smc
	 * @param fbv
	 * @return
	 * @throws SQLException
	 */
	public int deleteFaqBoard(SqlMapClient smc, FaqBoardVO fbv) throws SQLException;
	
	/**
	 * 게시글 검색
	 * @param smc
	 * @param str
	 * @return
	 * @throws SQLException
	 */
	public List<FaqBoardVO> searchFaqBoard(SqlMapClient smc, String faqTitle) throws SQLException;

	/**
	 * 전체 게시판 카운트
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public int getAllFaqBoardListCount(SqlMapClient smc) throws SQLException;
}
