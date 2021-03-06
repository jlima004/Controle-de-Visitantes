package model;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;



public class Evento {
	
	private int id;
	private String nome;
	private Date dataInicio;
	private Date dataTermino;
	private Time horaInicio;
	private Time horaTermino;
	private String responsavel;
	private String areaRelacionada;
	
	private ArrayList<Visitante> visitantes = new ArrayList<>();
	private ArrayList<Atracao> atracoes = new ArrayList<>();
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome();
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getAreaRelacionada() {
		return areaRelacionada;
	}
	public void setAreaRelacionada(String areaRelacionada) {
		this.areaRelacionada = areaRelacionada;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(Time horaTermino) {
		this.horaTermino = horaTermino;
	}
	public ArrayList<Visitante> getVisitantes() {
		return visitantes;
	}
	public void setVisitantes(List<Visitante> list) {
		this.visitantes = (ArrayList<Visitante>) list;
	}


	public ArrayList<Atracao> getAtracoes() {
		return atracoes;
	}


	public void setAtracoes(ArrayList<Atracao> atracoes) {
		this.atracoes = atracoes;
	}

	
	
	

}
