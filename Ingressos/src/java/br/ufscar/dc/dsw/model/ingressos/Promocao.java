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
public class Promocao {
    
    private String endereco;
    private int cnpj;
    private String nome;
    private float preco;
    private String dia; 
    private String hora;

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