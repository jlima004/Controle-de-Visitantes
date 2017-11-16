package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	private int id;
	private String nome;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private LocalTime horaInicio;
	private LocalTime horaTermino;
	private String responsavel;
	private String areaRelacionada;
	
	
	DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = LocalDate.parse(dataInicio);
	}
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = LocalDate.parse(dataTermino);;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = LocalTime.parse(horaInicio);;
	}
	public LocalTime getHoraTermino() {
		return horaTermino;
	}
	public void setHoraTermino(String horaTermino) {
		this.horaTermino = LocalTime.parse(horaTermino);
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
	
	
	

}
