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
        return "teatroCRUD.xhtml";
    }

    public String cadastra() {
        teatro = new Teatro();
        return "/Teatro/formulario.xhtml?faces-redirect=true";
    }

    public String edita(Long id) {
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        return "/Teatro/formulario.xhtml?faces-redirect=true";
    }

    public String salva() {
        TeatroDAO dao = new TeatroDAO();
        if ((teatro.getId() == null && dao.getCnpj(teatro.getCnpj()) == null) && dao.verifica(teatro.getEmail(), teatro.getSenha()) == null) {
            dao.save(teatro);
        } else {
            if(teatro.getId() != null){
                dao.update(teatro);
            }
        }
        return "/Usuario/AdminUser/teatroCRUD.xhtml?faces-redirect=true";
    }

    public String delete(Teatro teatro) {
        TeatroDAO dao = new TeatroDAO();
        dao.delete(teatro);
        return "teatroCRUD.xhtml?faces-redirect=true";
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
        teatro = dao.verifica(teatro.getEmail(), teatro.getSenha());
        if(teatro != null){
                return "Usuario/TeatroUser/teatroUser.xhtml";
        } else {
            teatro = new Teatro();
            return "loginTeatro.xhtml";
        }
    }
    
    public String teatrosCidade() throws SQLException {
        return "listaTeatrosPorCidade.xhtml";
    }
    
    public List<Teatro> listaTeatrosCidade(String nome) throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.listarTeatrosPorCidade(nome);
    }
    
}
