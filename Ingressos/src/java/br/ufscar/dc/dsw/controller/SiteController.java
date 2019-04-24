package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.model.ingressos.Site;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class SiteController extends HttpServlet {

    private SiteDAO dao;

    @Override
    public void init() {
        dao = new SiteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao":
                    insere(request, response);
                    break;
                case "/edicao":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao":
                    atualize(request, response);
                    break;
                case "/lista":
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
        List<Site> listaSites = dao.getAll();
        request.setAttribute("listaSites", listaSites);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Site/siteCRUD.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Site/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String endereco = request.getParameter("endereco");
        Site site = dao.get(endereco);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Site/formulario.jsp");
        request.setAttribute("site", site);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        Integer senha = Integer.parseInt(request.getParameter("senha"));
        String endereco = request.getParameter("endereco");
        String nome = request.getParameter("nome");
        Integer telefone = Integer.parseInt(request.getParameter("telefone"));

        Site site = new Site(email, senha, nome, endereco, telefone);
        dao.insert(site);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        Integer senha = Integer.parseInt(request.getParameter("senha"));
        String endereco = request.getParameter("endereco");
        String nome = request.getParameter("nome");
        Integer telefone = Integer.parseInt(request.getParameter("telefone"));

        Site site = new Site(email, senha, endereco, nome, telefone);
        dao.update(site);
        response.sendRedirect("lista");
    }

}