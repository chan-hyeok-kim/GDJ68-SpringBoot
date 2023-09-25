package com.ham.main.board.notice;


import java.util.List;

import com.ham.main.board.BoardVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO extends BoardVO{

	List<NoticeFileVO> noticeFileVOs;
	   
}
