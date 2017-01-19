package br.ucb.lab3.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucb.lab3.beans.Aluno;
import br.ucb.lab3.enumeradores.Sexo;
import br.ucb.lab3.factory.AlunoDAO;
import br.ucb.lab3.service.Validar;

public class UpdateAlunoAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6214329734870613703L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getParameter("enviar") != null) {
			ArrayList<String> errosAluno = Validar.validaFormAluno(req);
			if (errosAluno.isEmpty()) {
				Aluno aluno = new Aluno(req.getParameter("nome"),
						req.getParameter("cpf"), Sexo.getByFindOrdinal(Integer
								.parseInt(req.getParameter("sexo"))),
						req.getParameter("instrutor"), Double.parseDouble(req
								.getParameter("altura")),
						Double.parseDouble(req.getParameter("peso")));
				AlunoDAO dao = new AlunoDAO();
				dao.update(aluno, req.getParameter("cpf"));
				HttpSession session = req.getSession();
				session.setAttribute("aluno", aluno);
				resp.sendRedirect("listarAlunos");
			} else {
				req.setAttribute("errosAluno", errosAluno);
				req.getRequestDispatcher("updateAluno.jsp").forward(req, resp);
			}
		} else
			req.getRequestDispatcher("listarAlunos").forward(req, resp);
	}
}
