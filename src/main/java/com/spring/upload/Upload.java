package com.spring.upload;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


//해당 Upload클래스는 비지니스 로직을 수행하는 클래스->이럴땐 Service 애노테이션~뙇~

@Service
public class Upload {
	public boolean fileUpload(MultipartHttpServletRequest mRequest) {
		boolean isUpload = false;
		
		String uploadPath="C:\\NCS\\workspace(spring)\\15_FileUpload\\src\\main\\webapp\\resources\\upload\\";
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH + 1);
		int day = cal.get(Calendar.DATE);
		
		Iterator<String> iterator = mRequest.getFileNames();
		while(iterator.hasNext()) {
			String uploadFileName = iterator.next();
			
			//MultipartHttpServletRequest 인터페이스의 메서드
			// getFile(String name) : 파라미터의 name의 업로드 파일에 대한 정보를 구하는 메서드.
			// 톰캣에 있는 임시파일. :multipartFile
			// 그냥놔두게되며ㅑㄴ 나즁에 이름이 사라져버린다아.. 그래서 반드시 새로운 장소에 저장해둬야햄
			MultipartFile mfile = mRequest.getFile(uploadFileName);
			
			// 아직까지는 임시적으로 저장되는 파일. 
			String originalFileName = mfile.getOriginalFilename();
			
			// 물리적으로 저장이 필요
			// resources/...../upload/2020-05-08
			
			String homedir = uploadPath + year +"-"+ month + "-" +day;
			
			File path1 = new File(homedir);
			if(!path1.exists()) {
				path1.mkdirs();//폴더를 만듦
			}
			
			//파일을 만들어보자.
			String saveFileName = originalFileName;
			
			if(saveFileName !=null && !saveFileName.equals("")) {
				//첨부파일이 비어있지않다면!~~~~
				
				if(new File(homedir+"/"+saveFileName).exists()) {
					saveFileName = saveFileName+"_"+System.currentTimeMillis();
				}
				
				try {
					mfile.transferTo(new File(homedir+"/"+saveFileName));
					isUpload = true;
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return isUpload;
	}
}
