package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class ResultadoExamenPK implements Serializable{
	
	private String examen;
	
	private String historial;
	
	public ResultadoExamenPK() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((examen == null) ? 0 : examen.hashCode());
		result = prime * result + ((historial == null) ? 0 : historial.hashCode());
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
		if (examen == null) {
			if (other.examen != null)
				return false;
		} else if (!examen.equals(other.examen))
			return false;
		if (historial == null) {
			if (other.historial != null)
				return false;
		} else if (!historial.equals(other.historial))
			return false;
		return true;
	}

	
}
