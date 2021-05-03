package kr.or.ddit.user.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RespectBinding;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.user.vo.UserVO;

public class UserHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/login/register.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		String flag = (String)req.getParameter("flag");
		if("U".equals(flag)) {
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
		
		String flag = req.getParameter("flag");
		IUserService service = UserServiceImpl.getInstance();
		
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
		} else {
			if("CHKID".equals(flag)) { // id 중복 검사
				String userId = req.getParameter("userId");
				
				int cnt = service.chkUserId(userId);
				
				req.setAttribute("cnt", cnt);
				
				return "/html/common/userChkResult.jsp";
				
			} else if ("CHKNICK".equals(flag)) { // 닉네임 중복검사
				String userNickName = req.getParameter("userNickName");
				
				int cnt = service.chkNickName(userNickName);
				
				req.setAttribute("cnt", cnt);
				
				return "/html/common/userChkResult.jsp";
				
			} else if("C".equals(flag)) {
				UserVO uv = new UserVO();
				
				BeanUtils.populate(uv, req.getParameterMap());
				
				int cnt = service.signUpUser(uv);
				
				req.setAttribute("cnt", cnt);
				
				return "/html/common/userChkResult.jsp";
			} else if("U".equals(flag)) { // 유저 정보 수정
				UserVO uv = new UserVO();
				
				BeanUtils.populate(uv, req.getParameterMap());
				
				int cnt = service.updateUser(uv);
				String msg = "";
				if(cnt > 0) {
					msg = "성공";
				} else {
					msg = "실패";
				}
				UserVO user = service.getUser(uv.getUserId());
				
				HttpSession session = req.getSession();
				
				session.setAttribute("userVO", user);
				
				String redirectUrl = req.getContextPath() + "/main/main.do?" + URLEncoder.encode(msg, "UTF-8");
				
				return redirectUrl;
			} else if("D".equals(flag)) { // 유저 삭제
				UserVO uv = new UserVO();
				
				uv.setUserId(req.getParameter("userId"));
				
				int cnt = service.deleteUser(uv);
				
				String msg = "";
				if(cnt > 0) {
					msg = "성공";
				} else {
					msg = "실패";
				}
				String redirectUrl = req.getContextPath() + "/main/main.do?" + URLEncoder.encode(msg, "UTF-8");
				
				return redirectUrl;
			}
		}
		return null;
	}
}
