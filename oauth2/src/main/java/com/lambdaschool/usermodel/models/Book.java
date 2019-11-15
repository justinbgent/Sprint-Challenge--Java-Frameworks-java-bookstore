package com.lambdaschool.usermodel.models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false)
    private String booktitle;

    @Column(nullable = false, unique = true)
    private String ISBN;

    private int copy;
}
