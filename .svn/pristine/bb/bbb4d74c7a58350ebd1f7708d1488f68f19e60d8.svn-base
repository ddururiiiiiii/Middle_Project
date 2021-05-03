package kr.or.ddit.boardComment.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.service.INoticeService;
import kr.or.ddit.board.service.NoticeServiceImpl;
import kr.or.ddit.board.vo.NoticeBoardVO;
import kr.or.ddit.boardComment.service.INoticeCmService;
import kr.or.ddit.boardComment.service.NoticeCmServiceImpl;
import kr.or.ddit.boardComment.vo.NoticeCmVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.user.vo.UserVO;


public class NoticeCmHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	String flag = (String) req.getParameter("flagCm");
	
	 	String noticeNm = req.getParameter("noticeNm");
		
		HttpSession session = req.getSession();
		
		INoticeCmService noticeCmService = NoticeCmServiceImpl.getInstance();
		INoticeService noticeService = NoticeServiceImpl.getInstance();
		
		NoticeBoardVO nv2 = noticeService.getNoticeBoard(noticeNm);
		
		req.setAttribute("noticeVO", nv2);
		
		
		if("C".equals(flag)) { // 댓글 작성
			UserVO uv = (UserVO) session.getAttribute("userVO");
			String userId = uv.getUserId();
			
			NoticeBoardVO nv = new NoticeBoardVO();
	
			nv.setNoticeNm(noticeNm);
			nv.setNoticeNm(req.getParameter("ncNm"));
			nv = noticeService.getNoticeBoard(req.getParameter("ncNm"));
			req.setAttribute("nv", nv);

			if(nv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(nv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			NoticeCmVO ncv = new NoticeCmVO();
		
			ncv.setNcContent(req.getParameter("ncContent"));
			ncv.setNcWriter(userId);
			ncv.setNcNm(req.getParameter("ncNm"));
			ncv.setNcType(req.getParameter("ncType"));
			ncv.setNoticeNm(noticeNm);
		
			noticeCmService.insertNoticeCm(ncv);
			
			List<NoticeCmVO> noticeCmList = noticeCmService.getNoticeCmListByNoticeNm(req.getParameter("ncNm"));
			
			req.setAttribute("noticeCmList", noticeCmList);
			
			return "/WEB-INF/view/board/noticeBoardSelect.jsp";
			
		} else if("U".equals(flag)) { // 댓글 수정
			
			NoticeBoardVO nv = new NoticeBoardVO();
			nv.setNoticeNm(req.getParameter("ncNm"));
			
			nv = noticeService.getNoticeBoard(req.getParameter("ncNm"));
			
			req.setAttribute("nv", nv);

			
			if(nv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(nv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			NoticeCmVO ncv = new NoticeCmVO();
			ncv.setNcContent(req.getParameter("ncContent"));
			ncv.setNcNm(req.getParameter("ncNm"));
			ncv.setNoticeNm(req.getParameter("ncNm"));
			
			noticeService.updateNoticeBoard(nv);
			List<NoticeCmVO> noticeCmList = noticeCmService.getNoticeCmListByNoticeNm("ncNm");
			
			req.setAttribute("noticeCmList", noticeCmList);
			
			return "/WEB-INF/view/board/noticeBoardSelect.jsp"; 
		} else if("D".equals(flag)) { // 댓글 삭제
			NoticeCmVO ncv = new NoticeCmVO();
			
			NoticeBoardVO nv = new NoticeBoardVO();
			nv.setNoticeNm(req.getParameter("ncNm"));
			nv = noticeService.getNoticeBoard(req.getParameter("ncNm"));
			
			ncv.setNcNm(req.getParameter("ncNm"));
			ncv.setNoticeNm(req.getParameter("ncNm"));
			
			noticeCmService.deleteNoticeCm(ncv);
			List<NoticeCmVO> noticeCmList = noticeCmService.getNoticeCmListByNoticeNm("ncNm");
			
			if(nv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(nv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("noticeCmList", noticeCmList);
			req.setAttribute("nv", nv);
			
			return "/WEB-INF/view/board/noticeBoardSelect.jsp"; 
			
		}
		return "/WEB-INF/view/board/noticeBoardSelect.jsp"; 
	}
}
