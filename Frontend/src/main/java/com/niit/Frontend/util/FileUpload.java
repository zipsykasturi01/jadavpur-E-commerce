package com.niit.Frontend.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	private static final String ABS_PATH = "C:\\kasturi_E-commerce project\\Frontend\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = null;
	
	
	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String p_code) 
	{
		
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		

		if(! new File(REAL_PATH).exists()) 
		{
			 new File(REAL_PATH).mkdirs();
		}
		
		if(!new File(ABS_PATH).exists()) 
		{
			new File(ABS_PATH).mkdirs();
		}
		
		try 
		{
			//transfer the file to both the location
			file.transferTo(new File(REAL_PATH + p_code + ".jpg"));
			file.transferTo(new File(ABS_PATH + p_code + ".jpg"));
		}
		catch(IOException ex) 
		{
			ex.printStackTrace();
		}
		return true;
	}

}
