package com.mamaAndPapa.usedCarPapa.service;

import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import com.mamaAndPapa.usedCarPapa.domain.request.InsertSellingCarRequest;
import com.mamaAndPapa.usedCarPapa.domain.response.FindAllSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.FindOneSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.InsertSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.repository.SellingCarRepository;
import com.mamaAndPapa.usedCarPapa.security.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SellingCarService {
    private final SellingCarRepository sellingCarRepository;
    private final UserSecurityService userSecurityService;


    public InsertSellingCarResponse insertSellingCar(InsertSellingCarRequest request){
        SellingCar sellingCar = new SellingCar(request);
        sellingCarRepository.save(sellingCar);
        InsertSellingCarResponse insertSellingCarResponse = new InsertSellingCarResponse(sellingCar);
        return insertSellingCarResponse;
    }
    public List<FindAllSellingCarResponse> findAllSellingCar(Pageable pageable){
        List<FindAllSellingCarResponse> findAllSellingCarResponses = new ArrayList<>();
        Page<SellingCar> all = sellingCarRepository.findAllByOrderByCreateAtDesc(pageable);
        for (SellingCar one : all) {
            findAllSellingCarResponses.add(new FindAllSellingCarResponse
                    (one.getId(),one.getDetailModel().getName(), one.getPrice(),
                            userSecurityService.parseToken(userSecurityService.getToken()).getUserType()));
        }
        return findAllSellingCarResponses;
    }
    public FindOneSellingCarResponse findById(Long id){
        Optional<SellingCar> byId = sellingCarRepository.findById(id);
        return new FindOneSellingCarResponse(byId.get());
    }

}
