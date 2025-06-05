package com.example.scheduleproject.domain.schedule.entity;

import com.example.scheduleproject.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    public Schedule(){}

    public Schedule(Long userId, String title, String contents){
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }

    public void updateSchedule(String title, String contents){
        this.title = title;
        this.contents = contents;
    }
}
