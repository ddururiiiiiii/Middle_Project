package kr.or.ddit.user.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.user.vo.UserVO;

public class UserInfoUpdatePwChkHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/mypage/userUpdatePassCheck.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
		} else {
			String userPw = req.getParameter("userPw");
			HttpSession session = req.getSession();
			
			UserVO uv = (UserVO) session.getAttribute("userVO");

			if(userPw.equals(uv.getUserPw())) {
				req.setAttribute("chk", "T");
			} else {
				req.setAttribute("chk", "F");
			}
			return "/WEB-INF/view/mypage/userInfoUpdate.jsp";
		}
	}

}
