package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.FaqBoardDaoImpl;
import kr.or.ddit.board.dao.IFaqBoardDao;
import kr.or.ddit.board.vo.FaqBoardVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;


public class FaqServiceImpl implements IFaqService {
	
	private IFaqBoardDao FaqBoardDao;
	private SqlMapClient smc;
	
	private static IFaqService faqService;
	
	public FaqServiceImpl() {
		FaqBoardDao = FaqBoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IFaqService getInstance() {
		if(faqService == null) {
			faqService = new FaqServiceImpl();
		}
		return faqService;
	}

	@Override
	public List<FaqBoardVO> getAllFaqBoard(PagingVO pagingVO) {
		List<FaqBoardVO> list = new ArrayList<>();
		try {
			list = FaqBoardDao.getAllFaqBoard(smc, pagingVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public FaqBoardVO getFaqBoard(String faqNm) {
		FaqBoardVO fbv = new FaqBoardVO();
		try {
			fbv = FaqBoardDao.getFaqBoard(smc, faqNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fbv;
	}

	@Override
	public int insertFaqBoard(FaqBoardVO fbv) {
		int cnt = 0;
		try {
			cnt = FaqBoardDao.insertFaqBoard(smc, fbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateFaqBoard(FaqBoardVO fbv) {
		int cnt = 0;
		try {
			cnt = FaqBoardDao.updateFaqBoard(smc, fbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteFaqBoard(FaqBoardVO fbv) {
		int cnt = 0;
		try {
			cnt = FaqBoardDao.deleteFaqBoard(smc, fbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<FaqBoardVO> searchFaqBoard(String faqTitle) {
		List<FaqBoardVO> list = new ArrayList<>();
		
		try {
			list = FaqBoardDao.searchFaqBoard(smc, faqTitle);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getAllFaqBoardListCount() {
		int cnt = 0;
		try {
			cnt = FaqBoardDao.getAllFaqBoardListCount(smc);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return cnt;
	}

}
