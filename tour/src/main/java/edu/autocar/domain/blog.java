package edu.autocar.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class blog {

	private int blogId;
	private String owner;
	private String title;
	private String description;
	private int goodCnt;
	private Date regDate;
	private Date updateDate;

	
}
