package kr.or.ddit.boardComment.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.boardComment.vo.NoticeCmVO;

public interface INoticeCmDao {

	
	/**
	 * 공지사항 댓글 조회
	 * @param ncNm
	 * @param nv
	 * @return
	 * @throws SQLException
	 */
	public List<NoticeCmVO> getNoticeCmListByNoticeNm(SqlMapClient smc, String noticeNm) throws SQLException;

	/**
	 * 공지사항 댓글 등록
	 * @param smc
	 * @param nv
	 * @return
	 * @throws SQLException
	 */
	public int insertNoticeCm(SqlMapClient smc, NoticeCmVO ncv) throws SQLException;
	
	/**
	 * 공지사항 댓글 수정
	 * @param smc
	 * @param ncv
	 * @return
	 * @throws SQLException
	 */
	public int updateNoticeCm(SqlMapClient smc, NoticeCmVO ncv) throws SQLException;
	
	/**
	 * 공지사항 댓글 삭제
	 * @param smc
	 * @param ncv
	 * @return
	 * @throws SQLException
	 */
	public int deleteNoticeCm(SqlMapClient smc, NoticeCmVO ncv) throws SQLException;

	
}
