package br.ucb.lab3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucb.lab3.beans.Instrutor;
import br.ucb.lab3.factory.InstrutorDAO;
import br.ucb.lab3.service.Validar;

public class ExcluirInstrutorAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3555435807561313904L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		InstrutorDAO dao = new InstrutorDAO();
		Instrutor instrutor = (Instrutor) dao.selectWhereChave(req
				.getParameter("matricula"));
		if (!Validar.temAluno(instrutor.getNome())) {
			dao.delete(instrutor.getMatricula());
			req.setAttribute("mensagemExcluir",
					"Instrutor excluido com sucesso!!");
		} else
			req.setAttribute("mensagemRestricao",
					"Instrutor não pode ser excluido pois tem aluno!!");
		req.getRequestDispatcher("listarInstrutores").forward(req, resp);
	}
}
