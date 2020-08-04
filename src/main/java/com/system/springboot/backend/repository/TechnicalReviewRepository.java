package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.Firetruck;
import com.system.springboot.backend.entity.TechnicalReview;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface TechnicalReviewRepository  extends CrudRepository<TechnicalReview, Long> {

    TechnicalReview findTopByFiretruck(Firetruck firetruck);

    TechnicalReview findByDateBetween(Date initialDate, Date endDate);
}
