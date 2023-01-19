package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentUserSession {
	

	@Id
	@Column(unique = true)
	private Integer userId;
	
	
	private String uuid;
	
	private LocalDateTime localDateTime;

	

	
	
	
}
