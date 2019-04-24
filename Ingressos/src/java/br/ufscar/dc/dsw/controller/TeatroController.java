package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.TeatroDAO;
import br.ufscar.dc.dsw.model.ingressos.Teatro;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class TeatroController extends HttpServlet {

    private TeatroDAO dao;

    @Override
    public void init() {
        dao = new TeatroDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
                String action = request.getRequestURI();
                try {
                    switch (action) {
                        case "cadastro":
                            insere(request, response);
                            break;
                        default:
                            apresentaFormCadastro(request, response);
                            break;
                    }
                } catch (RuntimeException | IOException | ServletException e) {
                    throw new ServletException(e);
                }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "insercao":
                    insere(request, response);
                    break;
                case "edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "atualizacao":
                    atualize(request, response);
                    break;
                case "lista":
                    lista(request, response);
                    break;
                default:
                    apresentaFormCadastro(request, response);
                break;
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Teatro> listaTeatros = dao.getAll();
        request.setAttribute("listaTeatros", listaTeatros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Teatro/teatroCRUD.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Teatro/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        Teatro teatro = dao.get(nome);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Teatro/formulario.jsp");
        request.setAttribute("teatro", teatro);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        Integer senha = Integer.parseInt(request.getParameter("senha"));
        Integer cnpj = Integer.parseInt(request.getParameter("cnpj"));
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");

        Teatro teatro = new Teatro(email, senha, cnpj, nome, cidade);
        dao.insert(teatro);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        Integer senha = Integer.parseInt(request.getParameter("senha"));
        Integer cnpj = Integer.parseInt(request.getParameter("cnpj"));
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");

        Teatro teatro = new Teatro(email, senha, cnpj, nome, cidade);
        dao.update(teatro);
        response.sendRedirect("lista");
    }

}