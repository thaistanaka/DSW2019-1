/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Windows
 */
@Entity
public class Site implements Serializable{ //do trabalho

    private String email;
    private String senha;
    @Id
    private String endereco;
    private String nome;
    private int telefone;

    public Site(String email, String nome, String endereco, String senha,  int telefone) {
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nome = nome;
}
    
    public Site(){
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

   
}
