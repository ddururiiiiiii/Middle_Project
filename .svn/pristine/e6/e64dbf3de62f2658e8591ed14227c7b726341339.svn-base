package kr.or.ddit.board.handler;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.board.service.FaqServiceImpl;
import kr.or.ddit.board.service.IFaqService;
import kr.or.ddit.board.vo.FaqBoardVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class FaqBoardHandler implements CommandHandler{

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
				return "/WEB-INF/view/board/faqBoardInsert.jsp";
			} else {
				String userId = uv.getUserId();
				FaqBoardVO fbv = new FaqBoardVO(); 
				
				IFaqService service = FaqServiceImpl.getInstance();
				
				String faqTitle = req.getParameter("faqTitle");
				String faqContent = req.getParameter("faqContent");
				fbv.setFaqTitle(faqTitle);
				fbv.setFaqContent(faqContent);
				fbv.setFaqWriter(userId);
				
				if((String)req.getParameter("attachFile") == "") {
					FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFileId");
					AtchFileVO atchFileVO = new AtchFileVO();
					
					IAtchFileService fileService = AtchFileServiceImpl.getInstance();
					atchFileVO = fileService.saveAtchFile(item, userId);
					
					fbv.setAtchFileId(atchFileVO.getAtchFileId());
				}
				
				int cnt = service.insertFaqBoard(fbv);

				String msg = "";
				
				if(cnt > 0) {
					msg = "성공";
				} else {
					msg = "실패";
				}
				String redirectUrl = req.getContextPath() 
						+ "/board/faqBoard.do?msg="
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
			
			IFaqService service = FaqServiceImpl.getInstance();
			
			FaqBoardVO fbv = new FaqBoardVO();
			
			fbv.setFaqNm(req.getParameter("faqNm"));
			fbv.setFaqTitle(req.getParameter("faqTitle"));
			fbv.setFaqContent(req.getParameter("faqContent"));
			fbv.setAtchFileId(atchFileVO.getAtchFileId());
			
			int cnt = service.updateFaqBoard(fbv);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath() + "/board/faqBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			return redirectUrl;	
			
		} else if("D".equals(flag)) { // 게시글 삭제
			FaqBoardVO fbv = new FaqBoardVO();
			
			fbv.setFaqNm(req.getParameter("faqNm"));
			
			IFaqService service = FaqServiceImpl.getInstance();
			
			int cnt = service.deleteFaqBoard(fbv);
			
			String msg = "";
			if(cnt > 0){
				msg = "성공";
			} else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath() + "/board/faqBoard.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			
			return redirectUrl;
			
		} else if("SEL".equals(flag)) { // 한 게시글 조회
			String faqNm = req.getParameter("faqNm");
			
			IFaqService service = FaqServiceImpl.getInstance();
			
			FaqBoardVO fbv = service.getFaqBoard(faqNm);
			
			if(fbv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(fbv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("fbv", fbv);

			/*// 댓글 전부 보여줌
			IQnaCmService cmService = QnaCmServiceImpl.getInstance();
			
			List<QnaCmVO> cmList = cmService.getAllQnaCm(qnaNm);
			
			req.setAttribute("qnaCmList", cmList);*/
			
			return "/WEB-INF/view/board/faqBoardSelect.jsp";
			
		} else if("SCH".equals(flag)) { // 게시글 검색
			String faqTitle = "";

			faqTitle = req.getParameter("faqTitle");
			
			IFaqService service = FaqServiceImpl.getInstance();
			
			List<FaqBoardVO> list = service.searchFaqBoard(faqTitle);
			
			req.setAttribute("faqTitle", faqTitle);
			req.setAttribute("list", list);
			
			return "/WEB-INF/view/board/faqBoardList.jsp";
			
		} else if("INS".equals(flag)) {
			return "/WEB-INF/view/board/faqBoardInsert.jsp";
		} else if("UPD".equals(flag)) {
			String faqNm = (String)req.getParameter("faqNm");
			
			IFaqService service = FaqServiceImpl.getInstance();
			
			FaqBoardVO fbv = service.getFaqBoard(faqNm);
			
			if(fbv.getAtchFileId() > 0) {
				AtchFileVO fileVO = new AtchFileVO();
				fileVO.setAtchFileId(fbv.getAtchFileId());
				
				IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
				List<AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("fbv", fbv);
			
			return "/WEB-INF/view/board/faqBoardUpdate.jsp";
		}
		
		// 모든 게시글 조회
		
		// 요청 페이지 번호
		int pageNo = 
			req.getParameter("pageNo") == null ? 
			1 : Integer.parseInt(req.getParameter("pageNo"));
		
		PagingVO pagingVO = new PagingVO();
		
		IFaqService service = FaqServiceImpl.getInstance();
		
		int totalCount = service.getAllFaqBoardListCount();
		pagingVO.setTotalCount(totalCount);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setCountPerPage(15);
		pagingVO.setPageSize(5);

		List<FaqBoardVO> list = service.getAllFaqBoard(pagingVO);
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("list", list);
		req.setAttribute("pv", pagingVO);
		
		return "/WEB-INF/view/board/faqBoardList.jsp";
	}

}
