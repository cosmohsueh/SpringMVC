package com.cosmo.spring;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileDownloadController {

	private static final int BUFFER_SIZE = 4096;
	
	private String filePath = "/downloads/SpringProject.zip";
	
	@RequestMapping(value = "/download.do", method = RequestMethod.GET)
	public void doDownload(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ServletContext context = request.getSession().getServletContext();
		String appPath = context.getRealPath("");
		System.out.println("appPath: " + appPath);
		
		String fullPath = appPath + filePath;
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);
		
		String mimeType = context.getMimeType(fullPath);
		if(mimeType == null){
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME-TYPE: " + mimeType);
		
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		
		String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
        
        OutputStream outputStream = response.getOutputStream();
        
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
        
        while((bytesRead = inputStream.read(buffer)) != -1){
        	outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();
	}
}
