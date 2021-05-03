package kr.or.ddit.user.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.project.vo.ProjectVO;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.SqlMapClientUtil;


public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	private SqlMapClient smc;
	
	private static IUserService Service;
	
	public UserServiceImpl() {
		userDao = UserDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}

	public static IUserService getInstance() {
		if(Service == null) {
			Service = new UserServiceImpl();
		}
		return Service;
	}
	
	@Override
	public int signUpUser(UserVO uv) {
		int cnt = 0;
		try {
			cnt = userDao.signUpUser(smc, uv);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public List<UserVO> getUserList()  {
		List<UserVO> list = new ArrayList<UserVO>();
		try {
			list = userDao.getUserList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public UserVO findUser(UserVO uv) {
		try {
			uv = userDao.findUser(smc, uv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uv;
	}

	@Override
	public int chkNickName(String userNickName) {
		int cnt = 0;
		try {
			cnt = userDao.chkNickName(smc, userNickName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateUser(UserVO uv) {
		int cnt = 0;
		try {
			cnt = userDao.updateUser(smc, uv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public String findUserId(UserVO uv) {
		String userId = "";
		try {
			userId = userDao.findUserId(smc, uv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public String findUserPw(UserVO uv) {
		String userPw = "";
		try {
			userPw = userDao.findUserPw(smc, uv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userPw;
	}

	@Override
	public int deleteUser(UserVO uv) {
		int cnt = 0;
		try {
			cnt = userDao.deleteUser(smc, uv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public UserVO getUser(String userId){
		UserVO uv = null;
		try {
			uv = userDao.getUser(smc, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uv;
	}

	@Override
	public int signInUser(UserVO uv) {
		int cnt = 0;
		try {
			cnt = userDao.signInUser(smc, uv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int chkUserId(String userId){
		int cnt = 0;
		try {
			cnt = userDao.chkUserId(smc, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<ProjectVO> userOrderList(String userId) {
		List<ProjectVO> list = null;
		try {
			list = userDao.userOrderList(smc, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//유저 포인트 조회
	@Override
	public int userPoint(String userId) {
		int cnt = 0;
		try {
			cnt = userDao.userPoint(smc, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	//유저 포인트 수정(충전/환불)
	@Override
	public int userPointUpdate(UserVO uv) {
		int cnt = 0;

		try {
			cnt = userDao.userPointUpdate(smc, uv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int userPointUpdateRefund(UserVO uv) {
		int cnt = 0;

		try {
			cnt = userDao.userPointUpdateRefund(smc, uv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<ProjectVO> userSelfMadeProjectList(String userId) {
		List<ProjectVO> list = new ArrayList<>();
		try {
			list = userDao.userSelfMadeProjectList(smc, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
