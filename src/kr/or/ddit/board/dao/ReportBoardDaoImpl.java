package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import kr.or.ddit.board.vo.ReportBoardVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class ReportBoardDaoImpl implements IReportBoardDao{
	
	private static IReportBoardDao reportDao;
	
	private ReportBoardDaoImpl() {
		SqlMapClientUtil.getInstance();
	
	}
	
	public static IReportBoardDao getInstance() {
		if(reportDao == null) {
			reportDao = new ReportBoardDaoImpl();
		}
		return reportDao;
	}

	@Override
	public List<ReportBoardVO> getAllReportBoard(SqlMapClient smc, PagingVO pv) throws SQLException {
		return smc.queryForList("reportBoard.getAllReportBoard", pv);
	}

	@Override
	public ReportBoardVO getReportBoard(SqlMapClient smc, String reportNm) throws SQLException {
		return (ReportBoardVO) smc.queryForObject("reportBoard.getReportBoard", reportNm);
	}

	@Override
	public int insertReportBoard(SqlMapClient smc, ReportBoardVO rbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("reportBoard.insertReportBoard", rbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateReportBoard(SqlMapClient smc, ReportBoardVO rbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.update("reportBoard.updateReportBoard", rbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteReportBoard(SqlMapClient smc, ReportBoardVO rbv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.delete("reportBoard.deleteReportBoard", rbv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public List<ReportBoardVO> searchReportBoard(SqlMapClient smc, String str) throws SQLException {
		return smc.queryForList("reportBoard.searchReportBoard", str);
	}

	@Override
	public int getAllReportListCount(SqlMapClient smc) throws SQLException {
		return (int) smc.queryForObject("reportBoard.getAllReportListCount");
	}

}
