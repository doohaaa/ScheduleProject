package com.example.scheduleproject.dto;

import com.example.scheduleproject.entity.Schedule;
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

    // entity를 dto로 변환
    public static ScheduleResponseDto toDto(Schedule schedule){
        return new ScheduleResponseDto(schedule.getId(), schedule.getWriter(), schedule.getTitle(), schedule.getContents());
    }

}
