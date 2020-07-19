package com.system.springboot.backend.controller;

import com.system.springboot.backend.entity.Course;
import com.system.springboot.backend.service.CourseService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseRestController {


    /**
     * Injection of service user by constructor
     */
    private final CourseService courseService;
    /**
     * endpoint findAll
     * @return a list objects of type course or exception
     */
    @GetMapping
    public ResponseEntity<List<Course>> findAllCourses(){
        return new ResponseEntity <> (courseService.findAllCourses(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable Long id){
        return new ResponseEntity<>(courseService.findCourseById(id), HttpStatus.OK);
    }


    /**
     *
     * @param name
     * @return
     */
    @GetMapping("findNameSite/{name}")
    public ResponseEntity<List<Course>> findCoursesByNameContainingOrSiteContaining(@PathVariable String name){
        return new ResponseEntity <> (courseService.findCoursesByNameContainingOrSiteContaining(name, name), HttpStatus.OK);
    }

    /**
     *
     * @param course
     * @return
     */
    @PostMapping
    public ResponseEntity<Course> saveCourse(@Validated @RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course),HttpStatus.CREATED);
    }

    /**
     *
     * @param course
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Course> UpdateCourse(@Validated @RequestBody Course course, @PathVariable Long id){
        Course courseNew = courseService.findCourseById(id);
        courseNew = course;
        courseNew.setId(id);
        return new ResponseEntity<>(courseService.saveCourse(courseNew),HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return new ResponseEntity<>("Course successfully deleted",HttpStatus.OK);
    }

}
