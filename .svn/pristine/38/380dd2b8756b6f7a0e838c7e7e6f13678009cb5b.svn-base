package kr.or.ddit.user.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.base.dao.BaseDao;
import kr.or.ddit.user.vo.SignUpVO;

public class SignUpDao extends BaseDao {
	private SqlMapClient smc;
	
	public SignUpDao( ) {
		smc = super.getSqlMapClient();
	}
	
	public boolean signUpUser(SignUpVO sv) throws SQLException {
		boolean chk = false;
		
		int cnt = (int)smc.queryForObject("signUp.signUpUser", sv);
		
		if(cnt > 0) {
			chk = true;
		}
		return chk;
	}
	
	
}
