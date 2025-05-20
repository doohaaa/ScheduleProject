package com.example.scheduleproject.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {
    private final String writer;
    private final String title;
    private final String contents;

    public CreateScheduleRequestDto(String writer, String title, String contents){
        this.writer = writer;
        this.title = title;
        this.contents = contents;
    }
}
