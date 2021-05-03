package kr.or.ddit.boardComment.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.service.CommunityServiceImpl;
import kr.or.ddit.board.service.ICommunityService;
import kr.or.ddit.board.vo.CommunityBoardVO;
import kr.or.ddit.boardComment.service.CommunityCmServiceImpl;
import kr.or.ddit.boardComment.service.ICommunityCmService;
import kr.or.ddit.boardComment.vo.CommunityCmVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.user.vo.UserVO;

public class CommunityCmHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String flag = (String) req.getParameter("flagCm");
		
		HttpSession session = req.getSession();
		UserVO uv = (UserVO) session.getAttribute("userVO");
		
		ICommunityCmService service = CommunityCmServiceImpl.getInstance();
		ICommunityService boardService = CommunityServiceImpl.getInstance();
		
		if("C".equals(flag)) { // 댓글 작성
			String userId = uv.getUserId();
			
			CommunityBoardVO cbv = new CommunityBoardVO();
			cbv.setCbNm(req.getParameter("ccNm"));
			cbv = boardService.getCommunityBoard(req.getParameter("ccNm"));
			
			req.setAttribute("cbv", cbv);
			
			if(cbv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(cbv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			CommunityCmVO ccv = new CommunityCmVO();
			
			ccv.setCcContent(req.getParameter("ccContent"));
			ccv.setCcWriter(userId);
			ccv.setCbNm(req.getParameter("ccNm"));
			ccv.setCcType(req.getParameter("ccType"));
			
			
			service.insertCommunityCm(ccv);
			
			List<CommunityCmVO> communityCmList = service.getAllCommunityCm(req.getParameter("ccNm"));
			
			req.setAttribute("communityCmList", communityCmList);

			return "/WEB-INF/view/board/communityBoardSelect.jsp";
			
		} else if("U".equals(flag)) { // 댓글 수정
			CommunityBoardVO cbv = new CommunityBoardVO();
			cbv.setCbNm(req.getParameter("ccNm"));
			
			cbv = boardService.getCommunityBoard(req.getParameter("ccNm"));
			req.setAttribute("cbv", cbv);
			
			if(cbv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(cbv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			CommunityCmVO ccv = new CommunityCmVO();
			ccv.setCcContent(req.getParameter("ccContent"));
			ccv.setCcNm(req.getParameter("ccNmCm"));
			ccv.setCbNm(req.getParameter("ccNm"));
			
			service.updateCommunityCm(ccv);
			List<CommunityCmVO> communityCmList = service.getAllCommunityCm(req.getParameter("ccNm"));
			
			req.setAttribute("communityCmList", communityCmList);
			
			return "/WEB-INF/view/board/communityBoardSelect.jsp";
			
		} else if("D".equals(flag)) { // 댓글 삭제
			CommunityCmVO ccv = new CommunityCmVO();
			
			CommunityBoardVO cbv = new CommunityBoardVO();
			
			cbv.setCbNm(req.getParameter("ccNm"));
			cbv = boardService.getCommunityBoard(req.getParameter("ccNm"));
			
			ccv.setCcNm(req.getParameter("ccNmCm"));
			ccv.setCbNm(req.getParameter("ccNm"));
			
			service.deleteCommunityCm(ccv);
			List<CommunityCmVO> communityCmList = service.getAllCommunityCm(req.getParameter("ccNm"));
			
			if(cbv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(cbv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("communityCmList", communityCmList);
			req.setAttribute("cbv", cbv);

			return "/WEB-INF/view/board/communityBoardSelect.jsp";
		}
		return "/WEB-INF/view/board/communityBoardSelect.jsp";
	}

}
