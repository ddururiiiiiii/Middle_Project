package kr.or.ddit.user.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.project.vo.ProjectVO;
import kr.or.ddit.user.dao.IOrderDao;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.OrderDaoImpl;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.vo.OrderVO;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.SqlMapClientUtil;


public class OrderServiceImpl implements IOrderService {

	private IOrderDao orderDao;
	private SqlMapClient smc;
	
	private static IOrderService Service;
	
	public OrderServiceImpl() {
		orderDao = OrderDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}

	public static IOrderService getInstance() {
		if(Service == null) {
			Service = new OrderServiceImpl();
		}
		return Service;
	}

	@Override
	public int makeOrder(OrderVO ov) {
		int cnt = 0;
		try {
			cnt = orderDao.makeOrder(smc, ov);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<OrderVO> getOrderList(String userId) {
		List<OrderVO> list = new ArrayList<OrderVO>();
		try {
			list = orderDao.getOrderList(smc, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public OrderVO getOrder(long pjNm) {
		OrderVO ov = null;
		try {
			ov = orderDao.getOrder(smc, pjNm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ov;
	}

}
