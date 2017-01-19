package br.ucb.lab3.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucb.lab3.service.Validar;

/**
 * Servlet implementation class ControllerAction
 */
public class ControllerInstrutorAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6584148761487254174L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<String> errosInstrutor = Validar.validaFormInstrutor(req);
		String matriculaRepetida = Validar.validaMatriculaRepetida(req);
		if (errosInstrutor.isEmpty() && matriculaRepetida == null) {
			//resp.sendRedirect("cadastrarInstrutor");
			req.getRequestDispatcher("cadastrarInstrutor").forward(req, resp);
		} else {
			req.setAttribute("errosInstrutor", errosInstrutor);
			req.setAttribute("matriculaRepetida", matriculaRepetida);
			String selecionado = req.getParameter("anoConclusaoGraduacao");
			req.setAttribute("selecionado", selecionado);
			req.getRequestDispatcher("indexInstrutores.jsp").forward(req, resp);
		}
	}
}
