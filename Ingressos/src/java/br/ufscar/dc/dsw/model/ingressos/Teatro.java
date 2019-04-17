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
public class Teatro {

    private String email;
    private int senha;
    private int cnpj;
    private String nome;
    private String cidade;    

    public Teatro(String email, int senha, int cnpj, String nome, String cidade) {
        this.email = email;
        this.senha = senha;
        this.cnpj = cnpj;
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public int getSenha() {
        return senha;
    }

    public int getCnpj() {
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

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
