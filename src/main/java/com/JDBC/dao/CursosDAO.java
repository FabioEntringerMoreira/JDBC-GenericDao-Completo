package com.JDBC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.JDBC.ConexaoUtil;
import com.JDBC.exception.PersistenciaException;
import com.JDBC.model.CursosModel;

public class CursosDAO implements GenericoDAO<CursosModel> {

	@Override
	public void inserir(CursosModel cursosDTO) throws PersistenciaException {

		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "INSERT INTO `cadastro`.`cursos` "
					+ "(`idcurso`, `nome`, `descricao`, `carga`, `totaulas`, `ano`)"
					+ " VALUES (?, ?, ?, ?, ?, ?);";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, cursosDTO.getIdcurso());
			statement.setString(2, cursosDTO.getNome());
			statement.setString(3, cursosDTO.getDescricao());
			statement.setInt(4, cursosDTO.getCarga());
			statement.setInt(5, cursosDTO.getTotalaulas());
			statement.setInt(6, cursosDTO.getAno());

			statement.executeUpdate();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
	}

	@Override
	public void atualizar(CursosModel cursosDTO) throws PersistenciaException {

		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "UPDATE `cadastro`.`cursos` SET `idcurso` = ?,"
					+ " `nome` = ?, `descricao` = ?,"
					+ " `carga` = ?, `totaulas` = ?,"
					+ " `ano` = ? WHERE (`idcurso` = ?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, cursosDTO.getIdcurso());
			statement.setString(2, cursosDTO.getNome());
			statement.setString(3, cursosDTO.getDescricao());
			statement.setInt(4, cursosDTO.getCarga());
			statement.setInt(5, cursosDTO.getTotalaulas());
			statement.setInt(6, cursosDTO.getAno());
			statement.setInt(7, 40);

			statement.executeUpdate();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
	}

	@Override
	public void deletar(Integer idcurso) throws PersistenciaException {

		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "DELETE FROM cursos where idcurso = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idcurso);
			statement.execute();
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
	}

	@Override
	public List<CursosModel> listarTodos() throws PersistenciaException {

		List<CursosModel> cursos = new ArrayList<CursosModel>();
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();

			String sql = "select*from cursos;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeQuery();

			ResultSet rs = statement.getResultSet();

			while (rs.next()) {

				CursosModel curso = new CursosModel();
				curso.setIdcurso(rs.getInt("idcurso"));
				curso.setNome(rs.getString("nome"));
				curso.setDescricao(rs.getString("descricao"));
				curso.setCarga(rs.getInt("carga"));
				curso.setTotalaulas(rs.getInt("totaulas"));
				curso.setAno(rs.getInt("ano"));

				cursos.add(curso);
			}
			connection.close();

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		return cursos;
	}

	@Override
	public CursosModel listarPorId(Integer id) throws PersistenciaException {

		CursosModel cursoDTO = null;
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();

			PreparedStatement statement = connection
					.prepareStatement("select*from cursos where idcurso = ?");
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {

				cursoDTO = new CursosModel();
				cursoDTO.setIdcurso(rs.getInt("idcurso"));
				cursoDTO.setNome(rs.getString("nome"));
				cursoDTO.setDescricao(rs.getString("descricao"));
				cursoDTO.setCarga(rs.getInt("carga"));
				cursoDTO.setTotalaulas(rs.getInt("totaulas"));
				cursoDTO.setAno(rs.getInt("ano"));
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}

		return cursoDTO;
	}

}
