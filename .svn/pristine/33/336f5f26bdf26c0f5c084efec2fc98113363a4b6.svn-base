package kr.or.ddit.boardComment.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.boardComment.vo.QnaCmVO;

public interface IQnaCmDao {
	
	/**
	 * QnA게시판 댓글 목록 출력 메서드
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public List<QnaCmVO> getAllQnaCm(SqlMapClient smc, String qnaNm) throws SQLException;
	
	/**
	 * QnA게시판 댓글 작성 메서드
	 * @param smc
	 * @param qcv
	 * @return
	 * @throws SQLException
	 */
	
	/**
	 * QnA게시판 댓글 하나만 가져오는 메서드
	 * @param smc
	 * @param qvc
	 * @return
	 * @throws SQLException
	 */
	public QnaCmVO getQnaCm(SqlMapClient smc, QnaCmVO qvc) throws SQLException;
	
	/**
	 * QnA게시판 댓글 등록 메서드
	 * @param smc
	 * @param qcv
	 * @return
	 * @throws SQLException
	 */
	public int insertQnaCm(SqlMapClient smc, QnaCmVO qcv) throws SQLException;
	
	/**
	 * QnA게시판 댓글 수정 메서드
	 * @param smc
	 * @param qcv
	 * @return
	 * @throws SQLException
	 */
	public int updateQnaCm(SqlMapClient smc, QnaCmVO qcv) throws SQLException;
	
	/**
	 * QnA게시판 댓글 삭제 메서드
	 * @param smc
	 * @param qnaCmNm
	 * @return
	 * @throws SQLException
	 */
	public int deleteQnaCm(SqlMapClient smc, QnaCmVO qcv) throws SQLException;
	
}
