package kr.or.ddit.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.user.vo.OrderVO;

public interface IOrderDao {
	
	
	
	/**
	 * 주문하기
	 * @param smc
	 * @param ov
	 * @return
	 * @throws SQLException
	 */
	public int makeOrder(SqlMapClient smc, OrderVO ov) throws SQLException;

	/**
	 * 전체 주문 조회
	 * @param smc
	 * @return
	 * @throws SQLException
	 */
	public List<OrderVO> getOrderList(SqlMapClient smc, String userId) throws SQLException;
	
	/**
	 * 한 프로젝트의 주문 조회
	 * @param smc
	 * @param pjNm
	 * @return
	 * @throws SQLException
	 */
	public OrderVO getOrder(SqlMapClient smc, long pjNm) throws SQLException;
	
	
	
}
