package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class ResultadoExamenPK implements Serializable {

	private int examen;

	private int ordenMedica;

	public ResultadoExamenPK() {

	}

	public ResultadoExamenPK(int examen, int ordenMedica) {
		super();
		this.examen = examen;
		this.ordenMedica = ordenMedica;
	}

	public int getExamen() {
		return examen;
	}

	public void setExamen(int examen) {
		this.examen = examen;
	}

	public int getOrdenMedica() {
		return ordenMedica;
	}

	public void setOrdenMedica(int ordenMedica) {
		this.ordenMedica = ordenMedica;
	}

}
