package com.example.backend.controller;


import com.example.backend.entity.Pyq;
import com.example.backend.service.PyqTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/api/share")
public class PyqTableController {

    @Autowired
    private PyqTableService Pyqservice;

    @GetMapping("/api/pyq")
    public List<Pyq> getAllPyq() {
        return Pyqservice.getAllPyqData();
    }
}
