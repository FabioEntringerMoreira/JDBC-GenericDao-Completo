package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexaoUtil {

	private static ResourceBundle config;
	private static ConexaoUtil connectionUtil;

	private ConexaoUtil() {
		config = ResourceBundle.getBundle("config");
	}

	public static ConexaoUtil getInstance() {

		if (connectionUtil == null) {
			connectionUtil = new ConexaoUtil();
		}
		return connectionUtil;
	}

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Class.forName(config.getString("br.com.bill.bd.driver.sql"));
		return DriverManager.getConnection(
				config.getString("br.com.url.conexao"),
				config.getString("br.com.usuario"),
				config.getString("br.com.senha"));
	}

}
