package com.example.test.repository;

import com.example.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Anup on 9/9/15.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findById(Long id);
    User findByEmail(String email);

}
