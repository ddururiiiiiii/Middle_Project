package kr.or.ddit.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.NoticeBoardVO;
import kr.or.ddit.project.vo.ProjectVO;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class UserDaoImpl implements IUserDao {

	private static IUserDao ud;
	
	public UserDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static IUserDao getInstance() {
		if(ud == null) {
			ud = new UserDaoImpl();
		}
		return ud;
	}

	@Override
	public int signUpUser(SqlMapClient smc, UserVO uv) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("user.signUpUser", uv);
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int chkUserId(SqlMapClient smc, String userId) throws SQLException {
		return (int) smc.queryForObject("user.chkUserId", userId);
	}
	
	@Override
	public int chkNickName(SqlMapClient smc, String userNickName) throws SQLException {
		return (int) smc.queryForObject("user.chkNickName", userNickName);
	}
	
	@Override
	public List<UserVO> getUserList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("user.getUserList");
	}

	@Override
	public UserVO findUser(SqlMapClient smc, UserVO uv) throws SQLException {
		return (UserVO) smc.queryForObject("user.selectUser", uv);
	}

	@Override
	public int updateUser(SqlMapClient smc, UserVO uv) throws SQLException {
		return smc.update("user.updateUser", uv);
	}

	@Override
	public String findUserId(SqlMapClient smc, UserVO uv) throws SQLException {
		return (String) smc.queryForObject("user.selectUserId", uv);
	}

	@Override
	public String findUserPw(SqlMapClient smc, UserVO uv) throws SQLException {
		return (String) smc.queryForObject("user.selectUserPw", uv);
	}

	@Override
	public int deleteUser(SqlMapClient smc, UserVO uv) throws SQLException {
		return smc.delete("user.deleteUser", uv.getUserId());
	}

	@Override
	public UserVO getUser(SqlMapClient smc, String userId) throws SQLException {
		return (UserVO) smc.queryForObject("user.getUser", userId);
	}

	@Override
	public int signInUser(SqlMapClient smc, UserVO uv) throws SQLException {
		return (int) smc.queryForObject("user.signInUser", uv);
	}

	@Override
	public List<ProjectVO> userOrderList(SqlMapClient smc, String userId) throws SQLException {
		return smc.queryForList("user.userOrderList", userId);
	}

	//유저 포인트 조회
	@Override
	public int userPoint(SqlMapClient smc, String userId) throws SQLException {
		return (int) smc.queryForObject("user.userpoint", userId);
	}

	//유저 포인트 수정(충전)
	@Override
	public int userPointUpdate(SqlMapClient smc, UserVO uv) throws SQLException {
		return (int) smc.update("user.userpointUpdate", uv);
	}

	//유저 포인트 수정(충전)
	@Override
	public int userPointUpdateRefund(SqlMapClient smc, UserVO uv) throws SQLException {
		return (int) smc.update("user.userpointUpdateRefund", uv);

	}

	@Override
	public List<ProjectVO> userSelfMadeProjectList(SqlMapClient smc, String userId) throws SQLException {
		return smc.queryForList("user.userSelfMadeProjectList", userId);
	}

	
}
