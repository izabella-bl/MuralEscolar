package com.mural.escolar.api;
import java.util.List;

import com.mural.escolar.model.Mural;
import com.mural.escolar.repository.MuralRespository;

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
@RequestMapping("/api/mural")
public class MuralApi {
    @Autowired
    private MuralRespository repository;
    
    @GetMapping
    public List<Mural> mural(String titulo){
        if(titulo != null){
            return (List<Mural>)repository.findByTitulo(titulo) ;
        }
        return (List<Mural>)repository.findAll();
     
    }

    
    @PostMapping  
    public String salvar(@RequestBody Mural model){
        repository.save(model);
        return "salvo com sucesso";
    }

    @DeleteMapping("/{id}")    
    public String deletar(@PathVariable Long id){
        repository.deleteById(id);
        return "deletado com sucesso";
    }

    @PutMapping("/{id}")    
    public String update(@RequestBody Mural model, @PathVariable Long id){
        if(model.getId() == id){
            repository.save(model);
            return "alterado com sucesso";
        }
        return "id da url diferente do body";
    }
}
