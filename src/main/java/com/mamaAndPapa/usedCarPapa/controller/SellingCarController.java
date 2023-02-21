package com.mamaAndPapa.usedCarPapa.controller;

import com.mamaAndPapa.usedCarPapa.domain.request.InsertSellingCarRequest;
import com.mamaAndPapa.usedCarPapa.domain.response.FindAllSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.FindOneSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.InsertSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.service.SellingCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellingcar")
@RequiredArgsConstructor
public class SellingCarController {
    private final SellingCarService sellingCarService;
    @PostMapping
    public InsertSellingCarResponse insertSellingCar(@RequestBody InsertSellingCarRequest request){
        return sellingCarService.insertSellingCar(request);
    }

    @GetMapping
    public List<FindAllSellingCarResponse> findAllSellingCar(){
        return sellingCarService.findAllSellingCar();
    }
    @GetMapping("/{id}")
    public FindOneSellingCarResponse findById(@PathVariable Long id){
        return sellingCarService.findById(id);
    }

    @PutMapping("/{id}")
    public String successDeal(@PathVariable Long id){
        return sellingCarService.successDeal(id);
    }
}
