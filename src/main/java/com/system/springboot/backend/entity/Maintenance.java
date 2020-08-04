package com.system.springboot.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String site;

    private String mechanic;

    @Temporal(TemporalType.DATE)
    private Date date;

    @JsonIgnoreProperties(value = { "maintenance", "hibernateLazyInitializer", "handler" }, allowSetters = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private Firetruck firetruck;
}
