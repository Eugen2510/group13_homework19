package com.goit.eugene.module19_hw.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "note")
public class Note {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;
}
