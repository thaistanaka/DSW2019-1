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
    
    private int id;
    private String endereco;
    private int cnpj;
    private String nome;
    private float preco;
    private String dia; 
    private String hora;

    public Promocao(int id, String endereco, int cnpj, String nome, float preco, String dia, String hora) {
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

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
    
    public String setNome(String nome) {
        return nome;
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