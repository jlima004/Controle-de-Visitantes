package model;

import java.time.LocalDate;

public class Evento {
	
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private LocalDate horaInicio;
	private LocalDate horaTermino;
	private String responsavel;
	private String areaRelacionada;
	
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
	public LocalDate getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalDate horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalDate getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(LocalDate horaTermino) {
		this.horaTermino = horaTermino;
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
	
	
	

}
