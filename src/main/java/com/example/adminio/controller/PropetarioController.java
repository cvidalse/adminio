package com.example.adminio.controller;

import com.example.adminio.model.data.BoletaDAO;
import com.example.adminio.model.data.PropietarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PropetarioController {


    @Autowired
    private PropietarioDAO propietarioDAO;

    @Autowired
    private BoletaDAO boletaDAO;



}
