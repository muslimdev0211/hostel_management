package com.muslimdev.hostelmanegement.service;

import com.muslimdev.hostelmanegement.dto.BedDto;
import com.muslimdev.hostelmanegement.entity.Beds;
import com.muslimdev.hostelmanegement.repository.BedRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BedService {
    private final BedRepository bedRepository;

    public BedService(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    public BedDto addBeds(BedDto bedDto) {
        bedRepository.save(toEntity(bedDto));
        return bedDto;
    }

    public Beds toEntity(BedDto bedDto){
        Beds bed = new Beds();
        bed.setBedName(bedDto.getBedName());
        bed.setBedType(bedDto.getBedType());
        bed.setBedDescriptionl(bedDto.getBedDescriptionl());
        return bed;
    }
    public BedDto toDto(Beds beds){
        BedDto bedDto = new BedDto();
        bedDto.setBedName(beds.getBedName());
        bedDto.setBedType(beds.getBedType());
        bedDto.setBedDescriptionl(beds.getBedDescriptionl());
        return bedDto;
    }

    public List<BedDto> getAllBeds() {
        List <BedDto> bedDtos = new ArrayList<>();
        for (Beds beds: bedRepository.findAll()){
            bedDtos.add(toDto(beds));
        }
        return bedDtos;
    }

    public BedDto getBed(Long id) {
        Optional <Beds> bedsOptional = bedRepository.findById(id);
        return bedsOptional.map(this::toDto).orElse(null);
    }

    public void delete(Long id) {
        bedRepository.deleteById(id);
    }

    public BedDto updated(Long id, Map<String, Object> field) {
        Optional <Beds> bedsOptional = bedRepository.findById(id);

        if (bedsOptional.isPresent()){
            field.forEach((key, value) ->{
                Field field1 = ReflectionUtils.findField(Beds.class, key);
                field1.setAccessible(true);

               ReflectionUtils.setField(field1, bedsOptional.get(), value);

                });
        }
        bedRepository.save(bedsOptional.get());
        return toDto(bedsOptional.get());
    }
}
