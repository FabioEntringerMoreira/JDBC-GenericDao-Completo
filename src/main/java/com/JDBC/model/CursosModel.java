package com.JDBC.model;

public class CursosModel {

	private Integer idcurso;
	private String nome;
	private String descricao;
	private Integer carga;
	private Integer totalaulas;
	private Integer ano;
	
	public CursosModel(){
		
	}

	public CursosModel(Integer idcurso, String nome, String descricao,
			Integer carga, Integer totalaulas, Integer ano) {
		super();
		this.idcurso = idcurso;
		this.nome = nome;
		this.descricao = descricao;
		this.carga = carga;
		this.totalaulas = totalaulas;
		this.ano = ano;
	}

	public Integer getIdcurso() {
		return idcurso;
	}

	public void setIdcurso(Integer idcurso) {
		this.idcurso = idcurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCarga() {
		return carga;
	}

	public void setCarga(Integer carga) {
		this.carga = carga;
	}

	public Integer getTotalaulas() {
		return totalaulas;
	}

	public void setTotalaulas(Integer totalaulas) {
		this.totalaulas = totalaulas;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}
