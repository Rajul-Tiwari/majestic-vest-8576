package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer TicketId;

	@JsonIgnore
	@OneToOne
	private Activity activity;

	private LocalDateTime dateTime;

	@JsonIgnore
	@ManyToOne
	private Customer customer;
}
