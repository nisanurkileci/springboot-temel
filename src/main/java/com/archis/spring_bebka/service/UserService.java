package com.archis.spring_bebka.service;

import com.archis.spring_bebka.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {


    UserDto save(UserDto userDto);


    UserDto findById(Long id);


    List<UserDto> findAll();


    UserDto update(Long id, UserDto userDto);


    void deleteById(Long id);
}