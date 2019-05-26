/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.pojo.Teatro;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Windows
 */
@ManagedBean(name = "teatroBean")
@SessionScoped
public class TeatroBean implements Serializable {

    private Teatro teatro;
    
    public TeatroBean(){
        teatro = new Teatro();
    }

    public String lista() {
        return "teatro/index.xhtml";
    }

    public String cadastra() {
        teatro = new Teatro();
        return "/Ingressos2/faces/Teatro/formulario.xhtml";
    }

    public String edita(int cnpj) {
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(cnpj);
        return "teatro/formulario.xhtml";
    }

    public String salva() {
        TeatroDAO dao = new TeatroDAO();
        if (teatro.getCnpj() == 0  && dao.verifica(teatro.getEmail(), teatro.getSenha())) {
            dao.save(teatro);
        } else {
            if (dao.verifica(teatro.getEmail(), teatro.getSenha())){
                dao.update(teatro);
            }
        }
        return "index.xhtml";
    }

    public String delete(Teatro teatro) {
        TeatroDAO dao = new TeatroDAO();
        dao.delete(teatro);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Teatro> getTeatros() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.getAll();
    }

    public Teatro getTeatro() {
        return teatro;
    }
    
    public String login() {
        TeatroDAO dao = new TeatroDAO();
        if(!dao.verifica(teatro.getEmail(), teatro.getSenha())){
                return "Usuario/TeatroUser/pageTeatro.xhtml";
        } else {
            return "loginTeatro.xhtml";
        }
    }
    
    public String teatrosCidade() throws SQLException {
        return "listaTeatrosPorCidade.xhtml";
    }
    
    public List<Teatro> listaTeatrosCidade() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        String nome = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cidade");
        return dao.listarTeatrosPorCidade(nome);
    }
    
}
