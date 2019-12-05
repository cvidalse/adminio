package com.example.adminio.model.data;

import com.example.adminio.model.GastoComun;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface GastoComunDAO extends CrudRepository<GastoComun,Long> {

}
