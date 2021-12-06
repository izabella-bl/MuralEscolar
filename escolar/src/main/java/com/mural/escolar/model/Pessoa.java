package com.mural.escolar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@EqualsAndHashCode 
@Entity
@Table(name = "PESSOA")
public class Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private int matricula;
    private String areaDeAtuacao;
    private boolean corpodiscente;
    private boolean corpoDocente;
    
}