package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class CirugiaRealizarPK implements Serializable{

	private String cirugia;
	
	private String ordenMedica;
	
	public CirugiaRealizarPK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cirugia
	 * @param ordenMedica
	 */
	public CirugiaRealizarPK(String cirugia, String ordenMedica) {
		super();
		this.cirugia = cirugia;
		this.ordenMedica = ordenMedica;
	}

	/**
	 * @return the cirugia
	 */
	public String getCirugia() {
		return cirugia;
	}

	/**
	 * @param cirugia the cirugia to set
	 */
	public void setCirugia(String cirugia) {
		this.cirugia = cirugia;
	}

	/**
	 * @return the ordenMedica
	 */
	public String getOrdenMedica() {
		return ordenMedica;
	}

	/**
	 * @param ordenMedica the ordenMedica to set
	 */
	public void setOrdenMedica(String ordenMedica) {
		this.ordenMedica = ordenMedica;
	}
	
	
	
}
