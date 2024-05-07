package com.muslimdev.hostelmanegement.service;

import com.muslimdev.hostelmanegement.dto.AllotteeDto;
import com.muslimdev.hostelmanegement.entity.Allotees;
import com.muslimdev.hostelmanegement.repository.AllotteeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlloteeService {
    private final AllotteeRepository allotteeRepository;

    public AlloteeService(AllotteeRepository allotteeRepository) {
        this.allotteeRepository = allotteeRepository;
    }

    public AllotteeDto addAllotee(AllotteeDto allotteeDto) {
        allotteeRepository.save(toEntity(allotteeDto));
        return allotteeDto;

    }
    public Allotees toEntity(AllotteeDto allotteeDto){
        Allotees allotees = new Allotees();
        allotees.setAlloteeAdress(allotteeDto.getAlloteeAdress());
        allotees.setAlloteeEmail(allotteeDto.getAlloteeEmail());
        allotees.setAlloteeName(allotteeDto.getAlloteeName());
        allotees.setAlloteeMobile(allotteeDto.getAlloteeMobile());
        allotees.setAlloteePassword(allotteeDto.getAlloteePassword());
        allotees.setAlloteeUserName(allotteeDto.getAlloteeUserName());
        return allotees;
    }
    public AllotteeDto toDto(Allotees allotees){
        AllotteeDto allotteeDto = new AllotteeDto();
        allotteeDto.setAlloteeAdress(allotees.getAlloteeAdress());
        allotteeDto.setAlloteeEmail(allotees.getAlloteeEmail());
        allotteeDto.setAlloteeName(allotees.getAlloteeName());
        allotteeDto.setAlloteeMobile(allotees.getAlloteeMobile());
        allotteeDto.setAlloteePassword(allotees.getAlloteePassword());
        allotteeDto.setAlloteeUserName(allotees.getAlloteeUserName());
        return allotteeDto;

    }

    public AllotteeDto getId(Long id) {
        return toDto(allotteeRepository.findById(id).get());
    }

    public List<AllotteeDto> getAllotees() {
        List<AllotteeDto> allotteeDtos = new ArrayList<>();
        for (Allotees allotees: allotteeRepository.findAll()){
            allotteeDtos.add(toDto(allotees));
        }
        return allotteeDtos;
    }

    public void deletedAllotees(Long id) {
        allotteeRepository.deleteById(id);
    }
}
