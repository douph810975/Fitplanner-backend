package com.example.backend.repository;

import com.example.backend.entity.Pyq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PyqTableRepository extends JpaRepository<Pyq, Long> {
    // 可以自定义查询方法
}