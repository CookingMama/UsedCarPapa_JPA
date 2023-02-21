package com.mamaAndPapa.usedCarPapa.domain.response;

import com.mamaAndPapa.usedCarPapa.domain.entity.SellingCar;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellingCarListResponse {
    private Long totalSize;
    private Integer totalPage;
    private List<SellingCar.SellingCarMapping> sellingCars = new ArrayList<>();

    public SellingCarListResponse( List<SellingCar.SellingCarMapping> sellingCarList, Integer page, Integer size) {
        this.sellingCars = sellingCarList;
        this.totalSize = (long) sellingCarList.size();
        this.totalPage = (int) Math.ceil((double) sellingCarList.size()/(double) size);
        if (size * page < sellingCarList.size()) {
            this.sellingCars = sellingCarList.subList(size*page,
                    Math.min(size + (size*page), sellingCars.size()));
        }
    }
}
