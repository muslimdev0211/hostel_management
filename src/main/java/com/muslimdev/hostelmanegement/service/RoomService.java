package com.muslimdev.hostelmanegement.service;

import com.muslimdev.hostelmanegement.dto.RoomDto;
import com.muslimdev.hostelmanegement.entity.Rooms;
import com.muslimdev.hostelmanegement.repository.RoomRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Rooms roomAdd(RoomDto roomDto){
        Rooms rooms = new Rooms();
        rooms.setRoomExamId(roomDto.getRoomExamId());
        rooms.setRoomNumber(roomDto.getRoomNumber());
        rooms.setRoomDescription(roomDto.getRoomDescription());
        rooms.setRoomType(roomDto.getRoomType());
        roomRepository.save(rooms);
        return rooms;
    }

    public void deletedRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public List<RoomDto> findAllRooms() {
        List<RoomDto> roomDtos = new ArrayList<>();
        for (Rooms rooms: roomRepository.findAll()){
            roomDtos.add(toDto(rooms));
        }
        return roomDtos;
    }

    public RoomDto updateRoomByfieldss(Long id, Map <String, Object> fields){
        Optional<Rooms> roomsOptional = roomRepository.findById(id);

        if (roomsOptional.isPresent()){
            fields.forEach((key, value ) ->{
                Field field = ReflectionUtils.findField(Rooms.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, roomsOptional.get(), value);


            });
            roomRepository.save(roomsOptional.get());
            return toDto(roomsOptional.get());
        }
        return null;
    }

    public RoomDto toDto(Rooms rooms){
        RoomDto roomDto = new RoomDto();
        roomDto.setRoomExamId(rooms.getRoomExamId());
        roomDto.setRoomNumber(rooms.getRoomNumber());
        roomDto.setRoomDescription(rooms.getRoomDescription());
        roomDto.setRoomType(rooms.getRoomType());
        return roomDto;
    }

    public RoomDto findRoom(Long id) {
        Optional <Rooms> roomsOptional = roomRepository.findById(id);
        if (roomsOptional.isEmpty()){
            return null;
        }
        return toDto(roomsOptional.get());
    }
}
