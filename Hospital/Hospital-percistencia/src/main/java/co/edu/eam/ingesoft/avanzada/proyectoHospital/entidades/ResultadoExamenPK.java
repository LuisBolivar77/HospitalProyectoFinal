package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class ResultadoExamenPK implements Serializable{
	
	private String examenID;
	
	private String historialMedico;
	
	public ResultadoExamenPK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param examenID
	 * @param historialMedico
	 */
	public ResultadoExamenPK(String examenID, String historialMedico) {
		super();
		this.examenID = examenID;
		this.historialMedico = historialMedico;
	}

	/**
	 * @return the examenID
	 */
	public String getExamenID() {
		return examenID;
	}

	/**
	 * @param examenID the examenID to set
	 */
	public void setExamenID(String examenID) {
		this.examenID = examenID;
	}

	/**
	 * @return the historialMedico
	 */
	public String getHistorialMedico() {
		return historialMedico;
	}

	/**
	 * @param historialMedico the historialMedico to set
	 */
	public void setHistorialMedico(String historialMedico) {
		this.historialMedico = historialMedico;
	}
	
	

}
