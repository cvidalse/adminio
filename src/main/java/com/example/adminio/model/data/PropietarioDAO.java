package com.example.adminio.model.data;

import com.example.adminio.model.Propietario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Repository
public interface PropietarioDAO extends CrudRepository<Propietario,Long> {

    Propietario findByNombre(String nombre);

    ArrayList<Propietario> findAll();
}