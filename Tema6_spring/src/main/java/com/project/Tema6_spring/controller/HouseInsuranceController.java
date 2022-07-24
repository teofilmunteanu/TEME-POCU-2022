package com.project.Tema6_spring.controller;

import com.project.Tema6_spring.model.HouseInsurance;
import com.project.Tema6_spring.service.CarInsuranceService;
import com.project.Tema6_spring.service.HouseInsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HouseInsuranceController {
    private final HouseInsuranceService houseInsuranceService;

    @PostMapping(value="/api/insurances/house/create")
    public HouseInsurance create(@Valid @RequestBody HouseInsurance houseInsurance){
        return houseInsuranceService.create(houseInsurance);
    }

    @GetMapping(value="/api/insurances/houses")
    public List<HouseInsurance> getHouseInsurances(){
        return houseInsuranceService.findAll();
    }

    @GetMapping(value="/api/insurances/house/price/{id}")
    public double getHouseInsurancePrice(@PathVariable int id){
        return houseInsuranceService.getInsurancePrice(id);
    }
}
