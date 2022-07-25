package com.project.Tema7_springWeb.service;

import com.project.Tema7_springWeb.model.HouseInsurance;
import com.project.Tema7_springWeb.model.User;
import com.project.Tema7_springWeb.repository.HouseInsuranceRepository;
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

    public HouseInsurance find(int id){
        return houseInsuranceRepository.retrieveById(id);
    }

    public HouseInsurance find(int nrOfRooms, int buildYear){
        return houseInsuranceRepository.retrieveByRooms_Year(nrOfRooms, buildYear);
    }

    public void delete(int id){
        houseInsuranceRepository.delete(id);
    }

    public HouseInsurance update(int id, int nrOfRooms){
        HouseInsurance houseInsurance = houseInsuranceRepository.retrieveById(id);

        houseInsurance.setNumberOfRooms(nrOfRooms);
        houseInsuranceRepository.update(houseInsurance);

        return houseInsurance;
    }
}
