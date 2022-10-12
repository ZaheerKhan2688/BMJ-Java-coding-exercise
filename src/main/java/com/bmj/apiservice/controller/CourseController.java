package com.bmj.apiservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bmj.apiservice.dto.CourseDto;
import com.bmj.apiservice.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courseSearch/{searchTerm}")
	public ResponseEntity<List<CourseDto>> searchCourse(@PathVariable("searchTerm") final String searchTerm) {
		//search by keyword
		List<CourseDto> courseDto = this.courseService.searchData(searchTerm);
		
		return new ResponseEntity<List<CourseDto>>(courseDto , HttpStatus.OK);
	}
	
	//return total hours with list of courses matching
	@GetMapping("/courseSearchTime/{searchTerm}")
	public ResponseEntity<List<CourseDto>> searchCourseTime(@PathVariable("searchTerm") final String searchTerm) {
		List<CourseDto> courseDto = this.courseService.searchData(searchTerm);
		
		//We will fetch the hours by spliting by ","
		List<String> listOfHours = courseDto.stream().map(course -> course.toString().split(",")[0]).collect(Collectors.toList());
		
		//we ca reduce to the result
		//int total = sum.stream().map().reduce((num1, num2) -> num1+num2);
		
		return new ResponseEntity<List<CourseDto>>(courseDto , HttpStatus.OK);
	}
}
