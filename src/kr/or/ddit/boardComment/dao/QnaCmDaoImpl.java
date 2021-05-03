package kr.or.ddit.boardComment.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.boardComment.vo.QnaCmVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class QnaCmDaoImpl implements IQnaCmDao {

	private static IQnaCmDao qcd;
	
	public QnaCmDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static IQnaCmDao getInstance() {
		if(qcd == null) {
			qcd = new QnaCmDaoImpl();
		}
		return qcd;
	}
	
	@Override
	public List<QnaCmVO> getAllQnaCm(SqlMapClient smc, String qnaNm) throws SQLException {
		return smc.queryForList("qnaCm.getAllQnaCm", qnaNm);
	}

	@Override
	public int insertQnaCm(SqlMapClient smc, QnaCmVO qcv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.insert("qnaCm.insertQnaCm", qcv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int updateQnaCm(SqlMapClient smc, QnaCmVO qcv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.update("qnaCm.updateQnaCm", qcv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteQnaCm(SqlMapClient smc, QnaCmVO qcv) throws SQLException {
		int cnt = 0;
		
		Object obj = smc.delete("qnaCm.deleteQnaCm", qcv);
		
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public QnaCmVO getQnaCm(SqlMapClient smc, QnaCmVO qvc) throws SQLException {
		
		return (QnaCmVO) smc.queryForObject("qnaCm.getQnaCm", qvc);
	}

}
