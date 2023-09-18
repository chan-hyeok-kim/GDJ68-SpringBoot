package com.ham.main.board;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {

	private Long boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContents;
	private Date boardDate;
	private Long boardHit;
}
