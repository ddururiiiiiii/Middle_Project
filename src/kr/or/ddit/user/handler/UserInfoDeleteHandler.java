package kr.or.ddit.user.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;

public class UserInfoDeleteHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/mypage/userInfoDelete.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
		} else {
			return "/main/main.do";
		}
	}

}
