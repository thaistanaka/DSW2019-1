/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.converter;

import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.pojo.Teatro;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Windows
 */
@FacesConverter("TeatroConverter")
public class TeatroConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int cnpj = Integer.parseInt(string);
        TeatroDAO dao = new TeatroDAO();
        return dao.get(cnpj);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
       Teatro teatro = (Teatro) o;
       return teatro.getCnpj().toString();
    }
}