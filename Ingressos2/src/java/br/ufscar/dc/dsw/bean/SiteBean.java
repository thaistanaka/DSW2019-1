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
@ManagedBean(name = "siteBean")
@SessionScoped
public class SiteBean implements Serializable {

    private Site site;

    public SiteBean() {
        site = new Site();
    }
    public String lista() {
        return "siteCRUD.xhtml";
    }

    public String cadastra() {
        site = new Site();
        return "/Site/formulario.xhtml?faces-redirect=true";
    }

    public String edita(Long id) {
        SiteDAO dao = new SiteDAO();
        site = dao.get(id);
        return "/Site/formulario.xhtml?faces-redirect=true";
    }

    public String salva() {
        SiteDAO dao = new SiteDAO();
         if ((site.getId() == null && dao.getEndereco(site.getEndereco()) == null) &&
                 dao.verifica(site.getEmail(), site.getSenha()) == null) {
            dao.save(site);
        } else {
            if(site.getId() != null){
                dao.update(site);
            }
        }
        return "/Usuario/AdminUser/siteCRUD.xhtml?face-redirect=true";
    }

    public String delete(Site site) {
        SiteDAO dao = new SiteDAO();
        dao.delete(site);
        return "siteCRUD.xhtml?faces-redirect=true";
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
        site = dao.verifica(site.getEmail(), site.getSenha());
        if (site != null){
                return "Usuario/SiteUser/siteUser.xhtml";
            }
        else {
            site = new Site();
            return "loginSite.xhtml";
        }

    }

}
