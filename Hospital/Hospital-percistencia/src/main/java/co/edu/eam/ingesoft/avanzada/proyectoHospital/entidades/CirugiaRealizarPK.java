package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class CirugiaRealizarPK implements Serializable{

	private String cirugia;
	
	private String ordenMedica;
	
	public CirugiaRealizarPK() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cirugia == null) ? 0 : cirugia.hashCode());
		result = prime * result + ((ordenMedica == null) ? 0 : ordenMedica.hashCode());
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
		CirugiaRealizarPK other = (CirugiaRealizarPK) obj;
		if (cirugia == null) {
			if (other.cirugia != null)
				return false;
		} else if (!cirugia.equals(other.cirugia))
			return false;
		if (ordenMedica == null) {
			if (other.ordenMedica != null)
				return false;
		} else if (!ordenMedica.equals(other.ordenMedica))
			return false;
		return true;
	}

	
	
}
