package com.system.springboot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Firetruck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String trademark;

    private String model;

    private String engine;

    private String chassis;

    private String image;

    private String description;

    @Column(nullable=false)
    private String patent;

    @Temporal(TemporalType.DATE)
    private Date creation;

    private Integer capacity;

    private String state;

    @JsonIgnoreProperties(value = { "firetruck", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

    @JsonIgnoreProperties(value = { "firetruck", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "firetruck", cascade = CascadeType.ALL)
    private List<Compartment> compartment;

    @JsonIgnoreProperties(value = { "firetruck", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "firetruck", cascade = CascadeType.ALL)
    private List<Maintenance> maintenance;

    @JsonIgnoreProperties(value = { "firetruck", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "firetruck", cascade = CascadeType.ALL)
    private List<TechnicalReview> technicalReview;


}
