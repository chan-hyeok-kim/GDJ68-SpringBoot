package com.ham.main.commons;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//file 저장 후 파일명 리턴
	public String save(String path, MultipartFile multipartFile) throws Exception{
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
	    String fileName= UUID.randomUUID().toString()+"_"+multipartFile.getOriginalFilename();
	     
	    
//	    FileCopyUtils.copy 쓰면
//	    FileCopyUtils.copy(multipartFile.getBytes(), file);
	    
	    
//	    transferTo
	    file = new File(file,fileName);
	    multipartFile.transferTo(file);
	    
	    return fileName;
	    
	}

}
