package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class EncargadoCirugiaPK implements Serializable {

	private CirugiaRealizarPK cirugia;

	private String personalMedico;

	public EncargadoCirugiaPK() {

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cirugia == null) ? 0 : cirugia.hashCode());
		result = prime * result + ((personalMedico == null) ? 0 : personalMedico.hashCode());
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
		EncargadoCirugiaPK other = (EncargadoCirugiaPK) obj;
		if (cirugia == null) {
			if (other.cirugia != null)
				return false;
		} else if (!cirugia.equals(other.cirugia))
			return false;
		if (personalMedico == null) {
			if (other.personalMedico != null)
				return false;
		} else if (!personalMedico.equals(other.personalMedico))
			return false;
		return true;
	}

	
	
}
