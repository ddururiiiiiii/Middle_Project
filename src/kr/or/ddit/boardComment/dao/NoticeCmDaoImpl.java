package kr.or.ddit.boardComment.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.NoticeBoardDaoImpl;
import kr.or.ddit.board.vo.NoticeBoardVO;
import kr.or.ddit.boardComment.vo.NoticeCmVO;

public class NoticeCmDaoImpl implements INoticeCmDao{

	private static INoticeCmDao NoticeCmDao;
	
	public static INoticeCmDao getInstance() {
		if(NoticeCmDao == null) {
			NoticeCmDao = new NoticeCmDaoImpl();
		}
		return NoticeCmDao;
	}

	//공지사항 댓글 조회
	@Override
	public List<NoticeCmVO> getNoticeCmListByNoticeNm(SqlMapClient smc, String noticeNm) throws SQLException {
		return smc.queryForList("noticeCm.getNoticeCmListByNoticeNm", noticeNm);
	}

	//공지사항 댓글 등록
	@Override
	public int insertNoticeCm(SqlMapClient smc, NoticeCmVO ncv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("noticeCm.insertNoticeCm", ncv);
		
		if (obj == null) {
			cnt = 1; //성공
		}
		return cnt;
	}

	//공지사항 댓글 수정
	@Override
	public int updateNoticeCm(SqlMapClient smc, NoticeCmVO ncv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.update("noticeCm.updateNoticeCm", ncv);
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	//공지사항 댓글 삭제
	@Override
	public int deleteNoticeCm(SqlMapClient smc, NoticeCmVO ncv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.delete("noticeCm.deleteNoticeCm", ncv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}
}