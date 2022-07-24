package com.project.Tema6_spring.service;

import com.project.Tema6_spring.model.CarInsurance;
import com.project.Tema6_spring.model.HouseInsurance;
import com.project.Tema6_spring.repository.HouseInsuranceRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseInsuranceService {
    private final HouseInsuranceRepository houseInsuranceRepository;

    /*read from application.properties*/
    @Value("${house.baseInsurance}")
    private int baseInsurance;
    @Value("${house.priceDivisor}")
    private int priceDivisor;
    @Value("${house.roomsDivisor}")
    private int roomsDivisor;
    @Value("${house.yearDivisor}")
    private int yearDivisor;


    public HouseInsurance create(HouseInsurance houseInsurance){
        return houseInsuranceRepository.save(houseInsurance);
    }

    public List<HouseInsurance> findAll(){
        return houseInsuranceRepository.findAll();
    }

    public double getInsurancePrice(int id){
        HouseInsurance houseInsurance = houseInsuranceRepository.retrieveById(id);
        return baseInsurance +
                houseInsurance.getPrice() / priceDivisor *
                houseInsurance.getNumberOfRooms() / roomsDivisor +
                houseInsurance.getBuildingYear() / yearDivisor;
    }
}
