package com.spring.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	@Autowired
	private Upload upload;
	
	
	@RequestMapping("upload.do")
	public String upload() {
		return "uploadForm";
	}//upload() 메서드 end
	
	
	//MultipartHttpServletRequest : 인터페이스 
	// 주요 메서드
	// getFileNames() : 업로드된 파일"들"의 이름의 목록을 제공하는 메서드.
	//		==> 반환형 ? Iteratator<String>
	
	@RequestMapping("upload_ok.do")
	public ModelAndView upload(MultipartHttpServletRequest mRequest) {
		ModelAndView mav = new ModelAndView();
		
		if(upload.fileUpload(mRequest)) {
			mav.addObject("result", "파일업ㄹ드성공");
		}else {
			mav.addObject("result", "파일업로드실패");
		}
		
		mav.setViewName("uploadResult");
		
		return mav;
	}//upload() 메서드 end
}
