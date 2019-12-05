package com.example.adminio.controller;

import com.example.adminio.model.GastoComun;
import com.example.adminio.model.data.GastoComunDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
@RestController
public class GastoComunController {

    @Autowired
    private GastoComunDAO gastoComunDAO;

    @RequestMapping("/gasto_comun")
    public List<GastoComun> gastosComunes(){
        return (List<GastoComun>) gastoComunDAO.findAll();
    }




}
