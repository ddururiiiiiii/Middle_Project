package kr.or.ddit.boardComment.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.service.IQnaService;
import kr.or.ddit.board.service.QnaServiceImpl;
import kr.or.ddit.board.vo.QnaBoardVO;
import kr.or.ddit.boardComment.service.IQnaCmService;
import kr.or.ddit.boardComment.service.QnaCmServiceImpl;
import kr.or.ddit.boardComment.vo.QnaCmVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.user.vo.UserVO;

public class QnaCmHandler implements CommandHandler {
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String flag = (String) req.getParameter("flagCm");
		
		HttpSession session = req.getSession();
		
		IQnaCmService service = QnaCmServiceImpl.getInstance();
		IQnaService boardService = QnaServiceImpl.getInstance();
		
		if("C".equals(flag)) { // 댓글 작성
			UserVO uv = (UserVO) session.getAttribute("userVO");
			String userId = uv.getUserId();
			
			QnaBoardVO qbv = new QnaBoardVO();
			qbv.setQnaNm(req.getParameter("qnaNmCm"));
			qbv = boardService.getQnaBoard(req.getParameter("qnaNmCm"));
			req.setAttribute("qbv", qbv);
			
			if(qbv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(qbv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			QnaCmVO qcv = new QnaCmVO();
			qcv.setQcContent(req.getParameter("qcContent"));
			qcv.setqcWriter(userId);
			qcv.setQnaNm(req.getParameter("qnaNmCm"));
			qcv.setQcType(req.getParameter("qcType"));
			
			service.insertQnaCm(qcv);
			
			List<QnaCmVO> qnaCmList = service.getAllQnaCm(req.getParameter("qnaNmCm"));
			
			req.setAttribute("qnaCmList", qnaCmList);

			return "/WEB-INF/view/board/qnaBoardSelect.jsp";
		} else if("U".equals(flag)) { // 댓글 수정
			QnaBoardVO qbv = new QnaBoardVO();
			qbv.setQnaNm(req.getParameter("qnaNmCm"));
			qbv = boardService.getQnaBoard(req.getParameter("qnaNmCm"));
			req.setAttribute("qbv", qbv);
			
			if(qbv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(qbv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			QnaCmVO qcv = new QnaCmVO();
			qcv.setQcContent(req.getParameter("qcContent"));
			qcv.setQcNm(req.getParameter("qcNmCm"));
			qcv.setQnaNm(req.getParameter("qnaNmCm"));
			
			service.updateQnaCm(qcv);
			List<QnaCmVO> qnaCmList = service.getAllQnaCm(req.getParameter("qnaNmCm"));
			
			req.setAttribute("qnaCmList", qnaCmList);

			return "/WEB-INF/view/board/qnaBoardSelect.jsp";
			
		} else if("D".equals(flag)) { // 댓글 삭제
			QnaCmVO qcv = new QnaCmVO();
			
			QnaBoardVO qbv = new QnaBoardVO();
			qbv.setQnaNm(req.getParameter("qnaNmCm"));
			qbv = boardService.getQnaBoard(req.getParameter("qnaNmCm"));
			
			qcv.setQcNm(req.getParameter("qcNmCm"));
			qcv.setQnaNm(req.getParameter("qnaNmCm"));
			
			service.deleteQnaCm(qcv);
			List<QnaCmVO> qnaCmList = service.getAllQnaCm(req.getParameter("qnaNmCm"));
			
			if(qbv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(qbv.getAtchFileId());
				
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				
				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);
				
				req.setAttribute("atchFileList", atchFileList);
			}
			
			req.setAttribute("qnaCmList", qnaCmList);
			req.setAttribute("qbv", qbv);

			return "/WEB-INF/view/board/qnaBoardSelect.jsp";
		}
		return "/WEB-INF/view/board/qnaBoardSelect.jsp";
	}
}
