package kr.or.ddit.comm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.service.LikeyService;
import kr.or.ddit.comm.vo.LikeyVO;

@WebServlet("/LikeyServlet")
public class LikeyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			LikeyService likeyService = new LikeyService();
			
			List<LikeyVO> list = likeyService.retrieveLikeyList();

			req.setAttribute("list", list);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/html/common/likeyList.jsp");
			
			dispatcher.forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
