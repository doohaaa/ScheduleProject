package com.example.scheduleproject.domain.schedule.dto;

import lombok.Getter;

@Getter
public class UpdateTitleAndContentsRequestDto {

    private final String title;
    private final String contents;

    public UpdateTitleAndContentsRequestDto(String title, String contents){
        this.title= title;
        this.contents = contents;
    }

}
