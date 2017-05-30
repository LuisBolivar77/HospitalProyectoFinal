package co.edu.eam.ingesoft.avanzada.proyectoHospital.controladores;

import java.io.Serializable;

public class ControladorCita implements Serializable{
	
	private String fecha;
	
	private String medicoSelecc;
	
	private String tipoCitaSelecc;
	
	private String tipoEspeSelecc;
	
	
	
	
	
	
	
	
	
	public void listarMedicos(){
		
		
		
		
	}
	
	
	
	

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the medicoSelecc
	 */
	public String getMedicoSelecc() {
		return medicoSelecc;
	}

	/**
	 * @param medicoSelecc the medicoSelecc to set
	 */
	public void setMedicoSelecc(String medicoSelecc) {
		this.medicoSelecc = medicoSelecc;
	}

	/**
	 * @return the tipoCitaSelecc
	 */
	public String getTipoCitaSelecc() {
		return tipoCitaSelecc;
	}

	/**
	 * @param tipoCitaSelecc the tipoCitaSelecc to set
	 */
	public void setTipoCitaSelecc(String tipoCitaSelecc) {
		this.tipoCitaSelecc = tipoCitaSelecc;
	}

	/**
	 * @return the tipoEspeSelecc
	 */
	public String getTipoEspeSelecc() {
		return tipoEspeSelecc;
	}

	/**
	 * @param tipoEspeSelecc the tipoEspeSelecc to set
	 */
	public void setTipoEspeSelecc(String tipoEspeSelecc) {
		this.tipoEspeSelecc = tipoEspeSelecc;
	}
	
	

}
