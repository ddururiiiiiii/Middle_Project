package kr.or.ddit.user.service;

import java.sql.SQLException;

import kr.or.ddit.user.dao.SignUpDao;
import kr.or.ddit.user.vo.SignUpVO;

public class SignUpService {
	private SignUpDao signUpDao;
	
	public SignUpService() {
		if(signUpDao == null) {
			signUpDao = new SignUpDao();
		}
	}
	
	public boolean signUpUser(SignUpVO sv) throws SQLException {
		return signUpDao.signUpUser(sv);
	}
}
