package kr.or.ddit.comm.handler;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.json.simple.JSONObject;

import kr.or.ddit.util.FileUploadRequestWrapper;

public class UploadSummernoteImageFile implements CommandHandler {

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		
		JSONObject jsonObject = new JSONObject();
		
		String fileRoot = "../../upload";
		
		FileItem item = ((FileUploadRequestWrapper)req).getFileItem("uploadFile");
		String orignFileName = new File(item.getName()).getName();
		
		File storeFile = new File(fileRoot+"/"+orignFileName);
		
		item.write(storeFile); // 업로드 파일 저장
		
		
		
		
		
		
		
		
		
		
		
		// 404 에러 출력
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		
		return null;
	}
}