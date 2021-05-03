package kr.or.ddit.user.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.user.vo.UserVO;

public class UserSignInHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/login/login.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
		} else {
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			
			UserVO uv = new UserVO();
			uv.setUserId(userId);
			uv.setUserPw(userPw);
			
			IUserService service = UserServiceImpl.getInstance();
			
			int cnt = service.signInUser(uv);
			if(cnt > 0) {
				UserVO user = service.getUser(userId);
				
				HttpSession session = req.getSession();
				
				session.setAttribute("userVO", user);
				
				req.setAttribute("chk", "T");
			} else {
				req.setAttribute("chk", "F");
			}
			return VIEW_PAGE;
		}
	}
}
