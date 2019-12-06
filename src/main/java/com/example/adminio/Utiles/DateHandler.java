package com.example.adminio.Utiles;

import com.example.adminio.Utiles.DataAuxiliar.BoletaAuxiliar;
import com.example.adminio.Utiles.DataAuxiliar.PropietarioAuxiliar;
import com.example.adminio.model.Boleta;
import com.example.adminio.model.GastoComun;
import com.example.adminio.model.Propietario;
import com.example.adminio.model.data.GastoComunDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
        String ftermino = localDate.getYear()+ "-"+(localDate.getMonthValue())+"-"+localDate.lengthOfMonth();
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
        Date finicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechainicio);
        Date ftermino2 = new SimpleDateFormat("yyyy-MM-dd").parse(ftermino);
        List<GastoComun> lista = gastoComunDAO.findAllByFechaPagoBetween(finicio,ftermino2);
        return lista;
    }

    public BoletaAuxiliar ultimaBoleta(Propietario propietario){
        List<Boleta> boletas = propietario.getBoletas();
        Boleta boleta = boletas.get(boletas.size()-1);
        return  new BoletaAuxiliar(boleta.getId(),boleta.getMes(),boleta.getValor(),boleta.getFechaVencimiento(),boleta.isPagada(),boleta.getFechaEmision());
    }

    public List<BoletaAuxiliar> historiaBoleta(Propietario propietario) {
        List<Boleta> boletas = propietario.getBoletas();
        List<Boleta> historia = new ArrayList<>();
        if(boletas.size()>6) {
            historia = boletas.subList(boletas.size() - 6, boletas.size() - 1);
        }else{
            historia = boletas;
        }
        List<BoletaAuxiliar> boletaAuxiliars = new ArrayList<>();
        for(Boleta boleta:historia){
            boletaAuxiliars.add(new BoletaAuxiliar(boleta.getId(),boleta.getMes(),boleta.getValor(),boleta.getFechaVencimiento(),boleta.isPagada(),boleta.getFechaEmision()));
        }
        return boletaAuxiliars;
    }

    public List<PropietarioAuxiliar> getMorosos(List<Propietario> lista){
        List<PropietarioAuxiliar> morosos = new ArrayList<>();
        for(Propietario propietario:lista){
            if(esMoroso(propietario)){
                morosos.add(new PropietarioAuxiliar(propietario.getId(),propietario.getNombre(),propietario.getDireccion(),propietario.getCorreo(),propietario.getNtelefono()));
            }
        }
        return morosos;
    }

    private boolean esMoroso(Propietario propietario) {
        List<Boleta> boletas = propietario.getBoletas();
        Date hoy = new Date();
        for(int i=boletas.size()-1;i>=0;i--){
            Boleta boleta = boletas.get(i);
            if(!boleta.isPagada()&&hoy.before(boleta.getFechaVencimiento())){
                return true;
            }
        }
        return false;
    }



}
