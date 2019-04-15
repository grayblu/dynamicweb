package edu.autocar.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

	private int blogId;
	private String userId;
	private String title;
	private String description;
	private int goodCnt;
	private Date regDate;
	private Date updateDate;

	private List<BlogPost> list;
}
