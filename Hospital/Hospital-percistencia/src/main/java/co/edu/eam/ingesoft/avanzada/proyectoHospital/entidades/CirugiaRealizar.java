package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CIRUGIA_REALIZAR")
@IdClass(CirugiaRealizarPK.class)
public class CirugiaRealizar implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "CIRUGIA_ID")
	private Cirugia cirugia;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "CITA_ID")
	private Cita cita;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_HORA")
	private Date fechaHora;

	@ManyToOne
	@JoinColumn(name = "QUIROFANO_ID")
	private Quirofano quirofano;

	public CirugiaRealizar() {
		// TODO Auto-generated constructor stub
	}

	public CirugiaRealizar(Cirugia cirugia, Date fechaHora, Quirofano quirofano, Cita cita) {
		super();
		this.cirugia = cirugia;
		this.fechaHora = fechaHora;
		this.quirofano = quirofano;
		this.cita = cita;
	}
	
	public String getFechaCirugia() {
		return fechaHora.getDay() + "/" + fechaHora.getMonth() + "/" + fechaHora.getYear();
	}

	/**
	 * @return the cirugia
	 */
	public Cirugia getCirugia() {
		return cirugia;
	}

	/**
	 * @param cirugia
	 *            the cirugia to set
	 */
	public void setCirugia(Cirugia cirugia) {
		this.cirugia = cirugia;
	}


	/**
	 * @return the cita
	 */
	public Cita getCita() {
		return cita;
	}

	/**
	 * @param cita the cita to set
	 */
	public void setCita(Cita cita) {
		this.cita = cita;
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
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora
	 *            the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

}
