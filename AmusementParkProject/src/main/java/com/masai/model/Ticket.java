package com.masai.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @OneToOne( cascade = CascadeType.ALL)
    private Activity activity;
    private LocalDateTime dateTime;
    @ManyToOne
    private Customer customer;
}
