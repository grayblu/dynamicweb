package edu.autocar.domain;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {
	
	private int postId;
	private String userId;
	@NotEmpty(message="title 입력")
	private String title;
	@NotEmpty(message="content 입력")
	private String content;
	private int readCnt;
	private Date regDate;
	private Date updateDate;
}
