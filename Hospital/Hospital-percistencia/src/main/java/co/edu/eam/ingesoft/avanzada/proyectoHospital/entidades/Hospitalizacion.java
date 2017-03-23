package co.edu.eam.ingesoft.avanzada.proyectoHospital.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_HOSPITALIZACION")
public class Hospitalizacion implements Serializable{
	
	@Id
	@Column(name="ID")
	private String id;
	
	@Column(name="DESCRIPCION", nullable=false, length=200)
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_ENTRADA")
	private Date fechaEntrada;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_SALIDA")
	private Date fechaSalida;
	
	@OneToOne
	@JoinColumn(name="ORDEN_MEDICA")
	private OrdenMedica ordenMedica;
	
	@ManyToOne
	@JoinColumn(name="CAMA")
	private Cama cama;
	
	public Hospitalizacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param descripcion
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @param ordenMedica
	 * @param cama
	 */
	public Hospitalizacion(String id, String descripcion, Date fechaEntrada, Date fechaSalida, OrdenMedica ordenMedica,
			Cama cama) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.ordenMedica = ordenMedica;
		this.cama = cama;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fechaEntrada
	 */
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * @param fechaEntrada the fechaEntrada to set
	 */
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	/**
	 * @return the fechaSalida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * @param fechaSalida the fechaSalida to set
	 */
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
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
	 * @return the cama
	 */
	public Cama getCama() {
		return cama;
	}

	/**
	 * @param cama the cama to set
	 */
	public void setCama(Cama cama) {
		this.cama = cama;
	}
	
	
	

}
