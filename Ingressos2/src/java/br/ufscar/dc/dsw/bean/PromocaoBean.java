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
import javax.faces.context.FacesContext;

/**
 *
 * @author Windows
 */
@ManagedBean(name = "promocaoBean")
@SessionScoped
public class PromocaoBean implements Serializable {

    private Promocao promocao;
    
    public PromocaoBean(){
        promocao = new Promocao();
        promocao.setTeatro(new Teatro());
        promocao.setSite(new Site());
    }

    public String lista() {
        return "promocao/index.xhtml";
    }
    
    public String cadastra() {
        promocao = new Promocao();
        return "promocao/formulario.xhtml";
    }

    public String salva() {
        PromocaoDAO dao = new PromocaoDAO();
        if (promocao.getId() == null) {
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
    
    public String promocoesPorTeatro() throws SQLException {
        return "listaPromocoesDoTeatro.xhtml";
    }
    
    public List<Promocao> listaPromocaoTeatro() throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        String teatro = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("cnpj");
        return dao.listarTodasPromocoesDeUmTeatro(teatro);
    }
    
    public List<Promocao> listaPromocaoSite () throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        String site = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("endereco");
        return dao.listarTodasPromocoesDeUmSite(site);
    }

    public Promocao getPromocao() {
        return promocao;
    }
    
}
