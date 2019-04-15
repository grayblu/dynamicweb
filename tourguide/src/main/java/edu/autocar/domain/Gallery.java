package edu.autocar.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Gallery {

	private int galleryId;
	private String owner;
	@NotEmpty(message = "비밀번호는 필수 항목입니다.")
	private String password;
	@NotEmpty(message = "제목은 필수 항목입니다.")
	private String title;
	private String description;
	private int readCnt;
	private Date regDate;
	private Date updateDate;
	private List<Image> list;

	public int getRandom() {
		int size = list.size();
		if (size == 0)
			return -1;
		int ix = (int) (Math.random() * list.size());
		return list.get(ix).getImageId();
	}
}
