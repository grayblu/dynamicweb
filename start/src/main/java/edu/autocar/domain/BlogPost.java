package edu.autocar.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {

	private int postId;
	private String userId;
	private String title;
	private String content;
	private int readCnt;
	private Date regDate;
	private Date updateDate;
}
