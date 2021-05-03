package kr.or.ddit.board.handler;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.board.service.IFreeService;
import kr.or.ddit.board.service.FreeServiceImpl;
import kr.or.ddit.board.vo.FreeBoardVO;
import kr.or.ddit.boardComment.service.FreeCmServiceImpl;
import kr.or.ddit.boardComment.service.IFreeCmService;
import kr.or.ddit.boardComment.vo.FreeCmVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class FreeBoardHandler implements CommandHandler {

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		String flag = (String)req.getParameter("flag");
		
		if("C".equals(flag) || "U".equals(flag)) {
			if(req.getMethod().equals("GET")) { 
				return false;
			}else { 
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
				return "/WEB-INF/view/board/freeBoardInsert.jsp";
			} else {
				String userId = uv.getUserId();
				
				FreeBoardVO fv = new FreeBoardVO();
				
				IFreeService service = FreeServiceImpl.getInstance();
				
				String freeTitle = req.getParameter("freeTitle");
				String freeContent = req.getParameter("freeContent");
				fv.setFreeTitle(freeTitle);
				fv.setFreeContent(freeContent);
				fv.setFreeWriter(userId);
				
				if((String)req.getParameter("attachFile") != "") {
					FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFileId");
					AtchFileVO atchFileVO = new AtchFileVO();
					
					IAtchFileService fileService = AtchFileServiceImpl.getInstance();
					atchFileVO = fileService.saveAtchFile(item, userId);
					
					fv.setAtchFileId(atchFileVO.getAtchFileId());
				}
				
				int cnt = service.insertFreeBoard(fv);

				String msg = "";
				
				if(cnt > 0) {
					msg = "성공";
				} else {
					msg = "실패";
				}
				String redirectUrl = req.getContextPath() 
						+ "/board/freeBoard.do?msg=" 
						+ URLEncoder.encode(msg, "UTF-8");
				return redirectUrl;
			}
			
		} else if("U".equals(flag)) { // 게시글 수정
			
			String userId = uv.getUserId();

			IFreeService service = FreeServiceImpl.getInstance();
			
			FreeBoardVO fv = new FreeBoardVO();
			
			fv.setFreeNm(req.getParameter("freeNm"));
			fv.setFreeTitle(req.getParameter("freeTitle"));
			fv.setFreeContent(req.getParameter("freeContent"));
			
			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFileId");
			
			AtchFileVO atchFileVO = new AtchFileVO();
			
			atchFileVO.setAtchFileId(req.getParameter("atchFileId") == null ?
					-1 : Long.parseLong(req.getParameter("atchFileId")));
			
			if(item !=null && !item.getName().equals("")) {
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				atchFileVO = fileService.saveAtchFile(item, userId); // 첨부파일 저장
				fv.setAtchFileId(atchFileVO.getAtchFileId());
			}
			
			int cnt = service.updateFreeBoard(fv);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath() + "/board/freeBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			return redirectUrl;	
		} else if("D".equals(flag)) { // 게시글 삭제
			FreeBoardVO fv = new FreeBoardVO();
			
			fv.setFreeNm(req.getParameter("freeNm"));
			
			IFreeService service = FreeServiceImpl.getInstance();
			
			int cnt = service.deleteFreeBoard(fv);
			
			String msg = "";
			if(cnt > 0){
				msg = "성공";
			} else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath() + "/board/freeBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			return redirectUrl;
		} else if("SEL".equals(flag)) { // 한 게시글 조회
			String freeNm = req.getParameter("freeNm");
			
			IFreeService service = FreeServiceImpl.getInstance();
			
			FreeBoardVO fv = new FreeBoardVO();
			fv.setFreeNm(freeNm);
			
			fv = service.getFreeBoard(fv);
			
			if(fv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(fv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("fv", fv);
			
			IFreeCmService cmService = FreeCmServiceImpl.getInstance();
			
			int pageNo = req.getParameter("pageNo") == null ?
					1 : Integer.parseInt(req.getParameter("pageNo"));
			
			PagingVO pv = new PagingVO();
			
			int totalCount = cmService.getAllFreeCmCount(freeNm);
			pv.setBoardNo(req.getParameter("freeNm"));
			pv.setTotalCount(totalCount);
			pv.setCurrentPageNo(pageNo);
			pv.setCountPerPage(10);
			pv.setPageSize(5);
			
			List<FreeCmVO> cmList = cmService.getAllFreeCm(pv);
			
			req.setAttribute("freeCmList", cmList);
			req.setAttribute("pv", pv);
			
			return "/WEB-INF/view/board/freeBoardSelect.jsp";
			
		} else if("SCH".equals(flag)) { // 게시글 검색
			String str = "";

			str = req.getParameter("search");
			
			IFreeService service = FreeServiceImpl.getInstance();
			
			List<FreeBoardVO> list = service.searchFreeBoard(str);
			
			req.setAttribute("list", list);
			
			return "/WEB-INF/view/board/freeBoardList.jsp";
		} else if("INS".equals(flag)) {
			return "/WEB-INF/view/board/freeBoardInsert.jsp";
		} else if("UPD".equals(flag)) {
			String freeNm = (String)req.getParameter("freeNm");
			
			IFreeService service = FreeServiceImpl.getInstance();
			
			FreeBoardVO boardVO = new FreeBoardVO();
			boardVO.setFreeNm(freeNm);
			
			FreeBoardVO fv = service.getFreeBoard(boardVO);
			
			if(fv.getAtchFileId() > 0) {
				AtchFileVO fileVO = new AtchFileVO();
				fileVO.setAtchFileId(fv.getAtchFileId());
				
				IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
				List<AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("fv", fv);
			
			return "/WEB-INF/view/board/freeBoardUpdate.jsp";
		}
		
		// 모든 게시글 조회
		int pageNo = req.getParameter("pageNo") == null ?
				1 : Integer.parseInt(req.getParameter("pageNo"));
		
		PagingVO pv = new PagingVO();
		
		IFreeService service = FreeServiceImpl.getInstance();
		
		int totalCount = service.getAllFreeBoardListCount();
		pv.setTotalCount(totalCount);
		pv.setCurrentPageNo(pageNo);
		pv.setCountPerPage(15);
		pv.setPageSize(5);
		
		List<FreeBoardVO> list = service.getAllFreeBoardList(pv);
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("list", list);
		req.setAttribute("pv", pv);
		
		return "/WEB-INF/view/board/freeBoardList.jsp";
	}
}
