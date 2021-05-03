package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.NoticeBoardVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class NoticeBoardDaoImpl implements INoticeBoardDao {

private static INoticeBoardDao noticeDao;
	
	private NoticeBoardDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static INoticeBoardDao getInstance() {
		if(noticeDao == null) {
			noticeDao = new NoticeBoardDaoImpl();
		}
		return noticeDao;
	}
	
	@Override //공지사항 게시글 등록
	public int insertNoticeBoard(SqlMapClient smc, NoticeBoardVO nv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("noticeBoard.insertNoticeBoard", nv);
		if (obj == null) {
			cnt = 1; //성공  
		}
		return cnt;
	}
	
	@Override //전체 조회
	public List<NoticeBoardVO> getAllNoticeBoard(SqlMapClient smc, PagingVO pv) throws SQLException {
		return smc.queryForList("noticeBoard.getAllNoticeBoard", pv);
	}
	
	@Override //공지사항 게시글 수정
	public int updateNoticeBoard(SqlMapClient smc, NoticeBoardVO nv) throws SQLException {
		return smc.update("noticeBoard.updateNoticeBoard", nv);
	}
	
	@Override //공지사항 게시글 검색 (제목)
	public List<NoticeBoardVO> getSearchNoticeBoard(SqlMapClient smc, String noticeTitle) throws SQLException {
		return smc.queryForList("noticeBoard.getsearchNoticeBoard", noticeTitle);
	}
	
	@Override //공지사항 삭제
	public int deleteNoticeBoard(SqlMapClient smc, NoticeBoardVO nv) throws SQLException {
		return smc.update("noticeBoard.deleteNoticeBoard", nv);
	}
	
	@Override //공지사항 단건 조회
	public NoticeBoardVO getNoticeBoard(SqlMapClient smc, String noticeNm) throws SQLException {
		return (NoticeBoardVO)smc.queryForObject("noticeBoard.getNoticeBoardInfo", noticeNm);
	}

	@Override
	public int getNoticeBoardListCount(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("noticeBoard.getNoticeBoardListCount");
		return cnt;
	}
	
}
