package com.ham.main.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ham.main.board.BoardService;
import com.ham.main.board.BoardVO;
import com.ham.main.board.FileVO;
import com.ham.main.commons.FileManager;
import com.ham.main.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class NoticeService implements BoardService {
    
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
//	properties의 키로 밸류 가져옴
//	properties의 값을 자바에서 사용하고 싶을 때 사용
	@Value("${app.upload}")
	private String uploadPath;
	
	@Value("${app.board.notice}")
	private String boardName;
	
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makePageNum(noticeDAO.getCount(pager));	
		return noticeDAO.getList(pager);
	}

	@Override
	public int add(BoardVO boardVO, MultipartFile[] files) throws Exception {
		log.info("BoardNo: {}", boardVO.getBoardNo());
		int result = noticeDAO.add(boardVO);
		
		log.info("==========================");
		log.info("BoardNo: {}", boardVO.getBoardNo());
	    
		
		for(MultipartFile multipartFile: files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			NoticeFileVO noticeFileVO = new NoticeFileVO();
		    String fileName = fileManager.save(this.uploadPath+this.boardName, multipartFile);
		    noticeFileVO.setBoardNo(boardVO.getBoardNo());
		    noticeFileVO.setFileName(fileName);
		    noticeFileVO.setOriName(multipartFile.getOriginalFilename());
		    result = noticeDAO.fileAdd(noticeFileVO);
		}
		
		return result; 
	}

	@Override
	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		noticeDAO.setHitUpdate(boardVO);
		return noticeDAO.getDetail(boardVO);
	}

	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardVO);
	}

	@Override
	public FileVO getFileDetail(FileVO fileVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getFileDetail(fileVO);
	}
  
}
