package com.example.adminio.model.data;

import com.example.adminio.model.GastoComun;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public interface GastoComunDAO extends CrudRepository<GastoComun,Long> {
    List<GastoComun> findAllByFechaPagoBetween(
            Date publicationTimeStart,
            Date publicationTimeEnd);
}
