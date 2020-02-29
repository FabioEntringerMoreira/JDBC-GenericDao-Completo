package com.JDBC.dao;

import java.util.List;

import com.JDBC.exception.PersistenciaException;

public interface GenericoDAO<T> {

	void inserir(T obj) throws PersistenciaException;

	void atualizar(T obj) throws PersistenciaException;

	void deletar(Integer id) throws PersistenciaException;

	List<T> listarTodos() throws PersistenciaException;

	T listarPorId(Integer id) throws PersistenciaException;

}
