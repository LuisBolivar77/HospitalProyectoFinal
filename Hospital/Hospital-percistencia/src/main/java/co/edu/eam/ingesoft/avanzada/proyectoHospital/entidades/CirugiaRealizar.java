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
	@JoinColumn(name = "ORDEN_MEDICA_ID")
	private OrdenMedica ordenMedica;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_HORA")
	private Date fechaHora;

	@ManyToOne
	@JoinColumn(name = "QUIROFANO_ID")
	private Quirofano quirofano;

	@ManyToOne
	@JoinColumn(name = "CITA_ID", nullable = true)
	private Cita cita;

	public CirugiaRealizar() {
		// TODO Auto-generated constructor stub
	}

	public CirugiaRealizar(Cirugia cirugia, OrdenMedica ordenMedica, Date fechaHora, Quirofano quirofano, Cita cita) {
		super();
		this.cirugia = cirugia;
		this.ordenMedica = ordenMedica;
		this.fechaHora = fechaHora;
		this.quirofano = quirofano;
		this.cita = cita;
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
	 * @return the ordenMedica
	 */
	public OrdenMedica getOrdenMedica() {
		return ordenMedica;
	}

	/**
	 * @param ordenMedica
	 *            the ordenMedica to set
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
	 * @param fechaHora
	 *            the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

}
