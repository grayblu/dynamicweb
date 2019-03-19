package edu.autocar.domain;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
	@NotEmpty(message="Id는 필수 입력")
	private String userId;
	@NotEmpty(message="비번은 필수 입력")
	private String password;
}
