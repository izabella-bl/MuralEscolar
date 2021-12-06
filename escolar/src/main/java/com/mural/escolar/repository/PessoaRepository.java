package com.mural.escolar.repository;

import java.util.List;

import com.mural.escolar.model.Pessoa;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PessoaRepository extends PagingAndSortingRepository<Pessoa,Long>{

    @Override
    default Iterable<Pessoa> findAll() {
        return findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    List<Pessoa> findByNome(String nome);
    
}
