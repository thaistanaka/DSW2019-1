/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Windows
 */
@Entity
public class Promocao implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private float preco;
    private String dia;
    private String hora;
    
    @ManyToOne
    private Site site;
    
    @ManyToOne
    private Teatro teatro;

    public Promocao() {
    }
    
    public Long getId(){
        return id;
    }
    
    public Teatro getTeatro() {
        return teatro;
    }

    public Site getSite() {
        return site;
    }

    public String getNome() {
        return nome;
    }
    
    public float getPreco() {
        return preco;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public void setTeatro(Teatro teatro) {
        this.teatro = teatro;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
   
}