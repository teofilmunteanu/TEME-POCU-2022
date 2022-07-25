package com.project.Tema7_springWeb.repository;

import com.project.Tema7_springWeb.model.HouseInsurance;
import com.project.Tema7_springWeb.model.User;
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

    public HouseInsurance retrieveByRooms_Year(int nrOfRooms, int buildYear){
        return houseInsurances.stream().filter(insurance -> insurance.getNumberOfRooms() == nrOfRooms
                && insurance.getBuildingYear() == buildYear).findFirst().orElse(null);
    }

    public void delete(int id){
        houseInsurances.removeIf(insurance->insurance.getId() == id);
    }

    public void update(HouseInsurance updatedInsurance){
        HouseInsurance oldInsurance = retrieveById(updatedInsurance.getId());
        int i = houseInsurances.indexOf(oldInsurance);

        houseInsurances.set(i, updatedInsurance);
    }
}
