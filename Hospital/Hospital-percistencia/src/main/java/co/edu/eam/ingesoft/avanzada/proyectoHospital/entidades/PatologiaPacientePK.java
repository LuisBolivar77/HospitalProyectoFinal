package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class PatologiaPacientePK implements Serializable {

	private int patologia;
	
	private String cita;	

	public PatologiaPacientePK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the patologia
	 */
	public int getPatologia() {
		return patologia;
	}

	/**
	 * @param patologia the patologia to set
	 */
	public void setPatologia(int patologia) {
		this.patologia = patologia;
	}

	/**
	 * @return the cita
	 */
	public String getCita() {
		return cita;
	}

	/**
	 * @param cita the cita to set
	 */
	public void setCita(String cita) {
		this.cita = cita;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cita == null) ? 0 : cita.hashCode());
		result = prime * result + patologia;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatologiaPacientePK other = (PatologiaPacientePK) obj;
		if (cita == null) {
			if (other.cita != null)
				return false;
		} else if (!cita.equals(other.cita))
			return false;
		if (patologia != other.patologia)
			return false;
		return true;
	}

	

}
