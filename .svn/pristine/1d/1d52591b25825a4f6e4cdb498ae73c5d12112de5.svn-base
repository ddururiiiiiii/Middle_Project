package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.FreeBoardVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class FreeBoardDaoImpl implements IFreeBoardDao{

	private static IFreeBoardDao freeDao;
	
	public FreeBoardDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static IFreeBoardDao getInstance() {
		if(freeDao == null) {
			freeDao = new FreeBoardDaoImpl();
		}
		return freeDao;
	}

	@Override
	public List<FreeBoardVO> getAllFreeBoard(SqlMapClient smc, PagingVO pv) throws SQLException {
		return smc.queryForList("freeBoard.getAllFreeBoard", pv);
	}

	@Override
	public FreeBoardVO getFreeBoard(SqlMapClient smc, String FreeNm) throws SQLException {
		return (FreeBoardVO) smc.queryForObject("freeBoard.getFreeBoard", FreeNm);
	}

	@Override
	public int insertFreeBoard(SqlMapClient smc, FreeBoardVO fv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("freeBoard.insertFreeBoard", fv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateFreeBoard(SqlMapClient smc, FreeBoardVO fv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.update("freeBoard.updateFreeBoard", fv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteFreeBoard(SqlMapClient smc, FreeBoardVO fv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.delete("freeBoard.deleteFreeBoard", fv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public List<FreeBoardVO> searchFreeBoard(SqlMapClient smc, String str) throws SQLException {
		return smc.queryForList("freeBoard.searchFreeBoard", str);
	}

	@Override
	public int getAllFreeBoardListCount(SqlMapClient smc) throws SQLException {
		return (int) smc.queryForObject("freeBoard.getFreeBoardListCount");
	}
}
