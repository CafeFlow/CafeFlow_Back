package com.cafeflow.cafe.domain.cafe.repository;

import com.cafeflow.cafe.domain.cafe.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
}
