package org.example.avemusicaback.repository;


import org.example.avemusicaback.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findUserById(Integer userId);


    User findUserByTelephone(String telephone);






}
