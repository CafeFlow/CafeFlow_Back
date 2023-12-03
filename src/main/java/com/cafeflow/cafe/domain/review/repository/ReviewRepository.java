package com.cafeflow.cafe.domain.review.repository;

import com.cafeflow.cafe.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByCafeIdOrderByIdDesc(Long cafeId);
    List<Review> findByCafeId(Long cafeId);
}
