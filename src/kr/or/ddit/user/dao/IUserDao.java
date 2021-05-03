package kr.or.ddit.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.project.vo.ProjectVO;
import kr.or.ddit.user.vo.UserVO;

public interface IUserDao {
	
	/**
	 * ID 중복검사 메서드
	 * @param smc
	 * @param cnt
	 * @return
	 * @throws SQLException
	 */
	public int chkUserId(SqlMapClient smc, String userId) throws SQLException;
	
	/**
	 * 닉네임 중복검사 메서드
	 * @param userNickName
	 * @return
	 * @throws SQLException
	 */
	public int chkNickName(SqlMapClient smc, String userNickName) throws SQLException;
	
	/**
	 * 회원가입 메서드
	 * @param uv
	 * @return
	 * @throws SQLException
	 */
	public int signUpUser(SqlMapClient smc, UserVO uv) throws SQLException;

	/**
	 * 모든 유저 조회 메서드
	 * @return
	 * @throws SQLException
	 */
	public List<UserVO> getUserList(SqlMapClient smc) throws SQLException;
	
	/**
	 * 한 유저 정보 메서드
	 * @param smc
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public UserVO getUser(SqlMapClient smc, String userId) throws SQLException;
	
	/**
	 * 유저 찾기 메서드
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public UserVO findUser(SqlMapClient smc, UserVO uv) throws SQLException;
	
	/**
	 * 개인정보 변경 메서드
	 * @param uv
	 * @return
	 * @throws SQLException
	 */
	public int updateUser(SqlMapClient smc, UserVO uv) throws SQLException;
	
	/**
	 * 아이디 찾기 메서드
	 * @param uv
	 * @return
	 * @throws SQLException
	 */
	public String findUserId(SqlMapClient smc, UserVO uv) throws SQLException;
	
	/**
	 * 비밀번호 찾기 메서드
	 * @param uv
	 * @return
	 * @throws SQLException
	 */
	public String findUserPw(SqlMapClient smc, UserVO uv) throws SQLException;
	
	/**
	 * 유저 삭제 메서드
	 * @param smc
	 * @param uv
	 * @return
	 * @throws SQLException
	 */
	public int deleteUser(SqlMapClient smc, UserVO uv) throws SQLException;
	
	/**
	 * 로그인 통과 or 실패
	 * @param uv
	 * @return
	 */
	public int signInUser(SqlMapClient smc, UserVO uv) throws SQLException;
	
	/**
	 * 내가 후원한 프로젝트 리스트
	 * @param smc
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public List<ProjectVO> userOrderList(SqlMapClient smc, String userId) throws SQLException;
	
	/**
	 * 유저 포인트 조회
	 * @param smc
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public int userPoint(SqlMapClient smc, String userId) throws SQLException;
		
	/**
	 * 유저 포인트 수정(충전) 
	 * @param smc
	 * @param uv
	 * @return
	 * @throws SQLException
	 */
	public int userPointUpdate(SqlMapClient smc, UserVO uv) throws SQLException;

	/**
	 * 유저 포인트 수정(환불) 
	 * @param smc
	 * @param uv
	 * @return
	 * @throws SQLException
	 */
	public int userPointUpdateRefund(SqlMapClient smc, UserVO uv) throws SQLException;

	/**
	 * 유저가 만든 프로젝트 리스트 
	 * @param  smc
	 * @param  userId
	 * @return 
	 */
	public List<ProjectVO> userSelfMadeProjectList(SqlMapClient smc, String userId) throws SQLException;
	
}
