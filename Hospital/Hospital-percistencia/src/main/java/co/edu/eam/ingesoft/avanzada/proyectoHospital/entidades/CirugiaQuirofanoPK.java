package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class CirugiaQuirofanoPK implements Serializable{
	
	private Quirofano quirofano;
	
	private Cirugia cirugiaRealizar;
	
	
	public CirugiaQuirofanoPK() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cirugiaRealizar == null) ? 0 : cirugiaRealizar.hashCode());
		result = prime * result + ((quirofano == null) ? 0 : quirofano.hashCode());
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
		CirugiaQuirofanoPK other = (CirugiaQuirofanoPK) obj;
		if (cirugiaRealizar == null) {
			if (other.cirugiaRealizar != null)
				return false;
		} else if (!cirugiaRealizar.equals(other.cirugiaRealizar))
			return false;
		if (quirofano == null) {
			if (other.quirofano != null)
				return false;
		} else if (!quirofano.equals(other.quirofano))
			return false;
		return true;
	}


	

}
