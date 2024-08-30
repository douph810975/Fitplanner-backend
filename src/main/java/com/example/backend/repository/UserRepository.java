package com.example.backend.repository;

import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    // 自定义查询方法，通过用户名查找用户
    Optional<User> findByUsername(String username);
    //void save(User user);
}


