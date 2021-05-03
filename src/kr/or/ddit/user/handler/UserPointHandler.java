package kr.or.ddit.user.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.user.vo.UserVO;

public class UserPointHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/mypage/mpInfoPoint.jsp";

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		String flag = (String) req.getParameter("flag");

		if ("C".equals(flag) || "U".equals(flag) || "UF".equals(flag)) {
			if (req.getMethod().equals("GET")) {
				return false;
			} else {
				return true;
			}
		}
		if ("D".equals(flag)) {
			return true;
		}
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String flag = req.getParameter("flag");
		IUserService service = UserServiceImpl.getInstance();

		if (req.getMethod().equals("GET")) {
			return VIEW_PAGE;
		} else {
			
			if ("U".equals(flag)) { // 포인트 정보 수정

				HttpSession session = req.getSession();
				
				UserVO uv = (UserVO) session.getAttribute("userVO");
		
				
				int userMoney = Integer.parseInt(req.getParameter("userMoney"));			

				UserVO userVO = new UserVO();
				
				userVO.setUserMoney(userMoney);
				userVO.setUserId(uv.getUserId());

					
				int cnt = service.userPointUpdate(userVO);

				String msg = "";
				if (cnt > 0) {
					msg = "성공";
				} else {
					msg = "실패";
				}
				UserVO userv = new UserVO();
				
				userv = service.getUser(uv.getUserId());
				
				session.setAttribute("userVO", userv);
				
				String redirectUrl = req.getContextPath() + "/mypage/userPointHandler.do?msg=" + URLEncoder.encode(msg, "UTF-8");
				
				return redirectUrl;
			}
			else if("UF".equals(flag)) {
				HttpSession session = req.getSession();
				
				UserVO uv = (UserVO) session.getAttribute("userVO");
				
				int userMoney = Integer.parseInt(req.getParameter("userMoney"));			

				UserVO userVO = new UserVO();
				
				userVO.setUserMoney(userMoney);
				userVO.setUserId(uv.getUserId());
				
				int cnt = service.userPointUpdateRefund(userVO);

				String msg = "";
				if (cnt > 0) {
					msg = "성공";
				} else {
					msg = "실패";
				}
				
				UserVO userv = new UserVO();
			
				userv = service.getUser(uv.getUserId());
				
				session.setAttribute("userVO", userv);
				
				String redirectUrl = req.getContextPath() + "/mypage/userPointHandler.do?msg=" + URLEncoder.encode(msg, "UTF-8");
				
				return redirectUrl;
			}
			return VIEW_PAGE;
		}
	}
}

/*	// 포인트 정보 조회
			IUserService userService = UserServiceImpl.getInstance();

			String userId = req.getParameter("userId");

			int point = userService.userPoint(userId);

			req.setAttribute("point", point);*/