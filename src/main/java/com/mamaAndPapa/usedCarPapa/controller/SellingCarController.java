package com.mamaAndPapa.usedCarPapa.controller;

import com.mamaAndPapa.usedCarPapa.domain.request.InsertSellingCarRequest;
import com.mamaAndPapa.usedCarPapa.domain.response.InsertSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.service.SellingCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellingcar")
@RequiredArgsConstructor
public class SellingCarController {
    private final SellingCarService sellingCarService;
    @PostMapping
    public InsertSellingCarResponse insertSellingCar(@RequestBody InsertSellingCarRequest request){
        return sellingCarService.insertSellingCar(request);
    }

    @GetMapping("/{id}")
    public InsertSellingCarResponse findById(@PathVariable Long id){
        return sellingCarService.findById(id);
    }
}
