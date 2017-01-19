package br.ucb.lab3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.lab3.beans.Instrutor;
import br.ucb.lab3.factory.InstrutorDAO;

public class ListarInstrutoresAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3436031750082428893L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		InstrutorDAO dao = new InstrutorDAO();
		List<Instrutor> instrutores = dao.select();
		HttpSession session = req.getSession();
		session.setAttribute("instrutores", instrutores);
		// resp.sendRedirect("listarInstrutores.jsp");
		req.getRequestDispatcher("listarInstrutores.jsp").forward(req, resp);
	}
}
