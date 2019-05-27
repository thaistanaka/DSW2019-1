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
public class Teatro implements Serializable{
    //Classe que representa um teatro
    private String email;
    private String senha;
    @Id
    private Long cnpj;
    private String nome;
    private String cidade;    

    public Teatro(String email, String senha, Long cnpj, String nome, String cidade) {
        this.email = email;
        this.senha = senha;
        this.cnpj = cnpj;
        this.nome = nome;
        this.cidade = cidade;
    }
    
    public Teatro(String cidade, Long cnpj, String email, String nome) {
        this.email = email;
        this.cnpj = cnpj;
        this.nome = nome;
        this.cidade = cidade;
    }

    public Teatro() {
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
