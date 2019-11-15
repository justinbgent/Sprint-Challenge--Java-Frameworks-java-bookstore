package com.lambdaschool.usermodel.models;

import javax.persistence.*;

@Entity
@Table(name = "sections")
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionid;

    @Column(nullable = false, unique = true)
    private String sectionname;
}
