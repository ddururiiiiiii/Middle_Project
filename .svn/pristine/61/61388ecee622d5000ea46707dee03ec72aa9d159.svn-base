package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.CommunityBoardVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class CommunityBoardDaoImpl implements ICommunityBoardDao {

	private static ICommunityBoardDao communityBoardBoardVO;
	
	public CommunityBoardDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static ICommunityBoardDao getInstance() {
		if(communityBoardBoardVO == null) {
			communityBoardBoardVO = new CommunityBoardDaoImpl();
		}
		return communityBoardBoardVO;
	}
	@Override
	public List<CommunityBoardVO> getAllCommunityBoard(SqlMapClient smc) throws SQLException {
		return smc.queryForList("communityBoard.getAllCommunityBoard");

	}

	@Override
	public CommunityBoardVO getCommunityBoard(SqlMapClient smc, String cbNm) throws SQLException {
		return (CommunityBoardVO) smc.queryForObject("communityBoard.getCommunityBoard", cbNm);
	}

	@Override
	public int insertCommunityBoard(SqlMapClient smc, CommunityBoardVO cbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("communityBoard.insertCommunityBoard", cbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateCommunityBoard(SqlMapClient smc, CommunityBoardVO cbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.update("communityBoard.updateCommunityBoard", cbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteCommunityBoard(SqlMapClient smc, CommunityBoardVO cbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.delete("communityBoard.deleteCommunityBoard", cbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public List<CommunityBoardVO> searchCommunityBoard(SqlMapClient smc, String str) throws SQLException {
		return smc.queryForList("communityBoard.searchCommunityBoard", str);
	}

	@Override
	public int getAllCommunityListCount(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("communityBoard.getFaqAllCount");
		return cnt;
	}

}
