package kr.or.ddit.comm.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.base.dao.BaseDao;
import kr.or.ddit.comm.vo.LikeyVO;

public class LikeyDao extends BaseDao {
	private SqlMapClient smc;
	
	public LikeyDao() {
		smc = super.getSqlMapClient();
	}
	
	/**
	 * 관심사 목록들을 가져오는 메서드
	 * @return List<LikeyVO>
	 * @throws SQLException
	 */
	public List<LikeyVO> retrieveLikeyList() throws SQLException {
		return smc.queryForList("likey.retrieveLikeyList");
	}
}
