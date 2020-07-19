package com.system.springboot.backend.service;

import com.system.springboot.backend.entity.Course;
import com.system.springboot.backend.exception.InternalServerErrorException;
import com.system.springboot.backend.exception.NotFoundException;
import com.system.springboot.backend.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class CourseService {
    /**
     * dependency injection by constructor
     */
    private final CourseRepository courseRepository;
    /**
     *
     * @return list of all courses
     */
    public List<Course> findAllCourses(){
         List<Course> listCourses = new ArrayList<>();

         Optional.ofNullable(courseRepository.findAll())
                .orElseThrow(()-> new NotFoundException("empty list", new Exception("")))
                .forEach(listCourses::add);
         return listCourses;
    }
    /**
     *
     * @param id
     * @return object type course
     */
    public Course findCourseById(Long id){
        return courseRepository.findById(id).orElseThrow(()-> new NotFoundException("course not exist",new Exception("")));
    }

    /**
     *
     * @param name
     * @param site
     * @return
     */
    public List<Course> findCoursesByNameContainingOrSiteContaining(String name, String site){
        List<Course> listCourses = new ArrayList<>();

        Optional.of(courseRepository.findCoursesByNameContainingOrSiteContaining(name,site))
                .orElseThrow(()->new NotFoundException("empty list",new Exception("")))
                .forEach(listCourses::add);

        return listCourses;
    }

    /**
     *
     * @param course
     * @return object type course with attributes in json
     */
    public Course saveCourse(Course course){
        return Optional.of(courseRepository.save(course))
                .orElseThrow(()->new InternalServerErrorException("internal server error",new Exception("")));
    }

    public void deleteCourse(Long id){
        Course course=findCourseById(id);
        courseRepository.delete(course);
    }






}
