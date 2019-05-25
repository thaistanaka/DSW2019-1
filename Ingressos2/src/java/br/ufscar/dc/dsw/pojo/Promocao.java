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
import javax.persistence.IdClass;

/**
 *
 * @author Windows
 */
@Entity
public class Promocao implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String endereco;
    private String cnpj;
    private String nome;
    private float preco;
    @Id private String dia;
    @Id private String hora;

    public Promocao(Long id, String endereco, String cnpj, String nome, float preco, String dia, String hora) {
        this.id = id;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.nome = nome;
        this.preco = preco;
        this.dia = dia;
        this.hora = hora;
    }

    public Promocao() {
    }
    
    public Long getId(){
        return id;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public String getCnpj() {
        return cnpj;
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

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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