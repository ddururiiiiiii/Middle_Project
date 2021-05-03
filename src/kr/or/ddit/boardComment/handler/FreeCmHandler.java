package kr.or.ddit.boardComment.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.boardComment.service.IFreeCmService;
import kr.or.ddit.board.service.FreeServiceImpl;
import kr.or.ddit.board.service.IFreeService;
import kr.or.ddit.board.vo.FreeBoardVO;
import kr.or.ddit.boardComment.service.FreeCmServiceImpl;
import kr.or.ddit.boardComment.vo.FreeCmVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.user.vo.UserVO;

public class FreeCmHandler implements CommandHandler {
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String flag = (String) req.getParameter("flagCm");
		
		HttpSession session = req.getSession();
		
		IFreeCmService service = FreeCmServiceImpl.getInstance();
		IFreeService boardService = FreeServiceImpl.getInstance();
		
		if("C".equals(flag)) { // 댓글 작성
			UserVO uv = (UserVO) session.getAttribute("userVO");
			String userId = uv.getUserId();
			
			FreeBoardVO fv = new FreeBoardVO();
			fv.setFreeNm(req.getParameter("freeNmCm"));
			fv = boardService.getFreeBoard(fv);
			req.setAttribute("fv", fv);
			
			if(fv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(fv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			int pageNo = req.getParameter("pageNo") == null ? 
					1 : Integer.parseInt(req.getParameter("pageNo"));
			PagingVO pv = new PagingVO();
			
			int totalCount = service.getAllFreeCmCount(req.getParameter("freeNmCm"));
			pv.setBoardNo(req.getParameter("freeNmCm"));
			pv.setTotalCount(totalCount);
			pv.setCurrentPageNo(pageNo);
			pv.setCountPerPage(10);
			pv.setPageSize(5);
			
			FreeCmVO fcv = new FreeCmVO();
			fcv.setFcContent(req.getParameter("fcContent"));
			fcv.setFcWriter(userId);
			fcv.setFreeNm(req.getParameter("freeNmCm"));
			fcv.setFcType(req.getParameter("fcType"));
			
			service.insertFreeCm(fcv);
			
			List<FreeCmVO> freeCmList = service.getAllFreeCm(pv);
			
			req.setAttribute("freeCmList", freeCmList);
			req.setAttribute("pv", pv);
			
			return "/WEB-INF/view/board/freeBoardSelect.jsp";
			
		} else if ("U".equals(flag)) { // 댓글 수정
			FreeBoardVO fv = new FreeBoardVO();
			fv.setFreeNm(req.getParameter("freeNmCm"));
			fv = boardService.getFreeBoard(fv);
			req.setAttribute("fv", fv);
			
			if(fv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(fv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			FreeCmVO fcv = new FreeCmVO();
			fcv.setFcContent(req.getParameter("fcContent"));
			fcv.setFcNm(req.getParameter("fcNmCm"));
			fcv.setFreeNm(req.getParameter("freeNmCm"));
			service.updateFreeCm(fcv);
			
			int pageNo = req.getParameter("pageNo") == null ? 
					1 : Integer.parseInt(req.getParameter("pageNo"));
			PagingVO pv = new PagingVO();
			
			int totalCount = service.getAllFreeCmCount(req.getParameter("freeNmCm"));
			pv.setBoardNo(req.getParameter("freeNmCm"));
			pv.setTotalCount(totalCount);
			pv.setCurrentPageNo(pageNo);
			pv.setCountPerPage(10);
			pv.setPageSize(5);
			
			List<FreeCmVO> freeCmList = service.getAllFreeCm(pv);
			
			req.setAttribute("freeCmList", freeCmList);
			req.setAttribute("pv", pv);
			
			return "/WEB-INF/view/board/freeBoardSelect.jsp";
			
		} else if("D".equals(flag)) { // 댓글 삭제
			FreeCmVO fcv = new FreeCmVO();
			FreeBoardVO fv = new FreeBoardVO();
			fv.setFreeNm(req.getParameter("freeNmCm"));
			fv = boardService.getFreeBoard(fv);
			
			fcv.setFcNm(req.getParameter("fcNmCm"));
			fcv.setFreeNm(req.getParameter("freeNmCm"));
			
			service.deleteFreeCm(fcv);
			
			if(fv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(fv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			int pageNo = req.getParameter("pageNo") == null ? 
					1 : Integer.parseInt(req.getParameter("pageNo"));
			PagingVO pv = new PagingVO();
			
			int totalCount = service.getAllFreeCmCount(req.getParameter("freeNmCm"));
			pv.setBoardNo(req.getParameter("freeNmCm"));
			pv.setTotalCount(totalCount);
			pv.setCurrentPageNo(pageNo);
			pv.setCountPerPage(10);
			pv.setPageSize(5);
			
			List<FreeCmVO> freeCmList = service.getAllFreeCm(pv);
			req.setAttribute("fv", fv);
			req.setAttribute("freeCmList", freeCmList);
			req.setAttribute("pv", pv);
			
			return "/WEB-INF/view/board/freeBoardSelect.jsp";
		} 
		String freeNm = req.getParameter("freeNm");
		
		FreeBoardVO fv = new FreeBoardVO();
		fv.setFreeNm(freeNm);
		
		fv = boardService.getFreeBoard(fv);
		
		if(fv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
			AtchFileVO fileVO = new AtchFileVO();
			
			fileVO.setAtchFileId(fv.getAtchFileId());
			
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			
			List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
			
			req.setAttribute("atchFileList", atchFileList);
		}
		
		req.setAttribute("fv", fv);
		
		
		int pageNo = req.getParameter("pageNo") == null ?
				1 : Integer.parseInt(req.getParameter("pageNo"));
		
		PagingVO pv = new PagingVO();
		
		int totalCount = service.getAllFreeCmCount(freeNm);
		pv.setBoardNo(req.getParameter("freeNm"));
		pv.setTotalCount(totalCount);
		pv.setCurrentPageNo(pageNo);
		pv.setCountPerPage(10);
		pv.setPageSize(5);
		
		List<FreeCmVO> cmList = service.getAllFreeCm(pv);
		
		req.setAttribute("freeCmList", cmList);
		req.setAttribute("pv", pv);
		
		return "/WEB-INF/view/board/freeBoardSelect.jsp";
	}

}
