package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.NoticeBoardVO;
import kr.or.ddit.comm.vo.PagingVO;


public interface INoticeBoardDao {

	/**
	 * 공지사항 목록 조회
	 * @param smc
	 * @return list
	 * @throws SQLException
	 */
	public List<NoticeBoardVO> getAllNoticeBoard(SqlMapClient smc, PagingVO pv) throws SQLException;
	
	/**
	 * 전체 게시글 수를 반환하는 메서드 
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public int getNoticeBoardListCount(SqlMapClient smc) throws SQLException;

	/**
	 * 해당 번호 공지사항 조회 
	 * @param smc
	 * @param notice_nm
	 * @return
	 * @throws SQLException
	 */
	public NoticeBoardVO getNoticeBoard(SqlMapClient smc, String noticeNm) throws SQLException;

	/**
	 * 공지사항 등록
	 * @param smc
	 * @param nv
	 * @return 성공 1 실패 0
	 * @throws SQLException
	 */
	public int insertNoticeBoard(SqlMapClient smc, NoticeBoardVO nv) throws SQLException;
	
	
	/**
	 * 공지사항 수정 
	 * @param smc
	 * @param nv
	 * @return 성공 1 실패 0
	 * @throws SQLException
	 */
	public int updateNoticeBoard(SqlMapClient smc, NoticeBoardVO nv) throws SQLException;
	
	
	/**
	 * 공지사항 삭제
	 * @param smc
	 * @param notice_nm
	 * @return
	 * @throws SQLException
	 */
	public int deleteNoticeBoard(SqlMapClient smc, NoticeBoardVO nv) throws SQLException;

	/**
	 * 공지사항 검색 
	 * @param smc
	 * @param nv
	 * @return
	 * @throws SQLException
	 */
	public List<NoticeBoardVO> getSearchNoticeBoard(SqlMapClient smc, String noticeTitle) throws SQLException;
	
	
}
