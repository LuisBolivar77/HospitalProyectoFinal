package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class OrdenExamenPK implements Serializable {

	private int ordenMedica;

	private int examen;

	public OrdenExamenPK() {

	}

	public OrdenExamenPK(int ordenMedica, int examen) {
		super();
		this.ordenMedica = ordenMedica;
		this.examen = examen;
	}

	public int getOrdenMedica() {
		return ordenMedica;
	}

	public void setOrdenMedica(int ordenMedica) {
		this.ordenMedica = ordenMedica;
	}

	public int getExamen() {
		return examen;
	}

	public void setExamen(int examen) {
		this.examen = examen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examen;
		result = prime * result + ordenMedica;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdenExamenPK other = (OrdenExamenPK) obj;
		if (examen != other.examen)
			return false;
		if (ordenMedica != other.ordenMedica)
			return false;
		return true;
	}

}
