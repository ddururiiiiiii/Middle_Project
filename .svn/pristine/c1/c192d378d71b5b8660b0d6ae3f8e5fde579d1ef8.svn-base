package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.IQnaBoardDao;
import kr.or.ddit.board.dao.QnaBoardDaoImpl;
import kr.or.ddit.board.vo.QnaBoardVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class QnaServiceImpl implements IQnaService{

	private IQnaBoardDao boardDao;
	private SqlMapClient smc;
	
	private static IQnaService qnaService;
	
	public QnaServiceImpl() {
		boardDao = QnaBoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IQnaService getInstance() {
		if(qnaService == null) {
			qnaService = new QnaServiceImpl();
		}
		return qnaService;
	}

	@Override
	public List<QnaBoardVO> getAllQnaBoardList(PagingVO pv) {
		List<QnaBoardVO> list = new ArrayList<>();
		try {
			list = boardDao.getAllQnaBoard(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public QnaBoardVO getQnaBoard(String qnaNm) {
		QnaBoardVO qbv = new QnaBoardVO();
		try {
			qbv = boardDao.getQnaBoard(smc, qnaNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qbv;
	}

	@Override
	public int insertQnaBoard(QnaBoardVO qbv) {
		int cnt = 0;
		try {
			cnt = boardDao.insertQnaBoard(smc, qbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateQnaBoard(QnaBoardVO qbv) {
		int cnt = 0;
		try {
			cnt = boardDao.updateQnaBoard(smc, qbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteQnaBoard(QnaBoardVO qbv) {
		int cnt = 0;
		try {
			cnt = boardDao.deleteQnaBoard(smc, qbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<QnaBoardVO> searchQnaBoard(String str) {
		List<QnaBoardVO> list = new ArrayList<>();
		
		try {
			list = boardDao.searchQnaBoard(smc, str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getAllQnaBoardListCount() {
		int cnt = 0;
		try {
			cnt = boardDao.getAllQnaBoardListCount(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
