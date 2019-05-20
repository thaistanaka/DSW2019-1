/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.pojo.Promocao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows
 */
@WebServlet(urlPatterns = "/promocao/*")
public class PromocaoBean extends HttpServlet {

    private PromocaoDAO dao;

    public void init() {
        dao = new PromocaoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getRequestURI();
        action = action.split("/")[action.split("/").length - 1];
        try {

            switch (action) {
                case "cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                default:
            {
                try {
                    insere(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(PromocaoBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Promocao/formulario.xhtml");
        request.setAttribute("cnpj", request.getParameter("cnpj"));
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        request.setCharacterEncoding("UTF-8");

        if (request.getParameter("preco") != null && request.getParameter("cnpj") != null) {
            String endereco = request.getParameter("endereco");
            String nome = request.getParameter("nome");
            String dia = request.getParameter("dia");
            String hora = request.getParameter("hora");
            float preco = Float.parseFloat(request.getParameter("preco"));
            Integer cnpj = Integer.parseInt(request.getParameter("cnpj"));
            if (dao.Verifica(endereco, cnpj, hora, dia)) {
                Promocao promocao = new Promocao(endereco, cnpj, nome, preco, dia, hora);
                dao.save(promocao);
            } 
                  
        } 
            response.sendRedirect("/Ingressos2/loginTeatro.xhtml");
 
    }

}
