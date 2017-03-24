package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_CIRUGIA_QUIROFANO")
@IdClass(CirugiaQuirofanoPK.class)
public class CirugiaQuirofano implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="QUIROFANO")
	private Quirofano quirofano;
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CIRUGIA",referencedColumnName="CIRUGIA"),
		@JoinColumn(name="ORDEN_MEDICA",referencedColumnName="ORDEN_MEDICA")
	})
	private CirugiaRealizar cirugiaRealizar;
	
	
	public CirugiaQuirofano() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param quirofano
	 * @param cirugiaRealizar
	 */
	public CirugiaQuirofano(Quirofano quirofano, CirugiaRealizar cirugiaRealizar) {
		super();
		this.quirofano = quirofano;
		this.cirugiaRealizar = cirugiaRealizar;
	}


	/**
	 * @return the quirofano
	 */
	public Quirofano getQuirofano() {
		return quirofano;
	}


	/**
	 * @param quirofano the quirofano to set
	 */
	public void setQuirofano(Quirofano quirofano) {
		this.quirofano = quirofano;
	}


	/**
	 * @return the cirugiaRealizar
	 */
	public CirugiaRealizar getCirugiaRealizar() {
		return cirugiaRealizar;
	}


	/**
	 * @param cirugiaRealizar the cirugiaRealizar to set
	 */
	public void setCirugiaRealizar(CirugiaRealizar cirugiaRealizar) {
		this.cirugiaRealizar = cirugiaRealizar;
	}
	
	
	
	
}
