
package br.ucb.lab3.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.lab3.beans.Instrutor;
import br.ucb.lab3.factory.InstrutorDAO;
import br.ucb.lab3.service.Validar;

public class UpdateInstrutorAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7634569563440988638L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getParameter("enviar") != null) {
			ArrayList<String> errosInstrutor = Validar.validaFormInstrutor(req);
			if (errosInstrutor.isEmpty()) {
				Instrutor instrutor = new Instrutor(req.getParameter("nome"),
						req.getParameter("matricula"), Integer.parseInt(req
								.getParameter("anoConclusaoGraduacao")));
				InstrutorDAO dao = new InstrutorDAO();
				dao.update(instrutor, req.getParameter("matricula"));
				HttpSession session = req.getSession();
				session.setAttribute("instrutor", instrutor);
				resp.sendRedirect("listarInstrutores");
			} else {
				req.setAttribute("errosInstrutor", errosInstrutor);
				req.getRequestDispatcher("updateInstrutor.jsp").forward(req,
						resp);
			}
		} else
			req.getRequestDispatcher("listarInstrutores").forward(req, resp);
	}
}
