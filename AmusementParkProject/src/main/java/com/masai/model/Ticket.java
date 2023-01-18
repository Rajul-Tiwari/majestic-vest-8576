package com.masai.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer TicketId;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<Activity> activity;
    private LocalDateTime dateTime;
}
