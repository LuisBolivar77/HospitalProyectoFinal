package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

public class CirugiaQuirofanoPK implements Serializable{
	
	private String quirofanoId;
	
	private String cirugiaOrdenId;
	
	private String cirugiaId;
	
	
	public CirugiaQuirofanoPK() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param quirofanoId
	 * @param cirugiaOrdenId
	 * @param cirugiaId
	 */
	public CirugiaQuirofanoPK(String quirofanoId, String cirugiaOrdenId, String cirugiaId) {
		super();
		this.quirofanoId = quirofanoId;
		this.cirugiaOrdenId = cirugiaOrdenId;
		this.cirugiaId = cirugiaId;
	}


	/**
	 * @return the quirofanoId
	 */
	public String getQuirofanoId() {
		return quirofanoId;
	}


	/**
	 * @param quirofanoId the quirofanoId to set
	 */
	public void setQuirofanoId(String quirofanoId) {
		this.quirofanoId = quirofanoId;
	}


	/**
	 * @return the cirugiaOrdenId
	 */
	public String getCirugiaOrdenId() {
		return cirugiaOrdenId;
	}


	/**
	 * @param cirugiaOrdenId the cirugiaOrdenId to set
	 */
	public void setCirugiaOrdenId(String cirugiaOrdenId) {
		this.cirugiaOrdenId = cirugiaOrdenId;
	}


	/**
	 * @return the cirugiaId
	 */
	public String getCirugiaId() {
		return cirugiaId;
	}


	/**
	 * @param cirugiaId the cirugiaId to set
	 */
	public void setCirugiaId(String cirugiaId) {
		this.cirugiaId = cirugiaId;
	}
	
	

}
