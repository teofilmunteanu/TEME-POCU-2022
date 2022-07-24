package com.project.Tema6_spring.service;

import com.project.Tema6_spring.model.CarInsurance;
import com.project.Tema6_spring.model.User;
import com.project.Tema6_spring.repository.CarInsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("!dev") /* Run -> Edit configuration -> leave "Environment variables" empty*/
@RequiredArgsConstructor
public class CarInsuranceService {
    private final CarInsuranceRepository carInsuranceRepository;

    /*read from application.properties*/
    @Value("${car.baseInsurance}")
    private int baseInsurance;

    public CarInsurance create(CarInsurance carInsurance){
        return carInsuranceRepository.save(carInsurance);
    }

    public List<CarInsurance> findAll(){
        return carInsuranceRepository.findAll();
    }

    public double getInsurancePrice(int id){
        CarInsurance carInsurance = carInsuranceRepository.retrieveById(id);
        return baseInsurance;
    }
}
