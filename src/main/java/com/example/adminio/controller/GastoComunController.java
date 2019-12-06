package com.example.adminio.controller;

import com.example.adminio.Utiles.CalculoGastosComunes;
import com.example.adminio.Utiles.DataAuxiliar.BoletaAuxiliar;
import com.example.adminio.Utiles.DateHandler;
import com.example.adminio.model.Boleta;
import com.example.adminio.model.GastoComun;
import com.example.adminio.model.Propietario;
import com.example.adminio.model.data.BoletaDAO;
import com.example.adminio.model.data.GastoComunDAO;
import com.example.adminio.model.data.PropietarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
import java.util.*;

@RestController
public class GastoComunController {

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


    @RequestMapping("/gasto_comun_mes_actual")
    public List<GastoComun> gastosComunes() throws ParseException {
        return dateHandler.getMesActual();
    }

   /* @RequestMapping("/gasto_comun_valor_mes_actual")
    public HashMap<String,Integer> valor_mes() throws ParseException {
        //calculoGastosComunes = new CalculoGastosComunes();
        List<GastoComun> lista= dateHandler.getMesActual();
        return calculoGastosComunes.calcularGastosMes(lista);
    }
    */

    @RequestMapping("/gasto_comun_historico")
    public List<GastoComun> gastosComunesHistoricos() throws ParseException {
        return dateHandler.getHistoria();
    }

    @Scheduled(cron="1 * * * * *")
    public void generarCobro() throws ParseException {
        Date hoy = new Date();
        LocalDate date = hoy.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String mes = calculoGastosComunes.getMes(date.getMonthValue());
        date = date.plusMonths(1);
        String fecha_vencimiento = date.getYear()+"-"+date.getMonthValue()+"-"+date.getDayOfMonth();
        Date fvencimiento = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_vencimiento);
        List<Propietario> propietarios = (List<Propietario>) propietarioDAO.findAll();
        double gasto = calculoGastosComunes.calcularGastosMes(dateHandler.getMesActual());
        double m2Totales = calculoGastosComunes.calcularTotalM2(propietarios);
        double cobro = 0;
        for(Propietario propietario : propietarios){
            double proporcion = (double) propietario.getM2()/m2Totales;
            cobro = gasto*proporcion;
            boletaDao.save(new Boleta(mes,cobro,propietario,false,fvencimiento,hoy));
        }
    }

    @RequestMapping("/ultimaBoleta")
    public BoletaAuxiliar ultimaBoleta(@RequestParam(value = "id")Long id){
        Propietario propietario = propietarioDAO.findById(id).get();
        return dateHandler.ultimaBoleta(propietario);
    }
}

