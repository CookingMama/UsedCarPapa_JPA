package com.mamaAndPapa.usedCarPapa.controller;

import com.mamaAndPapa.usedCarPapa.domain.request.InsertSellingCarRequest;
import com.mamaAndPapa.usedCarPapa.domain.response.FindAllSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.FindOneSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.domain.response.InsertSellingCarResponse;
import com.mamaAndPapa.usedCarPapa.service.SellingCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
    public List<FindAllSellingCarResponse> findAllSellingCar(
            Pageable pageable,
            @RequestParam(value = "size", required = false,defaultValue = "5") Integer size,
            @RequestParam("page") Integer page
    ){
        return sellingCarService.findAllSellingCar(pageable);
    }
    @GetMapping("/{id}")
    public FindOneSellingCarResponse findById(@PathVariable Long id){
        return sellingCarService.findById(id);
    }


}
