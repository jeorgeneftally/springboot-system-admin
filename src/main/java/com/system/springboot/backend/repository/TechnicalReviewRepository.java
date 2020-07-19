package com.system.springboot.backend.repository;

import com.system.springboot.backend.entity.Firetruck;
import com.system.springboot.backend.entity.TechnicalReview;
import org.springframework.data.repository.CrudRepository;

public interface TechnicalReviewRepository  extends CrudRepository<TechnicalReview, Long> {

    TechnicalReview findTopByFiretruck(Firetruck firetruck);
}
