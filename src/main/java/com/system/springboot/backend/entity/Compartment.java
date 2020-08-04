package com.system.springboot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    @JsonIgnoreProperties(value = { "compartment", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Firetruck firetruck;

    @JsonIgnoreProperties(value = { "compartment", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "compartment", cascade = CascadeType.ALL)
    private Set<CompartmentDetail> compartmentDetail;
}
