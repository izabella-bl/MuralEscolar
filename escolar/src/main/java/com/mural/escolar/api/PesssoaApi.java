package com.mural.escolar.api;

import java.util.List;

import com.mural.escolar.model.Pessoa;
import com.mural.escolar.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoa")
public class PesssoaApi {

    @Autowired
    private PessoaRepository repository;
    
    @GetMapping
    public List<Pessoa> pessoas(String nome){
        if(nome != null){
            return (List<Pessoa>)repository.findByNome(nome) ;     
        }
        return (List<Pessoa>)repository.findAll();
     
    }
    
    @PostMapping  
    public String salvar(@RequestBody Pessoa model){
        repository.save(model);
        return "salvo com sucesso";
    }

    @DeleteMapping("/{id}")    
    public String deletar(@PathVariable Long id){
        repository.deleteById(id);
        return "deletado com sucesso";
    }

    @PutMapping("/{id}")    
    public String update(@RequestBody Pessoa model, @PathVariable Long id){
        if(model.getId() == id){
            repository.save(model);
            return "alterado com sucesso";
        }
        return "id da url diferente do body";
    }
    
}
