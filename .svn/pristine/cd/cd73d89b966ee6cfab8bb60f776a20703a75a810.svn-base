package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.CommunityBoardVO;
import kr.or.ddit.comm.vo.PagingVO;


public interface ICommunityBoardDao {

	/**
	 * 리뷰게시판 전체 조회
	 * @param smc
	 * @param pagingVO
	 * @return
	 * @throws SQLException
	 */
	public List<CommunityBoardVO> getAllCommunityBoard(SqlMapClient smc) throws SQLException; 

	/**
	 * 리뷰게시판 클릭 하나 조회
	 * @param smc
	 * @param cbNm
	 * @return
	 * @throws SQLException
	 */
	public CommunityBoardVO getCommunityBoard(SqlMapClient smc, String cbNm) throws SQLException;


	/**
	 * 리뷰게시판 등록 
	 * @param smc
	 * @param cbv
	 * @return
	 * @throws SQLException
	 */
	public int insertCommunityBoard(SqlMapClient smc, CommunityBoardVO cbv) throws SQLException;
	

	/**
	 * 리뷰게시판 수정
	 * @param smc
	 * @param cbv
	 * @return
	 * @throws SQLException
	 */
	public int updateCommunityBoard(SqlMapClient smc, CommunityBoardVO cbv) throws SQLException;
	

	/**
	 * 리뷰게시판 삭제
	 * @param smc
	 * @param cbv
	 * @return
	 * @throws SQLException
	 */
	public int deleteCommunityBoard(SqlMapClient smc, CommunityBoardVO cbv) throws SQLException;

	/**
	 * 리뷰게시판 검색
	 * @param smc
	 * @param cbv
	 * @return
	 * @throws SQLException
	 */
	List<CommunityBoardVO> searchCommunityBoard(SqlMapClient smc, String str) throws SQLException;
	
	/**
	 * 전체 게시판 카운트
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public int getAllCommunityListCount(SqlMapClient smc) throws SQLException;
}
