package br.ufscar.dc.dsw.model;


public class Promocao {

    private int id;
    private String endereco;
    private int cnpj;
    private float preco;
    private String dia; 
    private String hora;

    public Promocao(int id, String endereco, int cnpj, float preco, String dia, String hora) {
        this.id = id;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.preco = preco;
        this.dia = dia;
        this.hora = hora;
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

