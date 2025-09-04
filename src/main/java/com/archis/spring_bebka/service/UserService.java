package com.archis.spring_bebka.service;



import com.archis.spring_bebka.model.User;
import java.util.Optional;
import java.util.List;


public interface UserService {

    User save(User user);

    Optional<User> findById(Long id);

    List<User> findAll();

    User update(User user);

    void deleteById(Long id);

}
