package com.muslimdev.hostelmanegement.controller;

import com.muslimdev.hostelmanegement.dto.AllotteeDto;
import com.muslimdev.hostelmanegement.service.AlloteeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/allotees")
public class AlloteeController {
    private final AlloteeService alloteeService;

    public AlloteeController(AlloteeService alloteeService) {
        this.alloteeService = alloteeService;
    }

    @PostMapping("/allotee")
    public AllotteeDto post(@RequestBody AllotteeDto allotteeDto){
        return alloteeService.addAllotee(allotteeDto);
    }
    @GetMapping("/allotee/{id}")
    public AllotteeDto get(@PathVariable Long id){
        return alloteeService.getId(id);
    }
    @GetMapping("/allotees")
    public List <AllotteeDto>  getAll(){
        return alloteeService.getAllotees();
    }

    @DeleteMapping("/allotee/{id}")
        public String delete(@PathVariable Long id){

        alloteeService.deletedAllotees(id);
        return "Deleted";
    }


}
