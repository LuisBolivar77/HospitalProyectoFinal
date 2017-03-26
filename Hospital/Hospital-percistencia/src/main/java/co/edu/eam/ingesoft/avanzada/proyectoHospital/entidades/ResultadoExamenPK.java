package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class ResultadoExamenPK implements Serializable{
	
	private int examen;
	
	private int historial;
	
	public ResultadoExamenPK() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ResultadoExamenPK(int examen, int historial) {
		super();
		this.examen = examen;
		this.historial = historial;
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



	public int getExamen() {
		return examen;
	}



	public void setExamen(int examen) {
		this.examen = examen;
	}



	public int getHistorial() {
		return historial;
	}



	public void setHistorial(int historial) {
		this.historial = historial;
	}

	
	
}
