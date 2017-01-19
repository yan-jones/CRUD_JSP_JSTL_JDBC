package br.ucb.lab3.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.ucb.lab3.interfaces.DataBaseConfiguracao;

public class Conexao implements DataBaseConfiguracao {

	protected Connection connection;
	protected Statement statement;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;

	public Conexao() {
		try {
			Class.forName(DRIVER);
			setConnection(DriverManager.getConnection(URL + DATABASE, USER,
					PASS));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		if (getConnection() != null)
			try {
				getConnection().close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
	}

	public void close() {
		try {
			if (getResultSet() != null)
				getResultSet().close();
			if (getStatement() != null)
				getStatement().close();
			if (getPreparedStatement() != null)
				getPreparedStatement().close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

}
