package edu.autocar.domain;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int boardId;
	@NotEmpty(message="필수항목")
	private String title;
	@NotEmpty(message="필수항목")
	private String writer;
	@NotEmpty(message="필수항목")
	@Length(min=6, message="비번은 6글자 이상")
	private String password;
	private String content;
	private int readCnt;
	private Date regDate;
	private Date updateDate;
	
	public Board(int boardId) {
		super();
		this.boardId = boardId;
		title = "제목" + boardId;
		writer = "홍길동 " + boardId;
		content = "내용 " + boardId;
		password = "123456";
		readCnt = 0;
		regDate = new Date();
		updateDate = new Date();
		
	}
}
