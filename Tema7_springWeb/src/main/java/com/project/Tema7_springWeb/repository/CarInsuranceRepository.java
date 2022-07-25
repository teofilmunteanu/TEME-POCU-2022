package com.project.Tema7_springWeb.repository;

import com.project.Tema7_springWeb.model.CarInsurance;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarInsuranceRepository {
    private List<CarInsurance> carInsurances = new ArrayList<>();

    public List<CarInsurance> findAll(){
        return carInsurances;
    }

    public CarInsurance save(CarInsurance carInsurance){
        carInsurances.add(carInsurance);
        return carInsurance;
    }

    public CarInsurance retrieveById(int id){
        return carInsurances.stream().filter(insurance -> insurance.getId() == id).findFirst().orElse(null);
    }
}
