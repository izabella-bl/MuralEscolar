package com.mural.escolar.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter 
@Setter
@EqualsAndHashCode 
@Entity
@Table(name = "MURAL")
public class Mural implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String assunto;
    private String titulo;
    private  String descricao;
    private  LocalDate dataInicial;
    private  LocalDate dataFinal;

    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoa pessoa;
  

}