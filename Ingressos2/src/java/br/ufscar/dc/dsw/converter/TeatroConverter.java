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

    @Override//Converte uma string para objeto
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Long id = Long.parseLong(string);
        TeatroDAO dao = new TeatroDAO();
        return dao.get(id);
    }

    @Override//Converte um objeto para string
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
       Teatro teatro = (Teatro) o;
       return teatro.getCnpj();
    }
}