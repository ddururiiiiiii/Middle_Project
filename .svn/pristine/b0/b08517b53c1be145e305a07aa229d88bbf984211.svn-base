
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="kr.or.ddit.util.FileUploadRequestWrapper"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%


JSONObject jsonObject = new JSONObject();

String fileRoot = request.getContextPath() + "/attachfile/summernote";

FileItem item = ((FileUploadRequestWrapper)request).getFileItem("uploadFile");
String orignFileName = new File(item.getName()).getName();

File storeFile = new File(fileRoot + "/" + orignFileName);
System.out.println(item.toString());
System.out.println(storeFile.toString());
try {
	item.write(storeFile); // 업로드 파일 저장
}catch(Exception e) {
	e.printStackTrace();
}

// 생성된 경로를 JSON 형식으로 보내주기 위한 설정
JSONObject jobj = new JSONObject();
jobj.put("url", fileRoot + "/" + orignFileName);

response.setContentType("application/json"); // 데이터 타입을 json으로 설정하기 위한 세팅
out.print(jobj.toJSONString());



// 	System.out.println(request.getRequestURI());
//     // 이미지 업로드할 경로
// 	String uploadPath = "./attachfile";
// 	File isDir = new File(uploadPath);
// 	System.out.println(isDir.exists());
// 	if(!isDir.exists()){
// 		isDir.mkdirs();
// 		out.println("경로생성됨");
// 	}
    
// 	int size = 10 * 1024 * 1024;  // 업로드 사이즈 제한 10M 이하
	
// 	String fileName = ""; // 파일명
	
// 	try{
//         // 파일업로드 및 업로드 후 파일명 가져옴
// 		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
// 		Enumeration files = multi.getFileNames();
// 		String file = (String)files.nextElement(); 
// 		fileName = multi.getFilesystemName(file); 
		
// 	}catch(Exception e){
// 		e.printStackTrace();
// 	}
	
//     // 업로드된 경로와 파일명을 통해 이미지의 경로를 생성
// 	String imagePath = uploadPath + fileName;
	
//     // 생성된 경로를 JSON 형식으로 보내주기 위한 설정
// 	JSONObject jobj = new JSONObject();
// 	jobj.put("url", imagePath);
	
// 	response.setContentType("application/json"); // 데이터 타입을 json으로 설정하기 위한 세팅
// 	out.print(jobj.toJSONString());
%>