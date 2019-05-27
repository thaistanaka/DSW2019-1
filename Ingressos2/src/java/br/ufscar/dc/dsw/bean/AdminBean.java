package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.pojo.Admin;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "adminBean")
@SessionScoped
public class AdminBean {
       private Admin admin = new Admin();
    //Verifica se o login inserido está correto
    public String login(){
        if("admin".equals(admin.getNome()) && "admin".equals(admin.getSenha())){
            return "Usuario/AdminUser/pageAdmin.xhtml";
        }//Leva a página do administrador
        else
            return "loginAdmin.xhtml";//Volta para a mesma página           
    }
 
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}