package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.QnaBoardVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class QnaBoardDaoImpl implements IQnaBoardDao {

	private static IQnaBoardDao qba;
	
	public QnaBoardDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static IQnaBoardDao getInstance() {
		if(qba == null) {
			qba = new QnaBoardDaoImpl();
		}
		return qba;
	}

	@Override
	public List<QnaBoardVO> getAllQnaBoard(SqlMapClient smc, PagingVO pv) throws SQLException {
		return smc.queryForList("qnaBoard.getAllQnaBoard", pv);
	}

	@Override
	public QnaBoardVO getQnaBoard(SqlMapClient smc, String QnaNm) throws SQLException {
		return (QnaBoardVO) smc.queryForObject("qnaBoard.getQnaBoard", QnaNm);
	}

	@Override
	public int insertQnaBoard(SqlMapClient smc, QnaBoardVO qbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("qnaBoard.insertQnaBoard", qbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateQnaBoard(SqlMapClient smc, QnaBoardVO qbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.update("qnaBoard.updateQnaBoard", qbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteQnaBoard(SqlMapClient smc, QnaBoardVO qbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.delete("qnaBoard.deleteQnaBoard", qbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public List<QnaBoardVO> searchQnaBoard(SqlMapClient smc, String str) throws SQLException {
		return smc.queryForList("qnaBoard.searchQnaBoard", str);
	}

	@Override
	public int getAllQnaBoardListCount(SqlMapClient smc) throws SQLException {
		return (int) smc.queryForObject("qnaBoard.getAllQnaBoardListCount");
	}
}
