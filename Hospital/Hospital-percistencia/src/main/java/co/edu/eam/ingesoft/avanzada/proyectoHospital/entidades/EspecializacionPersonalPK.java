package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class EspecializacionPersonalPK implements Serializable {

	private int especializacion;
	
	private int personal;
	
	public EspecializacionPersonalPK() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + especializacion;
		result = prime * result + personal;
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
		EspecializacionPersonalPK other = (EspecializacionPersonalPK) obj;
		if (especializacion != other.especializacion)
			return false;
		if (personal != other.personal)
			return false;
		return true;
	}
	
	
	
}
