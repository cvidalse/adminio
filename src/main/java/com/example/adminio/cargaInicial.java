package com.example.adminio;

import com.example.adminio.model.GastoComun;
import com.example.adminio.model.Propietario;
import com.example.adminio.model.data.GastoComunDAO;
import com.example.adminio.model.data.PropietarioDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class cargaInicial {

    @Bean
    public CommandLineRunner ingresoCodigos(GastoComunDAO gastoDao){
        return (args -> {
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-05");
            System.out.println(fecha);
        GastoComun gasto = new GastoComun(fecha,"Cambio de baño",12000);
        gasto.setId((long)1);
        gastoDao.save(gasto);
        });
        }

    @Bean
    public CommandLineRunner ingresogasto(GastoComunDAO gastoDao){
        return (args -> {
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse("2019-11-03");
            System.out.println(fecha);
            GastoComun gasto = new GastoComun(fecha,"Cambio de baño",15000);
            gasto.setId((long)2);
            gastoDao.save(gasto);
        });
    }

    @Bean
    public CommandLineRunner ingresogasto2(GastoComunDAO gastoDao){
        return (args -> {
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-08");
            System.out.println(fecha);
            GastoComun gasto = new GastoComun(fecha,"Cambio de baño",15000);
            gasto.setId((long)3);
            gastoDao.save(gasto);
        });
    }

    @Bean
    public CommandLineRunner ingresoPropietario(PropietarioDAO propietarioDAO){
        return (args -> {
            Propietario propietario = new Propietario((long)1,"Cristian Vidal",100);
            Propietario propietario1 = new Propietario((long)2,"Christian Herrera",50);
            propietarioDAO.save(propietario);
            propietarioDAO.save(propietario1);
        });
    }

}
