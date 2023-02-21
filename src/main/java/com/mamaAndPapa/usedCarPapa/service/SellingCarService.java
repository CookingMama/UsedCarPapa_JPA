package com.mamaAndPapa.usedCarPapa.service;

import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import com.mamaAndPapa.usedCarPapa.domain.request.InsertSellingCarRequest;
import com.mamaAndPapa.usedCarPapa.domain.response.InsertSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.SellingCarListResponse;
import com.mamaAndPapa.usedCarPapa.repository.SellingCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellingCarService {
    private final SellingCarRepository sellingCarRepository;

    public InsertSellingCarResponse insertSellingCar(InsertSellingCarRequest request){
        SellingCar sellingCar = new SellingCar(request);
        sellingCarRepository.save(sellingCar);
        InsertSellingCarResponse insertSellingCarResponse = new InsertSellingCarResponse(sellingCar);
        return insertSellingCarResponse;
    }

    public InsertSellingCarResponse findById(Long id){
        Optional<SellingCar> byId = sellingCarRepository.findById(id);
        return new InsertSellingCarResponse(byId.get());
    }

    public SellingCarListResponse viewAllCars(Integer page, Integer size) {
        List<SellingCar.SellingCarMapping> sellingCars = sellingCarRepository.findAllBy();
        return new SellingCarListResponse(sellingCars,page,size);
    }
}
