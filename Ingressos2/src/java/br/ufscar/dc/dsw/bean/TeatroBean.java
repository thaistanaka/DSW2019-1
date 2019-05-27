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
    //Leva para o site de administração de teatros
    public String lista() {
        return "teatroCRUD.xhtml";
    }
    //Leva para o formulário de teatro
    public String cadastra() {
        teatro = new Teatro();
        return "/Teatro/formulario.xhtml?faces-redirect=true";
    }
    //Leva para o formulário de edição de teatro
    public String edita(Long id) {
        TeatroDAO dao = new TeatroDAO();
        teatro = dao.get(id);
        return "/Teatro/formulario.xhtml?faces-redirect=true";
    }
    //Salva o teatro criado se não houver outro com o mesmo cnpj 
    public String salva() {
        TeatroDAO dao = new TeatroDAO();
        if ((teatro.getId() == null && dao.getCnpj(teatro.getCnpj()) == null)
                && dao.verifica(teatro.getEmail(), teatro.getSenha()) == null) {
            dao.save(teatro);
        } else {
            if(teatro.getId() != null){
                dao.update(teatro);
            }
        }
        return "/Usuario/AdminUser/teatroCRUD.xhtml?faces-redirect=true";
    }
    //Remove um teatro do banco de dados
    public String delete(Teatro teatro) {
        TeatroDAO dao = new TeatroDAO();
        dao.delete(teatro);
        return "teatroCRUD.xhtml?faces-redirect=true";
    }
    //Retorna todos os teatros do banco de dados
    public List<Teatro> getTeatros() throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.getAll();
    }

    public Teatro getTeatro() {
        return teatro;
    }
    //Permite o login de um teatro usando seu email e senha
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
    //Leva para a lista contendo todos os teatros por cidade
    public String teatrosCidade() throws SQLException {
        return "listaTeatrosPorCidade.xhtml";
    }
    //Retorna todos os teatros da cidade especificada
    public List<Teatro> listaTeatrosCidade(String nome) throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.listarTeatrosPorCidade(nome);
    }
    
}
