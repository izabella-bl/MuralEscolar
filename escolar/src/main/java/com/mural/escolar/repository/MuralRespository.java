package com.mural.escolar.repository;

import java.util.List;


import com.mural.escolar.model.Mural;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MuralRespository extends PagingAndSortingRepository<Mural,Long>{
    @Override
    default Iterable<Mural> findAll() {
        return findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    List<Mural> findByTitulo(String titulo);


   
}
