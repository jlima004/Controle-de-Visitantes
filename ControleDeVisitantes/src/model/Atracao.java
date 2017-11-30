package model;

import java.sql.Date;
import java.sql.Time;


public class Atracao {
	
	private String nome;
	private int id;
	private Date data;
	private Time horaInicio;
	private Time horarioTermino;
	private String descricao;
	private int idEvento;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHorarioTermino() {
		return horarioTermino;
	}
	public void setHorarioTermino(Time horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	
	
	

}
