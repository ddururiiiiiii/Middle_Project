package kr.or.ddit.board.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.project.service.IProjectService;
import kr.or.ddit.project.service.ProjectServiceImpl;
import kr.or.ddit.project.vo.ProjectVO;

public class AdminProjectCheckHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/admin/adminProjectCheck.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IProjectService projectService = ProjectServiceImpl.getInstance();
		List<ProjectVO> projectList = projectService.getAllProjectList(); 
		req.setAttribute("projectList", projectList);
		return VIEW_PAGE;
	}
}
