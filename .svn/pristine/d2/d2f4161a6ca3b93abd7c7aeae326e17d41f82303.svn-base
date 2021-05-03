package kr.or.ddit.project.handler;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.board.service.FreeServiceImpl;
import kr.or.ddit.board.service.IFreeService;
import kr.or.ddit.board.vo.FreeBoardVO;
import kr.or.ddit.boardComment.service.FreeCmServiceImpl;
import kr.or.ddit.boardComment.service.IFreeCmService;
import kr.or.ddit.boardComment.vo.FreeCmVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.project.service.IProjectOptionService;
import kr.or.ddit.project.service.IProjectService;
import kr.or.ddit.project.service.ProjectOptionServiceImpl;
import kr.or.ddit.project.service.ProjectServiceImpl;
import kr.or.ddit.project.vo.ProjectOptionVO;
import kr.or.ddit.project.vo.ProjectVO;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class ProjectHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		String flag = (String)req.getParameter("flag");
		if("C".equals(flag) || "U".equals(flag)) {
			if(req.getMethod().equals("GET")) { 
				return false;
			} else { 
				return true;
			}
		}
		if("D".equals(flag)) {
			return true;
		}
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String flag = (String) req.getParameter("flag");
		
		HttpSession session = req.getSession();
		
		UserVO uv = (UserVO) session.getAttribute("userVO");
		
		if("C".equals(flag)) { // 게시글 작성
			if(req.getMethod().equals("GET")) {
				return "/WEB-INF/view/project/projectInsert.jsp";
			} else {
				String userId = uv.getUserId();

				IProjectService service = ProjectServiceImpl.getInstance();
				IProjectOptionService serviceOption = ProjectOptionServiceImpl.getInstance();
				
				ProjectVO pv = new ProjectVO(); 
				BeanUtils.populate(pv, req.getParameterMap());
				pv.setUserId(userId);
				
				FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFileId");
				AtchFileVO atchFileVO = new AtchFileVO();
				
				
				if(item != null && !item.getName().equals("")) {
					IAtchFileService fileService = AtchFileServiceImpl.getInstance();
					atchFileVO = fileService.saveAtchFile(item, userId); // 첨부파일 저장
					pv.setAtchFileId(atchFileVO.getAtchFileId());
				}
				
				long newPjNm = service.insertProject(pv);		
				/*프로젝트 옵션 전송*/
				String[] poName = req.getParameterValues("poName");
				String[] poAddPrice = req.getParameterValues("poAddPrice");
				String[] poContent = req.getParameterValues("poContent");
				
				for ( int i = 0 ; i < poName.length ; i++ ) {
					ProjectOptionVO pov = new ProjectOptionVO(); 
					
					pov.setPjNm(newPjNm);
					pov.setPoName(poName[i]);
					pov.setPoAddPrice(Long.parseLong(poAddPrice[i]));
					pov.setPoContent(poContent[i]);	
					pov.setAtchFileId(atchFileVO.getAtchFileId());
					
					serviceOption.insertProjectOption(pov);
				}
				return req.getContextPath()	+ "/project/projectBoard.do";
			}
			
		}  else if("D".equals(flag)) { // 프로젝트 삭제
			ProjectVO pv = new ProjectVO();
			
			pv.setPjNm(Integer.parseInt(req.getParameter("pjNm")));
			
			IProjectService service = ProjectServiceImpl.getInstance();
			
			int cnt = service.deleteProject(pv);
			
			String msg = "";
			if(cnt > 0){
				msg = "성공";
			} else {
				msg = "실패";
			}
			
			String redirectUrl = req.getContextPath() + "/project/ProjectBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			
			return redirectUrl;
			
		} else if("SEL".equals(flag)) { // 한 프로젝트 조회
			long pjNm = Long.parseLong(req.getParameter("pjNm"));
			
			IProjectService service = ProjectServiceImpl.getInstance();
			IProjectOptionService serviceOption = ProjectOptionServiceImpl.getInstance();
			
			ProjectVO pv = new ProjectVO();
			ProjectOptionVO pov = new ProjectOptionVO();
			
			pv.setPjNm(pjNm);
			
			pov.setPjNm(pjNm);
			
			pv = service.getProject(pjNm);
			
			List<ProjectOptionVO> list = serviceOption.getProjectOption(pov);
			
			if(pv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(pv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("listOption", list);
			
			req.setAttribute("pv", pv);
			
			return "/WEB-INF/view/project/projectSelect.jsp";
			
		} else if("SCH".equals(flag)) { // 게시글 검색
			String pjName = req.getParameter("pjName");
			
			IProjectService service = ProjectServiceImpl.getInstance();
			
			List<ProjectVO> list = service.searchProject(pjName);
			
			req.setAttribute("list", list);	
			
			ProjectVO pv = new ProjectVO();
			
			if(pv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(pv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			return "/WEB-INF/view/project/projectList.jsp";
			
		} else if("SCHS".equals(flag)) { // 게시글 검색
			String pjCategory = req.getParameter("pjCategory");
			
			IProjectService service = ProjectServiceImpl.getInstance();
			
			List<ProjectVO> list = service.searchProjectSelect(pjCategory);
			
			req.setAttribute("list", list);	
			
//			ProjectVO pv = new ProjectVO();
//			pv = service.getProject(Long.parseLong(req.getParameter("pjNm")));
//			
//			if(pv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
//				AtchFileVO fileVO = new AtchFileVO();
//				
//				fileVO.setAtchFileId(pv.getAtchFileId());
//				
//				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
//				
//				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
//				
//				req.setAttribute("atchFileList", atchFileList);
//			}
			
			return "/WEB-INF/view/project/projectList.jsp";
		} else if("OPT".equals(flag)) { // 리워드 선택
			long pjNm = Long.parseLong(req.getParameter("pjNm"));
			
			IProjectService service = ProjectServiceImpl.getInstance();
			IProjectOptionService serviceOption = ProjectOptionServiceImpl.getInstance();
			
			ProjectVO pv = new ProjectVO();
			ProjectOptionVO pov = new ProjectOptionVO();
			
			pv.setPjNm(pjNm);
			
			pov.setPjNm(pjNm);
			
			pv = service.getProject(pjNm);
			
			List<ProjectOptionVO> list = serviceOption.getProjectOption(pov);
			
			req.setAttribute("listOption", list);
			
			req.setAttribute("pv", pv);
			
			return "/WEB-INF/view/project/projectOptionSelect.jsp";
			
		} else if("INS".equals(flag)) {
			return "/WEB-INF/view/project/projectInsert.jsp";
		} 
		ProjectVO projectVO = new ProjectVO();
		
		BeanUtils.populate(projectVO, req.getParameterMap());
		
		IProjectService service2 = ProjectServiceImpl.getInstance();
		
		List<ProjectVO> list = service2.getAllProjectList();
		
		req.setAttribute("list", list);
		
		return "/WEB-INF/view/project/projectList.jsp";
	}

}
