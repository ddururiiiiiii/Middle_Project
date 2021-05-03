package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.QnaBoardVO;
import kr.or.ddit.comm.vo.PagingVO;

public interface IQnaBoardDao {
	
	/**
	 * 게시판 글 목록을 보는 메서드
	 * @param smc
	 * @return List<QnaBoardVO>
	 * @throws SQLException
	 */
	public List<QnaBoardVO> getAllQnaBoard(SqlMapClient smc, PagingVO pv) throws SQLException;
	
	/**
	 * 전체 게시글 수를 반환하는 메서드
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public int getAllQnaBoardListCount(SqlMapClient smc) throws SQLException;
	
	/**
	 * 게시글을 확인하는 메서드
	 * @param smc, qbv
	 * @return List<QnaBoardVO>
	 * @throws SQLException
	 */
	public QnaBoardVO getQnaBoard(SqlMapClient smc, String QnaNm) throws SQLException;

	/**
	 * 게시글 생성 메서드
	 * @param smc, qbv
	 * @return int
	 * @throws SQLException
	 */
	public int insertQnaBoard(SqlMapClient smc, QnaBoardVO qbv) throws SQLException;
	
	/**
	 * 게시글을 수정하는 메서드
	 * @param smc, qbv
	 * @return int
	 * @throws SQLException
	 */
	public int updateQnaBoard(SqlMapClient smc, QnaBoardVO qbv) throws SQLException;
	
	/**
	 * 게시글을 삭제하는 메서드
	 * @param smc, qbv
	 * @return int
	 * @throws SQLException
	 */
	public int deleteQnaBoard(SqlMapClient smc, QnaBoardVO qbv) throws SQLException;
	
	/**
	 * 게시글을 검색하는 메서드
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public List<QnaBoardVO> searchQnaBoard(SqlMapClient smc, String str) throws SQLException;
}
