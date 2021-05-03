package kr.or.ddit.board.handler;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

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
import kr.or.ddit.comm.vo.PagingVO;
import kr.or.ddit.user.vo.UserVO;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class AdminCommunityBoardHandler implements CommandHandler {

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

		if ("C".equals(flag)) { // 게시글 작성
			if (req.getMethod().equals("GET")) {
				return "/WEB-INF/view/admin/adminCommunityBoardInsert.jsp";
			} else {
				String userId = uv.getUserId();

				CommunityBoardVO cbv = new CommunityBoardVO();

				ICommunityService service = CommunityServiceImpl.getInstance();

				// String pjName = req.getParameter("pjName");
				String cbTitle = req.getParameter("cbTitle");
				String cbContent = req.getParameter("cbContent");
				// cbv.setPjName(pjName);
				cbv.setCbTitle(cbTitle);
				cbv.setCbContent(cbContent);
				cbv.setCbWriter(userId);

				if ((String) req.getParameter("attachFile") == "") {
					FileItem item = ((FileUploadRequestWrapper) req).getFileItem("atchFileId");
					AtchFileVO atchFileVO = new AtchFileVO();

					IAtchFileService fileService = AtchFileServiceImpl.getInstance();
					atchFileVO = fileService.saveAtchFile(item, userId);

					cbv.setAtchFileId(atchFileVO.getAtchFileId());
				}

				int cnt = service.insertCommunityBoard(cbv);

				String msg = "";

				if (cnt > 0) {
					msg = "성공";
				} else {
					msg = "실패";
				}
				String redirectUrl = req.getContextPath() + "/admin/adminCommunityBoard.do?msg="
						+ URLEncoder.encode(msg, "UTF-8");
				return redirectUrl;
			}

		} else if ("U".equals(flag)) { // 게시글 수정

			String userId = uv.getUserId();

			FileItem item = ((FileUploadRequestWrapper) req).getFileItem("atchFileId");

			AtchFileVO atchFileVO = new AtchFileVO();

			atchFileVO.setAtchFileId(
					req.getParameter("atchFileId") == null ? -1 : Long.parseLong(req.getParameter("atchFileId")));

			if (item != null && !item.getName().equals("")) {

				IAtchFileService fileService = AtchFileServiceImpl.getInstance();

				atchFileVO = fileService.saveAtchFile(item, userId); // 첨부파일 저장
			}

			ICommunityService service = CommunityServiceImpl.getInstance();

			CommunityBoardVO cbv = new CommunityBoardVO();

			cbv.setCbNm(req.getParameter("cbNm"));
			// cbv.setCbTitle(req.getParameter("cbTitle"));
			String pjName = req.getParameter("pjName");
			cbv.setPjName(req.getParameter("pjName")); // 프로젝트 이름
			cbv.setCbContent(req.getParameter("cbContent"));
			cbv.setAtchFileId(atchFileVO.getAtchFileId());

			int cnt = service.updateCommunityBoard(cbv);

			String msg = "";
			if (cnt > 0) {
				msg = "성공";
			} else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath() + "/admin/adminCommunityBoard.do?msg="
					+ URLEncoder.encode(msg, "UTF-8");

			return redirectUrl;

		} else if ("D".equals(flag)) { // 게시글 삭제
			CommunityBoardVO cbv = new CommunityBoardVO();

			cbv.setCbNm(req.getParameter("cbNm"));

			ICommunityService service = CommunityServiceImpl.getInstance();

			int cnt = service.deleteCommunityBoard(cbv);

			String msg = "";
			if (cnt > 0) {
				msg = "성공";
			} else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath() + "/admin/adminCommunityBoard.do?msg="
					+ URLEncoder.encode(msg, "UTF-8");
			return redirectUrl;

		} else if ("SEL".equals(flag)) { // 한 게시글 조회
			String cbNm = req.getParameter("cbNm");

			ICommunityService service = CommunityServiceImpl.getInstance();

			CommunityBoardVO cbv = new CommunityBoardVO();

			if (cbv.getAtchFileId() > 0) { // 첨부파일이 존재할 때
				AtchFileVO fileVO = new AtchFileVO();

				fileVO.setAtchFileId(cbv.getAtchFileId());

				IAtchFileService fileService = AtchFileServiceImpl.getInstance();

				List<AtchFileVO> atchFileList = fileService.getAtchFileList(fileVO);

				req.setAttribute("atchFileList", atchFileList);
			}

			req.setAttribute("cbv", cbv);

			// 댓글 전부 보여줌
			ICommunityCmService cmService = CommunityCmServiceImpl.getInstance();

			List<CommunityCmVO> cmList = cmService.getAllCommunityCm(cbNm);

			req.setAttribute("cmList", cmList);

			return "/WEB-INF/view/admin/adminCommunityBoardSelect.jsp";

		} else if ("SCH".equals(flag)) { // 게시글 검색
			String str = "";

			str = req.getParameter("search");

			ICommunityService service = CommunityServiceImpl.getInstance();
			CommunityBoardVO cb = new CommunityBoardVO();
			cb.setPjNm(req.getParameter("pjNm"));
			cb.setCbTitle(str);
			cb.setCbWriter(str);
			
			List<CommunityBoardVO> list = service.searchCommunityBoard(cb);

			// 모든 게시글 조회
			int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));

			PagingVO pagingVO = new PagingVO();

			int totalCount = service.getAllCommunityListCount();
			pagingVO.setTotalCount(totalCount);
			pagingVO.setCurrentPageNo(pageNo);
			pagingVO.setCountPerPage(15);
			pagingVO.setPageSize(5);

			req.setAttribute("totalCount", totalCount);
			req.setAttribute("pv", pagingVO);
			req.setAttribute("list", list);


			return "/WEB-INF/view/admin/adminCommunityBoardList.jsp";
		} else if ("INS".equals(flag)) {
			return "/WEB-INF/view/admin/adminCommunityBoardInsert.jsp";
		} else if ("UPD".equals(flag)) {

			String cbNm = req.getParameter("cbNm");

			ICommunityService service = CommunityServiceImpl.getInstance();

			CommunityBoardVO cbv = service.getCommunityBoard(cbNm);

			if (cbv.getAtchFileId() > 0) {
				AtchFileVO fileVO = new AtchFileVO();
				fileVO.setAtchFileId(cbv.getAtchFileId());

				IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
				List<AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);

				req.setAttribute("atchFileList", atchFileList);
			}

			req.setAttribute("cbv", cbv);

			return "/WEB-INF/view/admin/adminCommunityBoardUpdate.jsp";
		}

		// 모든 게시글 조회
		CommunityBoardVO boardVO = new CommunityBoardVO();

		BeanUtils.populate(boardVO, req.getParameterMap());

		ICommunityService service = CommunityServiceImpl.getInstance();

		List<CommunityBoardVO> list = service.getAllCommunityBoardList();

		req.setAttribute("list", list);

		return "/WEB-INF/view/admin/adminCommunityBoardList.jsp";
	}

}
