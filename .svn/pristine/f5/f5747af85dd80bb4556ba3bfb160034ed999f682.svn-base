package kr.or.ddit.user.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.comm.handler.CommandHandler;

public class LogOutHandler implements CommandHandler {

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if(req.getMethod().equals("GET")) {
			HttpSession session = req.getSession(true);
			
			session.invalidate();
			
			String redirectUrl = req.getContextPath() + "/main/main.do";
			
			return redirectUrl;
		}
		else {
			return "logOut.do";
		}
	}
}
