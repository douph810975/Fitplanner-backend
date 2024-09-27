package com.example.backend.service;

import com.example.backend.entity.Pyq;
import com.example.backend.repository.PyqTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PyqTableService {

    @Autowired
    private PyqTableRepository repository;

    public List<Pyq> getAllPyqData() {
        return repository.findAll();
    }
}
