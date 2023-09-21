package com.ham.main.board.qna;

import java.util.List;

import com.ham.main.board.BoardVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QnaVO extends BoardVO {

	private Long ref;
	private Long step;
	private Long depth;
	
}
