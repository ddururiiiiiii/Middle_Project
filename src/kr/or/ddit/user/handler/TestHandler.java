package kr.or.ddit.user.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;

public class TestHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) {

		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
