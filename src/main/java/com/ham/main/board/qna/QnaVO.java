package com.ham.main.board.qna;

import com.ham.main.board.BoardVO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QnaVO extends BoardVO {

	private Long ref;
	private Long step;
	private Long depth;
}
