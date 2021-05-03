package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.IReportBoardDao;
import kr.or.ddit.board.dao.ReportBoardDaoImpl;
import kr.or.ddit.board.vo.ReportBoardVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;


public class ReportServiceImpl implements IReportService{

	private IReportBoardDao reportBoardDao;
	private SqlMapClient smc;
	
	private static IReportService reportService;
	
	public ReportServiceImpl() {
		reportBoardDao = ReportBoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IReportService getInstance() {
		if(reportService == null) {
			reportService = new ReportServiceImpl();
		}
		return reportService;
	}	

	@Override
	public List<ReportBoardVO> getAllReportBoardList(PagingVO pv) {
		List<ReportBoardVO> list = new ArrayList<>();
		try {
			list = reportBoardDao.getAllReportBoard(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ReportBoardVO getReportBoard(String reportNm) {
		ReportBoardVO rbv = new ReportBoardVO();
		try {
			rbv = reportBoardDao.getReportBoard(smc, reportNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rbv;
	}

	@Override
	public int insertReportBoard(ReportBoardVO rbv) {
		int cnt = 0;
		try {
			cnt = reportBoardDao.insertReportBoard(smc, rbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateReportBoard(ReportBoardVO rbv) {
		int cnt = 0;
		try {
			cnt = reportBoardDao.updateReportBoard(smc, rbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteReportBoard(ReportBoardVO rbv) {
		int cnt = 0;
		try {
			cnt = reportBoardDao.deleteReportBoard(smc, rbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<ReportBoardVO> searchReportBoard(String str) {
		List<ReportBoardVO> list = new ArrayList<>();
		
		try {
			list = reportBoardDao.searchReportBoard(smc, str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getAllReportListCount() {
		int cnt = 0;
		try {
			cnt = reportBoardDao.getAllReportListCount(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
