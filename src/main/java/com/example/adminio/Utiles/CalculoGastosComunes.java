package com.example.adminio.Utiles;

import com.example.adminio.model.Boleta;
import com.example.adminio.model.GastoComun;
import com.example.adminio.model.Propietario;
import com.example.adminio.model.data.GastoComunDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class CalculoGastosComunes {
    private static String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre"
    ,"Octubre","Noviembre","Diciembre"};

    public String getMes(int mes){
        return meses[mes-1];
    }

    public int calcularGastosMes(List<GastoComun> lista) throws ParseException {
        int valor = 0;
        for(int i =0;i<lista.size();i++){
            valor += lista.get(i).getValor();
        }
        return valor;
    }

    public int calcularTotalM2(List<Propietario> propietarios){
        int m2totales=0;
        for(Propietario propietario: propietarios){
            m2totales+=propietario.getM2();
        }
        return m2totales;
    }





}
