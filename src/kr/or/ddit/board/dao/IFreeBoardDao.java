package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.FreeBoardVO;
import kr.or.ddit.comm.vo.PagingVO;

public interface IFreeBoardDao {
	
	/**
	 * 게시판 글 목록을 보는 메서드
	 * @param smc
	 * @return List<FreeBoardVO>
	 * @throws SQLException
	 */
	public List<FreeBoardVO> getAllFreeBoard(SqlMapClient smc, PagingVO pv) throws SQLException;
	
	/**
	 * 전체 게시글 수를 반환하는 메서드
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public int getAllFreeBoardListCount(SqlMapClient smc) throws SQLException;
	
	/**
	 * 게시글을 확인하는 메서드
	 * @param smc, fv
	 * @return List<FreeBoardVO>
	 * @throws SQLException
	 */
	public FreeBoardVO getFreeBoard(SqlMapClient smc, String FreeNm) throws SQLException;

	/**
	 * 게시글 생성 메서드
	 * @param smc, fv
	 * @return int
	 * @throws SQLException
	 */
	public int insertFreeBoard(SqlMapClient smc, FreeBoardVO fv) throws SQLException;
	
	/**
	 * 게시글을 수정하는 메서드
	 * @param smc, fv
	 * @return int
	 * @throws SQLException
	 */
	public int updateFreeBoard(SqlMapClient smc, FreeBoardVO fv) throws SQLException;
	
	/**
	 * 게시글을 삭제하는 메서드
	 * @param smc, fv
	 * @return int
	 * @throws SQLException
	 */
	public int deleteFreeBoard(SqlMapClient smc, FreeBoardVO fv) throws SQLException;
	
	/**
	 * 게시글을 검색하는 메서드
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public List<FreeBoardVO> searchFreeBoard(SqlMapClient smc, String str) throws SQLException;
}
