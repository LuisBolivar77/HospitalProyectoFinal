package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class CirugiaQuirofanoPK implements Serializable{
	
	private int quirofano;
	
	private CirugiaRealizarPK cirugiaRealizar;
	
	
	public CirugiaQuirofanoPK() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cirugiaRealizar == null) ? 0 : cirugiaRealizar.hashCode());
		result = prime * result + quirofano;
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
		if (quirofano != other.quirofano)
			return false;
		return true;
	}
	
	
	

}
