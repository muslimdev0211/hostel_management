package com.muslimdev.hostelmanegement.controller;

import com.muslimdev.hostelmanegement.dto.BedDto;
import com.muslimdev.hostelmanegement.service.BedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/beds")
public class BedController {
    private final BedService bedService;

    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    @PostMapping("/bed")
    public BedDto addBed(@RequestBody BedDto bedDto){
        return bedService.addBeds(bedDto);
    }
    @GetMapping("/beds")
    public List <BedDto> getBeds(){
        return bedService.getAllBeds();
    }
    @GetMapping("/bed/{id}")
        public BedDto findBed(@PathVariable Long id){
        return bedService.getBed(id);
    }
    @DeleteMapping("/bed/{id}")
    public ResponseEntity deleteBed(@PathVariable Long id){
        bedService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
    @PatchMapping("/bed/{id}")
    public BedDto updateBed(@PathVariable Long id, @RequestBody Map<String, Object> field){
        return bedService.updated(id,field);
    }
}
