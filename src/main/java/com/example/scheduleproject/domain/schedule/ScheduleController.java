package com.example.scheduleproject.domain.schedule;

import com.example.scheduleproject.domain.schedule.dto.CreateScheduleRequestDto;
import com.example.scheduleproject.domain.schedule.dto.ScheduleResponseDto;
import com.example.scheduleproject.domain.schedule.dto.ScheduleResponseDtoWithoutId;
import com.example.scheduleproject.domain.schedule.dto.UpdateTitleAndContentsRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save (@RequestBody CreateScheduleRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getUserId(), requestDto.getTitle(), requestDto.getContents()
                );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDtoWithoutId> findById(@PathVariable Long id){
        ScheduleResponseDtoWithoutId scheduleResponseDtoWithoutId = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDtoWithoutId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateSchedule(
            @PathVariable Long id, @RequestBody UpdateTitleAndContentsRequestDto requestDto
            ){
        scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContents());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
