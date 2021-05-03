package kr.or.ddit.board.handler;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.board.service.FaqServiceImpl;
import kr.or.ddit.board.service.IFaqService;
import kr.or.ddit.board.service.INoticeService;
import kr.or.ddit.board.service.NoticeServiceImpl;
import kr.or.ddit.board.vo.FaqBoardVO;
import kr.or.ddit.board.vo.NoticeBoardVO;
import kr.or.ddit.boardComment.service.INoticeCmService;
import kr.or.ddit.boardComment.service.NoticeCmServiceImpl;
import kr.or.ddit.boardComment.vo.NoticeCmVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class AdminNoticeBoardHandler implements CommandHandler {

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
				return "/WEB-INF/view/admin/adminNoticeBoardInsert.jsp";
			} else {
				
				NoticeBoardVO nv = new NoticeBoardVO();
				
				INoticeService service = NoticeServiceImpl.getInstance();
				
				String noticeTitle = req.getParameter("noticeTitle");
				String noticeContent = req.getParameter("noticeContent");
				nv.setNoticeTitle(noticeTitle);
				nv.setNoticeContent(noticeContent);
				nv.setNoticeWriter(uv.getUserId());
				
				if((String)req.getParameter("attachFile") == "") {
					FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFileId");
					AtchFileVO atchFileVO = new AtchFileVO();
					
					IAtchFileService fileService = AtchFileServiceImpl.getInstance();
					atchFileVO = fileService.saveAtchFile(item, uv.getUserId());
					
					nv.setAtchFileId(atchFileVO.getAtchFileId());
				}
				
				int cnt = service.insertNoticeBoard(nv);

				String msg = "";
				
				if(cnt > 0) {
					msg = "성공";
				} else {
					msg = "실패";
				}
				String redirectUrl = req.getContextPath() 
						+ "/admin/adminNoticeBoard.do?msg=" 
						+ URLEncoder.encode(msg, "UTF-8");
				return redirectUrl;
			}
			
		} else if("U".equals(flag)) { // 게시글 수정
			
			String userId = uv.getUserId();

			INoticeService service = NoticeServiceImpl.getInstance();
			
			NoticeBoardVO nv = new NoticeBoardVO();
			
			nv.setNoticeNm(req.getParameter("noticeNm"));
			nv.setNoticeTitle(req.getParameter("noticeTitle"));
			nv.setNoticeContent(req.getParameter("noticeContent"));
			
			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFileId");
			
			AtchFileVO atchFileVO = new AtchFileVO();
			
			atchFileVO.setAtchFileId(req.getParameter("atchFileId") == null ?
					-1 : Long.parseLong(req.getParameter("atchFileId")));
			
			if(item !=null && !item.getName().equals("")) {
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				atchFileVO = fileService.saveAtchFile(item, userId); // 첨부파일 저장
				
				nv.setAtchFileId(atchFileVO.getAtchFileId());
			}
			
			int cnt = service.updateNoticeBoard(nv);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath() + "/admin/adminNoticeBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			return redirectUrl;	
		} else if("D".equals(flag)) { // 게시글 삭제
			NoticeBoardVO nv = new NoticeBoardVO();
			
			nv.setNoticeNm(req.getParameter("noticeNm"));
			
			INoticeService service = NoticeServiceImpl.getInstance();
			
			int cnt = service.deleteNoticeBoard(nv);
			
			String msg = "";
			if(cnt > 0){
				msg = "성공";
			} else {
				msg = "실패";
			}
			
			String redirectUrl = req.getContextPath() + "/admin/adminNoticeBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			return redirectUrl;
		} else if("SEL".equals(flag)) { // 한 게시글 조회
			String noticeNm = req.getParameter("noticeNm");
			
			INoticeService service = NoticeServiceImpl.getInstance();
			
			NoticeBoardVO nv = service.getNoticeBoard(noticeNm);
			
			if(nv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(nv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("nv", nv);

			// 댓글 전부 보여줌
//			INoticeCmService cmService = NoticeCmServiceImpl.getInstance();
//			
//			List<NoticeCmVO> cmList = cmService.getNoticeCmListByNoticeNm(noticeNm);
//			
//			req.setAttribute("noticeCmList", cmList);
			
			return "/WEB-INF/view/admin/adminNoticeBoardSelect.jsp";
			
		} else if("SCH".equals(flag)) { // 게시글 검색
			
			String noticeTitle = "";

			noticeTitle = req.getParameter("noticeTitle");
			
			INoticeService service = NoticeServiceImpl.getInstance();
			
			List<NoticeBoardVO> list = service.getSearchNoticeBoardList(noticeTitle);
			
			req.setAttribute("noticeTitle", noticeTitle);
			req.setAttribute("list", list);
			
			return "/WEB-INF/view/admin/adminNoticeBoardList.jsp";
		} else if("INS".equals(flag)) { // 게시글 등록하는 페이지로 이동
			return "/WEB-INF/view/admin/adminNoticeBoardInsert.jsp";
		} else if("UPD".equals(flag)) { // 게시글 수정하는 페이지로 이동
			String noticNm = (String)req.getParameter("noticNm");
			
			INoticeService service = NoticeServiceImpl.getInstance();
			
			NoticeBoardVO nv = service.getNoticeBoard(noticNm);
			
			if(nv.getAtchFileId() > 0) {
				AtchFileVO fileVO = new AtchFileVO();
				fileVO.setAtchFileId(nv.getAtchFileId());
				
				IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
				List<AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("nv", nv);
			
			return "/WEB-INF/view/admin/adminNoticeBoardUpdate.jsp";
		}
		
		// 모든 게시글 조회
		int pageNo = req.getParameter("pageNo") == null ?
				1 : Integer.parseInt(req.getParameter("pageNo"));
		PagingVO pv = new PagingVO();
		
		INoticeService service = NoticeServiceImpl.getInstance();
		
		int totalCount = service.getNoticeBoardListCount();
		pv.setTotalCount(totalCount);
		pv.setCurrentPageNo(pageNo);
		pv.setCountPerPage(15);
		pv.setPageSize(5);
		
		List<NoticeBoardVO> list = service.getAllNoticeBoard(pv);
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("list", list);
		req.setAttribute("pv", pv);
		
		return "/WEB-INF/view/admin/adminNoticeBoardList.jsp";
	}
}
