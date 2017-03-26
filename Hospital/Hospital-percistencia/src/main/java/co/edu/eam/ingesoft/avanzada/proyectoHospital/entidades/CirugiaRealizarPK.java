package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class CirugiaRealizarPK implements Serializable{

	private int cirugia;
	
	private int ordenMedica;
	
	public CirugiaRealizarPK() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CirugiaRealizarPK(int cirugia, int ordenMedica) {
		super();
		this.cirugia = cirugia;
		this.ordenMedica = ordenMedica;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cirugia;
		result = prime * result + ordenMedica;
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
		CirugiaRealizarPK other = (CirugiaRealizarPK) obj;
		if (cirugia != other.cirugia)
			return false;
		if (ordenMedica != other.ordenMedica)
			return false;
		return true;
	}



	public int getCirugia() {
		return cirugia;
	}



	public void setCirugia(int cirugia) {
		this.cirugia = cirugia;
	}



	public int getOrdenMedica() {
		return ordenMedica;
	}



	public void setOrdenMedica(int ordenMedica) {
		this.ordenMedica = ordenMedica;
	}

	
	
}
