package com.example.scheduleproject.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDtoWithoutId {
    private final Long userId;
    private final String title;
    private final String contents;

    public ScheduleResponseDtoWithoutId(Long userId, String title, String contents){
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }
}
