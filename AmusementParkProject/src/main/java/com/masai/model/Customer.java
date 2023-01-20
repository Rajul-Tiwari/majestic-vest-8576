package com.masai.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerID;
	@NotNull
    private String User_Name;

	@Size(min=4,max=12,message = "Password should has minimum 4 to 12 characters")
	private String password;

	@NotNull
    private String address;

    @Size(min=10, message ="Mobile Number should be of 10 digits!")
	private String mobileNumber;

	@Email
    private String email;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Ticket> tickets;

    

}
