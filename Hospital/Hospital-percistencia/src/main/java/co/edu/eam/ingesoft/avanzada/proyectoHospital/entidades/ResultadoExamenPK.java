package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class ResultadoExamenPK implements Serializable {

	private int examen;

	private int cita;

	public ResultadoExamenPK() {

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cita;
		result = prime * result + examen;
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
		ResultadoExamenPK other = (ResultadoExamenPK) obj;
		if (cita != other.cita)
			return false;
		if (examen != other.examen)
			return false;
		return true;
	}

	
	

}
