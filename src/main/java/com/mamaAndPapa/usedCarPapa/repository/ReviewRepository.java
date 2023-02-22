package com.mamaAndPapa.usedCarPapa.repository;

import com.mamaAndPapa.usedCarPapa.domain.entity.Review;
import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
