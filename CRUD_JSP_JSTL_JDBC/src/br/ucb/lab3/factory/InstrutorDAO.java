package br.ucb.lab3.factory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucb.lab3.beans.Instrutor;
import br.ucb.lab3.enumeradores.QueryInstrutor;
import br.ucb.lab3.interfaces.DAO;

public class InstrutorDAO implements DAO<Instrutor> {

	private Conexao conexao;

	public InstrutorDAO() {
		setConexao(new Conexao());
	}

	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Instrutor object) {
		try {
			getConexao().setPreparedStatement(
					getConexao().getConnection().prepareStatement(
							QueryInstrutor.INSERT_INSTRUTOR.getQuery()));
			getConexao().getPreparedStatement().setString(1, object.getNome());
			getConexao().getPreparedStatement().setString(2,
					object.getMatricula());
			getConexao().getPreparedStatement().setInt(3,
					object.getAnoConcGrad());
			getConexao().getPreparedStatement().executeUpdate();
			getConexao().close();
			// getConexao().closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Instrutor> select() {
		List<Instrutor> instrutores = new ArrayList<Instrutor>();
		try {
			getConexao().setPreparedStatement(
					getConexao().getConnection().prepareStatement(
							QueryInstrutor.SELECT_INSTRUTOR.getQuery()));
			getConexao().setResultSet(
					getConexao().getPreparedStatement().executeQuery());
			ResultSet rs = getConexao().getResultSet();
			while (rs.next()) {
				instrutores.add(new Instrutor(rs.getString("nome"), rs
						.getString("matricula"), rs
						.getInt("ANO_CONCLUSAO_GRADUACAO")));
			}
			getConexao().close();
			getConexao().closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return instrutores;
	}

	@Override
	public Object selectWhereChave(String str) {
		Instrutor instrutor = new Instrutor();
		try {
			getConexao().setPreparedStatement(
					getConexao().getConnection().prepareStatement(
							QueryInstrutor.SELECT_WHERE_INSTRUTOR.getQuery()));
			getConexao().getPreparedStatement().setString(1, str);
			getConexao().setResultSet(
					getConexao().getPreparedStatement().executeQuery());
			ResultSet rs = getConexao().getResultSet();
			while (rs.next()) {
				instrutor.setNome(rs.getString("nome"));
				instrutor.setMatricula(rs.getString("matricula"));
				instrutor.setAnoConcGrad(rs.getInt("ANO_CONCLUSAO_GRADUACAO"));
			}
			getConexao().close();
			// getConexao().closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return instrutor;
	}

	@Override
	public Object selectWhereString(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Instrutor object, String str) {
		try {
			getConexao().setPreparedStatement(
					getConexao().getConnection().prepareStatement(
							QueryInstrutor.UPDATE_INSTRUTOR.getQuery()));
			getConexao().getPreparedStatement().setString(1, object.getNome());
			getConexao().getPreparedStatement().setString(2,
					object.getMatricula());
			getConexao().getPreparedStatement().setInt(3,
					object.getAnoConcGrad());
			getConexao().getPreparedStatement().setString(4, str);
			getConexao().getPreparedStatement().executeUpdate();
			getConexao().close();
			getConexao().closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void delete(String str) {
		try {
			getConexao().setPreparedStatement(
					getConexao().getConnection().prepareStatement(
							QueryInstrutor.DELETE_INSTRUTOR.getQuery()));
			getConexao().getPreparedStatement().setString(1, str);
			getConexao().getPreparedStatement().executeUpdate();
			getConexao().close();
			// getConexao().closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public Conexao getConexao() {
		return conexao;
	}

}
