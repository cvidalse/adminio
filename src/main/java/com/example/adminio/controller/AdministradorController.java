package com.example.adminio.controller;

import com.example.adminio.Utiles.CalculoGastosComunes;

import com.example.adminio.Utiles.CrudHandler;
import com.example.adminio.Utiles.DateHandler;
import com.example.adminio.model.Boleta;
import com.example.adminio.model.GastoComun;
import com.example.adminio.model.Propiedad;
import com.example.adminio.model.Propietario;
import com.example.adminio.model.data.BoletaDAO;
import com.example.adminio.model.data.GastoComunDAO;
import com.example.adminio.model.data.PropiedadDAO;
import com.example.adminio.model.data.PropietarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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

    @Autowired
    private  CrudHandler crudHandler;

    @Autowired
    private PropiedadDAO propiedadDAO;


    @RequestMapping("/obtener_morosos")
    public List<Propietario> getMoroso(){
        List<Propietario> propietarios = (List<Propietario>) propietarioDAO.findAll();
        System.out.println(propietarios.get(0).getBoletas());
        return dateHandler.getMorosos(propietarios);
    }

    @RequestMapping("/propietarios")
    public HashMap<String,List<Propietario>> listarPropietarios(){
        HashMap<String,List<Propietario>> propietarios = new HashMap<>();
        List<Propietario> prop = crudHandler.getPropietarios(propietarioDAO.findAll());
        propietarios.put("propietarios",prop);
        return propietarios;
    }

    @RequestMapping("/propietario")
    public Propietario propietario(Long id){
        return propietarioDAO.findById(id).get();
    }

    @RequestMapping("/eliminarPropietario")
    public void eliminarPropietario(Long id){
        propietarioDAO.deleteById(id);
    }


    @RequestMapping("/actualizarPropietario")
    public void actualizarPropietario(Propietario propietario){
        propietarioDAO.save(propietario);
    }

    @RequestMapping("/agregarPropietario")
    public void agregarPropietario(Propietario propietario){
        propietarioDAO.save(propietario);
    }

    @RequestMapping("/eliminarPropiedad")
    public void eliminarPropiedad(Long id){
        propiedadDAO.deleteById(id);
    }

    @RequestMapping("/agregarPropiedad")
    public void agregarPropiedad(@RequestParam Long id_propietario, Propiedad propiedad){
        Propietario pro = propietarioDAO.findById(id_propietario).get();
        propiedad.setPropietario(pro);
        propiedadDAO.save(propiedad);
    }

    @RequestMapping("/actualizarPropiedad")
    public void actualizarPropiedad(@RequestParam Long id_propietario, Propiedad propiedad){
        Propietario pro = propietarioDAO.findById(id_propietario).get();
        propiedad.setPropietario(pro);
        propiedadDAO.save(propiedad);
    }

    @RequestMapping("/agregarGastoComun")
    public void agregarGasto(GastoComun gastoComun){
        gastoComunDAO.save(gastoComun);
    }

    @RequestMapping("/borrarGastoComun")
    public void borrarGasto(Long id){
        gastoComunDAO.deleteById(id);
    }

    @RequestMapping("/getGastoComun")
    public GastoComun getGastoComun(Long id){
        return gastoComunDAO.findById(id).get();
    }

    @RequestMapping("/editarGastoComun")
    public void editarGasto(GastoComun gastoComun){
        gastoComunDAO.save(gastoComun);
    }

    @RequestMapping("/getPropietarionombre")
    public Propietario getPropietario(String nombre){
        Propietario propietario = propietarioDAO.findByNombre(nombre);
        return propietario;
    }
    @RequestMapping("/getPropietariosId")
    public Propietario getPropietario(Long id){
        Propietario propietario = propietarioDAO.findById(id).get();
        return propietario;
    }
    @RequestMapping("/registarPago")
    public void registrarPago(Long id){
        Boleta boleta = boletaDao.findById(id).get();
        boleta.setPagada(true);
    }
    






}
