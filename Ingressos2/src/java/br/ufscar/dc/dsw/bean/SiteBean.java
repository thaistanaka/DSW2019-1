/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.pojo.Site;
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
public class SiteBean implements Serializable {

    private Site site;

    public SiteBean() {
        site = new Site();
    }
    public String lista() {
        return "site/index.xhtml";
    }

    public String cadastra() {
        site = new Site();
        return "form.xhtml";
    }

    public String edita(String endereco) {
        SiteDAO dao = new SiteDAO();
        site = dao.get(endereco);
        return "site/formulario.xhtml";
    }

    public String salva() {
        SiteDAO dao = new SiteDAO();
        if (site.getEndereco() == null) {
            dao.save(site);
        } else {
            dao.update(site);
        }
        return "index.xhtml";
    }

    public String delete(Site site) {
        SiteDAO dao = new SiteDAO();
        dao.delete(site);
        return "index.xhtml";
    }

    public String volta() {
        return "/index.xhtml?faces-redirect=true";
    }

    public List<Site> getSites() throws SQLException {
        SiteDAO dao = new SiteDAO();
        return dao.getAll();
    }

    public Site getSite() {
        return site;
    }

    public String login() {
        SiteDAO dao = new SiteDAO();
        if (dao.verifica(site.getEmail(), site.getSenha())) {
            return "Usuario/SiteUser/pageSite.xhtml";
        } else {
            return "loginSite.xhtml";
        }

    }
 
    public void setSite(Site site) {
        this.site = site;
    }
}
