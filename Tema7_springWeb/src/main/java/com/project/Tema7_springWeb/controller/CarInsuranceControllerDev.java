package com.project.Tema7_springWeb.controller;

import com.project.Tema7_springWeb.model.CarInsurance;
import com.project.Tema7_springWeb.service.CarInsuranceServiceDev;
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
        CarInsurance createdCarInsurance =  carInsuranceService.create(carInsurance);
        double price = carInsuranceService.getInsurancePrice(carInsurance.getId());
        carInsurance.setInsurancePrice(price);

        return createdCarInsurance;
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
