package com.bmj.apiservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bmj.apiservice.dto.CourseDto;
import com.bmj.apiservice.dto.CourseRecordDto;
import com.bmj.apiservice.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	/*
	 * @Param searchTerm
	 * 
	 * return all matchable courses.
	 * */
	@GetMapping("/courseSearch/{searchTerm}")
	public ResponseEntity<List<CourseDto>> searchCourse(@PathVariable("searchTerm") final String searchTerm) {
		//search by keyword
		List<CourseDto> courseDto = this.courseService.searchData(searchTerm);
		
		return new ResponseEntity<List<CourseDto>>(courseDto , HttpStatus.OK);
	}
	
	/*
	 * @Param searchTerm
	 * 
	 * return all matchable courses and sum of hours.
	 * */
	@GetMapping("/courseSearchHours/{searchTerm}")
	public ResponseEntity<CourseRecordDto> searchCourseTime(@PathVariable("searchTerm") final String searchTerm) {
		List<CourseDto> courseDto = this.courseService.searchData(searchTerm);
		
		List<String> listOfHours = courseDto.stream().filter(course -> course.getTitle().indexOf(",") != -1).map(course -> course.getTitle().split(",")[0]).collect(Collectors.toList());
		
		Optional<Double> totalHours = listOfHours.stream().map(s -> Double.parseDouble(s)).reduce((num1, num2) -> num1 + num2);
		
		CourseRecordDto courseRecordDto = new CourseRecordDto(); 
		courseRecordDto.setCourses(courseDto);
		if(totalHours.isPresent()) {
			courseRecordDto.setSumOfHours(totalHours.get());
		}
		
		return new ResponseEntity<CourseRecordDto>(courseRecordDto , HttpStatus.OK);
	}
}
