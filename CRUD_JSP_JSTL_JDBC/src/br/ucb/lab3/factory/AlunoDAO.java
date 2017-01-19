package br.ucb.lab3.factory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ucb.lab3.beans.Aluno;
import br.ucb.lab3.enumeradores.QueryAluno;
import br.ucb.lab3.enumeradores.Sexo;
import br.ucb.lab3.interfaces.DAO;

public class AlunoDAO implements DAO<Aluno> {

	private Conexao conexao;

	public AlunoDAO() {
		setConexao(new Conexao());
	}

	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
	}

	@Override
	public void insert(Aluno object) {
		try {
			getConexao().setPreparedStatement(
					getConexao().getConnection().prepareStatement(
							QueryAluno.INSERT_ALUNO.getQuery()));
			getConexao().getPreparedStatement().setString(1, object.getNome());
			getConexao().getPreparedStatement().setString(2, object.getCpf());
			getConexao().getPreparedStatement().setInt(3,
					object.getSexo().ordinal());
			getConexao().getPreparedStatement().setString(4,
					object.getInstrutor());
			getConexao().getPreparedStatement()
					.setDouble(5, object.getAltura());
			getConexao().getPreparedStatement().setDouble(6, object.getPeso());
			getConexao().getPreparedStatement().executeUpdate();
			getConexao().close();
			getConexao().closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public List<Aluno> select() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			getConexao().setPreparedStatement(
					getConexao().getConnection().prepareStatement(
							QueryAluno.SELECT_ALUNO.getQuery()));
			getConexao().setResultSet(
					getConexao().getPreparedStatement().executeQuery());
			ResultSet rs = getConexao().getResultSet();
			while (rs.next()) {
				alunos.add(new Aluno(rs.getString("nome"), rs.getString("cpf"),
						Sexo.getByFindOrdinal(rs.getInt("sexo")), rs
								.getString("instrutor"),
						rs.getDouble("altura"), rs.getDouble("peso")));
			}
			getConexao().close();
			getConexao().closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return alunos;
	}

	@Override
	public Object selectWhereChave(String str) {
		Aluno aluno = new Aluno();
		try {
			getConexao().setPreparedStatement(
					getConexao().getConnection().prepareStatement(
							QueryAluno.SELECT_WHERE_CPF_ALUNO.getQuery()));
			getConexao().getPreparedStatement().setString(1, str);
			getConexao().setResultSet(
					getConexao().getPreparedStatement().executeQuery());
			ResultSet rs = getConexao().getResultSet();
			while (rs.next()) {
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setSexo(Sexo.getByFindOrdinal(rs.getInt("sexo")));
				aluno.setInstrutor(rs.getString("instrutor"));
				aluno.setAltura(rs.getDouble("altura"));
				aluno.setPeso(rs.getDouble("peso"));
			}
			getConexao().close();
			//getConexao().closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return aluno;
	}

	@Override
	public Object selectWhereString(String str) {
		Aluno aluno = new Aluno();
		try {
			getConexao()
					.setPreparedStatement(
							getConexao().getConnection().prepareStatement(
									QueryAluno.SELECT_WHERE_INSTRUTOR_ALUNO
											.getQuery()));
			getConexao().getPreparedStatement().setString(1, str);
			getConexao().setResultSet(
					getConexao().getPreparedStatement().executeQuery());
			ResultSet rs = getConexao().getResultSet();
			while (rs.next()) {
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setSexo(Sexo.getByFindOrdinal(rs.getInt("sexo")));
				aluno.setInstrutor(rs.getString("instrutor"));
				aluno.setAltura(rs.getDouble("altura"));
				aluno.setPeso(rs.getDouble("peso"));
			}
			getConexao().close();
			//getConexao().closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return aluno;
	}

	@Override
	public void update(Aluno object, String str) {
		try {
			getConexao().setPreparedStatement(
					getConexao().getConnection().prepareStatement(
							QueryAluno.UPDATE_ALUNO.getQuery()));
			getConexao().getPreparedStatement().setString(1, object.getNome());
			getConexao().getPreparedStatement().setString(2, object.getCpf());
			getConexao().getPreparedStatement().setInt(3,
					object.getSexo().ordinal());
			getConexao().getPreparedStatement().setString(4,
					object.getInstrutor());
			getConexao().getPreparedStatement()
					.setDouble(5, object.getAltura());
			getConexao().getPreparedStatement().setDouble(6, object.getPeso());
			getConexao().getPreparedStatement().setString(7, str);
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
							QueryAluno.DELETE_ALUNO.getQuery()));
			getConexao().getPreparedStatement().setString(1, str);
			getConexao().getPreparedStatement().executeUpdate();
			getConexao().close();
			getConexao().closeConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public Conexao getConexao() {
		return conexao;
	}

}
