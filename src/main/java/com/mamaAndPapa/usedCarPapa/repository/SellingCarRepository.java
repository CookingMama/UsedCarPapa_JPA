package com.mamaAndPapa.usedCarPapa.repository;

import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SellingCarRepository extends JpaRepository<SellingCar, Long> {
}
