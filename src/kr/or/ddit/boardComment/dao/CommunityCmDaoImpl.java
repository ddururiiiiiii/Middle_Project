package kr.or.ddit.boardComment.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.boardComment.vo.CommunityCmVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class CommunityCmDaoImpl implements ICommunityCmDao {
	
	private static ICommunityCmDao ccd;
	
	public CommunityCmDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static ICommunityCmDao getInstance() {
		if(ccd == null) {
			ccd = new CommunityCmDaoImpl();
		}
		return ccd;
	}

	@Override
	public List<CommunityCmVO> getAllCommunityCm(SqlMapClient smc, String cbNm) throws SQLException {
		return smc.queryForList("Community.getAllCommunityCm",cbNm );
	}

	@Override
	public int insertCommunityCm(SqlMapClient smc, CommunityCmVO ccv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("Community.insertCommunityCm", ccv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateCommunityCm(SqlMapClient smc, CommunityCmVO ccv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.update("Community.updateCommunityCm", ccv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteCommunityCm(SqlMapClient smc, CommunityCmVO ccv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.delete("Community.deleteCommunityCm", ccv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

}
