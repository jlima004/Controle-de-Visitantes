package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Atracao {

	private String nome;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horarioTermino;
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

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHorarioTermino() {
		return horarioTermino;
	}

	public void setHorarioTermino(LocalTime horarioTermino) {
		this.horarioTermino = horarioTermino;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
