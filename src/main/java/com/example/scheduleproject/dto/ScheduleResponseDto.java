package com.example.scheduleproject.dto;

import com.example.scheduleproject.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final Long userId;
    private final String title;
    private final String contents;

    public ScheduleResponseDto(Long id, Long userId, String title, String contents){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }

    // entity를 dto로 변환
    public static ScheduleResponseDto toDto(Schedule schedule){
        return new ScheduleResponseDto(schedule.getId(), schedule.getUserId(), schedule.getTitle(), schedule.getContents());
    }

}
