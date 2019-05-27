/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
import br.ufscar.dc.dsw.pojo.Site;
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
@ManagedBean(name = "promocaoBean")
@SessionScoped
public class PromocaoBean implements Serializable {

    private Promocao promocao;
    private final Teatro teatro;
    private final Site site;
    
    public PromocaoBean(){
        promocao = new Promocao();
        teatro = new Teatro();
        site = new Site();
        promocao.setTeatro(teatro);
        promocao.setSite(site);
    }
    
    public String cadastra() {
        promocao = new Promocao();
        return "/Promocao/formulario.xhtml?faces-redirect=true";
    }

    public String salva() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        if (dao.get(promocao.getId()) == null && dao.verifica(promocao.getSite(), promocao.getTeatro(), 
                promocao.getHora(), promocao.getDia()) == null) {
            dao.save(promocao);
        } 
        return "/Usuario/TeatroUser/teatroUser.xhtml?faces-redirect=true";
    }

    public List<Promocao> getPromocoes() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.getAll();
    }
    
    public String promocoesPorTeatro() throws SQLException {
        return "listaPromocoesDoTeatro.xhtml";
    }
    
    public List<Promocao> listaPromocaoTeatro(String teatro) throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.listarTodasPromocoesDeUmTeatro(teatro);
    }
    
    public List<Promocao> listaPromocaoSite (String site) throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.listarTodasPromocoesDeUmSite(site);
    }

    public Promocao getPromocao() {
        return promocao;
    }
    
}
