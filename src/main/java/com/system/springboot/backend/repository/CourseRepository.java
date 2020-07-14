package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {


}
