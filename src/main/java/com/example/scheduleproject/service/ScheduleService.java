package com.example.scheduleproject.service;

import com.example.scheduleproject.dto.CreateScheduleRequestDto;
import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.dto.ScheduleResponseDtoWithoutId;
import com.example.scheduleproject.entity.Schedule;
import com.example.scheduleproject.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto save(String writer, String title, String contents){
        Schedule schedule = new Schedule(writer, title, contents);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getWriter(), savedSchedule.getTitle(), savedSchedule.getContents());
    }

    public ScheduleResponseDtoWithoutId findById(Long id){
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        // NPE 방지
        if(optionalSchedule.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = "+id);
        }

        Schedule findSchedule = optionalSchedule.get();

        return new ScheduleResponseDtoWithoutId(findSchedule.getWriter(), findSchedule.getTitle(), findSchedule.getContents());
    }

    public List<ScheduleResponseDto> findAll(){
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::toDto).toList();
    }


}
