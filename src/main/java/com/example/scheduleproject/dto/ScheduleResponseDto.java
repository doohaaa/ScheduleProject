package com.example.scheduleproject.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String writer;
    private final String title;
    private final String contents;

    public ScheduleResponseDto(Long id, String writer, String title, String contents){
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }
}
