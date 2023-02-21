package com.mamaAndPapa.usedCarPapa.service;

import com.mamaAndPapa.usedCarPapa.domain.dto.ECheck;
import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import com.mamaAndPapa.usedCarPapa.domain.request.InsertSellingCarRequest;
import com.mamaAndPapa.usedCarPapa.domain.response.FindAllSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.FindOneSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.InsertSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.repository.SellingCarRepository;
import com.mamaAndPapa.usedCarPapa.security.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.persistence.criteria.CriteriaBuilder;
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
        Page<SellingCar> all = sellingCarRepository.findAllByOrderByCreateAt(pageable);
        for (SellingCar one : all) {
            findAllSellingCarResponses.add(new FindAllSellingCarResponse
                    (one.getId(),one.getDetailModel().getName(), one.getPrice(),
                            userSecurityService.parseToken(userSecurityService.getToken()).getUserType()));
        }
        return findAllSellingCarResponses;
    }
    public FindOneSellingCarResponse findById(Long id){
        Optional<SellingCar> byId = sellingCarRepository.findById(id);
        FindOneSellingCarResponse findOneSellingCarResponse = new FindOneSellingCarResponse(byId.get());
        findOneSellingCarResponse.setSeller(userSecurityService.parseToken(userSecurityService.getToken()).getName());
        return findOneSellingCarResponse;
    }
    public String successDeal(Long id){
        Optional<SellingCar> sellingCar = sellingCarRepository.findById(id);
        if (sellingCar.isEmpty()){
            return "선택하신 상품은 없는 존재하지 않는 상품입니다.";
        } else {
            sellingCar.get().setBuyerId(Long.valueOf(userSecurityService.parseToken(userSecurityService.getToken()).getId()));
            sellingCar.get().setBuyCheck(ECheck.CHECK);
        }
        sellingCarRepository.save(sellingCar.get());
        return "거래완료";
    }

}
