/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Windows
 */
@ManagedBean
@SessionScoped
public class PromocaoBean implements Serializable {

    private Promocao promocao;

    public String lista() {
        return "promocao/index.xhtml";
    }
    
    public String cadastra() {
        promocao = new Promocao();
        return "promocao/formulario.xhtml";
    }

    public String salva() {
        PromocaoDAO dao = new PromocaoDAO();
        if (promocao.get() == null) {
            dao.save(promocao);
        } else {
            dao.update(promocao);
        }
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }
    
    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.getAll();
    }
    
    public List<Promocao> getPromocoes(String cnpj) throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.listarTodasPromocoesDeUmTeatro(cnpj);
    }

    public Promocao getPromocao() {
        return promocao;
    }
    
}
