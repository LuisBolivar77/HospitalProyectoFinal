package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class CirugiaQuirofanoPK implements Serializable{
	
	private int quirofano;
	
	private int cirugiaRealizar;
	
	
	public CirugiaQuirofanoPK() {
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cirugiaRealizar;
		result = prime * result + quirofano;
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
		CirugiaQuirofanoPK other = (CirugiaQuirofanoPK) obj;
		if (cirugiaRealizar != other.cirugiaRealizar)
			return false;
		if (quirofano != other.quirofano)
			return false;
		return true;
	}


}
