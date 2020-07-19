package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findCoursesByNameContainingOrSiteContaining(String name, String site);

}
