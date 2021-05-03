package kr.or.ddit.user.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.project.service.IProjectService;
import kr.or.ddit.project.service.ProjectServiceImpl;
import kr.or.ddit.project.vo.ProjectVO;
import kr.or.ddit.user.service.IOrderService;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.OrderServiceImpl;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.user.vo.OrderVO;
import kr.or.ddit.user.vo.UserVO;

public class OrderHandler implements CommandHandler{
	
	private static final String VIEW_PAGE = "/WEB-INF/view/mypage/myOrder.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		String flag = req.getParameter("flag");
		
		HttpSession session = req.getSession();
		UserVO uv = (UserVO) session.getAttribute("userVO");
		
		IOrderService orderService = OrderServiceImpl.getInstance();
		

		OrderVO ov = new OrderVO(); 

		ov.setUserId(uv.getUserId());
		ov.setPjNm(req.getParameter("pjNm"));
		ov.setPjName(req.getParameter("pjName"));
		ov.setOrderPrice(Integer.parseInt(req.getParameter("orderPrice")));
		ov.setPoName(req.getParameter("poName"));
		ov.setAtchFileId(Long.parseLong(req.getParameter("atchFileId")));
		orderService.makeOrder(ov);
		
		IUserService userService = UserServiceImpl.getInstance();
		UserVO userVO = new UserVO();
		userVO.setUserId(uv.getUserId());
		userVO.setUserMoney(ov.getOrderPrice());
		userService.userPointUpdateRefund(userVO);
		
		userVO = userService.getUser(uv.getUserId());
		session.setAttribute("userVO", userVO);
		
		IProjectService projectService = ProjectServiceImpl.getInstance();
		ProjectVO pv = new ProjectVO();
		pv.setPjPrice(Long.parseLong(req.getParameter("orderPrice")));
		pv.setPjNm(Long.parseLong(req.getParameter("pjNm")));
		projectService.getDonation(pv);
		
		List<OrderVO> orderList = orderService.getOrderList(uv.getUserId());
		req.setAttribute("orderList", orderList);
		
		return VIEW_PAGE;
		
	}
}
