package com.masai.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer TicketId;
    @ManyToOne
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    private Activity activity;
    private LocalDateTime dateTime;
}
