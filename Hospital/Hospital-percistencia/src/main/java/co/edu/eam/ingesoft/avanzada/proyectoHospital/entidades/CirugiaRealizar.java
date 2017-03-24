package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CIRUGIA_REALIZAR")
public class CirugiaRealizar implements Serializable{

	@ManyToOne
	@JoinColumn(name="CIRUGIA")
	private Cirugia cirugia;
	
	@ManyToOne
	@JoinColumn(name="ORDEN_MEDICA")
	private OrdenMedica ordenMedica;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_HORA")
	private Date fechaHora;
	
	
	public CirugiaRealizar() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param cirugia
	 * @param ordenMedica
	 * @param fechaHora
	 */
	public CirugiaRealizar(Cirugia cirugia, OrdenMedica ordenMedica, Date fechaHora) {
		super();
		this.cirugia = cirugia;
		this.ordenMedica = ordenMedica;
		this.fechaHora = fechaHora;
	}


	/**
	 * @return the cirugia
	 */
	public Cirugia getCirugia() {
		return cirugia;
	}


	/**
	 * @param cirugia the cirugia to set
	 */
	public void setCirugia(Cirugia cirugia) {
		this.cirugia = cirugia;
	}


	/**
	 * @return the ordenMedica
	 */
	public OrdenMedica getOrdenMedica() {
		return ordenMedica;
	}


	/**
	 * @param ordenMedica the ordenMedica to set
	 */
	public void setOrdenMedica(OrdenMedica ordenMedica) {
		this.ordenMedica = ordenMedica;
	}


	/**
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}


	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	
	
}
