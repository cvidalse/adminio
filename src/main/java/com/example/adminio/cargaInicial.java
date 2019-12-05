package com.example.adminio;

import com.example.adminio.model.GastoComun;
import com.example.adminio.model.data.GastoComunDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class cargaInicial {

    @Bean
    public CommandLineRunner ingresoCodigos(GastoComunDAO gastoDao){
        return (args -> {
        GastoComun gasto = new GastoComun("2019-12-05","Cambio de baño",12000);
        gasto.setId((long)1);
        gastoDao.save(gasto);
        });
        }

    @Bean
    public CommandLineRunner ingresogasto(GastoComunDAO gastoDao){
        return (args -> {
            GastoComun gasto = new GastoComun("2019-12-08","Cambio de baño",15000);
            gasto.setId((long)2);
            gastoDao.save(gasto);
        });
    }
}
