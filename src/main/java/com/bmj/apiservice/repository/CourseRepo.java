package com.bmj.apiservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmj.apiservice.entity.CourseData;

public interface CourseRepo extends JpaRepository<CourseData, Integer>{

	List<CourseData> findByTitleContainingIgnoreCase(String s);

}
