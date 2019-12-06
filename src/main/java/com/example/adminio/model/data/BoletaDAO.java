package com.example.adminio.model.data;

import com.example.adminio.model.Boleta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BoletaDAO extends CrudRepository<Boleta,Long> {
}
