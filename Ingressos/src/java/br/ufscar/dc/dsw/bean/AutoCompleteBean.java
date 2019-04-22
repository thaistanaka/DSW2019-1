/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.model.ingressos.Promocao;
import br.ufscar.dc.dsw.model.ingressos.Teatro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lap
 */
public class AutoCompleteBean {
    public List<Teatro> getTeatrosPorCidade(String cidade) throws SQLException {
        TeatroDAO dao = new TeatroDAO();
        return dao.listarTodosTeatrosPorCidade(cidade);
    }

    public Iterable<Promocao> getPromocoesDeUmTeatro(int v) throws SQLException {
        PromocaoDAO dao = new PromocaoDAO();
        return dao.listarTodasPromocoesDeUmTeatro(v);
    }
}
