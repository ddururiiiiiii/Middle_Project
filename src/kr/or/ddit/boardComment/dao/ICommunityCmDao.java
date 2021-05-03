package kr.or.ddit.boardComment.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.boardComment.vo.CommunityCmVO;


public interface ICommunityCmDao {

	/**
	 * 후기 게시판 댓글 조회
	 * @param smc
	 * @param ccNm
	 * @return
	 * @throws SQLException
	 */
	public List<CommunityCmVO> getAllCommunityCm(SqlMapClient smc, String cbNm) throws SQLException;

	/**
	 * 후기 게시판 댓글 등록
	 * @param smc
	 * @param ccv
	 * @return
	 * @throws SQLException
	 */
	public int insertCommunityCm(SqlMapClient smc, CommunityCmVO ccv) throws SQLException;
	
	
	/**
	 * 후기 게시판 댓글 수정
	 * @param smc
	 * @param ccv
	 * @return
	 * @throws SQLException
	 */
	public int updateCommunityCm(SqlMapClient smc, CommunityCmVO ccv) throws SQLException;
	

	/**
	 * 후기 게시판 댓글 삭제
	 * @param smc
	 * @param ccv
	 * @return
	 * @throws SQLException
	 */
	public int deleteCommunityCm(SqlMapClient smc, CommunityCmVO ccv) throws SQLException;
	
}
