package com.project.Tema6_spring.repository;

import com.project.Tema6_spring.model.HouseInsurance;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HouseInsuranceRepository {
    private List<HouseInsurance> houseInsurances = new ArrayList<>();

    public List<HouseInsurance> findAll(){
        return houseInsurances;
    }

    public HouseInsurance save(HouseInsurance houseInsurance){
        houseInsurances.add(houseInsurance);
        return houseInsurance;
    }

    public HouseInsurance retrieveById(int id){
        return houseInsurances.stream().filter(insurance -> insurance.getId() == id).findFirst().orElse(null);
    }
}
