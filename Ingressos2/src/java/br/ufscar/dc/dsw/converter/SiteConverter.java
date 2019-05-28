/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.converter;

import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.pojo.Site;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author Windows
 */
@FacesConverter("SiteConverter")
public class SiteConverter implements Converter{

    @Override//Converte uma string para objeto
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        SiteDAO dao = new SiteDAO();
        return dao.getEndereco(string);
    }

    @Override//Converte um objeto para string
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
       Site site = (Site) o;
       return site.getEndereco();
    }
    
}
