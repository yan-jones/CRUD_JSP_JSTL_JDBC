package br.ucb.lab3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.lab3.beans.Instrutor;
import br.ucb.lab3.factory.InstrutorDAO;

public class CadastrarInstrutorAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5275528194785823825L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Instrutor instrutor = new Instrutor(req.getParameter("nome"),
				req.getParameter("matricula"), Integer.parseInt(req
						.getParameter("anoConclusaoGraduacao")));
		InstrutorDAO dao = new InstrutorDAO();
		dao.insert(instrutor);
		HttpSession session = req.getSession();
		session.setAttribute("instrutor", instrutor);
		resp.sendRedirect("listarInstrutores");
	}
}
