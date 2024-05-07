package com.muslimdev.hostelmanegement.service;

import com.muslimdev.hostelmanegement.dto.HostelDto;
import com.muslimdev.hostelmanegement.entity.Hostel;
import com.muslimdev.hostelmanegement.repository.HostelRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class HostelService {

    private final HostelRepository hostelRepository;

    public HostelService(HostelRepository hostelRepository) {
        this.hostelRepository = hostelRepository;
    }


    public HostelDto saveHostel(HostelDto hostelDto) {
        hostelRepository.save(toEntity(hostelDto));
        return hostelDto;
    }

    public Hostel toEntity(HostelDto hostelDto){
        Hostel hostel = new Hostel();
        hostel.setHostelName(hostelDto.getHostelName());
        hostel.setHostelAddres(hostelDto.getHostelAddres());
        hostel.setHostelDescription(hostelDto.getHostelDescription());
        hostel.setHostelType(hostelDto.getHostelType());
        hostel.setHostelRent(hostelDto.getHostelRent());

        return hostel;
    }

    public void deleted(Long id) {
        hostelRepository.deleteById(id);
    }

    public List<HostelDto> getAllHostels() {
        List <HostelDto> hostelDtos = new ArrayList<>();
       for (Hostel hostel: hostelRepository.findAll()){
           hostelDtos.add(toDto(hostel));
       }
       return hostelDtos;
    }
    public HostelDto toDto(Hostel hostel){
        HostelDto hostelDto = new HostelDto();
        hostelDto.setHostelName(hostel.getHostelName());
        hostelDto.setHostelAddres(hostel.getHostelAddres());
        hostelDto.setHostelDescription(hostel.getHostelDescription());
        hostelDto.setHostelType(hostel.getHostelType());
        hostelDto.setHostelRent(hostel.getHostelRent());
        return hostelDto;
    }

    public HostelDto getHostelId(Long id) {
        Optional<Hostel> hostelOptional = hostelRepository.findById(id);
        if (hostelOptional.isEmpty()){
            return null;
        }
        return toDto(hostelOptional.get());
    }

    public HostelDto updateHostels(Long id, Map<String, Object> fields) {
        Optional<Hostel> hostelOptional = hostelRepository.findById(id);

        if (hostelOptional.isPresent()){
            fields.forEach((key, value)->{
                        Field field = ReflectionUtils.findField(Hostel.class, key);
                        field.setAccessible(true);
                        ReflectionUtils.setField(field, hostelOptional.get(),value);

                    }
                    );
            hostelRepository.save(hostelOptional.get());
            return toDto(hostelOptional.get());
        }
        return null;

    }
}
