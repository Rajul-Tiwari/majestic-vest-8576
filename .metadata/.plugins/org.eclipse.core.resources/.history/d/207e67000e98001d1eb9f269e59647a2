package com.masai.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDTO {

	@Email
	private String email;

	@Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
	private String password;
	
	//private String role;
	
}
