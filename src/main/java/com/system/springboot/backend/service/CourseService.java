package com.system.springboot.backend.service;

import com.system.springboot.backend.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    
}
