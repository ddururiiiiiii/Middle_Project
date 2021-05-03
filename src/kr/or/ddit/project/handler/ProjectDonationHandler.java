package kr.or.ddit.project.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.project.service.IProjectOptionService;
import kr.or.ddit.project.service.IProjectService;
import kr.or.ddit.project.service.ProjectOptionServiceImpl;
import kr.or.ddit.project.service.ProjectServiceImpl;
import kr.or.ddit.project.vo.ProjectOptionVO;
import kr.or.ddit.project.vo.ProjectVO;

public class ProjectDonationHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/project/projectDonation.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		long pjNm = Long.parseLong(req.getParameter("pjNm"));
		
		IProjectOptionService optionService = ProjectOptionServiceImpl.getInstance();
		IProjectService projectService = ProjectServiceImpl.getInstance();
		
		
		ProjectVO pv = projectService.getProject(pjNm);
		
		ProjectOptionVO pov = new ProjectOptionVO();
		pov.setPjNm(pjNm);
		
		List<ProjectOptionVO> optionList = optionService.getProjectOption(pov);
		
		req.setAttribute("pv", pv);
		req.setAttribute("optionList", optionList);
		
		return VIEW_PAGE;
	}

}
