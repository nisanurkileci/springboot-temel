package com.archis.spring_bebka.service.impl;


import com.archis.spring_bebka.service.UserService;
import com.archis.spring_bebka.model.User;
import com.archis.spring_bebka.dto.UserDto;
import com.archis.spring_bebka.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation =  Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public User update(User user) {
        return null;
    }

    @Override
    @Transactional()
    public void deleteById(Long id) {

    }
}
