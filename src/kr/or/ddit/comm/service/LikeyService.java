package kr.or.ddit.comm.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.comm.dao.LikeyDao;
import kr.or.ddit.comm.vo.LikeyVO;

public class LikeyService {
	private LikeyDao likeyDao;
	
	public LikeyService() {
		if(likeyDao == null) {
			likeyDao = new LikeyDao();
		}
	}
	
	/**
	 * 관심사 목록들을 가져오는 메서드
	 * @return List<LikeyVO>
	 * @throws SQLException
	 */
	public List<LikeyVO> retrieveLikeyList() throws SQLException {
		return likeyDao.retrieveLikeyList();
	}
}
