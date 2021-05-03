package kr.or.ddit.boardComment.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.boardComment.dao.IQnaCmDao;
import kr.or.ddit.boardComment.dao.QnaCmDaoImpl;
import kr.or.ddit.boardComment.vo.QnaCmVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class QnaCmServiceImpl implements IQnaCmService{
	private IQnaCmDao qnaCmDao;
	private SqlMapClient smc;
	
	private static IQnaCmService qnaCmService;
	
	public QnaCmServiceImpl() {
		qnaCmDao = QnaCmDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IQnaCmService getInstance() {
		if(qnaCmService == null) {
			qnaCmService = new QnaCmServiceImpl();
		}
		return qnaCmService;
	}
	
	@Override
	public List<QnaCmVO> getAllQnaCm(String qnaNm) {
		List<QnaCmVO> list = new ArrayList<>();
		try {
			list = qnaCmDao.getAllQnaCm(smc, qnaNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertQnaCm(QnaCmVO qcv) {
		int cnt = 0;
		try {
			cnt = qnaCmDao.insertQnaCm(smc, qcv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateQnaCm(QnaCmVO qcv) {
		int cnt = 0;
		try {
			cnt = qnaCmDao.updateQnaCm(smc, qcv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteQnaCm(QnaCmVO qcv) {
		int cnt = 0;
		try {
			cnt = qnaCmDao.deleteQnaCm(smc, qcv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public QnaCmVO getQnaCm(QnaCmVO qcv) {
		QnaCmVO cmVO = new QnaCmVO();
		try {
			cmVO = qnaCmDao.getQnaCm(smc, qcv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cmVO;
	}

}
