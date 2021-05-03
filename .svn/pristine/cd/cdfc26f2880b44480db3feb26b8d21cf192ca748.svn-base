package kr.or.ddit.boardComment.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.boardComment.dao.CommunityCmDaoImpl;
import kr.or.ddit.boardComment.dao.ICommunityCmDao;
import kr.or.ddit.boardComment.vo.CommunityCmVO;
import kr.or.ddit.boardComment.vo.QnaCmVO;
import kr.or.ddit.util.SqlMapClientUtil;


public class CommunityCmServiceImpl implements ICommunityCmService{
	private ICommunityCmDao communityCmDao;
	private SqlMapClient smc;
	
	private static ICommunityCmService communityCmService;
	
	public CommunityCmServiceImpl() {
		communityCmDao = CommunityCmDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static ICommunityCmService getInstance() {
		if(communityCmService == null) {
			communityCmService = new CommunityCmServiceImpl();
		}
		return communityCmService;
	}

	@Override
	public List<CommunityCmVO> getAllCommunityCm(String cbNm) {
		List<CommunityCmVO> list = new ArrayList<>();
		try {
			list = communityCmDao.getAllCommunityCm(smc, cbNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int insertCommunityCm(CommunityCmVO ccv) {
		int cnt = 0;
		try {
			cnt = communityCmDao.insertCommunityCm(smc, ccv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateCommunityCm(CommunityCmVO ccv) {
		int cnt = 0;

		try {
			cnt = communityCmDao.updateCommunityCm(smc, ccv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteCommunityCm(CommunityCmVO ccv) {
		int cnt = 0;
		try {
			cnt = communityCmDao.deleteCommunityCm(smc, ccv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
