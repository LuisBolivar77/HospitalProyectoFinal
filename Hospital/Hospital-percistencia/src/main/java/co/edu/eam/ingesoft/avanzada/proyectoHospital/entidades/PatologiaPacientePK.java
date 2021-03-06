package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class PatologiaPacientePK implements Serializable {

	private int patologia;
	
	private int cita;	

	public PatologiaPacientePK() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cita;
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
		if (cita != other.cita)
			return false;
		if (patologia != other.patologia)
			return false;
		return true;
	}

	

}
