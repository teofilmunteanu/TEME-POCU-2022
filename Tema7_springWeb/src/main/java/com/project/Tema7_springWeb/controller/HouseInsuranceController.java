package com.project.Tema7_springWeb.controller;

import com.project.Tema7_springWeb.model.HouseInsurance;
import com.project.Tema7_springWeb.service.HouseInsuranceService;
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
        HouseInsurance createdHouseInsurance =  houseInsuranceService.create(houseInsurance);
        double price = houseInsuranceService.getInsurancePrice(houseInsurance.getId());
        houseInsurance.setInsurancePrice(price);

        return createdHouseInsurance;
    }

    @GetMapping(value="/api/insurances/houses")
    public List<HouseInsurance> getHouseInsurances(){
        return houseInsuranceService.findAll();
    }

    @GetMapping(value="/api/insurances/house/price/{id}")
    public double getHouseInsurancePrice(@PathVariable int id){
        return houseInsuranceService.getInsurancePrice(id);
    }

    @GetMapping(value="/api/insurances/house/{id}")
    public HouseInsurance  getHouseInsurance(@PathVariable int id){
        return houseInsuranceService.find(id);
    }

    @GetMapping(value="/api/insurances/house")
    public HouseInsurance  getHouseInsurance(@RequestParam(defaultValue = "1") int nrRooms, @RequestParam() int buildYear){
        return houseInsuranceService.find(nrRooms,buildYear);
    }

    @DeleteMapping(value="/api/insurances/houses/delete/{id}")
    public void deleteHouseInsurance(@PathVariable int id){
        houseInsuranceService.delete(id);
    }

    @PostMapping(value="api/insurances/houses/update/{id}")
    public HouseInsurance updateHouseInsurance(@PathVariable int id, @Valid @RequestBody HouseInsurance houseInsurance){
        return houseInsuranceService.update(id, houseInsurance.getNumberOfRooms());
    }
}
