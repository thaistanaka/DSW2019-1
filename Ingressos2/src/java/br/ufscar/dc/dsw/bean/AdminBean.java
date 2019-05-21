package br.ufscar.dc.dsw.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AdminBean {
    private String nome = "";
    private String senha = "";
    
    public String login(){
        if(nome.equals("admin") && senha.equals("admin")){
            return "usuario/adminUser/pageAdmin.xhtml";
        }
        else
            return "loginAdmin.xhtml";              
    }
    
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome= nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}