package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.FaqBoardVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class FaqBoardDaoImpl implements IFaqBoardDao{
	
	private static IFaqBoardDao faqBoardVO;
	
	public FaqBoardDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static IFaqBoardDao getInstance() {
		if(faqBoardVO == null) {
			faqBoardVO = new FaqBoardDaoImpl();
		}
		return faqBoardVO;
	}

	@Override
	public List<FaqBoardVO> getAllFaqBoard(SqlMapClient smc, PagingVO pagingVO) throws SQLException {
		List<FaqBoardVO> faqList = smc.queryForList("faqBoard.getAllFaqBoard", pagingVO);
		return faqList;
	}

	@Override
	public FaqBoardVO getFaqBoard(SqlMapClient smc, String faqNm) throws SQLException {
		return (FaqBoardVO) smc.queryForObject("faqBoard.getFaqBoard", faqNm);
	}

	@Override
	public int insertFaqBoard(SqlMapClient smc, FaqBoardVO fbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("faqBoard.insertFaqBoard", fbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateFaqBoard(SqlMapClient smc, FaqBoardVO fbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.update("faqBoard.updateFaqBoard", fbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteFaqBoard(SqlMapClient smc, FaqBoardVO fbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.delete("faqBoard.deleteFaqBoard", fbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public List<FaqBoardVO> searchFaqBoard(SqlMapClient smc, String faqTitle) throws SQLException {
		return smc.queryForList("faqBoard.searchFaqBoard", faqTitle);
	}

	@Override
	public int getAllFaqBoardListCount(SqlMapClient smc) throws SQLException {
		int cnt = (int)smc.queryForObject("faqBoard.getAllFaqBoardListCount");
		return cnt;
	}

}
