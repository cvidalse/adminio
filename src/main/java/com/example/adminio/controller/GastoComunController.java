package com.example.adminio.controller;

import com.example.adminio.model.GastoComun;
import com.example.adminio.model.data.GastoComunDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class GastoComunController {

    @Autowired
    private GastoComunDAO gastoComunDAO;

    @RequestMapping("/gasto_comun_mes_actual")
    public List<GastoComun> gastosComunes() throws ParseException {
        Date fconsulta = new Date();
        LocalDate localDate = fconsulta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String fechainicio = localDate.getYear()+"-"+(localDate.getMonthValue())+"-01";
        System.out.println(fechainicio);
        Date finicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechainicio);
        return (List<GastoComun>) gastoComunDAO.findAllByFechaPagoBetween(finicio,fconsulta);
    }

    @RequestMapping("/gasto_comun_historico")
    public List<GastoComun> gastosComunesHistoricos() throws ParseException {
        Date fconsulta = new Date();
        LocalDate localDate = fconsulta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.minus(6, ChronoUnit.MONTHS);
        String fechainicio = localDate.getYear()+"-"+((localDate.getMonthValue()))+"-01";
        System.out.println(fechainicio);
        Date finicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechainicio);
        return (List<GastoComun>) gastoComunDAO.findAllByFechaPagoBetween(finicio,fconsulta);
    }

    




}
