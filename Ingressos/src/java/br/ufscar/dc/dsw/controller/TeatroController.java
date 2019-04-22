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
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/cadastro1":
                    apresentaFormCadastro(request, response);
                    break;
                case "/insercao1":
                    insere(request, response);
                    break;
                case "/remocao1":
                    remove(request, response);
                    break;
                case "/edicao1":
                    apresentaFormEdicao(request, response);
                    break;
                case "/atualizacao1":
                    atualize(request, response);
                    break;
                default:
                    lista(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("teatro/listaTeatro.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("teatro/formularioTeatro.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cnpj = Integer.parseInt(request.getParameter("cnpj"));
        Teatro teatro = dao.get(cnpj);
        RequestDispatcher dispatcher = request.getRequestDispatcher("teatro/formularioTeatro.jsp");
        request.setAttribute("teatro", teatro);
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        Integer senha = Integer.parseInt(request.getParameter("senha"));
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");

        Teatro teatro = new Teatro(email, senha, nome, cidade);
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

    private void remove(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int cnpj = Integer.parseInt(request.getParameter("cnpj"));

        Teatro teatro = new Teatro(cnpj);
        dao.delete(teatro);
        response.sendRedirect("lista");
    }
}
