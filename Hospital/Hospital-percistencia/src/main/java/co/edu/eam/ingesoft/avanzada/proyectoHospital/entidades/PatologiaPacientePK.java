package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class PatologiaPacientePK implements Serializable {

	private int cita;

	private int patologia;

	public PatologiaPacientePK() {
		// TODO Auto-generated constructor stub
	}

	public PatologiaPacientePK(int cita, int patologia) {
		super();
		this.cita = cita;
		this.patologia = patologia;
	}

	public int getCita() {
		return cita;
	}

	public void setCita(int cita) {
		this.cita = cita;
	}

	public int getPatologia() {
		return patologia;
	}

	public void setPatologia(int patologia) {
		this.patologia = patologia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cita;
		result = prime * result + patologia;
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
		PatologiaPacientePK other = (PatologiaPacientePK) obj;
		if (cita != other.cita)
			return false;
		if (patologia != other.patologia)
			return false;
		return true;
	}

}
