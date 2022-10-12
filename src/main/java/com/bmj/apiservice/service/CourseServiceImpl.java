package com.bmj.apiservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmj.apiservice.dto.CourseDto;
import com.bmj.apiservice.entity.CourseData;
import com.bmj.apiservice.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepo courseRepo;

	@Override
	public List<CourseDto> searchData(String searchTerm) {
		
		List<CourseData> courseData = this.courseRepo.findByTitleContainingIgnoreCase(searchTerm);
		List<CourseDto> courseDto = courseData.stream().map((course) -> this.convertDatatoDto(course)).collect(Collectors.toList());
		
		return courseDto;
	}
	
	private CourseDto convertDatatoDto(CourseData coursedata) {
		CourseDto courseDto = new CourseDto();
		
		courseDto.setId(coursedata.getId());
		courseDto.setTitle(coursedata.getTitle());
		
		return courseDto;
	}

}
