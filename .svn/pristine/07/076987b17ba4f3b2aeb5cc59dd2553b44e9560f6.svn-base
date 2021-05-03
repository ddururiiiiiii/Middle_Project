package kr.or.ddit.user.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.project.vo.ProjectVO;
import kr.or.ddit.user.service.IOrderService;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.OrderServiceImpl;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.user.vo.OrderVO;
import kr.or.ddit.user.vo.UserVO;

public class MyOrderHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/mypage/myOrder.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		UserVO uv = (UserVO) session.getAttribute("userVO");
		IOrderService orderService = OrderServiceImpl.getInstance();
		List<OrderVO> orderList = orderService.getOrderList(uv.getUserId());
		
		req.setAttribute("orderList", orderList);		
		return VIEW_PAGE;
	}
}
