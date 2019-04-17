/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.model.ingressos;

/**
 *
 * @author Windows
 */
public class Site { //do trabalho

    private String email;
    private int senha;
    private String endereco;
    private String nome;
    private int telefone;

    public Site(String email, String endereco, String nome, int senha, int telefone) {
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
        this.telefone = telefone;
        this.nome = nome;
}

    public String getEmail() {
        return email;
    }

    public int getSenha() {
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

    public void setSenha(int senha) {
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
