package com.muslimdev.hostelmanegement.controller;

import com.muslimdev.hostelmanegement.dto.HostelDto;
import com.muslimdev.hostelmanegement.service.HostelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hostels")
public class HostelController {
    private final HostelService hostelService;

    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    @PostMapping("/hostel")
    public HostelDto findHostel(@RequestBody HostelDto hostelDto){
       return hostelService.saveHostel(hostelDto);
    }
    @DeleteMapping("/hostel/{id}")
    public ResponseEntity deleteHostel(@PathVariable Long id){
        hostelService.deleted(id);
        return ResponseEntity.ok("hostel is deleted");
    }
    @GetMapping("/hostels")
    public List <HostelDto> getHostels(){
        List <HostelDto> hostelDtos = hostelService.getAllHostels();
        return hostelDtos;
    }
    @GetMapping("/hostel/{id}")
    public HostelDto getHostel(@PathVariable Long id){
        return hostelService.getHostelId(id);
    }
    @PatchMapping("/hostel/{id}")
    public HostelDto updateHostel(@PathVariable Long id,@RequestBody Map<String, Object> fields){
       return hostelService.updateHostels(id, fields);
    }
}
