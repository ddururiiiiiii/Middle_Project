package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.vo.OrderVO;

public interface IOrderService {
	
	/**
	 * 주문정보 입력하는 메서드
	 * @param ov
	 * @return
	 */
	public int makeOrder(OrderVO ov);
	
	/**
	 * 주문내역 조회하는 메서드
	 * @return
	 */
	public List<OrderVO> getOrderList(String userId);
	
	/**
	 * 한 프로젝트 주문내역 조회 메서드
	 * @param pjNm
	 * @return
	 */
	public OrderVO getOrder(long pjNm);
	
	
}
