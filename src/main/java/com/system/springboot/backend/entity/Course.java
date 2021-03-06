package com.system.springboot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String site;

    private String hour;

    @Temporal(TemporalType.DATE)
    private Date date;

    @JsonIgnoreProperties(value = { "course", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToMany(mappedBy = "course")
    private Set<User> user;


}
