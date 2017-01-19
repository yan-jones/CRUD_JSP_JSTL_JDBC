package br.ucb.lab3.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucb.lab3.service.Validar;

/**
 * Servlet implementation class ControllerAlunoAction
 */
public class ControllerAlunoAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5996178003928631L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ArrayList<String> errosAluno = Validar.validaFormAluno(req);
		String cpfRepetido = Validar.validaCpfRepetido(req);
		if (errosAluno.isEmpty() && cpfRepetido == null)
			req.getRequestDispatcher("cadastrarAluno").forward(req, resp);
		// resp.sendRedirect("cadastrarAluno");
		else {
			req.setAttribute("errosAluno", errosAluno);
			req.setAttribute("cpfRepetido", cpfRepetido);
			String selecionado = req.getParameter("instrutor");
			req.setAttribute("selecionado", selecionado);
			req.getRequestDispatcher("indexAlunos.jsp").forward(req, resp);
		}
	}
}
