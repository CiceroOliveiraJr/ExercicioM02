package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import repository.ConexaoException;

public class GerenciadorConexaoMysql implements GerenciadorConexao {
	private static GerenciadorConexaoMysql instancia;
	
	private GerenciadorConexaoMysql() {
		
	}
	
	/**
	 * Retornar uma inst�ncia SINGLETON do GerenciadorConexao
	 * @return
	 */
	public static GerenciadorConexaoMysql getInstancia() {
		if(instancia==null) {
			instancia = new GerenciadorConexaoMysql();
		}
		return instancia;
	}

	@Override
	public Connection conectar()throws ConexaoException {
		String url = "jdbc:mysql://localhost:3306/lojaunit?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String password = "123456";
		Connection c;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			throw new ConexaoException(e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new ConexaoException(e.getMessage());
		}
		return c;
	}

	@Override
	public void desconectar(Connection c)throws ConexaoException {
		try {
			c.close();
		}catch(SQLException e) {
			throw new ConexaoException(e.getMessage());
		}
	}

}