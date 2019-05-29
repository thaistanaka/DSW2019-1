/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
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
    //Leva para o site de administração de sites
    public String lista() {
        return "siteCRUD.xhtml";
    }
    //Leva para o formulário de site
    public String cadastra() {
        site = new Site();
        return "/Site/formulario.xhtml?faces-redirect=true";
    }
    //Leva para o formulário de edição de site
    public String edita(Long id) {
        SiteDAO dao = new SiteDAO();
        site = dao.get(id);
        return "/Site/formulario.xhtml?faces-redirect=true";
    }
    
    public String logout(){
        return "/loginSite.xhtml?faces-redirect=true";
    }
    //Salva o site criado se não houver outro com o mesmo endereço 
    public String salva() {
        SiteDAO dao = new SiteDAO();
        List<Site> sites = dao.getEnderecoList(site.getEndereco());
         if ((site.getId() == null && dao.getEndereco(site.getEndereco()) == null) &&
                 dao.verifica(site.getEmail(), site.getSenha()) == null) {
            dao.save(site);
        } else {
            if(site.getId() != null && (sites.size() == 1 && (dao.getEnderecoId(site.getEndereco(), site.getId()) != null))){
                dao.update(site);
            }
        }
        return "/Usuario/AdminUser/siteCRUD.xhtml?face-redirect=true";
    }
    //Remove um site do banco de dados
    public String delete(Site site) throws SQLException {
        PromocaoDAO daoP = new PromocaoDAO();
        List<Promocao> promos = daoP.listarTodasPromocoesDeUmSite(site.getEndereco());
        for(Promocao promocao: promos){
            daoP.delete(promocao);
        }
        SiteDAO dao = new SiteDAO();
        dao.delete(site);
        return "siteCRUD.xhtml?faces-redirect=true";
    }
    //Retorna todos os sites do banco de dados
    public List<Site> getSites() throws SQLException {
        SiteDAO dao = new SiteDAO();
        return dao.getAll();
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
    //Permite o login de um site usando seu email e senha
    public String login() {
        SiteDAO dao = new SiteDAO();
        if (dao.verifica(site.getEmail(), site.getSenha()) != null){
                return "Usuario/SiteUser/siteUser.xhtml?faces-redirect=true";
            }
        else {
            return "loginSite.xhtml";
        }

    }

}
