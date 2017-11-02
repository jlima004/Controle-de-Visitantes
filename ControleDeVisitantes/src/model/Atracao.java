package model;

import java.time.LocalDate;

public class Atracao {
	
	private String nome;
	private LocalDate data;
	private LocalDate horaInicio;
	private LocalDate horarioTermino;
	private String tipo;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalDate getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalDate horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalDate getHorarioTermino() {
		return horarioTermino;
	}
	public void setHorarioTermino(LocalDate horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
