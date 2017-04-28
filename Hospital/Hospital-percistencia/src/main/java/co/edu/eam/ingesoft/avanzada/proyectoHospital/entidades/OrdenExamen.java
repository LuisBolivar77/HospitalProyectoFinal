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
@Table(name = "ORDEN_EXAMEN")
public class OrdenExamen implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "ORDEN_MEDICA_ID")
	private OrdenMedica ordenMedica;

	@Id
	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	private Examen examen;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_HORA")
	private Date fecha;

	public OrdenExamen() {

	}

	public OrdenExamen(OrdenMedica ordenMedica, Examen examen, Date fecha) {
		super();
		this.ordenMedica = ordenMedica;
		this.examen = examen;
		this.fecha = fecha;
	}

	public OrdenMedica getOrdenMedica() {
		return ordenMedica;
	}

	public void setOrdenMedica(OrdenMedica ordenMedica) {
		this.ordenMedica = ordenMedica;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
