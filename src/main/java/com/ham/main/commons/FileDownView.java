package com.ham.main.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.ham.main.board.FileVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FileDownView extends AbstractView{

	@Value("${app.upload}")
	private String filePath;
	
	
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//서버에서 파일을 찾아서 클라이언트로 전송
		
		//어디에서?
		String board = (String)model.get("board");
		
		//어떤 파일?
		FileVO fileVO = (FileVO)model.get("fileVO");
		String fileName = fileVO.getFileName();
		
		//파일 객체 생성
		File file = new File(filePath+board,fileName);
		
		//한글 처리
		response.setCharacterEncoding("UTF-8");
		
		//파일의 크기 정보
		response.setContentLengthLong(file.length());;

		//다운로드시 파일의 이름 인코딩
		String downName = URLEncoder.encode(fileVO.getOriName(),"UTF-8");
		
		//헤더 정보 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+downName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
//		response.setHeader("Content-Length", ""+file.length());
		//HDD에서 파일 읽어서
		FileInputStream fi = new FileInputStream(file);
		
		//클라이언트로 전송
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);
//		fi에서 읽어들인걸 os로 전송하자
		
//		자원 해제
		os.close();
		fi.close();
		
		log.info("--------- File Down view-------");
		log.info("Board:{}", board);
		
		
	}
}
