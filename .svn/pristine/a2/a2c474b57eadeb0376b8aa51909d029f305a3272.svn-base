package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.CommunityBoardDaoImpl;
import kr.or.ddit.board.dao.ICommunityBoardDao;
import kr.or.ddit.board.vo.CommunityBoardVO;
import kr.or.ddit.board.vo.FaqBoardVO;
import kr.or.ddit.boardComment.service.INoticeCmService;
import kr.or.ddit.boardComment.service.NoticeCmServiceImpl;
import kr.or.ddit.boardComment.vo.NoticeCmVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class CommunityServiceImpl implements ICommunityService{
	
	private ICommunityBoardDao CommunityBoardDao;
	private SqlMapClient smc;
	
	private static ICommunityService communityService;
	
	public CommunityServiceImpl() {
		CommunityBoardDao = CommunityBoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static ICommunityService getInstance() {
		if(communityService == null) {
			communityService = new CommunityServiceImpl(); 
		}
		return communityService;
	}

	@Override
	public List<CommunityBoardVO> getAllCommunityBoardList() {
		List<CommunityBoardVO> list = new ArrayList<>();
		try {
			list = CommunityBoardDao.getAllCommunityBoard(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
		//프로젝트 정보 조회
		/*INoticeCmService noticeCmService = NoticeCmServiceImpl.getInstance();
		List<NoticeCmVO> noticeCmVOList = noticeCmService.getNoticeCmListByNoticeNm(noticNm);
		nv.setNoticeCmVOList(noticeCmVOList);*/
		
	}

	@Override
	public CommunityBoardVO getCommunityBoard(String cbNm) {
		CommunityBoardVO cbv = new CommunityBoardVO();
		try {
			cbv = CommunityBoardDao.getCommunityBoard(smc, cbNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cbv;
	}

	@Override
	public int insertCommunityBoard(CommunityBoardVO cbv) {
		int cnt = 0;
		try {
			cnt = CommunityBoardDao.insertCommunityBoard(smc, cbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateCommunityBoard(CommunityBoardVO cbv) {
		int cnt = 0;
		try {
			cnt = CommunityBoardDao.updateCommunityBoard(smc, cbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteCommunityBoard(CommunityBoardVO cbv) {
		int cnt = 0;
		try {
			cnt = CommunityBoardDao.deleteCommunityBoard(smc, cbv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<CommunityBoardVO> searchCommunityBoard(CommunityBoardVO cb) {
		List<CommunityBoardVO> list = new ArrayList<>();
		
		try {
			list = CommunityBoardDao.searchCommunityBoard(smc, cb);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getAllCommunityListCount() {
		int cnt = 0;
		try {
			cnt = CommunityBoardDao.getAllCommunityListCount(smc);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<CommunityBoardVO> getPjCommunityBoard(String pjNm) {
		List<CommunityBoardVO> list = null;
		try {
			list = CommunityBoardDao.getPjCommunityBoard(smc, pjNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
