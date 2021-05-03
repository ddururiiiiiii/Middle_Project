package kr.or.ddit.board.handler;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.board.service.IReportService;
import kr.or.ddit.board.service.ReportServiceImpl;
import kr.or.ddit.board.vo.ReportBoardVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class AdminReportBoardHandler implements CommandHandler {

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		String flag = (String) req.getParameter("flag");

		if ("C".equals(flag) || "U".equals(flag)) {
			if (req.getMethod().equals("GET")) {
				return false;
			} else {
				return true;
			}
		}
		if ("D".equals(flag)) {
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
				return "/WEB-INF/view/admin/adminReportBoardInsert.jsp";
			} else {
				String userId = uv.getUserId();
				
				ReportBoardVO rbv = new ReportBoardVO();
				
				IReportService service = ReportServiceImpl.getInstance();
				
				String reportTitle = req.getParameter("reportTitle");
				String reportContent = req.getParameter("reportContent");
				rbv.setReportTitle(reportTitle);
				rbv.setReportContent(reportContent);
				rbv.setReportWriter(userId);
				
				FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFileId");
				
				AtchFileVO atchFileVO = new AtchFileVO();
				
				atchFileVO.setAtchFileId(req.getParameter("atchFileId") == null ?
						-1 : Long.parseLong(req.getParameter("atchFileId")));
				
				if(item != null && !item.getName().equals("")) {
					
					IAtchFileService fileService = AtchFileServiceImpl.getInstance();
					
					atchFileVO = fileService.saveAtchFile(item, userId); // 첨부파일 저장
					
					rbv.setAtchFileId(atchFileVO.getAtchFileId());
				}
				int cnt = service.insertReportBoard(rbv);

				String msg = "";
				
				if(cnt > 0) {
					msg = "성공";
				} else {
					msg = "실패";
				}
				String redirectUrl = req.getContextPath() 
						+ "/admin/adminReportBoard.do?msg=" 
						+ URLEncoder.encode(msg, "UTF-8");
				return redirectUrl;
			}
			
		} else if("U".equals(flag)) { // 게시글 수정
			
			String userId = uv.getUserId();
			
			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFileId");
			
			AtchFileVO atchFileVO = new AtchFileVO();
			
			atchFileVO.setAtchFileId(req.getParameter("atchFileId") == null ?
					-1 : Long.parseLong(req.getParameter("atchFileId")));
			
			if(item !=null && !item.getName().equals("")) {
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				atchFileVO = fileService.saveAtchFile(item, userId); // 첨부파일 저장
			}
			
			IReportService service = ReportServiceImpl.getInstance();
			
			ReportBoardVO rbv = new ReportBoardVO();
			
			rbv.setReportNm(req.getParameter("reportNm"));
			rbv.setReportTitle(req.getParameter("reportTitle"));
			rbv.setReportContent(req.getParameter("reportContent"));
			rbv.setAtchFileId(atchFileVO.getAtchFileId());
			
			int cnt = service.updateReportBoard(rbv);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath() + "/admin/adminReportBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			return redirectUrl;	
		} else if("D".equals(flag)) { // 게시글 삭제
			ReportBoardVO rbv = new ReportBoardVO();
			
			rbv.setReportNm(req.getParameter("reportNm"));
			
			IReportService service = ReportServiceImpl.getInstance();
			
			int cnt = service.deleteReportBoard(rbv);
			
			String msg = "";
			if(cnt > 0){
				msg = "성공";
			} else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath() + "/admin/adminReportBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			return redirectUrl;
		} else if("SEL".equals(flag)) { // 한 게시글 조회
			String reportNm = req.getParameter("reportNm");
			
			IReportService service = ReportServiceImpl.getInstance();
			
			ReportBoardVO rbv = service.getReportBoard(reportNm);
			
			if(rbv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(rbv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("rbv", rbv);

			/*// 댓글 전부 보여줌
			IQnaCmService cmService = QnaCmServiceImpl.getInstance();
			
			List<QnaCmVO> cmList = cmService.getAllQnaCm(qnaNm);
			
			req.setAttribute("qnaCmList", cmList);*/
			
			return "/WEB-INF/view/admin/adminReportBoardSelect.jsp";
			
		} else if("SCH".equals(flag)) { // 게시글 검색
			String str = "";

			str = req.getParameter("search");
			
			IReportService service = ReportServiceImpl.getInstance();
			
			List<ReportBoardVO> list = service.searchReportBoard(str);
			
			req.setAttribute("list", list);
			
			return "/WEB-INF/view/admin/adminReportBoardList.jsp";
		} else if("INS".equals(flag)) {
			return "/WEB-INF/view/admin/adminReportBoardInsert.jsp";
		} else if("UPD".equals(flag)) {
			String reportNm = (String)req.getParameter("reportNm");
			
			IReportService service = ReportServiceImpl.getInstance();
			
			ReportBoardVO rbv = service.getReportBoard(reportNm);
			
			if(rbv.getAtchFileId() > 0) {
				AtchFileVO fileVO = new AtchFileVO();
				fileVO.setAtchFileId(rbv.getAtchFileId());
				
				IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
				List<AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("rbv", rbv);
			
			return "/WEB-INF/view/admin/adminReportBoardUpdate.jsp";
		}
		
		// 모든 게시글 조회
		int pageNo = 
				req.getParameter("pageNo") == null ? 
				1 : Integer.parseInt(req.getParameter("pageNo"));
			
		PagingVO pagingVO = new PagingVO();
		
		IReportService service = ReportServiceImpl.getInstance();
		
		int totalCount = service.getAllReportListCount();
		pagingVO.setTotalCount(totalCount);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setCountPerPage(15);
		pagingVO.setPageSize(5);
		
		ReportBoardVO boardVO = new ReportBoardVO();
		
		BeanUtils.populate(boardVO, req.getParameterMap());
		
		List<ReportBoardVO> list = service.getAllReportBoardList(pagingVO);
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("list", list);
		req.setAttribute("pv", pagingVO);
		
		return "/WEB-INF/view/admin/adminReportBoardList.jsp";
	}
}
