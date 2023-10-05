package com.ham.main.board.notice;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ham.main.board.BoardVO;
import com.ham.main.board.FileVO;
import com.ham.main.commons.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("list")
	public String getList(Pager pager,Model model) throws Exception{
		 
		 List<BoardVO> ar = noticeService.getList(pager);
		 model.addAttribute("list", ar);
		 model.addAttribute("pager", pager);
	    //ERROR, WARN, INFO, DEBUG, TRACE
		log.error("getList 실행");
		return "board/list";	
	}
	
	@GetMapping("add")
	public String add() throws Exception{
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(BoardVO boardVO, MultipartFile[] files) throws Exception{
		log.info("BoardVO : {}", boardVO);
	
		int result = noticeService.add(boardVO, files);
		
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public String getDetail(BoardVO boardVO,Model model) throws Exception{
		boardVO = noticeService.getDetail(boardVO);
		model.addAttribute("nvo", boardVO);
		return "board/detail";
	}
	
	@GetMapping("update")
	public String setUpdate(BoardVO boardVO,Model model) throws Exception{
		boardVO = noticeService.getDetail(boardVO);
		model.addAttribute("nvo", boardVO);
		return "board/update";
	}
	
	@PostMapping("update")
	public String setUpdate(BoardVO boardVO) throws Exception{
		int result = noticeService.setUpdate(boardVO);
		return "redirect:/notice/detail?boardNo="+boardVO.getBoardNo();
	}
	
	@PostMapping("delete")
	public String setDelete(BoardVO boardVO) throws Exception{
		int result = noticeService.setDelete(boardVO);
		return "redirect:./list";
	}
	
	@GetMapping("fileDown")
	public String getFileDown(FileVO fileVO,Model model) throws Exception{
		fileVO = noticeService.getFileDetail(fileVO);	
		model.addAttribute("fileVO", fileVO);
		return "fileDownView";
	}
	
	
	
}
