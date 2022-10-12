package com.bmj.apiservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bmj.apiservice.dto.CourseDto;

@Service
public interface CourseService {
	
	public List<CourseDto> searchData(String keyword);

}
