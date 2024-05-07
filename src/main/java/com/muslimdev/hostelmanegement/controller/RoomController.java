package com.muslimdev.hostelmanegement.controller;

import com.muslimdev.hostelmanegement.dto.RoomDto;
import com.muslimdev.hostelmanegement.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/room")
    public ResponseEntity addRoom(@RequestBody RoomDto roomDto){
        roomService.roomAdd(roomDto);
        return ResponseEntity.ok(roomDto);
    }
    @DeleteMapping("/room/{id}")
    public ResponseEntity deleted(@PathVariable Long id){
        roomService.deletedRoom(id);
        return ResponseEntity.ok("Room is deleted");
    }
    @GetMapping("/room")
    public List<RoomDto> findAll(){
        List<RoomDto> roomDtoList = roomService.findAllRooms();
        return roomDtoList;
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity updatefields(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        return ResponseEntity.ok(roomService.updateRoomByfieldss(id, fields));
    }
    @GetMapping("/room/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        return ResponseEntity.ok(roomService.findRoom(id));
    }

}
