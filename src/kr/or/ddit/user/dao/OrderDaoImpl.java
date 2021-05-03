package kr.or.ddit.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.user.vo.OrderVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class OrderDaoImpl implements IOrderDao {

	private static IOrderDao ud;
	
	public OrderDaoImpl() {
		SqlMapClientUtil.getInstance();
	}
	
	public static IOrderDao getInstance() {
		if(ud == null) {
			ud = new OrderDaoImpl();
		}
		return ud;
	}

	@Override
	public int makeOrder(SqlMapClient smc, OrderVO ov) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("order.makeOrder", ov);
		if(obj != null) {
			cnt = 1;
		}
		return cnt;
	}

	
	@Override
	public List<OrderVO> getOrderList(SqlMapClient smc, String userId) throws SQLException {
		return smc.queryForList("order.getOrderList", userId);
	}


	@Override
	public OrderVO getOrder(SqlMapClient smc, long pjNm) throws SQLException {
		return (OrderVO) smc.queryForObject("order.getOrder", pjNm);
	}


	
}
