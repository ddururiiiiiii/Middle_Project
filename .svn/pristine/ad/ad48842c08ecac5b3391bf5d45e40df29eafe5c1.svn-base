package kr.or.ddit.board.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.project.service.IProjectOptionService;
import kr.or.ddit.project.service.IProjectService;
import kr.or.ddit.project.service.ProjectOptionServiceImpl;
import kr.or.ddit.project.service.ProjectServiceImpl;
import kr.or.ddit.project.vo.ProjectOptionVO;
import kr.or.ddit.project.vo.ProjectVO;

public class AdminProjectLookHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/admin/adminProjectLook.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		long pjNm = (long) req.getAttribute("pjNm");
		IProjectService projectService = ProjectServiceImpl.getInstance();
		IProjectOptionService optionService = ProjectOptionServiceImpl.getInstance();
		
		ProjectVO pv = projectService.getProject(pjNm);
		ProjectOptionVO pov = new ProjectOptionVO();
		pov.setPjNm(pjNm);
		
		List<ProjectOptionVO> list = optionService.getProjectOption(pov);
		
		if(pv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
			AtchFileVO fileVO = new AtchFileVO();
			
			fileVO.setAtchFileId(pv.getAtchFileId());
			
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			
			List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
			
			req.setAttribute("atchFileList", atchFileList);
		}
		req.setAttribute("optionList", list);
		req.setAttribute("pv", pv);
		
		return VIEW_PAGE;
	}

}
