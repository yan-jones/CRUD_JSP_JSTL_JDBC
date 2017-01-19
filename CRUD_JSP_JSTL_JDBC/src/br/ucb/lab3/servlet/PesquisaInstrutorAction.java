package br.ucb.lab3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.lab3.beans.Instrutor;
import br.ucb.lab3.factory.InstrutorDAO;

public class PesquisaInstrutorAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 764933054046969L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String matricula = req.getParameter("matricula");
		InstrutorDAO dao = new InstrutorDAO();
		Instrutor instrutor = (Instrutor) dao.selectWhereChave(matricula);
		HttpSession session = req.getSession();
		session.setAttribute("instrutor", instrutor);
		resp.sendRedirect("updateInstrutor.jsp");
	}

}
