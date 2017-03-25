package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class ResultadoExamenPK implements Serializable{
	
	private int examen;
	
	private int historial;
	
	public ResultadoExamenPK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examen;
		result = prime * result + historial;
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
		ResultadoExamenPK other = (ResultadoExamenPK) obj;
		if (examen != other.examen)
			return false;
		if (historial != other.historial)
			return false;
		return true;
	}

	
	
}
