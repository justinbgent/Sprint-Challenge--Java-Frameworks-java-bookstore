package com.lambdaschool.usermodel.models;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lastname;

    private String firstname;
}
