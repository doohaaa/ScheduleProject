package com.example.scheduleproject.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="schedule")
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    public Schedule(){}

    public Schedule(String writer, String title, String contents){
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }

    public void updateSchedule(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
