package kr.or.ddit.boardComment.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.boardComment.vo.FreeCmVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class FreeCmDaoImpl implements IFreeCmDao {

	private static IFreeCmDao fcd;
	
	public FreeCmDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static IFreeCmDao getInstance() {
		if(fcd == null) {
			fcd = new FreeCmDaoImpl();
		}
		return fcd;
	}
	
	@Override
	public List<FreeCmVO> getAllFreeCm(SqlMapClient smc, PagingVO pv) throws SQLException {
		return smc.queryForList("freeCm.getAllFreeCm", pv);
	}
	
	@Override
	public int insertFreeCm(SqlMapClient smc, FreeCmVO fcv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("freeCm.insertFreeCm", fcv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateFreeCm(SqlMapClient smc, FreeCmVO fcv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.update("freeCm.updateFreeCm", fcv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteFreeCm(SqlMapClient smc, FreeCmVO fcv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.delete("freeCm.deleteFreeCm", fcv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int getAllFreeCmCount(SqlMapClient smc, String freeNm) throws SQLException {
		return (int) smc.queryForObject("freeCm.getAllFreeCmCount", freeNm);
	}

}
