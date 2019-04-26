/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.model.ingressos.Promocao;
import java.io.IOException;
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
public class PromocaoController extends HttpServlet{
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
                    insere(request, response);
                    break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }


    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/formularioPromocao.jsp");
        request.setAttribute("cnpj",request.getParameter("cnpj"));
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        if(request.getParameter("preco") != null && request.getParameter("cnpj") != null){
            String endereco = request.getParameter("endereco");
            String nome = request.getParameter("nome");
            String dia = request.getParameter("dia");
            String hora = request.getParameter("hora");
            float preco = Float.parseFloat(request.getParameter("preco"));
            Integer cnpj = Integer.parseInt(request.getParameter("cnpj"));
            Promocao promocao = new Promocao(endereco, cnpj, nome, preco, dia, hora);
            dao.insert(promocao);
        }
        
        response.sendRedirect("/Ingressos/teatroUser.jsp");
    }

}
