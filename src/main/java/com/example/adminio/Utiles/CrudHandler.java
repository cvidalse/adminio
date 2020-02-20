package com.example.adminio.Utiles;

import com.example.adminio.model.Propietario;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
@Service
public class CrudHandler {


    public List<Propietario> getPropietarios(Iterable<Propietario> propietarios){
        Iterator it = propietarios.iterator();
        ArrayList<Propietario> pro = new ArrayList<>();
        while(it.hasNext()){
            pro.add((Propietario) it.next());
        }
        return pro;
    }

}
