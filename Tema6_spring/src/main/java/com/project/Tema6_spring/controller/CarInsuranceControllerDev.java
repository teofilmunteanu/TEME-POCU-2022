package com.project.Tema6_spring.controller;

import com.project.Tema6_spring.model.CarInsurance;
import com.project.Tema6_spring.service.CarInsuranceService;
import com.project.Tema6_spring.service.CarInsuranceServiceDev;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Profile("dev")
@RestController
@RequiredArgsConstructor
public class CarInsuranceControllerDev {
    private final CarInsuranceServiceDev carInsuranceService;

    @PostMapping(value="/api/insurances/car/create")
    public CarInsurance create(@Valid @RequestBody CarInsurance carInsurance){
        return carInsuranceService.create(carInsurance);
    }

    @GetMapping(value="/api/insurances/cars")
    public List<CarInsurance> getCarInsurances(){
        return carInsuranceService.findAll();
    }

    @GetMapping(value="/api/insurances/car/price/{id}")
    public double getCarInsurancePrice(@PathVariable int id){
        return carInsuranceService.getInsurancePrice(id);
    }
}
