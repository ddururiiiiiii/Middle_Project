package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.FreeBoardDaoImpl;
import kr.or.ddit.board.dao.IFreeBoardDao;
import kr.or.ddit.board.vo.FreeBoardVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class FreeServiceImpl implements IFreeService{

	private IFreeBoardDao boardDao;
	private SqlMapClient smc;
	
	private static IFreeService freeService;
	
	public FreeServiceImpl() {
		boardDao = FreeBoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IFreeService getInstance() {
		if(freeService == null) {
			freeService = new FreeServiceImpl();
		}
		return freeService;
	}

	@Override
	public List<FreeBoardVO> getAllFreeBoardList(PagingVO pv) {
		List<FreeBoardVO> list = new ArrayList<>();
		try {
			list = boardDao.getAllFreeBoard(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public FreeBoardVO getFreeBoard(FreeBoardVO fv) {
		try {
			fv = boardDao.getFreeBoard(smc, fv.getFreeNm());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fv;
	}

	@Override
	public int insertFreeBoard(FreeBoardVO fv) {
		int cnt = 0;
		try {
			cnt = boardDao.insertFreeBoard(smc, fv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateFreeBoard(FreeBoardVO fv) {
		int cnt = 0;
		try {
			cnt = boardDao.updateFreeBoard(smc, fv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteFreeBoard(FreeBoardVO fv) {
		int cnt = 0;
		try {
			cnt = boardDao.deleteFreeBoard(smc, fv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<FreeBoardVO> searchFreeBoard(String str) {
		List<FreeBoardVO> list = new ArrayList<>();
		
		try {
			list = boardDao.searchFreeBoard(smc, str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getAllFreeBoardListCount() {
		int cnt = 0;
		try {
			cnt = boardDao.getAllFreeBoardListCount(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
