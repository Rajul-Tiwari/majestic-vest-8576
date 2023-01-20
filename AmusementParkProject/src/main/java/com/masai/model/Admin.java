package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Admin {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminID;
	
	@NotNull
	@Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
    private String user_Name;


	@Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
	private String password;

	@NotNull
    private String address;

    @Size(min=10, message ="Mobile Number should be of 10 digits!")
	private String mobileNumber;

	@Email
    private String email;
	
	
	
	
	
	
	
	

    
    

}
