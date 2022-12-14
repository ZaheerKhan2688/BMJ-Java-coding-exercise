package com.bmj.apiservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CourseRecordDto {
	
	double sumOfHours;
	
	List<CourseDto> courses;
}
