/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author Windows
 */
@Entity @IdClass(PromocaoKey.class)
public class Promocao implements Serializable {
    @Id private String endereco;
    private int cnpj;
    private String nome;
    private float preco;
    @Id private String dia;
    @Id private String hora;

    public Promocao(String endereco, int cnpj, String nome, float preco, String dia, String hora) {
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.nome = nome;
        this.preco = preco;
        this.dia = dia;
        this.hora = hora;
    }

    public Promocao() {
    }

    public String[] get() {
        String []vetor  = new String[3];
        vetor [0] = endereco;
        vetor [1] = dia;
        vetor [2] = hora;
        return vetor;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public int getCnpj() {
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

    public void setCnpj(int cnpj) {
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