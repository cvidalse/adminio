package com.example.adminio.Utiles;

import com.example.adminio.model.GastoComun;
import com.example.adminio.model.data.GastoComunDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class DateHandler {

    @Autowired
    private GastoComunDAO gastoComunDAO;



    public List<GastoComun> getMesActual() throws ParseException {
        Date fconsulta = new Date();
        LocalDate localDate = fconsulta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.minus(1, ChronoUnit.MONTHS);
        String fechainicio = localDate.getYear() + "-" + (localDate.getMonthValue()) + "-01";
        System.out.println(fechainicio);
        String ftermino = localDate.getYear()+ "-"+(localDate.getMonthValue())+"-"+localDate.lengthOfMonth();
        System.out.println(ftermino);
        Date finicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechainicio);
        Date ftermino2 = new SimpleDateFormat("yyyy-MM-dd").parse(ftermino);
        List<GastoComun> lista = gastoComunDAO.findAllByFechaPagoBetween(finicio,ftermino2);
        return lista;
    }

    public List<GastoComun> getHistoria() throws ParseException {
        Date fconsulta = new Date();
        LocalDate localDate = fconsulta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        localDate = localDate.minus(1, ChronoUnit.MONTHS);
        String ftermino = localDate.getYear()+ "-"+(localDate.getMonthValue())+"-"+localDate.lengthOfMonth();
        localDate = localDate.minus(6, ChronoUnit.MONTHS);
        String fechainicio = localDate.getYear() + "-" + ((localDate.getMonthValue())) + "-01";
        System.out.println(fechainicio);
        Date finicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechainicio);
        Date ftermino2 = new SimpleDateFormat("yyyy-MM-dd").parse(ftermino);
        List<GastoComun> lista = gastoComunDAO.findAllByFechaPagoBetween(finicio,ftermino2);
        return lista;
    }
}
