package com.masai.model;

import jakarta.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AdmnId;
    @Embedded
    private AbstractUser abstractUser;
}
