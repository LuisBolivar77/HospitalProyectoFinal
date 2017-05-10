package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class MedicamentoTratamientoPK implements Serializable {

	private int medicamento;
	
	private int tratamiento;
	
	public MedicamentoTratamientoPK() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + medicamento;
		result = prime * result + tratamiento;
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
		MedicamentoTratamientoPK other = (MedicamentoTratamientoPK) obj;
		if (medicamento != other.medicamento)
			return false;
		if (tratamiento != other.tratamiento)
			return false;
		return true;
	}
	
	
	
}
