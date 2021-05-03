package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.INoticeBoardDao;
import kr.or.ddit.board.dao.NoticeBoardDaoImpl;
import kr.or.ddit.board.vo.FaqBoardVO;
import kr.or.ddit.board.vo.NoticeBoardVO;
import kr.or.ddit.boardComment.service.INoticeCmService;
import kr.or.ddit.boardComment.service.NoticeCmServiceImpl;
import kr.or.ddit.boardComment.vo.NoticeCmVO;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class NoticeServiceImpl implements INoticeService{

	private INoticeBoardDao noticeDao;
	private SqlMapClient smc;
	
	public static NoticeServiceImpl noticeService;
	
	private NoticeServiceImpl() {
		noticeDao = NoticeBoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static NoticeServiceImpl getInstance() {
		if (noticeService == null) {
			noticeService = new NoticeServiceImpl();
		}
		return noticeService;
		
	}
	
	//공지글 등록
	@Override
	public int insertNoticeBoard(NoticeBoardVO nv) {
		int cnt = 0;
		
		try {
			smc.startTransaction();
			cnt = noticeDao.insertNoticeBoard(smc, nv);
			smc.commitTransaction();
		} catch (SQLException e) {
			try {
				smc.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return cnt;
	}
	
	//공지글 조회
	@Override
	public List<NoticeBoardVO> getAllNoticeBoard(PagingVO pv) {
		List<NoticeBoardVO> noticeList = new ArrayList<>();

		try {
			noticeList = noticeDao.getAllNoticeBoard(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noticeList;
	}
	


	//공지글 삭제
	@Override
	public int deleteNoticeBoard(NoticeBoardVO noticeVO) {
		
		int cnt = 0;

		try {
			cnt = noticeDao.deleteNoticeBoard(smc, noticeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	//공지사항 수정
	@Override
	public int updateNoticeBoard(NoticeBoardVO nv) {
		int cnt = 0;

		try {
			cnt = noticeDao.updateNoticeBoard(smc, nv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	//공지글 단건조회
	@Override
	public NoticeBoardVO getNoticeBoard(String noticeNm) {
		NoticeBoardVO nv = new NoticeBoardVO();
		try {
			nv = noticeDao.getNoticeBoard(smc, noticeNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}

	//공지글 검색
	@Override
	public List<NoticeBoardVO> getSearchNoticeBoardList(String noticeTitle) {
		List<NoticeBoardVO> noticeList = new ArrayList<>();
		try {
			noticeList = noticeDao.getSearchNoticeBoard(smc, noticeTitle);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public int getNoticeBoardListCount() {
		int cnt = 0;
		try {
			cnt = noticeDao.getNoticeBoardListCount(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


}
