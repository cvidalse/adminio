package com.example.adminio.controller;

import com.example.adminio.Utiles.CalculoGastosComunes;
import com.example.adminio.Utiles.DataAuxiliar.BoletaAuxiliar;
import com.example.adminio.Utiles.DataAuxiliar.PropietarioAuxiliar;
import com.example.adminio.Utiles.DateHandler;
import com.example.adminio.model.Propietario;
import com.example.adminio.model.data.BoletaDAO;
import com.example.adminio.model.data.GastoComunDAO;
import com.example.adminio.model.data.PropietarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdministradorController {

    @Autowired
    private DateHandler dateHandler;

    @Autowired
    private GastoComunDAO gastoComunDAO;

    @Autowired
    private CalculoGastosComunes calculoGastosComunes;

    @Autowired
    private PropietarioDAO propietarioDAO;

    @Autowired
    private BoletaDAO boletaDao;

    @RequestMapping("/obtener_morosos")
    public List<PropietarioAuxiliar> getMoroso(){
        List<Propietario> propietarios = (List<Propietario>) propietarioDAO.findAll();
        System.out.println(propietarios.get(0).getBoletas());
        return dateHandler.getMorosos(propietarios);
    }

}
