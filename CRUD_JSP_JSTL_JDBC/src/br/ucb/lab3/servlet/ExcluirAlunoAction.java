package br.ucb.lab3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucb.lab3.factory.AlunoDAO;

public class ExcluirAlunoAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1067276442547265945L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		AlunoDAO dao = new AlunoDAO();
		dao.delete(req.getParameter("cpf"));
		req.setAttribute("mensagemExcluir", "Aluno excluido com sucesso!!");
		req.getRequestDispatcher("listarAlunos").forward(req, resp);
	}
}
